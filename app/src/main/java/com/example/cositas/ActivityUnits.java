package com.example.cositas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cositas.Dimensions.Dimension;
import com.example.cositas.Dimensions.DimensionAceleration;
import com.example.cositas.Dimensions.DimensionAngle;
import com.example.cositas.Dimensions.DimensionDensity;
import com.example.cositas.Dimensions.DimensionEnergy;
import com.example.cositas.Dimensions.DimensionForce;
import com.example.cositas.Dimensions.DimensionFuelConsumption;
import com.example.cositas.Dimensions.DimensionLength;
import com.example.cositas.Dimensions.DimensionMass;
import com.example.cositas.Dimensions.DimensionMomentum;
import com.example.cositas.Dimensions.DimensionPower;
import com.example.cositas.Dimensions.DimensionPressure;
import com.example.cositas.Dimensions.DimensionSpeed;
import com.example.cositas.Dimensions.DimensionStorage;
import com.example.cositas.Dimensions.DimensionSurface;
import com.example.cositas.Dimensions.DimensionTemperature;
import com.example.cositas.Dimensions.DimensionTime;
import com.example.cositas.Dimensions.DimensionVolume;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ActivityUnits extends AppCompatActivity {
    public int dimension;
    public int unit;

    public List<Dimension> dimensions;

    public List<String> dimensions_str_list;
    public List<String> units_str_list;

    private SpinnerUnit spinnerUnit;

    private LinearLayout layoutTable;

    public List<TextView[]> edits;

    public EditText editValue;

    private Typeface typeface;

    LinearLayout.LayoutParams params_table;
    LinearLayout.LayoutParams params_table1;
    LinearLayout.LayoutParams params_table2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_units);

        initializeArrays();

        units_str_list = new ArrayList<>();

        edits = new ArrayList<>();

        new SpinnerDimension(findViewById(R.id.spinner_dimension), this);
        spinnerUnit = new SpinnerUnit(findViewById(R.id.spinner_unit), this);

        layoutTable = findViewById(R.id.LinearL_table);

        editValue = findViewById(R.id.editTextNumber_val);

        new ButtonConvert(findViewById(R.id.imgB_calculate));

        typeface = ResourcesCompat.getFont(this, R.font.alice);

        params_table = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params_table.setMargins(0, px(5), 0, 0);

        params_table1 = new LinearLayout.LayoutParams(px(180), px(50));
        params_table2 = new LinearLayout.LayoutParams(px(170), px(50));

        new ButtonBack(findViewById(R.id.imgB_back));
    }

    private void initializeArrays() {
        initializeDimensions();
        initializeDimensionsStrArray();
    }

    private void initializeDimensions() {
        this.dimensions = new ArrayList<>();
        this.dimensions.add(new DimensionAceleration());
        this.dimensions.add(new DimensionAngle());
        this.dimensions.add(new DimensionDensity());
        this.dimensions.add(new DimensionEnergy());
        this.dimensions.add(new DimensionForce());
        this.dimensions.add(new DimensionFuelConsumption());
        this.dimensions.add(new DimensionLength());
        this.dimensions.add(new DimensionMass());
        this.dimensions.add(new DimensionMomentum());
        this.dimensions.add(new DimensionPower());
        this.dimensions.add(new DimensionPressure());
        this.dimensions.add(new DimensionSpeed());
        this.dimensions.add(new DimensionStorage());
        this.dimensions.add(new DimensionSurface());
        this.dimensions.add(new DimensionTemperature());
        this.dimensions.add(new DimensionTime());
        this.dimensions.add(new DimensionVolume());

        Collections.sort(this.dimensions);
    }

    public void initializeDimensionsStrArray() {
        this.dimensions_str_list = new ArrayList<>();
        for (Dimension dimension : this.dimensions) {
            this.dimensions_str_list.add(dimension.toString());
        }
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public void setUnits() {
        this.units_str_list.clear();
        Collections.addAll(this.units_str_list, this.dimensions.get(this.dimension).unitArray());

        this.spinnerUnit.setAdapter(this);
    }

    public void setTable() {
        this.edits.clear();
        this.layoutTable.removeAllViews();

        LinearLayout layout;
        TextView edit1, edit2;

        int n = this.units_str_list.size();
        for (int i = 0; i < n; i++) {
            edit1 =  new TextView(new ContextThemeWrapper(this, R.style.table_1), null, 0);
            edit1.setLayoutParams(this.params_table1);
            edit1.setPadding(10,0,10,0);
            edit1.setTypeface(this.typeface);
            edit1.setText(this.units_str_list.get(i));

            edit2 =  new TextView(new ContextThemeWrapper(this, R.style.table_2), null, 0);
            edit2.setPadding(10,0,10,0);
            edit2.setLayoutParams(this.params_table2);
            edit2.setTypeface(this.typeface);

            layout = new LinearLayout(new ContextThemeWrapper(this, R.style.table_layout), null, 0);
            layout.setLayoutParams(this.params_table);

            layout.addView(edit1);
            layout.addView(edit2);

            this.layoutTable.addView(layout);

            this.edits.add(new TextView[2]);
            this.edits.get(i)[0] = edit1;
            this.edits.get(i)[1] = edit2;
        }
    }

    private int px(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}