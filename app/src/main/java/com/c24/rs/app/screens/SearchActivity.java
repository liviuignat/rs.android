package com.c24.rs.app.screens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.c24.rs.R;
import com.c24.rs.bl.queries.SearchTariffQuery;
import com.c24.rs.bl.queries.SearchTariffQueryHandler;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.search_activity)
public class SearchActivity extends AppCompatActivity {

    public Context context;

    @Bean
    public SearchTariffQueryHandler searchTariffQueryHandler;

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

    @ViewById(R.id.insuredPerson)
    public Spinner insuredPersonSpinner;

    @ViewById(R.id.employmentStatus)
    public Spinner employmentStatusSpinner;

    @ViewById(R.id.partnerEmploymentStatus)
    public Spinner partnerEmploymentSatusSpinner;

    @ViewById(R.id.searchButton)
    public Button searchButton;

    @AfterViews
    public void init() {
        this.context = this;

        wantsPrivateCheckbox.setChecked(true);
        wantsOccupationCheckbox.setChecked(true);
        wantsTrafficCheckbox.setChecked(true);

        String[] insuredPersonTypeArray = getResources().getStringArray(R.array.insured_person_type_array);
        insuredPersonSpinner.setAdapter(new ArrayAdapter<>(this.context, android.R.layout.simple_spinner_dropdown_item, insuredPersonTypeArray));

        String[] employmentStatusArray = getResources().getStringArray(R.array.employment_status_array);
        employmentStatusSpinner.setAdapter(new ArrayAdapter<>(this.context, android.R.layout.simple_spinner_dropdown_item, employmentStatusArray));
        partnerEmploymentSatusSpinner.setAdapter(new ArrayAdapter<>(this.context, android.R.layout.simple_spinner_dropdown_item, employmentStatusArray));
    }

    @Click(R.id.searchButton)
    void searchButtonClicked() {
        SearchTariffQuery searchTariffQuery = new SearchTariffQuery()
                .wantsPrivate(wantsPrivateCheckbox.isChecked())
                .wantsOccupation(wantsOccupationCheckbox.isChecked())
                .wantsTraffic(wantsTrafficCheckbox.isChecked())
                .wantsResidence(wantsResidenceCheckbox.isChecked())
                .wantsRent(wantsRentCheckbox.isChecked());

        Intent intent = new Intent(this.context, MainActivity_.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(MainActivity.PARAM_SEARCH, searchTariffQuery);
        intent.putExtras(bundle);

        startActivity(intent);
    }

}
