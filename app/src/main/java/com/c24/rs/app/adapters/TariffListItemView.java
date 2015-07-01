package com.c24.rs.app.adapters;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.c24.rs.R;
import com.c24.rs.bl.Tariff;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.tariffs_list_item)
public class TariffListItemView extends LinearLayout {

    @ViewById(R.id.tariff_name)
    public TextView tariffNameTextView;

    public TariffListItemView(Context context) {
        super(context);
    }

    public void bind(Tariff tariff) {
        tariffNameTextView.setText(tariff.getName());
    }
}