package com.example.cositas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ActivityCalculator extends AppCompatActivity {

    private EditText txt_val1, txt_val2;
    private SwitchMemory switch1, switch2;

    public MyDouble result = new MyDouble(0.0);
    public MyDouble memory = new MyDouble(0.0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        txt_val1 = findViewById(R.id.editTextNumberDecimal_val1);
        txt_val2 = findViewById(R.id.editTextNumberDecimal_val2);

        switch1 = new SwitchMemory(findViewById(R.id.switch1));
        switch2 = new SwitchMemory(findViewById(R.id.switch2));

        new ButtonCalculateOper(findViewById(R.id.button_calculate));
        new ButtonMemory(findViewById(R.id.button_mClr));
        new ButtonMemory(findViewById(R.id.button_mSet));
        new ButtonMemory(findViewById(R.id.button_mPlus));
        new ButtonMemory(findViewById(R.id.button_mMinus));

        new ButtonBack(findViewById(R.id.imgB_back));
    }

    public void manageSwitchs() {
        if (switch1.isChecked()) {
            txt_val1.setText(memory.toString());
        }

        if (switch2.isChecked()) {
            txt_val2.setText(memory.toString());
        }
    }

    public String getTxtVal1() { return this.txt_val1.getText().toString(); }
    public void setTxtVal1(String str) { this.txt_val1.setText(str);}

    public String getTxtVal2() { return this.txt_val2.getText().toString(); }
    public void setTxtVal2(String str) { this.txt_val2.setText(str);}
}