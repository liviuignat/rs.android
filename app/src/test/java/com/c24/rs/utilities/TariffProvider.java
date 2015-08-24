package com.c24.rs.utilities;

import com.c24.rs.domain.models.Tariff;
import com.c24.rs.http.converters.Json2TariffConverter_;

import org.json.JSONException;
import org.robolectric.RuntimeEnvironment;

public class TariffProvider {
    public static Tariff getSingleTariff() throws JSONException {
        Json2TariffConverter_ converter = Json2TariffConverter_.getInstance_(RuntimeEnvironment.application);
        return converter.convert(TariffJsonProvider.getSingleTariffJson());
    }
}
