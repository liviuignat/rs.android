package com.c24.rs.http.converters;

import com.c24.rs.bl.TariffDetails;
import com.c24.rs.common.JsonReader;

import org.json.JSONObject;

public class Json2TariffDetailsConverter {
    public TariffDetails convert(JSONObject json){
        TariffDetails instance = new TariffDetails()
                .id(JsonReader.getInt(json, "id"))
                .name(JsonReader.getString(json, "name"))
                ;

        return instance;
    }
}
