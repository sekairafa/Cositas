package com.example.cositas;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerDimension {

    public SpinnerDimension(Spinner spinner, ActivityUnits context) {
        spinner = spinner;

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, R.layout.spinner_item, context.dimensions_str_list);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                context.setDimension(position);
                context.setUnits();
                context.setTable();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
