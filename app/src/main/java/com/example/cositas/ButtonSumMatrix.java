package com.example.cositas;

import android.widget.Button;

public class ButtonSumMatrix {
    public ButtonSumMatrix(Button button) {
        button.setOnClickListener(v -> {
            ActivityMatrix context = (ActivityMatrix) v.getContext();

            MyMatrix matrixA = context.getMatrix(0);
            MyMatrix matrixB = context.getMatrix(1);

            int id = button.getId();
            if (id == R.id.button_matrix_sum) {
                matrixA.sum(matrixB);
            }
            else if (id == R.id.button_matrix_sub) {
                matrixA.sub(matrixB);
            }

            context.setMatrix(0, matrixA);
        });
    }
}
