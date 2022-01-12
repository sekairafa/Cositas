package com.example.cositas;

import android.widget.ImageButton;

public class ButtonSelect {

    public ButtonSelect(ImageButton button, int limit, boolean isHigh) {
        button.setOnClickListener(v -> {
            ActivityRootsSolver context = (ActivityRootsSolver) v.getContext();

            int order = context.myOrder.get();

            if (isHigh && ++order > limit ) {
                order = limit;
            }

            if (!isHigh && --order < limit ) {
                order = limit;
            }

            context.myOrder.set(order);
            context.txt_order_val.setText(String.valueOf(order));
        });
    }
}
