package com.c24.rs.app.adapters;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.c24.rs.R;
import com.c24.rs.bl.Tariff;
import com.c24.rs.common.formatters.CurrencyFormatter;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

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

    public TariffListItemView(Context context) {
        super(context);
    }

    public void bind(Tariff tariff) {
        tariffNameTextView.setText(tariff.getTariffInfo().getName());
        tariffInsuranceNameTextView.setText(tariff.getInsuranceInfo().getName());
        tariffPriceTextView.setText(new CurrencyFormatter().get(tariff.getPricingDetails().getAmount(), "€"));
    }
}