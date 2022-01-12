package com.example.cositas;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class EditOrderCube {

    EditText edit;

    public void setText(String str) {
        this.edit.setText(str);
    }

    public EditOrderCube(ActivityMagicCube context, EditText edit, int min, int max) {
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
                    context.button_generate.setEnabled(false);
                    return;
                }

                context.myOrder.set(order);
                context.button_generate.setEnabled(true);
                context.displayMatrix();
            }
        });
    }
}
