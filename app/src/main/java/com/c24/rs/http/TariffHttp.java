package com.c24.rs.http;

import com.c24.rs.bl.Tariff;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by liviu.ignat on 6/30/2015.
 */
public class TariffHttp {

    public ArrayList<Tariff> getTariffs() throws IOException, JSONException {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        String url = "https://vergleich.rechtsschutzversicherung.check24.de/api/tariffs?b2BAdPartner=checkvers&b2BPartner=check24&businessNumberOfEmployees=0&employmentStatus=1&familyStatus=4&featureMode=list&insuredPersonBirthdate=1980-06-29T22:00:00.000Z&isMarriedOrCohabitating=true&maxContractPeriodYears=1&maxInsuranceSelfParticipation=150&minInsuranceCoverage=300000&numberOfPropertiesRentedOut=1&partnerEmploymentStatus=1&paymentPeriod=4&wantsBusiness=false&wantsOccupation=true&wantsPrivate=true&wantsRent=false&wantsResidence=false&wantsTraffic=true&yearlyGrossRentingIncome=6000";

        StringBuffer responseBuffer = request(url, "GET");
        String responseString = responseBuffer.toString();

        JSONArray jsonArray = new JSONArray(responseString);
        for (int index = 0; index < jsonArray.length(); index++) {
            JSONObject json = jsonArray.getJSONObject(index);
            Tariff tariff = new Tariff()
                    .id(json.getJSONObject("tariffInfo").getInt("id"))
                    .name(json.getJSONObject("tariffInfo").getString("name"));

            tariffs.add(tariff);
        }

        return tariffs;
    }

    private StringBuffer request(String urlString, String method) throws IOException {
        StringBuffer chaine = new StringBuffer("");

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestProperty("User-Agent", "");
        connection.setRequestMethod(method);
        connection.connect();

        InputStream inputStream = connection.getInputStream();

        BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        while ((line = rd.readLine()) != null) {
            chaine.append(line);
        }

        return chaine;
    }
}
