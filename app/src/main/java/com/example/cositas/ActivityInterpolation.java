package com.example.cositas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ActivityInterpolation extends AppCompatActivity {
    private final int count_panels = 2;

    private final int[] id_panels = {
            R.id.LinearL_wrapper_1d,
            R.id.LinearL_wrapper_2d
    };

    private final int[] id_1d_points = {
            R.id.LinearL_1d_p1,
            R.id.LinearL_1d_p2,
            R.id.LinearL_1d_p3,
            R.id.LinearL_1d_p4,
            R.id.LinearL_1d_p5
    };

    public LinearLayout[] panels = new LinearLayout[count_panels];

    public ViewGroup[] points = new LinearLayout[5];

    private EditText[] grid2DEdit = new EditText[10];
    private TextView[] grid2DText = new TextView[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolation);

        int i;
        for (i = 0; i < count_panels; i++) {
            panels[i] = findViewById(id_panels[i]);
        }

        for (i = 0; i < 5; i++) {
            points[i] = findViewById(id_1d_points[i]);
        }

        this.initialize2DData();

        new RadioButtonDimension(findViewById(R.id.radioButton_1d));
        new RadioButtonDimension(findViewById(R.id.radioButton_2d));

        new RadioButtonIntType(findViewById(R.id.radioButton_1d_nearest));
        new RadioButtonIntType(findViewById(R.id.radioButton_1d_linear));
        new RadioButtonIntType(findViewById(R.id.radioButton_1d_cubic));

        new ButtonCalculateInter(findViewById(R.id.button_calculate));
        new ButtonCleanInter(findViewById(R.id.button_clean));

        new ButtonBack(findViewById(R.id.imgB_back));
    }

    private void initialize2DData() {
        int i;
        for (i = 0; i < 5; i++) {
            grid2DEdit[i] = findViewById(getResources().getIdentifier("editTextNumber_0" + i, "id", getPackageName()));
            grid2DText[i] = findViewById(getResources().getIdentifier("txt_0" + i, "id", getPackageName()));
        }

        for (i = 5; i < 10; i++) {
            grid2DEdit[i] = findViewById(getResources().getIdentifier("editTextNumber_0" + i, "id", getPackageName()));
        }
    }

    public int getRadioIndex(int index_radioGroup) {

        RadioGroup radioGroup;
        switch (index_radioGroup) {
            case 1:
                radioGroup = findViewById(R.id.radioGroup_dimension);
                break;
            case 2:
                radioGroup = findViewById(R.id.radioGroup_1d);
                break;
            case 3:
                radioGroup = findViewById(R.id.radioGroup_2d);
                break;
            default:
                return -1;
        }

        return radioGroup.indexOfChild(findViewById(radioGroup.getCheckedRadioButtonId()));
    }

    public MyPoint[] get1DPoints(int length) throws Exception {
        if (length != 3 && length != 5) {
            return null;
        }

        MyPoint[] points_return = new MyPoint[length];
        MyPoint points_pivot = new MyPoint();

        MyPoint point_temp = new MyPoint();
        MyDouble temp = new MyDouble(0.0);

        boolean flag = false;
        boolean is_y = false;

        int i, i_;
        for (i = 0,  i_ = 0; i < length; i++) {
            int count = 0;

            ViewGroup point_group = this.points[i];

            for (int j = 0; j < 2; j++) {
                EditText edit = (EditText) point_group.getChildAt(j + 1);

                if (temp.parse(edit.getText().toString())) {
                    edit.setText("");
                    count++;
                    is_y = (j == 1);
                }

                point_temp.set(j, temp.get());
            }

            if (count == 2) {
                throw new Exception("Inserte datos para punto P" + (i + 1));
            }

            if (count == 1) {
                if (flag) {
                    throw new Exception("Inserte " + (length * 2 - 1) + " datos");
                }

                flag = true;

                points_pivot.set(point_temp);
            }
            else {
                points_return[i_++] = new MyPoint(point_temp);
            }
        }

        if (!flag) {
            throw new Exception("Campos llenos");
        }

        points_return[length - 1] = new MyPoint(points_pivot);

        if (!is_y) {
            MyPoint.swapAll(points_return);
        }

        if (points_return[0].getX() == points_return[1].getX()) {
            throw new Exception("Indeterminado");
        }

        return points_return;
    }

    public double[] get2DPoints() throws Exception {
        double[] data_return = new double[10];
        MyDouble temp = new MyDouble(0.0);

        boolean flag = false;
        for(int i = 0; i < 10; i++) {
            EditText edit = grid2DEdit[i];

            if (temp.parse(edit.getText().toString())) {
                edit.setText("");
                flag = true;
            }

            data_return[i] = temp.get();
        }

        if (flag) {
            throw new Exception("Datos invalidos o incompletos");
        }

        if (!areSecuencials(data_return[0], data_return[1], data_return[2])) {
            throw new Exception("Incongruencias lado X");
        }

        if (!areSecuencials(data_return[3], data_return[6], data_return[7])) {
            throw new Exception("Incongruencias lado Y");
        }

        return data_return;
    }

    private boolean areSecuencials(double a, double b, double c) {
        boolean flag = false;

        if (a == b && b == c) {
            flag = false;
        }
        else if (b >= a) {
            flag = (c >= b);
        }
        else if (b <= a) {
            flag = (c <= b);
        }

        return flag;
    }

    public void put1D(double val) {
        for(ViewGroup group : points) {
            for (int i = 1; i < 3; i++) {
                EditText edit = (EditText) group.getChildAt(i);

                if (edit.getText().toString().equals("")) {
                    edit.setText(String.valueOf(val));
                    return;
                }
            }
        }
    }

    public void put2D(double[] values) {
        if (values.length != 5) {
            return;
        }

        for(int i = 0; i < 5; i++) {
            grid2DText[i].setText(String.valueOf(values[i]));
        }
    }

    public void clean() {
        for(ViewGroup group : points) {
            for (int i = 1; i < 3; i++) {
                EditText edit = (EditText) group.getChildAt(i);
                edit.setText("");
            }
        }

        for(int i = 0; i < 5; i++) {
            grid2DEdit[i].setText("");
            grid2DText[i].setText("");
        }

        for(int i = 5; i < 10; i++) {
            grid2DEdit[i].setText("");
        }
    }
}