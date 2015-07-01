package com.c24.rs.screens;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.c24.rs.bl.Tariff;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

@EBean
public class TariffsListAdapter extends BaseAdapter {
    public List<Tariff> tariffs;

    @RootContext
    public Context context;

    void initAdapter(List<Tariff> tariffs) {
        this.tariffs = tariffs;
    }

    @Override
    public int getCount() {
        return tariffs.size();
    }

    @Override
    public Tariff getItem(int position) {
        return tariffs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return tariffs.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TariffListItemView tariffItemView;
        if (convertView == null) {
            tariffItemView = TariffListItemView_.build(context);
        } else {
            tariffItemView = (TariffListItemView) convertView;
        }

        tariffItemView.bind(getItem(position));

        return tariffItemView;
    }


}


