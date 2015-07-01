package com.c24.rs.bl;

import java.util.ArrayList;

public class Tariff {
    public Tariff () {
        setInsuranceInfo(new InsuranceInfo());
        setTariffInfo(new TariffDetails());
        setPricingDetails(new PricingDetails());
        setTariffFeatures(new ArrayList<TariffFeature>());
    }

    public Integer getId() {
        return this.getTariffInfo().getId();
    }
    
    private TariffDetails mTariffInfo;
    public TariffDetails getTariffInfo() {
        return mTariffInfo;
    }
    public void setTariffInfo(TariffDetails val) {
        mTariffInfo = val;
    }
    public Tariff tariffInfo(TariffDetails val) {
        this.setTariffInfo(val);
        return this;
    }

    private PricingDetails mPricingDetails;
    public PricingDetails getPricingDetails() {
        return mPricingDetails;
    }
    public void setPricingDetails(PricingDetails val) {
        mPricingDetails = val;
    }
    public Tariff pricintDetails(PricingDetails val) {
        this.setPricingDetails(val);
        return this;
    }

    private InsuranceInfo mInsuranceInfo;
    public InsuranceInfo getInsuranceInfo() {
        return mInsuranceInfo;
    }
    public void setInsuranceInfo(InsuranceInfo val) {
        mInsuranceInfo = val;
    }
    public Tariff insuranceInfo(InsuranceInfo val) {
        this.setInsuranceInfo(val);
        return this;
    }

    private ArrayList<TariffFeature> mTariffFeatures;
    public ArrayList<TariffFeature> getTariffFeatures() {
        return mTariffFeatures;
    }
    public void setTariffFeatures(ArrayList<TariffFeature> val) {
        mTariffFeatures = val;
    }
    public Tariff tariffFeatures(ArrayList<TariffFeature> val) {
        this.setTariffFeatures(val);
        return this;
    }
}
