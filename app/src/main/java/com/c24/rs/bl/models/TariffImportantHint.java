package com.c24.rs.bl.models;

import java.io.Serializable;

public class TariffImportantHint implements Serializable {
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
