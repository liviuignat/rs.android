package com.c24.rs.http;

import android.net.Uri;

import com.c24.rs.bl.models.Tariff;
import com.c24.rs.bl.queries.SearchTariffQuery;
import com.c24.rs.http.converters.Json2TariffConverter;

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
    public Json2TariffConverter json2TariffConverter;

    public Uri.Builder getUrlBuilder(SearchTariffQuery query) {
        Uri.Builder uriBuilder = new Uri.Builder();
        uriBuilder.scheme("https")
                .authority("api.rechtsschutzversicherung.check24.de")
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
        return uriBuilder;
    }

    public ArrayList<Tariff> getTariffs(SearchTariffQuery query) throws IOException, JSONException {
        ArrayList<Tariff> tariffs = new ArrayList<>();

        Uri.Builder uriBuilder = getUrlBuilder(query);

        StringBuffer responseBuffer = this.request(uriBuilder.build().toString(), "GET");
        String responseString = responseBuffer.toString();

        JSONArray jsonArray = new JSONArray(responseString);
        for (int index = 0; index < jsonArray.length(); index++) {
            JSONObject tariffJson = jsonArray.getJSONObject(index);
            Tariff tariff = json2TariffConverter.convert(tariffJson);
            tariffs.add(tariff);
        }

        return tariffs;
    }

    public Tariff getTariffById(Integer tariffId, SearchTariffQuery searchTariffQuery) throws IOException, JSONException {
        Uri.Builder uriBuilder = getUrlBuilder(searchTariffQuery);
        uriBuilder.appendPath(tariffId.toString());

        StringBuffer responseBuffer = this.request(uriBuilder.build().toString(), "GET");
        String responseString = responseBuffer.toString();

        JSONObject tariffJson = new JSONObject(responseString);

        Tariff tariff = json2TariffConverter.convert(tariffJson);

        return tariff;
    }
}
