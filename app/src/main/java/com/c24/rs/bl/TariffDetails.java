package com.c24.rs.bl;

public class TariffDetails {
    private Integer mId;
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

    private String mName;
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

    private Double mGrade;
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

    private Integer mScore;
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
}
