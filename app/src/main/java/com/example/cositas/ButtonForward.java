package com.example.cositas;

import android.content.Intent;
import android.widget.ImageButton;

public class ButtonForward {

    public ButtonForward(ImageButton backButton, int n) {
        backButton.setOnClickListener(v -> {
            Intent i;

            switch (n)
            {
                case 1:
                    i = new Intent(v.getContext(), ActivityCalculator.class);
                    break;
                case 2:
                    i = new Intent(v.getContext(), ActivityRootsSolver.class);
                    break;
                case 3:
                    i = new Intent(v.getContext(), ActivityMatrix.class);
                    break;
                case 4:
                    i = new Intent(v.getContext(), ActivityEquationsSolver.class);
                    break;
                case 5:
                    i = new Intent(v.getContext(), ActivityInterpolation.class);
                    break;
                case 6:
                    i = new Intent(v.getContext(), ActivityUnits.class);
                    break;
                case 7:
                    i = new Intent(v.getContext(), ActivityMagicCube.class);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + n);
            }

            v.getContext().startActivity(i);
        });
    }
}

