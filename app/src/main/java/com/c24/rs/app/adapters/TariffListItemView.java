package com.c24.rs.app.adapters;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.c24.rs.R;
import com.c24.rs.app.uicontrols.TariffNote;
import com.c24.rs.bl.models.Tariff;
import com.c24.rs.bl.models.TariffFeature;
import com.c24.rs.bl.models.TariffImportantHint;
import com.c24.rs.common.SystemInfo;
import com.c24.rs.common.formatters.CurrencyFormatter;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EViewGroup(R.layout.tariffs_list_item)
public class TariffListItemView extends LinearLayout {

    @ViewById(R.id.row_container)
    public View rowContainer;

    @ViewById(R.id.tariff_row)
    public View tariffRow;

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

    @ViewById(R.id.tariff_important_hint_0)
    public TextView importantHint0View;

    @ViewById(R.id.tariff_important_hint_1)
    public TextView importantHint1View;

    @ViewById(R.id.tariff_important_hint_2)
    public TextView importantHint2View;

    @ViewById(R.id.tariff_important_hint_3)
    public TextView importantHint3View;

    @ViewById(R.id.sponsored_label)
    public TextView sponsoredLabel;

    public TariffListItemView(Context context) {
        super(context);
    }

    public void bind(Tariff tariff) {
        tariffNameTextView.setText(tariff.getTariffInfo().getName());
        tariffInsuranceNameTextView.setText(tariff.getInsuranceInfo().getName());
        tariffPriceTextView.setText(new CurrencyFormatter().get(tariff.getPricingDetails().getAmount(), "€"));
        tariffNoteView.setValue(tariff.getTariffInfo().getGrade());

        bindTariffFeatures(tariff);
        bindImportantHints(tariff);

        if(tariff.getTariffInfo().getIsSponsored()) {
            sponsoredLabel.setVisibility(VISIBLE);
            sponsoredLabel.setText(tariff.getTariffInfo().getSponsoringDetail().getText());

            if(SystemInfo.hasLollipop()) {
                rowContainer.setBackgroundResource(R.drawable.c24_sponsored_row_ripple);
            } else {
                rowContainer.setBackgroundResource(R.drawable.c24_sponsored_row_background);
            }
        } else {
            sponsoredLabel.setVisibility(GONE);

            if(SystemInfo.hasLollipop()) {
                rowContainer.setBackgroundResource(R.drawable.c24_normal_row_ripple);
            } else {
                rowContainer.setBackgroundResource(R.drawable.c24_normal_row_background);
            }
        }
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