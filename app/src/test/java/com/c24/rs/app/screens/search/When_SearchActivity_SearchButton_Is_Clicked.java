package com.c24.rs.app.screens.search;

import com.c24.rs.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class When_SearchActivity_SearchButton_Is_Clicked {
    SearchActivity activity;

    @Before
    public void setUp() {
        //activity = Robolectric.setupActivity(SearchActivity.class);
    }

    @Test
    public void should_show_tariff_list() throws Exception {
    }
}
