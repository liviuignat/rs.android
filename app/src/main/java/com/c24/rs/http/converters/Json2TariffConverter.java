package com.c24.rs.http.converters;

import com.c24.rs.bl.models.Tariff;
import com.c24.rs.bl.models.TariffFeature;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

@EBean
public class Json2TariffConverter {
    @Bean
    public Json2TariffDetailsConverter json2TariffDetailsConverter;

    @Bean
    public Json2InsuranceInfoConverter json2InsuranceInfoConverter;

    @Bean
    public Json2PricingDetailsConverter json2PricingDetailsConverter;

    @Bean
    public Json2TariffFeatureConverter json2TariffFeatureConverter;

    @Bean
    public Json2TariffImportantHintConverter json2TariffImportantHintConverter;

    public Tariff convert(JSONObject tariffJson) throws JSONException {
        JSONObject tariffInfoJson = tariffJson.getJSONObject("tariffInfo");
        JSONObject insuranceJson = tariffJson.getJSONObject("insurance");
        JSONObject pricingDetailsJson = tariffJson.getJSONObject("pricingDetails");
        JSONArray tariffFeatureJsonArray = tariffInfoJson.getJSONArray("keyFeatures");
        JSONArray importantHintsJsonArray = tariffInfoJson.getJSONArray("importantHints");

        Tariff instance = new Tariff()
                .tariffInfo(this.json2TariffDetailsConverter.convert(tariffInfoJson))
                .insuranceInfo(this.json2InsuranceInfoConverter.convert(insuranceJson))
                .pricintDetails(this.json2PricingDetailsConverter.convert(pricingDetailsJson))
                ;

        instance.getTariffInfo().setTariffFeatures(getFeatures(tariffFeatureJsonArray));
        if(tariffInfoJson.has("detailedFeatures")) {
            instance.getTariffInfo().setDetailedFeatures(getFeatures(tariffInfoJson.getJSONArray("detailedFeatures")));
        }
        if(tariffInfoJson.has("scoredFeatures")) {
            instance.getTariffInfo().setScoredFeatures(getFeatures(tariffInfoJson.getJSONArray("scoredFeatures")));
        }

        for (int counter = 0; counter < importantHintsJsonArray.length(); counter++) {
            JSONObject importantHintJson = importantHintsJsonArray.getJSONObject(counter);
            instance.getTariffInfo().getImportantHints().add(this.json2TariffImportantHintConverter.convert(importantHintJson));
        }

        return instance;
    }

    private ArrayList<TariffFeature> getFeatures(JSONArray jsonArray) throws JSONException {
        ArrayList<TariffFeature> array = new ArrayList<>();
        for (int counter = 0; counter < jsonArray.length(); counter++) {
            JSONObject tariffFeatureJson = jsonArray.getJSONObject(counter);
            array.add(this.json2TariffFeatureConverter.convert(tariffFeatureJson));
        }
        return array;
    }
}
