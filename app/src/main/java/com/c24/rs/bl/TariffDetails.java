package com.c24.rs.bl;

import java.util.ArrayList;

public class TariffDetails {
    private Integer mId = 0;
    public Integer getId() {
        return mId;
    }
    public void setId(Integer val) {
        mId = val;
    }
    public TariffDetails id(Integer val) {
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
    public TariffDetails name(String val) {
        this.setName(val);
        return this;
    }

    private Double mGrade = 0.0;
    public Double getGrade() {
        return mGrade;
    }
    public void setGrade(Double val) {
        mGrade = val;
    }
    public TariffDetails grade(Double val) {
        this.setGrade(val);
        return this;
    }

    private Integer mScore = 0;
    public Integer getScore() {
        return mScore;
    }
    public void setScore(Integer val) {
        mScore = val;
    }
    public TariffDetails score(Integer val) {
        this.setScore(val);
        return this;
    }

    private ArrayList<TariffFeature> mTariffFeatures = new ArrayList<>();
    public ArrayList<TariffFeature> getTariffFeatures() {
        return mTariffFeatures;
    }
    public void setTariffFeatures(ArrayList<TariffFeature> val) {
        mTariffFeatures = val;
    }
    public TariffDetails tariffFeatures(ArrayList<TariffFeature> val) {
        this.setTariffFeatures(val);
        return this;
    }
}
