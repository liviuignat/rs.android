package com.c24.rs.app.uicontrols;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.c24.rs.R;
import com.c24.rs.common.formatters.GradeTextFormatter;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.tariff_note)
public class TariffNote extends LinearLayout {

    @ViewById(R.id.tariff_note_value)
    public TextView tariffNoteValueTextView;

    @ViewById(R.id.tariff_note_text)
    public TextView tariffNoteTextView;

    @ViewById(R.id.tariff_note_image)
    public ImageView tariffNoteImageView;

    public TariffNote(Context context) {
        super(context);
    }

    public TariffNote(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setValue(Double noteValue) {
        tariffNoteValueTextView.setText(noteValue.toString());
        tariffNoteTextView.setText(new GradeTextFormatter().get(noteValue));
    }

    public void setIsTopGrade(Boolean value) {
        if(value) {
            tariffNoteImageView.setImageDrawable(getContext().getResources().getDrawable(R.mipmap.tariff_note_top));
        } else {
            tariffNoteImageView.setImageDrawable(getContext().getResources().getDrawable(R.mipmap.tariff_note));
        }
    }
}
