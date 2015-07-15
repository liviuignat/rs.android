package com.c24.rs.app.adapters;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.c24.rs.R;
import com.c24.rs.bl.models.TariffFeature;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.tariffs_feature_detail_item)
public class TariffFeatureDetailsItemView extends GenericListAdapterView<TariffFeature> {

    @ViewById(R.id.tariff_detail_feature_name)
    public TextView tariffFeatureNameTextView;

    public TariffFeatureDetailsItemView(Context context) {
        super(context);
    }
    public TariffFeatureDetailsItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void bind(TariffFeature tariffFeature) {
        tariffFeatureNameTextView.setText(tariffFeature.getName());
    }
}
