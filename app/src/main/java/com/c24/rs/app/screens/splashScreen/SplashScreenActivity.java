package com.c24.rs.app.screens.splashScreen;

import android.os.Handler;

import com.c24.rs.R;
import com.c24.rs.app.ActivityBase;
import com.c24.rs.app.screens.search.SearchActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.splash_screen_activity)
public class SplashScreenActivity extends ActivityBase {
    private static int SPLASH_TIME_OUT = 1000;

    @Override
    protected Boolean shouldShowActionBar() {
        return true;
    }

    @AfterViews
    public void init() {
        final SplashScreenActivity view = this;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //do some initialization
                SearchActivity.initialize(view.context);
            }
        }, SPLASH_TIME_OUT);
    }
}
