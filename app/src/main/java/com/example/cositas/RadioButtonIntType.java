package com.example.cositas;

import android.view.View;
import android.widget.RadioButton;

public class RadioButtonIntType {
    RadioButtonIntType(RadioButton radioButton) {
        radioButton.setOnClickListener( v -> {
            ActivityInterpolation context = (ActivityInterpolation) v.getContext();

            int visivility = (v.getId() == R.id.radioButton_1d_cubic)? View.VISIBLE : View.GONE;

            context.points[3].setVisibility(visivility);
            context.points[4].setVisibility(visivility);
        });
    }
}
