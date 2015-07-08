package com.c24.rs.app.screens;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.c24.rs.R;
import com.c24.rs.app.ActivityBase;
import com.c24.rs.app.adapters.TariffsListAdapter;
import com.c24.rs.bl.Tariff;
import com.c24.rs.bl.queries.SearchTariffQuery;
import com.c24.rs.bl.queries.SearchTariffQueryHandler;

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
public class MainActivity extends ActivityBase {

    public static String PARAM_SEARCH = "PARAM_SEARCH";
    public SearchTariffQuery tariffSearchQuery;

    @Bean
    public SearchTariffQueryHandler searchTariffQueryHandler;

    @OptionsMenuItem(R.id.action_settings)
    public MenuItem menuSettings;

    @ViewById(R.id.tariffs_list)
    public ListView tariffsList;

    @Bean
    public TariffsListAdapter tariffListAdapter;

    public ProgressDialog loadingDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = this.getIntent().getExtras();
        tariffSearchQuery = (SearchTariffQuery)args.getSerializable(PARAM_SEARCH);
    }

    @AfterViews
    public void init() {
        loadingDialog = ProgressDialog.show(this, "", "Loading. Please wait...", true);
        doGetTarifsAsync();
    }

    @OptionsItem(R.id.action_settings)
    public boolean menuSettingsSelected() {
        return true;
    }

    @Background
    public void doGetTarifsAsync() {
        try {
            ArrayList<Tariff> tariffs = searchTariffQueryHandler.query(this.tariffSearchQuery);
            bindTariffs(tariffs);
        } catch (IOException e) {
            onError(e);
        } catch (JSONException e) {
            onError(e);
        }
    }

    @UiThread
    public void bindTariffs(ArrayList<Tariff> tariffs) {
        tariffListAdapter.initAdapter(tariffs);
        tariffsList.setAdapter(tariffListAdapter);
        this.loadingDialog.hide();
    }

    @UiThread
    public void onError(Exception ex) {
        this.loadingDialog.hide();
    }
}
