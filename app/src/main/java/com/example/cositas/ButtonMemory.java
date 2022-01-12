package com.example.cositas;

import android.widget.Button;
import android.widget.TextView;

public class ButtonMemory {

    public ButtonMemory(Button button) {
        button.setOnClickListener( v -> {
            ActivityCalculator context = (ActivityCalculator) v.getContext();

            int id = v.getId();

            if (id == R.id.button_mClr) {
                context.memory.set(0.0);
            }
            else if (id == R.id.button_mSet) {
                context.memory.set(context.result);
            }
            else if (id == R.id.button_mPlus) {
                context.memory.plus(context.result);
            }
            else if ( id == R.id.button_mMinus) {
                context.memory.minus(context.result);
            }
            else {
                return;
            }

            ((TextView) context.findViewById(R.id.txt_memory)).setText(context.memory.toString());

            context.manageSwitchs();
        });
    }
}
