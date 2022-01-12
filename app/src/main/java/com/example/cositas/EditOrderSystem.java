package com.example.cositas;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class EditOrderSystem {

    EditText edit;

    public void setText(String str) {
        this.edit.setText(str);
    }

    public EditOrderSystem(ActivityEquationsSolver context, EditText edit, int min, int max) {
        this.edit = edit;

        this.edit.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                MyInteger order = new MyInteger(0);

                if (order.parse(s.toString()) || order.get() < min || order.get() > max) {
                    context.button_calculate.setEnabled(false);
                    return;
                }

                context.myOrder.set(order);
                context.button_calculate.setEnabled(true);

                int i, j;
                for (j = 0; j < order.get(); j++) {
                    for(i = 0; i < order.get(); i++) {
                        context.fields_left[j][i].setVisibility(View.VISIBLE);
                    }

                    for(i = order.get(); i < context.max_size; i++) {
                        context.fields_left[j][i].setVisibility(View.GONE);
                    }

                    context.rows[j].setVisibility(View.VISIBLE);
                    context.results[j].setVisibility(View.VISIBLE);
                }

                for (j = order.get(); j < context.max_size; j++) {
                    context.rows[j].setVisibility(View.GONE);
                    context.results[j].setVisibility(View.GONE);
                }

                context.cleanSolutions();
            }
        });
    }
}
