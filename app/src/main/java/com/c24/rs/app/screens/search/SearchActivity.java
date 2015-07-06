package com.c24.rs.app.screens.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.c24.rs.R;
import com.c24.rs.app.ActivityBase;
import com.c24.rs.app.adapters.KeyValueElement;
import com.c24.rs.app.screens.tariffList.TariffListActivity;
import com.c24.rs.app.screens.tariffList.TariffListActivity_;
import com.c24.rs.bl.models.search.FAMILY_STATUS;
import com.c24.rs.bl.queries.SearchTariffQuery;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.CheckedChange;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemSelect;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.search_activity)
public class SearchActivity extends ActivityBase {

    public Context context;

    @ViewById(R.id.wantsPrivate)
    public CheckBox wantsPrivateCheckbox;

    @ViewById(R.id.wantsOccupation)
    public CheckBox wantsOccupationCheckbox;

    @ViewById(R.id.wantsTraffic)
    public CheckBox wantsTrafficCheckbox;

    @ViewById(R.id.wantsResidence)
    public CheckBox wantsResidenceCheckbox;

    @ViewById(R.id.wantsRent)
    public CheckBox wantsRentCheckbox;

    @ViewById(R.id.numberOfProperties)
    public Spinner numberOfPropertiesSpinner;

    @ViewById(R.id.rentIncome)
    public Spinner rentIncomeSpinner;

    @ViewById(R.id.insuredPerson)
    public Spinner insuredPersonSpinner;

    @ViewById(R.id.employmentStatus)
    public Spinner employmentStatusSpinner;

    @ViewById(R.id.partnerEmploymentStatus)
    public Spinner partnerEmploymentSatusSpinner;

    @ViewById(R.id.searchButton)
    public Button searchButton;

    @ViewById(R.id.rentOptionsContainer)
    public LinearLayout rentOptionsContainer;

    @ViewById(R.id.partnerEmploymentStatusContainer)
    public LinearLayout partnerEmploymentStatusContainer;

    @Bean
    public SearchOptionsFactory searchOptionsFactory;

    @AfterViews
    public void init() {
        this.context = this;

        wantsPrivateCheckbox.setChecked(true);
        wantsOccupationCheckbox.setChecked(true);
        wantsTrafficCheckbox.setChecked(true);

        insuredPersonSpinner.setAdapter(new ArrayAdapter<>(this.context, android.R.layout.simple_spinner_dropdown_item, searchOptionsFactory.getFamilyStatuses()));
        employmentStatusSpinner.setAdapter(new ArrayAdapter<>(this.context, android.R.layout.simple_spinner_dropdown_item, searchOptionsFactory.getEmploymentStatuses()));
        partnerEmploymentSatusSpinner.setAdapter(new ArrayAdapter<>(this.context, android.R.layout.simple_spinner_dropdown_item, searchOptionsFactory.getEmploymentStatuses()));
        numberOfPropertiesSpinner.setAdapter(new ArrayAdapter<>(this.context, android.R.layout.simple_spinner_dropdown_item, searchOptionsFactory.getRentNumberOfRooms()));
        rentIncomeSpinner.setAdapter(new ArrayAdapter<>(this.context, android.R.layout.simple_spinner_dropdown_item, searchOptionsFactory.getRentIncomes()));

        insuredPersonSpinner.setSelection(3);

        wantsRentChanged();
    }

    @ItemSelect(R.id.insuredPerson)
    public void myListItemSelected(boolean selected, int position) {
        KeyValueElement<FAMILY_STATUS, String> selectedElement = searchOptionsFactory.getFamilyStatuses()[position];
        if(selectedElement.getKey() == FAMILY_STATUS.COUPLE ||  selectedElement.getKey() == FAMILY_STATUS.FAMILY) {
            partnerEmploymentStatusContainer.setVisibility(View.VISIBLE);
        } else {
            partnerEmploymentStatusContainer.setVisibility(View.GONE);
        }
    }

    @Click(R.id.searchButton)
    void searchButtonClicked() {
        SearchTariffQuery searchTariffQuery = new SearchTariffQuery()
                .wantsPrivate(wantsPrivateCheckbox.isChecked())
                .wantsOccupation(wantsOccupationCheckbox.isChecked())
                .wantsTraffic(wantsTrafficCheckbox.isChecked())
                .wantsResidence(wantsResidenceCheckbox.isChecked())
                .wantsRent(wantsRentCheckbox.isChecked());

        Intent intent = new Intent(this.context, TariffListActivity_.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(TariffListActivity.PARAM_SEARCH, searchTariffQuery);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    @CheckedChange(R.id.wantsRent)
    public void wantsRentChanged() {
        if(wantsRentCheckbox.isChecked()) {
            rentOptionsContainer.setVisibility(View.VISIBLE);
        } else {
            rentOptionsContainer.setVisibility(View.GONE);
        }
    }

}
