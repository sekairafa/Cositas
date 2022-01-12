package com.example.cositas;

import android.widget.Button;
import android.widget.Toast;

public class ButtonCalculateRoots {

    private Button button;

    public void setEnabled(boolean flag) { button.setEnabled(flag); }

    public ButtonCalculateRoots(Button button) {
        this.button = button;

        this.button.setOnClickListener( v -> {
            ActivityRootsSolver context = (ActivityRootsSolver) v.getContext();

            int order = context.myOrder.get();
            double[] coefs = new double[order + 1];

            MyDouble temp = new MyDouble(0.0);

            if(temp.parse(context.txt_values[0].getText().toString())) {
                Toast.makeText(context, "Parámetro 'a' invalido", Toast.LENGTH_SHORT).show();
                return;
            }
            coefs[0] = temp.get();

            int i;
            for (i = 1; i <= order; i++) {
                if(temp.parse(context.txt_values[i].getText().toString())) {
                    temp.set(0.0);
                    context.txt_values[i].setText("0.0");
                }
                coefs[i] = temp.get();
            }

            Polynomy poly = new Polynomy(coefs);

            MyComplex[] roots = poly.roots();

            for(i = 0; i < roots.length; i++) { //order
                context.txt_results[i].setText(roots[i].toString());
            }
        });
    }
}
