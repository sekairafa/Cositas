package com.example.cositas;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class EditOrder {

    EditText edit;

    public void setText(String str) {
        this.edit.setText(str);
    }

    public EditOrder(ActivityRootsSolver context, EditText edit, int min, int max) {
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

                switch (order.get()) {
                    case 1:
                        context.txt.setText(R.string.txt_poly1_a3_string);
                        break;
                    case 2:
                        context.txt.setText(R.string.txt_poly2_a3_string);
                        break;
                    case 3:
                        context.txt.setText(R.string.txt_poly3_a3_string);
                        break;
                    case 4:
                        context.txt.setText(R.string.txt_poly4_a3_string);
                        break;
                    case 5:
                        context.txt.setText(R.string.txt_poly5_a3_string);
                        break;
                }

                for (int i = 0; i < order.get(); i++) {
                    context.layout_values[i + 1].setVisibility(View.VISIBLE);
                    context.layout_results[i].setVisibility(View.VISIBLE);
                }

                for (int i = order.get(); i < 5; i++) {
                    context.layout_values[i + 1].setVisibility(View.GONE);
                    context.layout_results[i].setVisibility(View.GONE);
                }

                for(EditText txt : context.txt_results) {
                    txt.setText("");
                }
            }
        });
    }
}
