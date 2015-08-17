package com.c24.rs.domain.queries;

import android.text.TextUtils;

import com.c24.rs.domain.models.Tariff;
import com.c24.rs.domain.models.TariffFeature;
import com.c24.rs.domain.models.TariffFeatureGroup;
import com.c24.rs.common.CacheKeys;
import com.c24.rs.common.ComplexPreferences;
import com.c24.rs.http.TariffHttp;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@EBean
public class SearchByIdQueryHandler {
    @Bean
    public TariffHttp tariffHttp;

    @Bean
    public ComplexPreferences complexPreferences;

    public Tariff query(SearchTariffByIdQuery query) throws IOException, JSONException {
        if(query.getSearchTariffQuery() == null) {
            query.setSearchTariffQuery(complexPreferences.getObject(CacheKeys.CURRENT_SEARCH_QUERY, SearchTariffQuery.class));
        }

        Tariff tariff = tariffHttp.getTariffById(query.getTariffId(), query.getSearchTariffQuery());

        complexPreferences.putObject(CacheKeys.CURRENT_TARIFF_LIST + query.getTariffId(), tariff);
        complexPreferences.commit();

        ArrayList<TariffFeatureGroup> detailedFeatureGroups = fillTariffFeatureGroups(tariff.getTariffInfo().getDetailedFeatures());
        ArrayList<TariffFeatureGroup> scoredFeaturesGroup = fillTariffFeatureGroups(tariff.getTariffInfo().getScoredFeatures());
        tariff.getTariffInfo()
                .detailedFeatureGroups(detailedFeatureGroups)
                .scoredFeaturesGroups(scoredFeaturesGroup);

        return tariff;
    }

    public ArrayList<TariffFeatureGroup> fillTariffFeatureGroups(ArrayList<TariffFeature> tarifffeatures) {
        ArrayList<TariffFeatureGroup> groups = new ArrayList<>();
        HashMap<String, ArrayList<TariffFeature>> featureMap = new HashMap<>();

        for (TariffFeature feature: tarifffeatures) {
            String groupName = feature.getGroup().getName();
            if(!TextUtils.isEmpty(groupName)) {
                if(!featureMap.containsKey(groupName)) {
                    featureMap.put(groupName, new ArrayList<TariffFeature>());
                }
                featureMap.get(groupName).add(feature);
            }
        }

        for (String hashKeys: featureMap.keySet()) {
            ArrayList<TariffFeature> groupFeatures = featureMap.get(hashKeys);
            TariffFeatureGroup group = groupFeatures.get(0).getGroup().features(groupFeatures);
            groups.add(group);
        }

        return groups;
    }
}
