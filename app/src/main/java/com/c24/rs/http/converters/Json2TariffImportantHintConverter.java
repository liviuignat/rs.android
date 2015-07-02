package com.c24.rs.http.converters;

import com.c24.rs.bl.TariffImportantHint;
import com.c24.rs.common.JsonReader;

import org.json.JSONObject;

public class Json2TariffImportantHintConverter {
    public TariffImportantHint convert(JSONObject json){
        TariffImportantHint instance = new TariffImportantHint()
                .text(JsonReader.getString(json, "text"))
                ;

        return instance;
    }
}
