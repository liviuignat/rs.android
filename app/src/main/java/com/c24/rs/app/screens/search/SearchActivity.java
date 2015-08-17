package com.c24.rs.app.screens.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.c24.rs.R;
import com.c24.rs.app.ActivityBase;
import com.c24.rs.app.screens.tariffList.TariffListActivity;
import com.c24.rs.common.KeyValueElement;
import com.c24.rs.domain.models.search.EMPLOYMENT_STATUS;
import com.c24.rs.domain.models.search.FAMILY_STATUS;
import com.c24.rs.domain.queries.SearchTariffQuery;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.CheckedChange;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemSelect;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.search_activity)
public class SearchActivity extends ActivityBase {
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
    public Spinner familyStatusSpinner;

    @ViewById(R.id.employmentStatus)
    public Spinner employmentStatusSpinner;

    @ViewById(R.id.partnerEmploymentStatusContainer)
    public LinearLayout partnerEmploymentStatusContainer;

    @ViewById(R.id.partnerEmploymentStatus)
    public Spinner partnerEmploymentSatusSpinner;

    @ViewById(R.id.searchButton)
    public Button searchButton;

    @ViewById(R.id.rentOptionsContainer)
    public LinearLayout rentOptionsContainer;

    @ViewById(R.id.wantsBusinessContainer)
    public LinearLayout wantsBusinessContainer;

    @ViewById(R.id.wantsBusiness_yes)
    public RadioButton wantsBusiness;

    @ViewById(R.id.wantsBusiness_no)
    public RadioButton wantsBusiness_no;

    @ViewById(R.id.numberOfEmployeesContainer)
    public LinearLayout numberOfEmployeesContainer;

    @ViewById(R.id.numberOfEmployeesSpinner)
    public Spinner numberOfEmployeesSpinner;

    @Bean
    public SearchOptionsFactory searchOptionsFactory;

    @AfterViews
    public void init() {
        wantsPrivateCheckbox.setChecked(true);
        wantsOccupationCheckbox.setChecked(true);
        wantsTrafficCheckbox.setChecked(true);
        wantsBusiness.setChecked(false);
        wantsBusiness_no.setChecked(true);

        familyStatusSpinner.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, searchOptionsFactory.getFamilyStatuses()));
        employmentStatusSpinner.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, searchOptionsFactory.getEmploymentStatuses()));
        partnerEmploymentSatusSpinner.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, searchOptionsFactory.getEmploymentStatuses()));
        numberOfPropertiesSpinner.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, searchOptionsFactory.getRentNumberOfRooms()));
        rentIncomeSpinner.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, searchOptionsFactory.getRentIncomes()));
        numberOfEmployeesSpinner.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, searchOptionsFactory.getNumberOfEmployees()));

        rentIncomeSpinner.setSelection(1);
        familyStatusSpinner.setSelection(3);

        wantsRentChanged();
        wantsBusinessChanged();
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
    public void searchButtonClicked() {
        TariffListActivity.initialize(context, getSearchTariffQuery());
    }

    public SearchTariffQuery getSearchTariffQuery() {
        return new SearchTariffQuery()
            .wantsPrivate(wantsPrivateCheckbox.isChecked())
            .wantsOccupation(wantsOccupationCheckbox.isChecked())
            .wantsTraffic(wantsTrafficCheckbox.isChecked())
            .wantsResidence(wantsResidenceCheckbox.isChecked())
            .wantsRent(wantsRentCheckbox.isChecked())
            .familyStatus(searchOptionsFactory.getFamilyStatuses()[familyStatusSpinner.getSelectedItemPosition()].getKey())
            .employmentStatus(searchOptionsFactory.getEmploymentStatuses()[employmentStatusSpinner.getSelectedItemPosition()].getKey())
            .partnerEmploymentStatus(searchOptionsFactory.getEmploymentStatuses()[partnerEmploymentSatusSpinner.getSelectedItemPosition()].getKey())
            .earlyGrossIncome(searchOptionsFactory.getRentIncomes()[rentIncomeSpinner.getSelectedItemPosition()].getKey())
            .numberOfPropertiesRentedOut(searchOptionsFactory.getRentNumberOfRooms()[numberOfPropertiesSpinner.getSelectedItemPosition()].getKey())
            .wantsBusiness(wantsBusiness.isChecked())
            .businessNumberOfEmployees(numberOfEmployeesSpinner.getSelectedItemPosition())
        ;
    }

    @CheckedChange(R.id.wantsRent)
    public void wantsRentChanged() {
        if(wantsRentCheckbox.isChecked()) {
            rentOptionsContainer.setVisibility(View.VISIBLE);
        } else {
            rentOptionsContainer.setVisibility(View.GONE);
        }
    }

    @ItemSelect({R.id.employmentStatus, R.id.partnerEmploymentStatus})
    public void employmentStatusChanged(boolean selected, int position) {
        EMPLOYMENT_STATUS employmentStatus = searchOptionsFactory.getEmploymentStatuses()[position].getKey();
        if(selected && employmentStatus == EMPLOYMENT_STATUS.FREELANCER) {
            wantsBusinessContainer.setVisibility(View.VISIBLE);
        } else {
            wantsBusinessContainer.setVisibility(View.GONE);
        }
    }

    @CheckedChange(R.id.wantsBusiness_yes)
    public void wantsBusinessChanged() {
        if(this.wantsBusiness.isChecked()) {
            numberOfEmployeesContainer.setVisibility(View.VISIBLE);
        } else {
            numberOfEmployeesContainer.setVisibility(View.GONE);
        }
    }

    public static void initialize(Context context) {
        Intent intent = new Intent(context, SearchActivity_.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);

        context.startActivity(intent);
    }

}
