package com.c24.rs.bl.models;

import java.io.Serializable;

public class InsuranceInfo implements Serializable {
    private Integer mId;
    public Integer getId() {
        return mId;
    }
    public void setId(Integer val) {
        mId = val;
    }
    public InsuranceInfo id(Integer val) {
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
    public InsuranceInfo name(String val) {
        this.setName(val);
        return this;
    }

    private String mDescription;
    public String getDescription() {
        return mDescription;
    }
    public void setDescription(String val) {
        mDescription = val;
    }
    public InsuranceInfo description(String val) {
        this.setDescription(val);
        return this;
    }

}
