package com.example.cositas;

import android.view.View;
import android.widget.RadioButton;

public class RadioButtonDimension {
    RadioButtonDimension(RadioButton radioButton) {
        radioButton.setOnClickListener( v -> {
            ActivityInterpolation context = (ActivityInterpolation) v.getContext();

            int id = v.getId();

            int i, count = context.panels.length;
            for (i = 0; i < count; i++) {
                context.panels[i].setVisibility(View.GONE);
            }

            if (id == R.id.radioButton_1d) {
                i = 0;
            }
            else if (id == R.id.radioButton_2d) {
                i = 1;
            }

            context.panels[i].setVisibility(View.VISIBLE);
        });
    }
}
