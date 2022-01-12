package com.example.cositas;

import android.widget.Button;

public class ButtonCleanInter {
    public ButtonCleanInter(Button button) {
        button.setOnClickListener(v -> {
            ActivityInterpolation context = (ActivityInterpolation) v.getContext();
            context.clean();
        });
    }
}
