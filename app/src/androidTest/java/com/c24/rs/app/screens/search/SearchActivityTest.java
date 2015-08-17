package com.c24.rs.app.screens.search;

import android.content.Context;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import com.c24.rs.R;

public class SearchActivityTest extends ActivityUnitTestCase<SearchActivity_> {

    private SearchActivity_ activity;

    public SearchActivityTest() {
        super(SearchActivity_.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        Context context = getInstrumentation().getTargetContext();
        context.setTheme(R.style.Theme_AppCompat);

        activity = launchActivity(context.getPackageName(), SearchActivity_.class, null);
        getInstrumentation().waitForIdleSync();
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @SmallTest
    public void should_have_privat_checkbox_checked() {
        assertEquals(activity.wantsPrivateCheckbox.isChecked(), true);
    }
}