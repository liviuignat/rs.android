package com.c24.rs.screens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.c24.rs.R;
import com.c24.rs.bl.Tariff;

import java.util.ArrayList;

/**
 * Created by liviu.ignat on 6/30/2015.
 */
public class TariffsListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Tariff> tariffs;
    private LayoutInflater inflater;

    public TariffsListAdapter (Context context, ArrayList<Tariff> tariffs) {
        this.context = context;
        this.tariffs = tariffs;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return tariffs.size();
    }

    @Override
    public Object getItem(int position) {
        return tariffs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return tariffs.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.tariffs_list_item, null);

        Tariff tariff = tariffs.get(position);

        TextView textviewTitle = (TextView) convertView.findViewById(R.id.tariff_name);
        textviewTitle.setText(tariff.getName());

        return convertView ;
    }
}
