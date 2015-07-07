package com.c24.rs.common;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonReader {
    public static <T> T get(JSONObject json, String key, T defaultValue) {
        if(json.has(key)) {
            try {
                return (T)json.get(key);
            } catch (JSONException e) {
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    public static Integer getInt(JSONObject json, String key) {
        return JsonReader.get(json, key, 0);
    }

    public static String getString(JSONObject json, String key) {
        return JsonReader.get(json, key, "");
    }

    public static Boolean getBoolean(JSONObject json, String key) {
        if(json.has(key)) {
            try {
                return json.getBoolean(key);
            } catch (JSONException e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public static Double getDouble(JSONObject json, String key) {
        if(json.has(key)) {
            try {
                return json.getDouble(key);
            } catch (JSONException e) {
                return 0.0;
            }
        } else {
            return 0.0;
        }
    }
}
