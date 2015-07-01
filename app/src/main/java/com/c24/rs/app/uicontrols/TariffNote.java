package com.c24.rs.app.uicontrols;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.c24.rs.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.tariff_note)
public class TariffNote extends LinearLayout {
    @ViewById(R.id.tariff_note_value)
    public TextView tariffNoteValueTextView;

    @ViewById(R.id.tariff_note_text)
    public TextView tariffNoteTextTextView;

    public TariffNote(Context context) {
        super(context);
    }

    public TariffNote(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setValue(Double noteValue) {
        tariffNoteValueTextView.setText(noteValue.toString());
    }
}
