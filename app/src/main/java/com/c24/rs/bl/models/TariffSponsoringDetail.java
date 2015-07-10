package com.c24.rs.bl.models;

public class TariffSponsoringDetail {
    private String mText = "";
    public String getText() {
        return mText;
    }
    public void setText(String val) {
        mText = val;
    }
    public TariffSponsoringDetail text(String val) {
        this.setText(val);
        return this;
    }

    private Boolean mIsTopGrade = false;
    public Boolean getIsTopGrade() {
        return mIsTopGrade;
    }
    public void setIsTopGrade(Boolean val) {
        mIsTopGrade = val;
    }
    public TariffSponsoringDetail isTopGrade(Boolean val) {
        this.setIsTopGrade(val);
        return this;
    }
}
