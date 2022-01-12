package com.example.cositas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ActivityEquationsSolver extends AppCompatActivity {

    private final int[] id_rows = {
            R.id.LinearL_system_fields_row1,
            R.id.LinearL_system_fields_row2,
            R.id.LinearL_system_fields_row3,
            R.id.LinearL_system_fields_row4,
            R.id.LinearL_system_fields_row5
    };

    private final int[][] id_fields_left = {
            {
                    R.id.LinearL_system_field_1_1,
                    R.id.LinearL_system_field_1_2,
                    R.id.LinearL_system_field_1_3,
                    R.id.LinearL_system_field_1_4,
                    R.id.LinearL_system_field_1_5,
            },
            {
                    R.id.LinearL_system_field_2_1,
                    R.id.LinearL_system_field_2_2,
                    R.id.LinearL_system_field_2_3,
                    R.id.LinearL_system_field_2_4,
                    R.id.LinearL_system_field_2_5
            },
            {
                    R.id.LinearL_system_field_3_1,
                    R.id.LinearL_system_field_3_2,
                    R.id.LinearL_system_field_3_3,
                    R.id.LinearL_system_field_3_4,
                    R.id.LinearL_system_field_3_5
            },
            {
                    R.id.LinearL_system_field_4_1,
                    R.id.LinearL_system_field_4_2,
                    R.id.LinearL_system_field_4_3,
                    R.id.LinearL_system_field_4_4,
                    R.id.LinearL_system_field_4_5
            },
            {
                    R.id.LinearL_system_field_5_1,
                    R.id.LinearL_system_field_5_2,
                    R.id.LinearL_system_field_5_3,
                    R.id.LinearL_system_field_5_4,
                    R.id.LinearL_system_field_5_5
            }
    };

    private final int[] id_fields_right = {
            R.id.LinearL_system_field_1_6,
            R.id.LinearL_system_field_2_6,
            R.id.LinearL_system_field_3_6,
            R.id.LinearL_system_field_4_6,
            R.id.LinearL_system_field_5_6
    };

    private final int[] id_results = {
            R.id.LinearL_x1,
            R.id.LinearL_x2,
            R.id.LinearL_x3,
            R.id.LinearL_x4,
            R.id.LinearL_x5
    };

    public final int max_size = 5;

    public EditOrderSystem txt_order_val;
    public ButtonCalculateSystem button_calculate;

    public LinearLayout[] rows = new LinearLayout[max_size];

    public ViewGroup[][] fields_left = new ViewGroup[max_size][max_size];
    public ViewGroup[] fields_right = new ViewGroup[max_size];

    public ViewGroup[] results = new ViewGroup[max_size];
    public EditText[] txt_results = new EditText[max_size];

    public MyInteger myOrder = new MyInteger(2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equations_solver);

        for (int j = 0; j < max_size; j++) {
            for (int i = 0; i < max_size; i++) {
                fields_left[j][i] = (LinearLayout) findViewById(id_fields_left[j][i]);
            }

            fields_right[j] = (LinearLayout) findViewById(id_fields_right[j]);
            rows[j] = (LinearLayout) findViewById(id_rows[j]);

            results[j] = (ViewGroup) findViewById(id_results[j]);
            txt_results[j] = (EditText) results[j].getChildAt(1);
        }

        txt_order_val = new EditOrderSystem(this, findViewById(R.id.editTextNumber_select), 1, 5);

        button_calculate = new ButtonCalculateSystem(findViewById(R.id.button_calculate));

        new ButtonClean(findViewById(R.id.button_clean));

        new ButtonSelectEquations(findViewById(R.id.imgB_plus), 5, true);
        new ButtonSelectEquations(findViewById(R.id.imgB_minus), 1, false);

        new ButtonBack(findViewById(R.id.imgB_back));
    }

    public MyMatrix getLFields() {
        MyMatrix matrix = new MyMatrix(this.myOrder.get());

        MyDouble temp = new MyDouble(0.0);

        for (int j = 0; j < this.myOrder.get(); j++) {
            for (int i = 0; i < this.myOrder.get(); i++) {
                EditText edit = (EditText) this.fields_left[j][i].getChildAt(0);

                if(temp.parse(edit.getText().toString())) {
                    temp.set(0.0);
                    edit.setText("");
                }

                matrix.set(j, i, temp.get());
            }
        }

        return matrix;
    }

    public double[] getRFields() {
        double[] fields = new double[this.myOrder.get()];

        MyDouble temp = new MyDouble(0.0);

        for (int i = 0; i < this.myOrder.get(); i++) {
            EditText edit = (EditText) this.fields_right[i].getChildAt(0);

            if(temp.parse(edit.getText().toString())) {
                temp.set(0.0);
                edit.setText("");
            }

            fields[i] = temp.get();
        }

        return fields;
    }

    public void setSolutions(double[] solutions) {
        if (solutions.length == this.myOrder.get()) {
            for (int i = 0; i < this.myOrder.get(); i++) {
                this.txt_results[i].setText(String.valueOf(solutions[i]));
            }
        }
    }

    public void clean() {
        cleanLeft();
        cleanRight();
        cleanSolutions();
    }

    public void cleanLeft() {
        for (int j = 0; j < this.myOrder.get(); j++) {
            for (int i = 0; i < this.myOrder.get(); i++) {
                EditText edit = (EditText) this.fields_left[j][i].getChildAt(0);
                edit.setText("");
            }
        }
    }

    public void cleanRight() {
        for (int i = 0; i < this.myOrder.get(); i++) {
            EditText edit = (EditText) this.fields_right[i].getChildAt(0);
            edit.setText("");;
        }
    }

    public void cleanSolutions() {
        for(EditText txt : this.txt_results) {
            txt.setText("");
        }
    }
}