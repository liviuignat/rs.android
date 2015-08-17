package com.c24.rs.http.converters;

import com.c24.rs.domain.models.TariffSponsoringDetail;
import com.c24.rs.common.JsonReader;

import org.androidannotations.annotations.EBean;
import org.json.JSONObject;

@EBean
public class Json2TariffSponsoringDetailsConverter {
    public TariffSponsoringDetail convert(JSONObject json){
        TariffSponsoringDetail instance = new TariffSponsoringDetail()
                .text(JsonReader.getString(json, "helpTextName"))
                .isTopGrade(JsonReader.getBoolean(json, "isTopGrade"));

        return instance;
    }
}
