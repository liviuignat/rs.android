package com.c24.rs.app.adapters;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.c24.rs.R;
import com.c24.rs.app.uicontrols.AdaptableLinearLayout;
import com.c24.rs.bl.models.TariffFeature;
import com.c24.rs.bl.models.TariffFeatureGroup;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.tariffs_feature_group_detail_item)
public class TariffFeatureGroupDetailsItemView extends GenericListAdapterView<TariffFeatureGroup> {

    @ViewById(R.id.tariff_detail_group_name)
    public TextView tariffGroupNameTextView;

    @ViewById(R.id.tariff_feature_details_list)
    public AdaptableLinearLayout tariffFeaturesDetailsList;

    @Bean
    public GenericListAdapter<TariffFeature, TariffFeatureDetailsItemView> tariffFeatureListAdapter;

    public TariffFeatureGroupDetailsItemView(Context context) {
        super(context);
    }
    public TariffFeatureGroupDetailsItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void bind(TariffFeatureGroup group) {
        tariffGroupNameTextView.setText(group.getName());
        tariffFeatureListAdapter.initAdapter(TariffFeatureDetailsItemView.class, group.getFeatures());
        tariffFeaturesDetailsList.setAdapter(tariffFeatureListAdapter);
        LayoutParams params = (LayoutParams) tariffFeaturesDetailsList.getLayoutParams();
        params.height = 100 * group.getFeatures().size();
    }
}