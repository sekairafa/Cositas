package com.example.cositas;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonInvMatrix {
    public ButtonInvMatrix(Button button) {
        button.setOnClickListener(v -> {
            ActivityMatrix context = (ActivityMatrix) v.getContext();

            MyMatrix matrix = context.getMatrix(4);

            double determinant = matrix.determinant();

            TextView txt_determinant = context.findViewById(R.id.txt_determinant);
            txt_determinant.setText(String.valueOf(determinant));

            if (determinant != 0.0) {
                context.setMatrix(2, matrix.inverse());
            }
            else {
                Toast.makeText(context, "Determinante 0.0, matriz no posee inversa", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
