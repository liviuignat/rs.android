package com.c24.rs.bl.queries;

import com.c24.rs.bl.models.Tariff;
import com.c24.rs.common.CacheKeys;
import com.c24.rs.common.ComplexPreferences;
import com.c24.rs.http.TariffHttp;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.json.JSONException;

import java.io.IOException;

@EBean
public class SearchByIdQueryHandler {
    @Bean
    public TariffHttp tariffHttp;

    @Bean
    public ComplexPreferences complexPreferences;

    public Tariff query(SearchTariffByIdQuery query) throws IOException, JSONException {
        if(query.getSearchTariffQuery() == null) {
            query.setSearchTariffQuery(complexPreferences.getObject(CacheKeys.CURRENT_SEARCH_QUERY, SearchTariffQuery.class));
        }

        Tariff tariff = tariffHttp.getTariffById(query.getTariffId(), query.getSearchTariffQuery());

        complexPreferences.putObject(CacheKeys.CURRENT_TARIFF_LIST + query.getTariffId(), tariff);
        complexPreferences.commit();

        return tariff;
    }
}
