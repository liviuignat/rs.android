package com.c24.rs.app.screens.tariffDetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.c24.rs.R;
import com.c24.rs.app.ActivityBase;
import com.c24.rs.app.uicontrols.ObservableScrollView;
import com.c24.rs.app.uicontrols.TariffDetailHeader;
import com.c24.rs.bl.models.Tariff;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.tariff_detail_activity)
@OptionsMenu(R.menu.menu_tariff_detail)
public class TariffDetailActivity  extends ActivityBase implements
        ObservableScrollView.Callbacks {

    public static String PARAM_SELECTED_TARIFF = "PARAM_SELECTED_TARIFF";
    private static final float PHOTO_ASPECT_RATIO = 2.00f;
    public Tariff selectedTariff;

    private int maxHeaderElevation;

    @ViewById(R.id.tariff_detail_header)
    public TariffDetailHeader tariffItemView;

    @ViewById(R.id.scroll_view)
    public ObservableScrollView scrollView;

    @ViewById(R.id.tariff_detail_image)
    public ImageView tariffImage;

    @ViewById(R.id.image_container)
    public View imageContainer;

    @ViewById(R.id.content_container)
    public View contentContainer;

    @Override
    public Boolean shouldShowActionBar() {
        return false;
    }

    private ViewTreeObserver.OnGlobalLayoutListener layoutEventListener
            = new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            recomputePhotoAndScrollingMetrics();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = this.getIntent().getExtras();
        selectedTariff = (Tariff)args.getSerializable(PARAM_SELECTED_TARIFF);

        maxHeaderElevation =  getResources().getDimensionPixelSize(R.dimen.tariff_detail_max_header_elevation);
    }

    @AfterViews
    public void init() {
        tariffItemView.setTariff(selectedTariff);
        imageContainer.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.tariff_arag));

        scrollView.addCallbacks(this);
        ViewTreeObserver vto = scrollView.getViewTreeObserver();
        if (vto.isAlive()) {
            vto.addOnGlobalLayoutListener(layoutEventListener);
        }

        final Toolbar toolbar = getActionBarToolbar();
        toolbar.setNavigationIcon(R.mipmap.ic_up);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                String title = selectedTariff.getInsuranceInfo().getName() + " - " + selectedTariff.getTariffInfo().getName();
                toolbar.setTitle(title);
            }
        });
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (scrollView == null) {
            return;
        }

        ViewTreeObserver vto = scrollView.getViewTreeObserver();
        if (vto.isAlive()) {
            vto.removeGlobalOnLayoutListener(layoutEventListener);
        }
    }

    @Override
    public void onScrollChanged(int x, int y, int oldX, int oldY, int deltaX, int deltaY) {
        computeScrollChange(deltaX, deltaY);
    }

    private int photoHeightPixels;

    private void computeScrollChange(int deltaX, int deltaY) {
        int scrollY = scrollView.getScrollY();
        getActionBarToolbar().setTranslationY(scrollY);
        float gapFillProgress = 1;
        if (photoHeightPixels != 0) {
            gapFillProgress = Math.min(Math.max(getProgress(scrollY, 0, photoHeightPixels), 0), 1);
        }

        ViewCompat.setElevation(getActionBarToolbar(), gapFillProgress * maxHeaderElevation);

        imageContainer.setTranslationY(scrollY * 0.5f);
    }

    private void recomputePhotoAndScrollingMetrics() {
        photoHeightPixels = 0;
        photoHeightPixels = (int) (tariffImage.getWidth() / PHOTO_ASPECT_RATIO);
        photoHeightPixels = Math.min(photoHeightPixels, scrollView.getHeight() * 2 / 3);

        ViewGroup.LayoutParams lp;
        lp = imageContainer.getLayoutParams();
        if (lp.height != photoHeightPixels) {
            lp.height = photoHeightPixels;
            imageContainer.setLayoutParams(lp);
        }

        ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams)contentContainer.getLayoutParams();
        if (mlp.topMargin != photoHeightPixels) {
            mlp.topMargin = photoHeightPixels;
            contentContainer.setLayoutParams(mlp);
        }

        computeScrollChange(0, 0);
    }

    public static float getProgress(int value, int min, int max) {
        if (min == max) {
            throw new IllegalArgumentException("Max (" + max + ") cannot equal min (" + min + ")");
        }
        return (value - min) / (float) (max - min);
    }

    public static void initialize(Context context, Tariff tariff) {
        Intent intent = new Intent(context, TariffDetailActivity_.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(PARAM_SELECTED_TARIFF, tariff);
        intent.putExtras(bundle);

        context.startActivity(intent);
    }
}
