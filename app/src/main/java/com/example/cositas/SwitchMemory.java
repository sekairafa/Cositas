package com.example.cositas;

import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.widget.SwitchCompat;

public class SwitchMemory {
    private SwitchCompat mySwitch;

    public SwitchMemory(SwitchCompat _switch) {
        this.mySwitch = _switch;

        this.mySwitch.setOnClickListener(v -> {
            ViewGroup container = (ViewGroup) v.getParent();
            EditText editText = (EditText) container.getChildAt(container.indexOfChild(v) - 1);

            if (this.mySwitch.isChecked()) {
                editText.setEnabled(false);
                editText.setText(((ActivityCalculator) v.getContext()).memory.toString());
            }
            else {
                editText.setEnabled(true);
            }
        });
    }

    public boolean isChecked() {
        return mySwitch.isChecked();
    }
}
