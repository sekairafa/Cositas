package com.example.cositas;

import android.widget.EditText;
import android.widget.ImageButton;

public class ButtonTranspose {
    public ButtonTranspose(ImageButton button) {
        button.setOnClickListener(v -> {
            ActivityMatrix context = (ActivityMatrix) v.getContext();

            MyMatrix matrixA = context.getMatrix(0).transpose();
            MyMatrix matrixB = context.getMatrix(1).transpose();

            MyInteger temp = new MyInteger(context.count_sumRows);
            context.count_sumRows.set(context.count_sumCols);
            context.count_sumCols.set(temp);

            EditText edit;
            for(int j = 0; j < context.count_sumRows.get(); j++) {
                for(int i = 0; i < context.count_sumCols.get(); i++) {
                    edit = (EditText) context.sumFields[0][j][i].getChildAt(0);
                    edit.setText(String.valueOf(matrixA.get(j, i)));

                    edit = (EditText) context.sumFields[1][j][i].getChildAt(0);
                    edit.setText(String.valueOf(matrixB.get(j, i)));
                }

                for(int i = context.count_sumCols.get(); i < context.maxSize; i++) {
                    edit = (EditText) context.sumFields[0][j][i].getChildAt(0);
                    edit.setText("");

                    edit = (EditText) context.sumFields[1][j][i].getChildAt(0);
                    edit.setText("");
                }
            }

            for(int j = context.count_sumRows.get(); j < context.maxSize; j++) {
                for(int i = 0; i < context.maxSize; i++) {
                    edit = (EditText) context.sumFields[0][j][i].getChildAt(0);
                    edit.setText("");

                    edit = (EditText) context.sumFields[1][j][i].getChildAt(0);
                    edit.setText("");
                }
            }

            edit = context.findViewById(R.id.editTextNumber_sum_rows);
            edit.setText(String.valueOf(context.count_sumRows.get()));

            edit = context.findViewById(R.id.editTextNumber_sum_cols);
            edit.setText(String.valueOf(context.count_sumCols.get()));
        });
    }
}
