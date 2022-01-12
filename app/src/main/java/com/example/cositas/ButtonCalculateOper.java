package com.example.cositas;

import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonCalculateOper {

    public ButtonCalculateOper(Button button) {
        button.setOnClickListener(v -> {
            ActivityCalculator context = (ActivityCalculator) v.getContext();

            MyDouble val1 = new MyDouble(0.0);
            MyDouble val2 = new MyDouble(0.0);

            if(val1.parse(context.getTxtVal1())) {
                context.setTxtVal1("");
                Toast.makeText(context, "Parámetro 1 inválido", Toast.LENGTH_SHORT).show();
                return;
            }

            if(val2.parse(context.getTxtVal2())) {
                context.setTxtVal2("");
                Toast.makeText(context, "Parámetro 2 inválido", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioGroup radioGroup = (RadioGroup) context.findViewById(R.id.radioGroup_oper);
            int id = radioGroup.getCheckedRadioButtonId();

            if(id == R.id.radioButton_add) {
                val1.plus(val2);
            }
            else if(id == R.id.radioButton_sub) {
                val1.minus(val2);
            }
            else if(id == R.id.radioButton_mul) {
                val1.multiply(val2);
            }
            else if(id == R.id.radioButton_div) {
                if (val1.divide(val2) == null) {
                    Toast.makeText(context, "División por 0", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            context.result.set(val1);
            ((TextView) context.findViewById(R.id.txt_result)).setText(context.result.toString());

            context.manageSwitchs();
        });
    }
}
