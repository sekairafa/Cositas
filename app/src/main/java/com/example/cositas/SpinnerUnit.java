package com.example.cositas;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerUnit {
    private Spinner spinner;

    public SpinnerUnit(Spinner spinner, ActivityUnits context) {
        this.spinner = spinner;

        this.setAdapter(context);

        this.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                context.setUnit(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void setAdapter(ActivityUnits context) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, R.layout.spinner_item, context.units_str_list);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        this.spinner.setAdapter(adapter);
    }
}
