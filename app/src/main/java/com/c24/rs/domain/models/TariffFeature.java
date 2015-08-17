package com.c24.rs.domain.models;

import java.io.Serializable;

public class TariffFeature implements Serializable {
    private Integer mId = 0;
    public Integer getId() {
        return mId;
    }
    public void setId(Integer val) {
        mId = val;
    }
    public TariffFeature id(Integer val) {
        this.setId(val);
        return this;
    }

    private String mName= "";
    public String getName() {
        return mName;
    }
    public void setName(String val) {
        mName = val;
    }
    public TariffFeature name(String val) {
        this.setName(val);
        return this;
    }

    private String mValue = "";
    public String getValue() {
        return mValue;
    }
    public void setValue(String val) {
        mValue = val;
    }
    public TariffFeature value(String val) {
        this.setValue(val);
        return this;
    }

    private Integer mScore = 0;
    public Integer getScore() {
        return mScore;
    }
    public void setScore(Integer val) {
        mScore = val;
    }
    public TariffFeature score(Integer val) {
        this.setScore(val);
        return this;
    }

    private Integer mMaxScore = 0;
    public Integer getMaxScore() {
        return mMaxScore;
    }
    public void setMaxScore(Integer val) {
        mMaxScore = val;
    }
    public TariffFeature maxScore(Integer val) {
        this.setMaxScore(val);
        return this;
    }


    private TariffFeatureGroup mGroup = new TariffFeatureGroup();
    public TariffFeatureGroup getGroup() {
        return mGroup;
    }
    public void setGroup(TariffFeatureGroup val) {
        mGroup = val;
    }
    public TariffFeature group(TariffFeatureGroup val) {
        this.setGroup(val);
        return this;
    }
}
