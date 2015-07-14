package com.c24.rs.app.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@EBean
public class GenericListAdapter<TObject, TLayout extends GenericListAdapterView<TObject>> extends BaseAdapter {

    private final Context context;
    private Class<TLayout> clazz;
    public List<TObject> objects;

    public GenericListAdapter(Context context) {

        this.context = context;
    }

    public void initAdapter(Class<TLayout> clazz, List<TObject> objects) {
        this.clazz = clazz;
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public TObject getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TLayout view = null;
        if (convertView == null) {
            String cName = clazz.getName() + "_";
            try {
                Class<?> klass = Class.forName(cName);
                Method method = klass.getMethod("build", Context.class);
                view = (TLayout)method.invoke(null, context);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            view = (TLayout) convertView;
        }

        TObject obj = getItem(position);
        view.bind(obj);

        return view;
    }

}
