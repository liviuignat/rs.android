package com.c24.rs.app.screens;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.c24.rs.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.search_activity)
public class SearchActivity extends AppCompatActivity {

    @ViewById(R.id.insuredPerson)
    public Spinner insuredPersonSpinner;

    @AfterViews
    public void init() {
        Context context = this;

        String[] insuredPersonTypeArray = getResources().getStringArray(R.array.insured_person_type_array);
        insuredPersonSpinner.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, insuredPersonTypeArray));
        //insuredPersonSpinner.setAdapter(mEventTypesAdapter);

    }

}
