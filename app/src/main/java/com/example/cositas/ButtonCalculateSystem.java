package com.example.cositas;

import android.widget.Button;
import android.widget.Toast;

public class ButtonCalculateSystem {

    private Button button;

    public void setEnabled(boolean flag) { button.setEnabled(flag); }

    public ButtonCalculateSystem(Button button) {
        this.button = button;

        this.button.setOnClickListener( v -> {
            ActivityEquationsSolver context = (ActivityEquationsSolver) v.getContext();

            MyMatrix fields_left = context.getLFields();
            double[] fields_right = context.getRFields();

            double[] solutions;

            try {
                solutions = MyMatrix.getSolutions(fields_left, fields_right);
            }
            catch (Exception e){
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                context.cleanSolutions();
                return;
            }

            context.setSolutions(solutions);
        });
    }
}
