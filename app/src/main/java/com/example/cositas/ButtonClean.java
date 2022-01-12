package com.example.cositas;

import android.widget.Button;

public class ButtonClean {

    public ButtonClean(Button button) {
        button.setOnClickListener(v -> {
            ActivityEquationsSolver context = (ActivityEquationsSolver) v.getContext();
            context.clean();
        });
    }
}
