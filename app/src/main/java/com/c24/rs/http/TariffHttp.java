package com.c24.rs.http;

import com.c24.rs.bl.Tariff;
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

        String url = String.format("https://vergleich.rechtsschutzversicherung.check24.de/api/tariffs?b2BAdPartner=checkvers&b2BPartner=check24&wantsBusiness=false&wantsOccupation=%s&wantsPrivate=%s&wantsRent=%s&wantsResidence=%s&wantsTraffic=%s&businessNumberOfEmployees=0&employmentStatus=1&familyStatus=4&featureMode=list&insuredPersonBirthdate=1980-06-29T22:00:00.000Z&isMarriedOrCohabitating=true&maxContractPeriodYears=1&maxInsuranceSelfParticipation=150&minInsuranceCoverage=300000&numberOfPropertiesRentedOut=1&partnerEmploymentStatus=1&paymentPeriod=4&yearlyGrossRentingIncome=6000",
                query.getWantsOccupation(), query.getWantsPrivate(), query.getWantsRent(), query.getWantsResidence(), query.getWantsTraffic());

        StringBuffer responseBuffer = request(url, "GET");
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
