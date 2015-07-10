package com.c24.rs.app;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.c24.rs.R;

public class ActivityBase extends AppCompatActivity {
    private View customActionView;

    protected Context context;

    protected Boolean shouldShowActionBar() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(shouldShowActionBar()) {
            requestWindowFeature(Window.FEATURE_ACTION_BAR);
            supportRequestWindowFeature(Window.FEATURE_ACTION_BAR);
        }

        super.onCreate(savedInstanceState);

        context = this;

        if(shouldShowActionBar() && getSupportActionBar() != null) {
            LayoutInflater inflator = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            customActionView = inflator.inflate(R.layout.actionbar_title_view, null);

            ActionBar actionBar = getSupportActionBar();

            actionBar.setElevation(0F);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowHomeEnabled(true);

            actionBar.setCustomView(customActionView);
            actionBar.setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.c24_header)));

            String title = getTitle().toString();
            setTitle(title);
        }
    }

    private Toolbar mActionBarToolbar;
    protected Toolbar getActionBarToolbar() {
        if (mActionBarToolbar == null) {
            mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
            if (mActionBarToolbar != null) {
                setSupportActionBar(mActionBarToolbar);
            }
        }
        return mActionBarToolbar;
    }

    @Override
    public void setTitle(CharSequence title) {
        if(customActionView != null) {
            ActionBar actionBar = getSupportActionBar();
            ((TextView) customActionView.findViewById(R.id.title)).setText(title);
            actionBar.setTitle("");
        } else {
            super.setTitle(title);
        }
    }
}
