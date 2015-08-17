package com.c24.rs.domain.models;

import java.io.Serializable;
import java.util.ArrayList;

public class TariffDetails implements Serializable {
    private Integer mId = 0;
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

    private String mName = "";
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

    private Double mGrade = 0.0;
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

    private Integer mScore = 0;
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

    private Boolean mIsSponsored = false;
    public Boolean getIsSponsored() {
        return mIsSponsored;
    }
    public void setIsSponsored(Boolean val) {
        mIsSponsored = val;
    }
    public TariffDetails isSponsored(Boolean val) {
        this.setIsSponsored(val);
        return this;
    }

    private TariffSponsoringDetail mSponsoringDetail = new TariffSponsoringDetail();
    public TariffSponsoringDetail getSponsoringDetail() {
        return mSponsoringDetail;
    }
    public void setSponsoringDetail(TariffSponsoringDetail val) {
        mSponsoringDetail = val;
    }
    public TariffDetails sponsoringDetail(TariffSponsoringDetail val) {
        this.setSponsoringDetail(val);
        return this;
    }


    private ArrayList<TariffFeature> mTariffFeatures = new ArrayList<>();
    public ArrayList<TariffFeature> getTariffFeatures() {
        return mTariffFeatures;
    }
    public void setTariffFeatures(ArrayList<TariffFeature> val) {
        mTariffFeatures = val;
    }
    public TariffDetails tariffFeatures(ArrayList<TariffFeature> val) {
        this.setTariffFeatures(val);
        return this;
    }
    
    private ArrayList<TariffFeature> mDetailedFeatures = new ArrayList<>();
    public ArrayList<TariffFeature> getDetailedFeatures() {
        return mDetailedFeatures;
    }
    public void setDetailedFeatures(ArrayList<TariffFeature> val) {
        mDetailedFeatures = val;
    }
    public TariffDetails detailedFeatures(ArrayList<TariffFeature> val) {
        this.setDetailedFeatures(val);
        return this;
    }

    private ArrayList<TariffFeature> mScoredFeatures = new ArrayList<>();
    public ArrayList<TariffFeature> getScoredFeatures() {
        return mScoredFeatures;
    }
    public void setScoredFeatures(ArrayList<TariffFeature> val) {
        mScoredFeatures = val;
    }
    public TariffDetails scoredFeatures(ArrayList<TariffFeature> val) {
        this.setScoredFeatures(val);
        return this;
    }

    private ArrayList<TariffFeatureGroup> mDetailedFeatureGroups;
    public ArrayList<TariffFeatureGroup> getDetailedFeatureGroups() {
        return mDetailedFeatureGroups;
    }
    public void setDetailedFeatureGroups(ArrayList<TariffFeatureGroup> val) {
        mDetailedFeatureGroups = val;
    }
    public TariffDetails detailedFeatureGroups(ArrayList<TariffFeatureGroup> val) {
        this.setDetailedFeatureGroups(val);
        return this;
    }

    private ArrayList mScoredFeaturesGroups;
    public ArrayList getScoredFeaturesGroups() {
        return mScoredFeaturesGroups;
    }
    public void setScoredFeaturesGroups(ArrayList val) {
        mScoredFeaturesGroups = val;
    }
    public TariffDetails scoredFeaturesGroups(ArrayList val) {
        this.setScoredFeaturesGroups(val);
        return this;
    }

    private ArrayList<TariffImportantHint> mImportantHints = new ArrayList<>();;
    public ArrayList<TariffImportantHint> getImportantHints() {
        return mImportantHints;
    }
    public void setImportantHints(ArrayList<TariffImportantHint> val) {
        mImportantHints = val;
    }
    public TariffDetails importantHints(ArrayList<TariffImportantHint> val) {
        this.setImportantHints(val);
        return this;
    }
}
