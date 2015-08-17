package com.c24.rs.http.converters;

import com.c24.rs.domain.models.TariffDetails;
import com.c24.rs.common.JsonReader;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.json.JSONException;
import org.json.JSONObject;

@EBean
public class Json2TariffDetailsConverter {

    @Bean
    public Json2TariffSponsoringDetailsConverter json2TariffSponsoringDetailsConverter;

    public TariffDetails convert(JSONObject json) throws JSONException {
        TariffDetails instance = new TariffDetails()
                .id(JsonReader.getInt(json, "id"))
                .name(JsonReader.getString(json, "name"))
                .grade(JsonReader.getDouble(json, "grade"))
                .isSponsored(json.has("sponsoringDetail") && !json.isNull("sponsoringDetail"))
                ;

        if(instance.getIsSponsored()) {
            instance.setSponsoringDetail(json2TariffSponsoringDetailsConverter.convert(json.getJSONObject("sponsoringDetail")));
        }

        return instance;
    }
}
