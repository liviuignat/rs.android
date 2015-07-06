package com.c24.rs.http.converters;

import com.c24.rs.bl.models.PricingDetails;
import com.c24.rs.common.JsonReader;

import org.androidannotations.annotations.EBean;
import org.json.JSONObject;

@EBean
public class Json2PricingDetailsConverter {
    public PricingDetails convert(JSONObject json){
        PricingDetails instance = new PricingDetails()
                .amount(JsonReader.getDouble(json, "amount"))
                .paymentPeriod(JsonReader.getInt(json, "paymentPeriod"))
                ;

        return instance;
    }
}
