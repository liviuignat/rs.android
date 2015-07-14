package com.c24.rs.app.adapters;

import android.content.Context;
import android.util.AttributeSet;

import com.c24.rs.R;
import com.c24.rs.bl.models.TariffFeature;

import org.androidannotations.annotations.EViewGroup;

@EViewGroup(R.layout.tariffs_list_item)
public class TariffFeatureDetailsItemView extends GenericListAdapterView<TariffFeature> {
    public TariffFeatureDetailsItemView(Context context) {
        super(context);
    }
    public TariffFeatureDetailsItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void bind(TariffFeature tariffFeature) {

    }
}
