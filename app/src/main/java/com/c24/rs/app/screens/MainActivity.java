package com.c24.rs.app.screens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import com.c24.rs.R;
import com.c24.rs.app.adapters.TariffsListAdapter;
import com.c24.rs.bl.Tariff;
import com.c24.rs.http.TariffHttp;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.menu_main)
public class MainActivity extends AppCompatActivity {
    @OptionsMenuItem(R.id.action_settings)
    public MenuItem menuSettings;

    @ViewById(R.id.tariffs_list)
    public ListView tariffsList;

    @Bean
    public TariffsListAdapter tariffListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    public void init() {
        doGetTarifsAsync();
    }

    @OptionsItem(R.id.action_settings)
    public boolean menuSettingsSelected() {
        return true;
    }

    @Background
    public void doGetTarifsAsync() {
        TariffHttp http = new TariffHttp();
        try {
            ArrayList<Tariff> tariffs = http.getTariffs();
            bindTariffs(tariffs);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @UiThread
    public void bindTariffs(ArrayList<Tariff> tariffs) {
        tariffListAdapter.initAdapter(tariffs);
        tariffsList.setAdapter(tariffListAdapter);
    }
}