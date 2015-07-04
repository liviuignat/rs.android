package com.c24.rs.http;

import com.c24.rs.bl.Tariff;
import com.c24.rs.bl.queries.SearchTariffQuery;
import com.c24.rs.http.converters.Json2InsuranceInfoConverter;
import com.c24.rs.http.converters.Json2PricingDetailsConverter;
import com.c24.rs.http.converters.Json2TariffDetailsConverter;
import com.c24.rs.http.converters.Json2TariffFeatureConverter;
import com.c24.rs.http.converters.Json2TariffImportantHintConverter;

import org.androidannotations.annotations.EBean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

@EBean
public class TariffHttp extends HttpBase {

    public ArrayList<Tariff> getTariffs(SearchTariffQuery query) throws IOException, JSONException {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        String url = "https://vergleich.rechtsschutzversicherung.check24.de/api/tariffs?b2BAdPartner=checkvers&b2BPartner=check24&businessNumberOfEmployees=0&employmentStatus=1&familyStatus=4&featureMode=list&insuredPersonBirthdate=1980-06-29T22:00:00.000Z&isMarriedOrCohabitating=true&maxContractPeriodYears=1&maxInsuranceSelfParticipation=150&minInsuranceCoverage=300000&numberOfPropertiesRentedOut=1&partnerEmploymentStatus=1&paymentPeriod=4&wantsBusiness=false&wantsOccupation=true&wantsPrivate=true&wantsRent=false&wantsResidence=false&wantsTraffic=true&yearlyGrossRentingIncome=6000";

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
                    .tariffInfo(new Json2TariffDetailsConverter().convert(tariffInfoJson))
                    .insuranceInfo(new Json2InsuranceInfoConverter().convert(insuranceJson))
                    .pricintDetails(new Json2PricingDetailsConverter().convert(pricingDetailsJson))
                    ;

            for (int counter = 0; counter < tariffFeatureJsonArray.length(); counter++) {
                JSONObject tariffFeatureJson = tariffFeatureJsonArray.getJSONObject(counter);
                tariff.getTariffInfo().getTariffFeatures().add(new Json2TariffFeatureConverter().convert(tariffFeatureJson));
            }

            for (int counter = 0; counter < importantHintsJsonArray.length(); counter++) {
                JSONObject importantHintJson = importantHintsJsonArray.getJSONObject(counter);
                tariff.getTariffInfo().getImportantHints().add(new Json2TariffImportantHintConverter().convert(importantHintJson));
            }

            tariffs.add(tariff);
        }

        return tariffs;
    }
}
