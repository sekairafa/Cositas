package com.example.cositas;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class EditSumDimension {

    public EditSumDimension(ActivityMatrix context, EditText edit, int min, int max) {
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
                if (id == R.id.editTextNumber_sum_rows){
                    context.count_sumRows.set(val);
                }
                else if (id == R.id.editTextNumber_sum_cols){
                    context.count_sumCols.set(val);
                }

                context.setSumVisibility();
            }
        });
    }
}
