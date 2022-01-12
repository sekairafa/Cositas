package com.example.cositas;

import android.widget.ImageButton;

public class ButtonConvert {
    public ButtonConvert(ImageButton button) {
        button.setOnClickListener(v -> {
            ActivityUnits context = (ActivityUnits) v.getContext();

            MyDouble x = new MyDouble(0.0);
            MyDouble y = new MyDouble(0.0);

            if (x.parse(context.editValue.getText().toString())) {
                context.editValue.setText("");
                return;
            }

            int n = context.units_str_list.size();
            for (int i = 0; i < n; i++) {
                y.set(context.dimensions.get(context.dimension).convert(x.get(), context.unit, i));
                context.edits.get(i)[1].setText(y.toString());
            }
        });
    }
}
