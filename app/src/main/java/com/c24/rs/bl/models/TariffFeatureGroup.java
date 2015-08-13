package com.c24.rs.bl.models;

import java.io.Serializable;
import java.util.ArrayList;

public class TariffFeatureGroup implements Serializable {
    private Integer mId = 0;
    public Integer getId() {
        return mId;
    }
    public void setId(Integer val) {
        mId = val;
    }
    public TariffFeatureGroup id(Integer val) {
        this.setId(val);
        return this;
    }

    private String mName = "";
    public String getName() {
        return mName;
    }
    public void setName(String val) {
        mName = val;
    }
    public TariffFeatureGroup name(String val) {
        this.setName(val);
        return this;
    }

    private ArrayList<TariffFeature> mFeatures = new ArrayList<>();
    public ArrayList<TariffFeature> getFeatures() {
        return mFeatures;
    }
    public void setFeatures(ArrayList<TariffFeature> val) {
        mFeatures = val;
    }
    public TariffFeatureGroup features(ArrayList<TariffFeature> val) {
        this.setFeatures(val);
        return this;
    }

}
