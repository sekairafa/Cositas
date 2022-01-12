package com.example.cositas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityRootsSolver extends AppCompatActivity {

    private final int[] id_values = {
            R.id.LinearL_val1,
            R.id.LinearL_val2,
            R.id.LinearL_val3,
            R.id.LinearL_val4,
            R.id.LinearL_val5,
            R.id.LinearL_val6
    };

    private final int[] id_results = {
            R.id.LinearL_x1,
            R.id.LinearL_x2,
            R.id.LinearL_x3,
            R.id.LinearL_x4,
            R.id.LinearL_x5
    };

    private final int id_values_count = 6;
    private final int id_results_count = 5;

    public EditOrder txt_order_val;
    public ButtonCalculateRoots button_calculate;

    public ViewGroup[] layout_values = new ViewGroup[id_values_count];
    public ViewGroup[] layout_results = new ViewGroup[id_results_count];

    public EditText[] txt_values = new EditText[id_values_count];
    public EditText[] txt_results = new EditText[id_results_count];

    public TextView txt;

    public MyInteger myOrder = new MyInteger(2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roots_solver);

        for (int i = 0; i < id_values_count; i++) {
            layout_values[i] = findViewById(id_values[i]);
            txt_values[i] = (EditText) layout_values[i].getChildAt(1);
        }

        for (int i = 0; i < id_results_count; i++) {
            layout_results[i] = findViewById(id_results[i]);
            txt_results[i] = (EditText) layout_results[i].getChildAt(1);
        }

        txt_order_val = new EditOrder(this, findViewById(R.id.editTextNumber_select), 1, 5);
        txt = findViewById(R.id.txt_order);

        new ButtonSelect(findViewById(R.id.imgB_plus), 5, true);
        new ButtonSelect(findViewById(R.id.imgB_minus), 1, false);

        button_calculate = new ButtonCalculateRoots(findViewById(R.id.button_calculate));

        new ButtonBack(findViewById(R.id.imgB_back));
    }
}