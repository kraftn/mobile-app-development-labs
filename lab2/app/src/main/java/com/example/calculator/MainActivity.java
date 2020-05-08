package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private TextView tv = null;

    private Double leftOperand = null;
    private Double rightOperand = null;
    private char operation = ADDITION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
    }

    @Override
    public void onClick(View v) {
        String data = tv.getText().toString();
        if (data.contains("=")) {
            data = "";
            tv.setText(data);
            leftOperand = null;
            rightOperand = null;
        }

        if (leftOperand != null) {
            data = data.substring(data.indexOf(" " + operation + " ") + 3);
        }

        switch(v.getId()) {
            case R.id.btn_0:
                tv.append("0");
                break;
            case R.id.btn_1:
                tv.append("1");
                break;
            case R.id.btn_2:
                tv.append("2");
                break;
            case R.id.btn_3:
                tv.append("3");
                break;
            case R.id.btn_4:
                tv.append("4");
                break;
            case R.id.btn_5:
                tv.append("5");
                break;
            case R.id.btn_6:
                tv.append("6");
                break;
            case R.id.btn_7:
                tv.append("7");
                break;
            case R.id.btn_8:
                tv.append("8");
                break;
            case R.id.btn_9:
                tv.append("9");
                break;
            case R.id.btn_point:
                if (!data.contains(".")) {
                    tv.append(".");
                }
                break;
            case R.id.btn_plus:
                if ((null == leftOperand) && IsRightString(data)) {
                    leftOperand = Double.valueOf(data);
                    operation = ADDITION;
                    tv.append(" + ");
                }
                break;
            case R.id.btn_minus:
                if ((null == leftOperand) && IsRightString(data)) {
                    leftOperand = Double.valueOf(data);
                    operation = SUBTRACTION;
                    tv.append(" - ");
                } else if (data.equals("")) {
                    tv.append("-");
                }
                break;
            case R.id.btn_multiplication:
                if ((null == leftOperand) && IsRightString(data)) {
                    leftOperand = Double.valueOf(data);
                    operation = MULTIPLICATION;
                    tv.append(" * ");
                }
                break;
            case R.id.btn_division:
                if ((null == leftOperand) && IsRightString(data)) {
                    leftOperand = Double.valueOf(data);
                    operation = DIVISION;
                    tv.append(" / ");
                }
                break;
            case R.id.btn_equal:
                if ((leftOperand != null) && IsRightString(data)) {
                    rightOperand = Double.valueOf(data);
                    DoOperation();
                }
                break;
        }
    }

    private void DoOperation() {
        double res = 0.0;
        switch (operation){
            case ADDITION:
                res = leftOperand + rightOperand;
                break;
            case SUBTRACTION:
                res = leftOperand - rightOperand;
                break;
            case MULTIPLICATION:
                res = leftOperand * rightOperand;
                break;
            case DIVISION:
                res = leftOperand / rightOperand;
                break;
        }
        tv.append(" = " + res);
    }

    private boolean IsRightString(String str) {
        return !str.equals("") && !str.equals("-") && !str.equals(".") && !str.equals("-.");
    }
}
