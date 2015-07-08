package com.c24.rs.http.converters;

import com.c24.rs.bl.models.TariffImportantHint;
import com.c24.rs.common.JsonReader;

import org.androidannotations.annotations.EBean;
import org.json.JSONObject;

@EBean
public class Json2TariffImportantHintConverter {
    public TariffImportantHint convert(JSONObject json){
        TariffImportantHint instance = new TariffImportantHint()
                .text(JsonReader.getString(json, "text"))
                ;

        return instance;
    }
}
