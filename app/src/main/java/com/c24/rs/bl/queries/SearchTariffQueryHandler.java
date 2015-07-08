package com.c24.rs.bl.queries;

import com.c24.rs.bl.models.Tariff;
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

    public ArrayList<Tariff> query(SearchTariffQuery query) throws IOException, JSONException {
        return tariffHttp.getTariffs(query);
    }
}
