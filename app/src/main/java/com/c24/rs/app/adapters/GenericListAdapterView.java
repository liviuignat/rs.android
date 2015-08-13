package com.c24.rs.app.adapters;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public abstract class GenericListAdapterView<TObject> extends LinearLayout {
    public GenericListAdapterView(Context context) {
        super(context);
    }
    public GenericListAdapterView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public abstract void bind(TObject obj);
}
