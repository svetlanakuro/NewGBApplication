package com.example.newgbapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySettings extends AppCompatActivity implements Constants {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(codeStyleToStyleId(getCodeStyle()));
        setContentView(R.layout.activity_settings);

        initRadioButtons();
        initView();
    }

    private int getCodeStyle() {
        SharedPreferences preferences = getSharedPreferences(NAME_SHARED_PREFERENCE, MODE_PRIVATE);
        return preferences.getInt(appTheme, NewGBApplication);
    }

    private void setAppTheme(int codeStyle) {
        SharedPreferences preferences = getSharedPreferences(NAME_SHARED_PREFERENCE, MODE_PRIVATE);
        preferences.edit()
                .putInt(appTheme, codeStyle)
                .apply();
    }

    private int codeStyleToStyleId(int codeStyle) {
        if (codeStyle == NewGBApplicationDark) {
            return R.style.Theme_NewGBApplicationDark;
        }
        return R.style.Theme_NewGBApplication;
    }

    private void initRadioButtons() {
        findViewById(R.id.radioButtonLightTheme).setOnClickListener(v -> {
            setAppTheme(NewGBApplication);
            recreate();
            RadioGroup radioGroup = findViewById(R.id.radioButtons);
            radioGroup.check(radioGroup.getChildAt(NewGBApplication).getId());
        });
        findViewById(R.id.radioButtonDarkTheme).setOnClickListener(v -> {
            setAppTheme(NewGBApplicationDark);
            recreate();
            RadioGroup radioGroup = findViewById(R.id.radioButtons);
            radioGroup.check(radioGroup.getChildAt(NewGBApplicationDark).getId());
        });
    }

    private void initView() {
        findViewById(R.id.buttonApply).setOnClickListener(v -> finish());
    }
}