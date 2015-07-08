package com.c24.rs.bl.queries;

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
}
