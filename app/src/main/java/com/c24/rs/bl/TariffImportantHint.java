package com.c24.rs.bl;

public class TariffImportantHint {
    private String mText;
    public String getText() {
        return mText;
    }
    public void setText(String val) {
        mText = val;
    }
    public TariffImportantHint text(String val) {
        this.setText(val);
        return this;
    }
}
