package com.example.newgbapplication;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.inputView);
        output = findViewById(R.id.outputView);

        input.setShowSoftInputOnFocus(false);
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
        calculate();
    }

    public void oneButton(View view) {
        updateText(getResources().getString(R.string._1));
        calculate();
    }

    public void twoButton(View view) {
        updateText(getResources().getString(R.string._2));
        calculate();
    }

    public void threeButton(View view) {
        updateText(getResources().getString(R.string._3));
        calculate();
    }

    public void fourButton(View view) {
        updateText(getResources().getString(R.string._4));
        calculate();
    }

    public void fiveButton(View view) {
        updateText(getResources().getString(R.string._5));
        calculate();
    }

    public void sixButton(View view) {
        updateText(getResources().getString(R.string._6));
        calculate();
    }

    public void sevenButton(View view) {
        updateText(getResources().getString(R.string._7));
        calculate();
    }

    public void eightButton(View view) {
        updateText(getResources().getString(R.string._8));
        calculate();
    }

    public void nineButton(View view) {
        updateText(getResources().getString(R.string._9));
        calculate();
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

            calculate();
        }
    }

    public void allCleanButton(View view) {
        input.setText("");
        output.setText("");
    }

    public void calculateButton(View view) {
        String userExpression = input.getText().toString();
        Expression expression = new Expression(userExpression);
        String result = String.valueOf(expression.calculate());

        input.setText(result);
        input.setSelection(result.length());
        calculate();
    }

    public void calculate() {
        String userExpression = input.getText().toString();
        Expression expression = new Expression(userExpression);
        String result = String.valueOf(expression.calculate());

        output.setText(result);
    }
}