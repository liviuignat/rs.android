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
    
}
