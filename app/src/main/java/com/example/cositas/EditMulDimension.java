package com.example.cositas;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class EditMulDimension {

    public EditMulDimension(ActivityMatrix context, EditText edit, int min, int max) {
        edit.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                MyInteger val = new MyInteger(0);

                if (val.parse(s.toString()) || val.get() < min || val.get() > max) {
                    val.set(2);
                }

                int id = edit.getId();
                if (id == R.id.editTextNumber_mul_rows){
                    context.count_mulRows.set(val);
                }
                else if (id == R.id.editTextNumber_mul_common){
                    context.count_mulCommon.set(val);
                }
                else if (id == R.id.editTextNumber_mul_cols){
                    context.count_mulCols.set(val);
                }

                context.setMulVisibility();
            }
        });
    }
}
