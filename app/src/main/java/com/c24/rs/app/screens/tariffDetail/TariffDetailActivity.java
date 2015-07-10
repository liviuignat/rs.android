package com.c24.rs.app.screens.tariffDetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.c24.rs.R;
import com.c24.rs.app.ActivityBase;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.tariff_detail_activity)
public class TariffDetailActivity  extends ActivityBase {

    @Override
    public Boolean shouldShowActionBar() {
        return false;
    }

    @AfterViews
    public void init() {
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
                toolbar.setTitle("");
            }
        });
    }

    public static void initialize(Context context) {
        Intent intent = new Intent(context, TariffDetailActivity_.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);

        context.startActivity(intent);
    }
}
