package com.example.cositas;

import android.content.Intent;
import android.widget.ImageButton;

public class ButtonBack {

    public ButtonBack(ImageButton backButton) {
        backButton.setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), ActivityMain.class);
            v.getContext().startActivity(i);
        });
    }
}
