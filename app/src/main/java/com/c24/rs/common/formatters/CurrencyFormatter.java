package com.c24.rs.common.formatters;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class CurrencyFormatter {
    public String get(Double value) {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        return format.format(value);
    }

    public String get(Double value, String currencySymbol) {

        if(currencySymbol == null) {
            currencySymbol = "";
        }

        NumberFormat df = NumberFormat.getCurrencyInstance();
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setCurrencySymbol(currencySymbol);
        dfs.setGroupingSeparator('.');
        dfs.setMonetaryDecimalSeparator(',');
        ((DecimalFormat) df).setDecimalFormatSymbols(dfs);

        return df.format(value);
    }
}

