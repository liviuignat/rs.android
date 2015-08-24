package com.c24.rs.domain.queries;

import com.c24.rs.BuildConfig;
import com.c24.rs.common.ComplexPreferences;
import com.c24.rs.domain.models.Tariff;
import com.c24.rs.http.TariffHttp;
import com.c24.rs.utilities.TariffProvider;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class SearchByIdQueryHandlerTest {

    SearchByIdQueryHandler queryHandler;
    Tariff queriedTariff;

    @Before
    public void setUp() throws IOException, JSONException {
        //queryHandler  = SearchByIdQueryHandler_.getInstance_(RuntimeEnvironment.application);
        queryHandler = new SearchByIdQueryHandler();
        queryHandler.tariffHttp = Mockito.mock(TariffHttp.class);
        queryHandler.complexPreferences = Mockito.mock(ComplexPreferences.class);

        Mockito.doReturn(TariffProvider.getSingleTariff()).when(queryHandler.tariffHttp).getTariffById(Mockito.anyInt(), Mockito.any(SearchTariffQuery.class));

        queriedTariff = queryHandler.query(new SearchTariffByIdQuery());
    }

    @Test
    public void should_have_4_detailed_tariff_feature_groups() throws IOException, JSONException {
        assertEquals(queriedTariff.getTariffInfo().getDetailedFeatureGroups().size(), 4);
    }

    @Test
    public void should_have_4_scored_tariff_feature_groups() throws IOException, JSONException {
        assertEquals(queriedTariff.getTariffInfo().getScoredFeaturesGroups().size(), 4);
    }
}