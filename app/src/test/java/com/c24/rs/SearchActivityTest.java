package com.c24.rs;

import com.c24.rs.app.screens.search.SearchActivity_;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertTrue;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class SearchActivityTest {

    SearchActivity_ activity;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(SearchActivity_.class);
    }

    @Test
    public void should_have_activity_defined() throws Exception {
        assertTrue(activity != null);
    }

    @Test
    public void should_have_privat_checkbox_checked() throws Exception {
        assertTrue(activity.wantsPrivateCheckbox.isChecked());
    }
}