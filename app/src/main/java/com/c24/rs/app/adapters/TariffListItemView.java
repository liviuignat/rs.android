package com.c24.rs.app.adapters;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.c24.rs.R;
import com.c24.rs.app.uicontrols.TariffNote;
import com.c24.rs.bl.Tariff;
import com.c24.rs.bl.TariffFeature;
import com.c24.rs.common.formatters.CurrencyFormatter;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EViewGroup(R.layout.tariffs_list_item)
public class TariffListItemView extends LinearLayout {

    @ViewById(R.id.tariff_name)
    public TextView tariffNameTextView;

    @ViewById(R.id.tariff_insurance_name)
    public TextView tariffInsuranceNameTextView;

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

    public TariffListItemView(Context context) {
        super(context);
    }

    public void bind(Tariff tariff) {
        tariffNameTextView.setText(tariff.getTariffInfo().getName());
        tariffInsuranceNameTextView.setText(tariff.getInsuranceInfo().getName());
        tariffPriceTextView.setText(new CurrencyFormatter().get(tariff.getPricingDetails().getAmount(), "€"));
        tariffNoteView.setValue(tariff.getTariffInfo().getGrade());

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

    public String getTariffFeatureText(TariffFeature tariffFeature) {
        return String.format("%s: %s", tariffFeature.getName(), tariffFeature.getValue());
    }
}