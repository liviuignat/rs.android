package com.c24.rs.http.converters;

import com.c24.rs.bl.TariffFeature;
import com.c24.rs.common.JsonReader;

import org.json.JSONObject;

public class Json2TariffFeatureConverter {
    public TariffFeature convert(JSONObject json){
        TariffFeature instance = new TariffFeature()
                .id(JsonReader.getInt(json, "id"))
                .name(JsonReader.getString(json, "name"))
                .value(JsonReader.getString(json, "value"))
                ;

        return instance;
    }
}
