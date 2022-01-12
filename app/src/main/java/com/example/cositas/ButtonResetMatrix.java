package com.example.cositas;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ButtonResetMatrix {
    public ButtonResetMatrix(Button button, ViewGroup[][] fields) {
        button.setOnLongClickListener(v -> {
            int rows = fields.length;
            if (rows == 0) {
                return false;
            }

            int cols = fields[0].length;
            if (cols == 0) {
                return false;
            }

            for (ViewGroup[] field : fields) {
                for (int i = 0; i < cols; i++) {
                    EditText edit = (EditText) field[i].getChildAt(0);
                    edit.setText("");
                }
            }

            return true;
        });
    }
}
