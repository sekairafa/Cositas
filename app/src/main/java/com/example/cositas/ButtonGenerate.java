package com.example.cositas;

import android.widget.Button;

public class ButtonGenerate {

    private Button button;

    public void setEnabled(boolean flag) { button.setEnabled(flag); }

    public ButtonGenerate(Button button) {
        this.button = button;

        this.button.setOnClickListener( v -> {
            ActivityMagicCube context = (ActivityMagicCube) v.getContext();

            context.generate();
        });
    }
}
