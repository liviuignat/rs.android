package com.c24.rs.app.screens.search;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.c24.rs.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
public class SearchActivityTest extends ActivityInstrumentationTestCase2<SearchActivity_> {

    private SearchActivity_ activity;

    public SearchActivityTest() {
        super(SearchActivity_.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void test_initially_privat_should_be_shown() {
        onView(withText("Privat")).check(matches(isDisplayed()));
    }

    public void test_when_renting_is_checked_renting_options_should_be_shown() throws InterruptedException {
        onView(withId(R.id.wantsRent)).perform(click());
        onView(withId(R.id.rentOptionsContainer)).check(matches(isDisplayed()));
    }
}