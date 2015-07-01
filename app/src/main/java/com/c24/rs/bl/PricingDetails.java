package com.c24.rs.bl;

/**
 * Created by liviu.ignat on 7/1/2015.
 */
public class PricingDetails {
    private Double mAmount;
    public Double getAmount() {
        return mAmount;
    }
    public void setAmount(Double val) {
        mAmount = val;
    }
    public PricingDetails amount(Double val) {
        this.setAmount(val);
        return this;
    }


    private Integer mPaymentPeriod;
    public Integer getPaymentPeriod() {
        return mPaymentPeriod;
    }
    public void setPaymentPeriod(Integer val) {
        mPaymentPeriod = val;
    }
    public PricingDetails paymentPeriod(Integer val) {
        this.setPaymentPeriod(val);
        return this;
    }

}
