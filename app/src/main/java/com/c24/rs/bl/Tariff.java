package com.c24.rs.bl;

/**
 * Created by liviu.ignat on 6/30/2015.
 */
public class Tariff {
    private Integer mId;
    public Integer getId() {
        return mId;
    }
    public void setId(Integer val) {
        mId = val;
    }
    public Tariff id(Integer val) {
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
    public Tariff name(String val) {
        this.setName(val);
        return this;
    }


}
