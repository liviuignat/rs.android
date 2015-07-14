package com.c24.rs.app.screens.tariffList;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.c24.rs.R;
import com.c24.rs.app.ActivityBase;
import com.c24.rs.app.adapters.TariffsListAdapter;
import com.c24.rs.app.screens.tariffDetail.TariffDetailActivity_;
import com.c24.rs.bl.models.Tariff;
import com.c24.rs.bl.queries.SearchTariffQuery;
import com.c24.rs.bl.queries.SearchTariffQueryHandler;
import com.c24.rs.common.CacheKeys;
import com.c24.rs.common.ComplexPreferences;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
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
public class TariffListActivity extends ActivityBase {

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

    @Bean
    public ComplexPreferences complexPreferences;

    public ProgressDialog loadingDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = this.getIntent().getExtras();
        if(args.containsKey(PARAM_SEARCH)) {
            tariffSearchQuery = (SearchTariffQuery) args.getSerializable(PARAM_SEARCH);
        } else {
            tariffSearchQuery =  complexPreferences.getObject(CacheKeys.CURRENT_SEARCH_QUERY, SearchTariffQuery.class);
        }
    }

    @AfterViews
    public void init() {
        loadingDialog = ProgressDialog.show(this, "", getString(R.string.loading_text), true);
        doGetTarifsAsync();
    }

    @OptionsItem(R.id.action_settings)
    public boolean menuSettingsSelected() {
        return true;
    }

    @ItemClick(R.id.tariffs_list)
    public void tariffListItemClick(Tariff selectedTariff) {
        TariffDetailActivity_.initialize(context, selectedTariff);
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

    public static void initialize(Context context, SearchTariffQuery searchTariffQuery) {
        Intent intent = new Intent(context, TariffListActivity_.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(TariffListActivity.PARAM_SEARCH, searchTariffQuery);
        intent.putExtras(bundle);

        context.startActivity(intent);
    }
}
