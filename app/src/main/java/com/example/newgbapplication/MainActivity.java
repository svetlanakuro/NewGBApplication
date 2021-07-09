package com.example.newgbapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button= findViewById(R.id.switchLayout);
        button.setOnClickListener(v -> setContentView(R.layout.activity_main_1));
    }
}