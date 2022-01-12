package com.example.cositas;

import android.widget.Button;

public class ButtonMulMatrix {
    public ButtonMulMatrix(Button button) {
        button.setOnClickListener(v -> {
            ActivityMatrix context = (ActivityMatrix) v.getContext();

            MyMatrix matrixA = context.getMatrix(2);
            MyMatrix matrixB = context.getMatrix(3);

            MyMatrix matrixC = MyMatrix.multiply(matrixA, matrixB);

            context.setMatrix(1, matrixC);
        });
    }
}
