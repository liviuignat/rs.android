package com.c24.rs.app.screens.search;

import com.c24.rs.BuildConfig;
import com.c24.rs.app.screens.tariffList.TariffListActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
@PrepareForTest(TariffListActivity.class)
public class When_SearchActivity_SearchButton_Is_Clicked {
    SearchActivity_ activity;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(SearchActivity_.class);
    }

    @Test
    public void should_show_tariff_list() throws Exception {
        PowerMockito.mockStatic(TariffListActivity.class);

        PowerMockito.verifyStatic(Mockito.times(100));
        activity.getSearchTariffQuery();


//        SearchActivity_ spy = Mockito.spy(SearchActivity_.class);
//
//        Mockito.doReturn(new SearchTariffQuery()).when(spy).getSearchTariffQuery();
//
//        spy.searchButtonClicked();
//
//        Mockito.verify(spy).getSearchTariffQuery();
    }
}
