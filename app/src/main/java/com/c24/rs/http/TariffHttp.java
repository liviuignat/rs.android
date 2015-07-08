package com.c24.rs.http;

import android.net.Uri;

import com.c24.rs.bl.models.Tariff;
import com.c24.rs.bl.queries.SearchTariffQuery;
import com.c24.rs.http.converters.Json2InsuranceInfoConverter;
import com.c24.rs.http.converters.Json2PricingDetailsConverter;
import com.c24.rs.http.converters.Json2TariffDetailsConverter;
import com.c24.rs.http.converters.Json2TariffFeatureConverter;
import com.c24.rs.http.converters.Json2TariffImportantHintConverter;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

@EBean
public class TariffHttp extends HttpBase {
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

    public ArrayList<Tariff> getTariffs(SearchTariffQuery query) throws IOException, JSONException {
        ArrayList<Tariff> tariffs = new ArrayList<>();

        Uri.Builder uriBuilder = new Uri.Builder();
        uriBuilder.scheme("https")
                .authority("vergleich.rechtsschutzversicherung.check24.de")
                .appendPath("api")
                .appendPath("tariffs")
                .appendQueryParameter("b2BAdPartner", "checkvers")
                .appendQueryParameter("b2BPartner", "check24")
                .appendQueryParameter("wantsOccupation", query.getWantsOccupation().toString())
                .appendQueryParameter("wantsPrivate", query.getWantsPrivate().toString())
                .appendQueryParameter("wantsResidence", query.getWantsResidence().toString())
                .appendQueryParameter("wantsRent", query.getWantsRent().toString())
                .appendQueryParameter("numberOfPropertiesRentedOut", query.getNumberOfPropertiesRentedOut().toString())
                .appendQueryParameter("yearlyGrossRentingIncome", query.getEarlyGrossIncome().toString())
                .appendQueryParameter("wantsTraffic", query.getWantsTraffic().toString())
                .appendQueryParameter("familyStatus", query.getFamilyStatus().getValue().toString())
                .appendQueryParameter("employmentStatus", query.getEmploymentStatus().getValue().toString())
                .appendQueryParameter("partnerEmploymentStatus", query.getPartnerEmploymentStatus().getValue().toString())
                .appendQueryParameter("isMarriedOrCohabitating", query.getIsMarriedOrCohabitating().toString())
                .appendQueryParameter("insuredPersonBirthdate", "1980-06-29T22:00:00.000Z")
                .appendQueryParameter("wantsBusiness", query.getWantsBusiness().toString())
                .appendQueryParameter("businessNumberOfEmployees", query.getNumberOfPropertiesRentedOut().toString())
                .appendQueryParameter("maxContractPeriodYears", "1")
                .appendQueryParameter("maxInsuranceSelfParticipation", "150")
                .appendQueryParameter("minInsuranceCoverage", "300000")
                .appendQueryParameter("paymentPeriod", "4")
                .appendQueryParameter("featureMode", "list")
        ;

        StringBuffer responseBuffer = this.request(uriBuilder.build().toString(), "GET");
        String responseString = responseBuffer.toString();

        JSONArray jsonArray = new JSONArray(responseString);
        for (int index = 0; index < jsonArray.length(); index++) {
            JSONObject tariffJson = jsonArray.getJSONObject(index);
            JSONObject tariffInfoJson = tariffJson.getJSONObject("tariffInfo");
            JSONObject insuranceJson = tariffJson.getJSONObject("insurance");
            JSONObject pricingDetailsJson = tariffJson.getJSONObject("pricingDetails");
            JSONArray tariffFeatureJsonArray = tariffInfoJson.getJSONArray("keyFeatures");
            JSONArray importantHintsJsonArray = tariffInfoJson.getJSONArray("importantHints");

            Tariff tariff = new Tariff()
                    .tariffInfo(this.json2TariffDetailsConverter.convert(tariffInfoJson))
                    .insuranceInfo(this.json2InsuranceInfoConverter.convert(insuranceJson))
                    .pricintDetails(this.json2PricingDetailsConverter.convert(pricingDetailsJson))
                    ;

            for (int counter = 0; counter < tariffFeatureJsonArray.length(); counter++) {
                JSONObject tariffFeatureJson = tariffFeatureJsonArray.getJSONObject(counter);
                tariff.getTariffInfo().getTariffFeatures().add(this.json2TariffFeatureConverter.convert(tariffFeatureJson));
            }

            for (int counter = 0; counter < importantHintsJsonArray.length(); counter++) {
                JSONObject importantHintJson = importantHintsJsonArray.getJSONObject(counter);
                tariff.getTariffInfo().getImportantHints().add(this.json2TariffImportantHintConverter.convert(importantHintJson));
            }

            tariffs.add(tariff);
        }

        return tariffs;
    }
}
