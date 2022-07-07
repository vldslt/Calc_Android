package com.example.calc_android;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private Boolean newSession = true;
    private Boolean operation = true;
    private Boolean dot = true;
    private Boolean preDot = true;
    private String operator;
    private String firstNumber;
    private String secondNumber;
    private Double resultNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.key_equals);

    }

    @SuppressLint("NonConstantResourceId")
    public void clickNumber(View view) {
        if (newSession) {
            result.setText("");
            newSession = false;
        }
        String number = result.getText().toString();
        if (view.getId() == R.id.key_dot && dot && !preDot) {
            number = number + ".";
            dot = false;
        } else if (view.getId() == R.id.key_dot && dot && preDot) {
            number = number + "0.";
            dot = false;
        }


        switch (view.getId()) {
            case R.id.key_1:
                number = number + "1";
                break;
            case R.id.key_2:
                number = number + "2";
                break;
            case R.id.key_3:
                number = number + "3";
                break;
            case R.id.key_4:
                number = number + "4";
                break;
            case R.id.key_5:
                number = number + "5";
                break;
            case R.id.key_6:
                number = number + "6";
                break;
            case R.id.key_7:
                number = number + "7";
                break;
            case R.id.key_8:
                number = number + "8";
                break;
            case R.id.key_9:
                number = number + "9";
                break;
            case R.id.key_0:
                number = number + "0";
                break;
        }
        preDot = false;
        result.setText(number);
    }

    @SuppressLint("NonConstantResourceId")
    public void operate(View view) {
        String sign = result.getText().toString();
        firstNumber = result.getText().toString();

        if (!newSession && operation) {
            switch (view.getId()) {
                case R.id.key_division:
                    sign = "/";
                    operator = "/";
                    break;
                case R.id.key_multiplication:
                    sign = "*";
                    operator = "*";
                    break;
                case R.id.key_addition:
                    sign = "+";
                    operator = "+";
                    break;
                case R.id.key_subtraction:
                    sign = "-";
                    operator = "-";
                    break;
            }
            operation = false;
            dot = true;
            preDot = true;
        }
        result.setText(sign);
        newSession = true;

    }

    public void equals(View view) {
        secondNumber = result.getText().toString();
        switch (operator) {
            case "+":
                resultNumber = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
                break;
            case "-":
                resultNumber = Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
                break;
            case "*":
                resultNumber = Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
                break;
            case "/":
                resultNumber = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
                break;


        }
        newSession = true;
        operation = true;
        dot = false;
        result.setText(resultNumber + "");

    }

    public void clear(View view) {
        if (view.getId() == R.id.clear_text) {
            result.setText("0");
            newSession = true;
            operation = true;
            dot = true;
            preDot = true;
            resultNumber = 0.0;

        }
    }
}