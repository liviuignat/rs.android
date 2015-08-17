package com.c24.rs.domain.queries;

import com.c24.rs.domain.models.search.EMPLOYMENT_STATUS;
import com.c24.rs.domain.models.search.FAMILY_STATUS;

import java.io.Serializable;

public class SearchTariffQuery implements Serializable {
    private Boolean mWantsPrivate = false;
    public Boolean getWantsPrivate() {
        return mWantsPrivate;
    }
    public void setWantsPrivate(Boolean val) {
        mWantsPrivate = val;
    }
    public SearchTariffQuery wantsPrivate(Boolean val) {
        this.setWantsPrivate(val);
        return this;
    }

    private Boolean mWantsOccupation = false;
    public Boolean getWantsOccupation() {
        return mWantsOccupation;
    }
    public void setWantsOccupation(Boolean val) {
        mWantsOccupation = val;
    }
    public SearchTariffQuery wantsOccupation(Boolean val) {
        this.setWantsOccupation(val);
        return this;
    }

    private Boolean mWantsTraffic = false;
    public Boolean getWantsTraffic() {
        return mWantsTraffic;
    }
    public void setWantsTraffic(Boolean val) {
        mWantsTraffic = val;
    }
    public SearchTariffQuery wantsTraffic(Boolean val) {
        this.setWantsTraffic(val);
        return this;
    }

    private Boolean mWantsResidence = false;
    public Boolean getWantsResidence() {
        return mWantsResidence;
    }
    public void setWantsResidence(Boolean val) {
        mWantsResidence = val;
    }
    public SearchTariffQuery wantsResidence(Boolean val) {
        this.setWantsResidence(val);
        return this;
    }

    private Boolean mWantsRent = false;
    public Boolean getWantsRent() {
        return mWantsRent;
    }
    public void setWantsRent(Boolean val) {
        mWantsRent = val;
    }
    public SearchTariffQuery wantsRent(Boolean val) {
        this.setWantsRent(val);
        return this;
    }

    private FAMILY_STATUS mFamilyStatus = FAMILY_STATUS.FAMILY;
    public FAMILY_STATUS getFamilyStatus() {
        return mFamilyStatus;
    }
    public void setFamilyStatus(FAMILY_STATUS val) {
        mFamilyStatus = val;
    }
    public SearchTariffQuery familyStatus(FAMILY_STATUS val) {
        this.setFamilyStatus(val);
        return this;
    }

    private EMPLOYMENT_STATUS mEmploymentStatus = EMPLOYMENT_STATUS.NOT_SPECIFIED;
    public EMPLOYMENT_STATUS getEmploymentStatus() {
        return mEmploymentStatus;
    }
    public void setEmploymentStatus(EMPLOYMENT_STATUS val) {
        mEmploymentStatus = val;
    }
    public SearchTariffQuery employmentStatus(EMPLOYMENT_STATUS val) {
        this.setEmploymentStatus(val);
        return this;
    }

    private EMPLOYMENT_STATUS mPartnerEmploymentStatus = EMPLOYMENT_STATUS.NOT_SPECIFIED;
    public EMPLOYMENT_STATUS getPartnerEmploymentStatus() {
        return mPartnerEmploymentStatus;
    }
    public void setPartnerEmploymentStatus(EMPLOYMENT_STATUS val) {
        mPartnerEmploymentStatus = val;
    }
    public SearchTariffQuery partnerEmploymentStatus(EMPLOYMENT_STATUS val) {
        this.setPartnerEmploymentStatus(val);
        return this;
    }

    private Double mEarlyGrossIncome = 6000.0;
    public Double getEarlyGrossIncome() {
        return mEarlyGrossIncome;
    }
    public void setEarlyGrossIncome(Double val) {
        mEarlyGrossIncome = val;
    }
    public SearchTariffQuery earlyGrossIncome(Double val) {
        this.setEarlyGrossIncome(val);
        return this;
    }

    private Integer mNumberOfPropertiesRentedOut = 0;
    public Integer getNumberOfPropertiesRentedOut() {
        return mNumberOfPropertiesRentedOut;
    }
    public void setNumberOfPropertiesRentedOut(Integer val) {
        mNumberOfPropertiesRentedOut = val;
    }
    public SearchTariffQuery numberOfPropertiesRentedOut(Integer val) {
        this.setNumberOfPropertiesRentedOut(val);
        return this;
    }

    private Boolean mWantsBusiness = false;
    public Boolean getWantsBusiness() {
        return mWantsBusiness;
    }
    public void setWantsBusiness(Boolean val) {
        mWantsBusiness = val;
    }
    public SearchTariffQuery wantsBusiness(Boolean val) {
        this.setWantsBusiness(val);
        return this;
    }

    private Integer mBusinessNumberOfEmployees = 0;
    public Integer getBusinessNumberOfEmployees() {
        return mBusinessNumberOfEmployees;
    }
    public void setBusinessNumberOfEmployees(Integer val) {
        mBusinessNumberOfEmployees = val;
    }
    public SearchTariffQuery businessNumberOfEmployees(Integer val) {
        this.setBusinessNumberOfEmployees(val);
        return this;
    }


    public Boolean getIsMarriedOrCohabitating() {
        return this.getFamilyStatus() == FAMILY_STATUS.COUPLE ||  this.getFamilyStatus() == FAMILY_STATUS.FAMILY;
    }

}
