package com.c24.rs.http.converters;

import com.c24.rs.bl.InsuranceInfo;
import com.c24.rs.common.JsonReader;

import org.androidannotations.annotations.EBean;
import org.json.JSONObject;

@EBean
public class Json2InsuranceInfoConverter {
    public InsuranceInfo convert(JSONObject json){
        InsuranceInfo instance = new InsuranceInfo()
                .id(JsonReader.getInt(json, "id"))
                .name(JsonReader.getString(json, "name"))
                .description(JsonReader.getString(json, "description"))
                ;

        return instance;
    }
}
