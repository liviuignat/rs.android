package com.c24.rs.bl.queries;

import com.c24.rs.bl.models.Tariff;
import com.c24.rs.common.CacheKeys;
import com.c24.rs.common.ComplexPreferences;
import com.c24.rs.http.TariffHttp;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

@EBean
public class SearchTariffQueryHandler {

    @Bean
    public TariffHttp tariffHttp;

    @Bean
    public ComplexPreferences complexPreferences;

    public ArrayList<Tariff> query(SearchTariffQuery query) throws IOException, JSONException {
        ArrayList<Tariff> tariffs = tariffHttp.getTariffs(query);

        complexPreferences.putObject(CacheKeys.CURRENT_SEARCH_QUERY, query);
        complexPreferences.putObject(CacheKeys.CURRENT_TARIFF_LIST, tariffs);
        complexPreferences.commit();

        return tariffs;
    }
}
