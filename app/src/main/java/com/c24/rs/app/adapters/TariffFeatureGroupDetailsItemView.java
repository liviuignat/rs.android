package com.c24.rs.app.adapters;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.c24.rs.R;
import com.c24.rs.domain.models.TariffFeature;
import com.c24.rs.domain.models.TariffFeatureGroup;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.tariffs_feature_group_detail_item)
public class TariffFeatureGroupDetailsItemView extends GenericListAdapterView<TariffFeatureGroup> {

    @ViewById(R.id.tariff_detail_group_name)
    public TextView tariffGroupNameTextView;

    @ViewById(R.id.tariff_feature_details_list)
    public LinearLayout tariffFeaturesDetailsList;

    public TariffFeatureGroupDetailsItemView(Context context) {
        super(context);
    }
    public TariffFeatureGroupDetailsItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void bind(TariffFeatureGroup group) {
        tariffGroupNameTextView.setText(group.getName());

        for (TariffFeature feature : group.getFeatures()) {
            TariffFeatureDetailsItemView view = TariffFeatureDetailsItemView_.build(getContext());
            view.bind(feature);
            tariffFeaturesDetailsList.addView(view);
        }
    }
}