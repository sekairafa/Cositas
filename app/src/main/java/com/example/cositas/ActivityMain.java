package com.example.cositas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int n = 7;
        for (int i = 1; i <= n; i++) {
            int id = getResources().getIdentifier("imgB_option_" + i, "id", getPackageName());
            new ButtonForward(findViewById(id), i);
        }
    }
}