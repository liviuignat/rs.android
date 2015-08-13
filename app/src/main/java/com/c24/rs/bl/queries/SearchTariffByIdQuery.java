package com.c24.rs.bl.queries;

public class SearchTariffByIdQuery {
    private Integer mTariffId = 0;
    public Integer getTariffId() {
        return mTariffId;
    }
    public void setTariffId(Integer val) {
        mTariffId = val;
    }
    public SearchTariffByIdQuery tariffId(Integer val) {
        this.setTariffId(val);
        return this;
    }


    private SearchTariffQuery mSearchTariffQuery;
    public SearchTariffQuery getSearchTariffQuery() {
        return mSearchTariffQuery;
    }
    public void setSearchTariffQuery(SearchTariffQuery val) {
        mSearchTariffQuery = val;
    }
    public SearchTariffByIdQuery searchTariffQuery(SearchTariffQuery val) {
        this.setSearchTariffQuery(val);
        return this;
    }
}
