package com.example.newgbapplication;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private TextView resultPreview;
    private UserText userText;
    private final static String KeyUserText = "UserText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.inputView);
        resultPreview = findViewById(R.id.resultPreviewView);

        input.setShowSoftInputOnFocus(false);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        userText = new UserText(input.getText().toString(), resultPreview.getText().toString());
        instanceState.putParcelable(KeyUserText, userText);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        userText = instanceState.getParcelable(KeyUserText);

        input.setText(userText.getUserInput());
        input.setSelection(input.getText().length());

        resultPreview.setText(userText.getUserOutput());
    }

    private void updateText(String addStr) {
        String oldStr = input.getText().toString();

        int cursorPosition = input.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPosition);
        String rightStr = oldStr.substring(cursorPosition);

        input.setText(String.format("%s%s%s", leftStr, addStr, rightStr));

        input.setSelection(cursorPosition + addStr.length());
    }

    public void zeroButton(View view) {
        updateText(getResources().getString(R.string._0));
        resultPreview.setText(calculate(input.getText().toString()));
    }

    public void oneButton(View view) {
        updateText(getResources().getString(R.string._1));
        resultPreview.setText(calculate(input.getText().toString()));
    }

    public void twoButton(View view) {
        updateText(getResources().getString(R.string._2));
        resultPreview.setText(calculate(input.getText().toString()));
    }

    public void threeButton(View view) {
        updateText(getResources().getString(R.string._3));
        resultPreview.setText(calculate(input.getText().toString()));
    }

    public void fourButton(View view) {
        updateText(getResources().getString(R.string._4));
        resultPreview.setText(calculate(input.getText().toString()));
    }

    public void fiveButton(View view) {
        updateText(getResources().getString(R.string._5));
        resultPreview.setText(calculate(input.getText().toString()));
    }

    public void sixButton(View view) {
        updateText(getResources().getString(R.string._6));
        resultPreview.setText(calculate(input.getText().toString()));
    }

    public void sevenButton(View view) {
        updateText(getResources().getString(R.string._7));
        resultPreview.setText(calculate(input.getText().toString()));
    }

    public void eightButton(View view) {
        updateText(getResources().getString(R.string._8));
        resultPreview.setText(calculate(input.getText().toString()));
    }

    public void nineButton(View view) {
        updateText(getResources().getString(R.string._9));
        resultPreview.setText(calculate(input.getText().toString()));
    }

    public void pointButton(View view) {
        updateText(getResources().getString(R.string.point));
    }

    public void additionButton(View view) {
        updateText(getResources().getString(R.string.addition));
    }

    public void subtractionButton(View view) {
        updateText(getResources().getString(R.string.subtraction));
    }

    public void multiplicationButton(View view) {
        updateText(getResources().getString(R.string.multiplication));
    }

    public void divisionButton(View view) {
        updateText(getResources().getString(R.string.division));
    }

    public void percentageButton(View view) {
        updateText(getResources().getString(R.string.percentage));
    }

    public void cleanButton(View view) {
        int cursorPosition = input.getSelectionStart();
        int partStr = input.getText().length();

        if (cursorPosition != 0 && partStr != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) input.getText();
            selection.replace(cursorPosition - 1, cursorPosition, "");
            input.setText(selection);
            input.setSelection(cursorPosition - 1);
        }
        resultPreview.setText(calculate(input.getText().toString()));
    }

    public void allCleanButton(View view) {
        input.setText("");
        resultPreview.setText("");
    }

    public void calculateButton(View view) {
        input.setText(calculate(input.getText().toString()));
        input.setSelection(calculate(input.getText().toString()).length());

        resultPreview.setText("");
    }

    public String calculate(String str) {
        Expression expression = new Expression(str);
        String result = String.valueOf(expression.calculate());
        if (result.equals("NaN")) {
            result = "Некорректное выражение";
        }
        return result;
    }
}