package com.c24.rs.app.screens.search;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.c24.rs.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SearchActivityTest  {
    @Rule
    public ActivityTestRule<SearchActivity_> mActivityRule = new ActivityTestRule<>(SearchActivity_.class);

    @Test
    public void when_initialized_privat_should_be_shown() {
        onView(withText("Privat")).check(matches(isDisplayed()));
    }

    @Test
    public void when_renting_is_checked_renting_options_should_be_shown() {
        onView(withId(R.id.wantsRent)).perform(click());
        onView(withId(R.id.rentOptionsContainer)).check(matches(isDisplayed()));
    }

    @Test
    public void when_clicking_the_search_button_should_not_display_the_view() {
        onView(withId(R.id.searchButton)).perform(click());
        onView(withId(R.id.searchButton)).check(doesNotExist());
    }
}