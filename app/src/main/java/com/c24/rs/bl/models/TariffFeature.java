package com.c24.rs.bl.models;

public class TariffFeature {
    private Integer mId;
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

    private String mName;
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

    private String mValue;
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
}
