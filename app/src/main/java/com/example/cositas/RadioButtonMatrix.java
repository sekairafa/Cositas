package com.example.cositas;

import android.view.View;
import android.widget.RadioButton;

public class RadioButtonMatrix {
    RadioButtonMatrix(RadioButton radioButton) {
        radioButton.setOnClickListener( v -> {
            ActivityMatrix context = (ActivityMatrix) v.getContext();

            int id = v.getId();

            int i, count = context.panels.length;
            for (i = 0; i < count; i++) {
                context.panels[i].setVisibility(View.GONE);
            }

            if (id == R.id.radioButton_sum_mat) {
                i = 0;
            }
            else if (id == R.id.radioButton_mul_mat) {
                i = 1;
            }
            else if (id == R.id.radioButton_inv_mat) {
                i = 2;
            }

            context.panels[i].setVisibility(View.VISIBLE);
        });
    }
}
