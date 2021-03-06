package com.c24.rs.app.uicontrols;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.c24.rs.R;
import com.c24.rs.bl.models.Tariff;
import com.c24.rs.bl.models.TariffFeature;
import com.c24.rs.bl.models.TariffImportantHint;
import com.c24.rs.common.formatters.CurrencyFormatter;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EViewGroup(R.layout.tariff_detail_header)
public class TariffDetailHeader  extends LinearLayout {
    @ViewById(R.id.tariff_row)
    public View tariffRow;

    @ViewById(R.id.tariff_payment_mode)
    public TextView tariffPaymentModeTextView;

    @ViewById(R.id.tariff_price)
    public TextView tariffPriceTextView;

    @ViewById(R.id.tariff_note)
    public TariffNote tariffNoteView;

    @ViewById(R.id.tariff_feature_0)
    public TextView tariffFeature0View;

    @ViewById(R.id.tariff_feature_1)
    public TextView tariffFeature1View;

    @ViewById(R.id.tariff_feature_2)
    public TextView tariffFeature2View;

    @ViewById(R.id.tariff_feature_3)
    public TextView tariffFeature3View;

    @ViewById(R.id.tariff_important_hint_0)
    public TextView importantHint0View;

    @ViewById(R.id.tariff_important_hint_1)
    public TextView importantHint1View;

    @ViewById(R.id.tariff_important_hint_2)
    public TextView importantHint2View;

    @ViewById(R.id.tariff_important_hint_3)
    public TextView importantHint3View;

    public TariffDetailHeader(Context context) {
        super(context);
    }

    public TariffDetailHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setTariff(Tariff tariff) {
        tariffPriceTextView.setText(new CurrencyFormatter().get(tariff.getPricingDetails().getAmount(), "€"));
        tariffNoteView.setValue(tariff.getTariffInfo().getGrade());
        tariffNoteView.setIsTopGrade(tariff.getTariffInfo().getSponsoringDetail().getIsTopGrade());

        bindTariffFeatures(tariff);
        bindImportantHints(tariff);
    }

    public void bindTariffFeatures(Tariff tariff) {
        tariffFeature0View.setVisibility(GONE);
        tariffFeature1View.setVisibility(GONE);
        tariffFeature2View.setVisibility(GONE);
        tariffFeature3View.setVisibility(GONE);

        ArrayList<TariffFeature> tariffFeatures = tariff.getTariffInfo().getTariffFeatures();
        Integer tariffFeatureSize = tariffFeatures.size();

        if(tariffFeatureSize >= 1) {
            tariffFeature0View.setVisibility(VISIBLE);
            tariffFeature0View.setText(getTariffFeatureText(tariffFeatures.get(0)));
        }
        if(tariffFeatureSize >= 2) {
            tariffFeature1View.setVisibility(VISIBLE);
            tariffFeature1View.setText(getTariffFeatureText(tariffFeatures.get(1)));
        }
        if(tariffFeatureSize >= 3) {
            tariffFeature2View.setVisibility(VISIBLE);
            tariffFeature2View.setText(getTariffFeatureText(tariffFeatures.get(2)));
        }
        if(tariffFeatureSize >= 4) {
            tariffFeature3View.setVisibility(VISIBLE);
            tariffFeature3View.setText(getTariffFeatureText(tariffFeatures.get(3)));
        }
    }

    public void bindImportantHints(Tariff tariff) {
        importantHint0View.setVisibility(GONE);
        importantHint1View.setVisibility(GONE);
        importantHint2View.setVisibility(GONE);
        importantHint3View.setVisibility(GONE);

        ArrayList<TariffImportantHint> importantHints = tariff.getTariffInfo().getImportantHints();
        Integer importantHintsSize = importantHints.size();
        if(importantHintsSize >= 1) {
            importantHint0View.setVisibility(VISIBLE);
            importantHint0View.setText(importantHints.get(0).getText());
        }
        if(importantHintsSize >= 2) {
            importantHint1View.setVisibility(VISIBLE);
            importantHint1View.setText(importantHints.get(1).getText());
        }
        if(importantHintsSize >= 3) {
            importantHint2View.setVisibility(VISIBLE);
            importantHint2View.setText(importantHints.get(2).getText());
        }
        if(importantHintsSize >= 4) {
            importantHint3View.setVisibility(VISIBLE);
            importantHint3View.setText(importantHints.get(3).getText());
        }
    }

    public String getTariffFeatureText(TariffFeature tariffFeature) {
        return String.format("%s: %s", tariffFeature.getName(), tariffFeature.getValue());
    }
}
