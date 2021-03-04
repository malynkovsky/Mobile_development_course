package ru.filimonov.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {
    private static final int OPERATION_KIND_NONE = 0;
    private static final int OPERATION_KIND_PLUS = 1;
    private static final int OPERATION_KIND_MINUS = 2;
    private static final int OPERATION_KIND_MULTIPLY = 3;
    private static final int OPERATION_KIND_DIVIDE= 4;
    private static final int OPERATION_KIND_SIN = 5;
    private static final int OPERATION_KIND_COS = 6;
    private static final int OPERATION_KIND_EXP = 7;


    private double result = 0;
    private double firstVal = 0;
    private double secondVal = 0;
    private int operationKind = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clearResults();

        Button button = (Button) findViewById(R.id.button_clear);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                clearResults();
            }

        });

        button = (Button) findViewById(R.id.button_equals);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applyEquals();
            }
        });
    }


    private void clearResults(){
        result = 0;
        firstVal = 0;
        secondVal = 0;
        operationKind = OPERATION_KIND_NONE;
        TextView view = (TextView) findViewById(R.id.result);
        view.setText(getText(R.string.text_result));

    }

    private void applyEquals(){
        if (operationKind == OPERATION_KIND_NONE)
            return;
        TextView view = (TextView) findViewById(R.id.result);
        if (operationKind < 5 && operationKind != 0){
            String strBuff = (String) view.getText();
            try {
                secondVal = Double.valueOf(strBuff);
            }
            catch (NumberFormatException e)
            {
                secondVal = 0;
            }
        }


        switch (operationKind){
            case OPERATION_KIND_PLUS:
                result = firstVal + secondVal;
                break;
            case OPERATION_KIND_MINUS:
                result = firstVal - secondVal;
                break;
            case OPERATION_KIND_MULTIPLY:
                result = firstVal * secondVal;
                break;
            case OPERATION_KIND_DIVIDE:
                result = firstVal / secondVal;
                break;
            case OPERATION_KIND_SIN:
                result = Math.sin(firstVal);
                break;
            case OPERATION_KIND_COS:
                result = Math.cos(firstVal);
                break;
            case OPERATION_KIND_EXP:
                result = Math.exp(firstVal);
                break;
            default:
                break;
        }

        firstVal = result; //для чего , а стоп а=да чтоб потом щапомнить и дальше с ним делать что-то
        view.setText(Double.toString(result));

    }

    public void OnClickOperation(View view) {
        int bid = view.getId();
        switch (bid){
            case R.id.button_plus:
                operationKind = OPERATION_KIND_PLUS;
                break;
            case R.id.button_minus:
                operationKind = OPERATION_KIND_MINUS;
                break;
            case R.id.button_multiply:
                operationKind = OPERATION_KIND_MULTIPLY;
                break;
            case R.id.button_divide:
                operationKind = OPERATION_KIND_DIVIDE;
                break;
            case R.id.button_sin:
                operationKind = OPERATION_KIND_SIN;
                break;
            case R.id.button_cos:
                operationKind = OPERATION_KIND_COS;
                break;
            case R.id.button_exp:
                operationKind = OPERATION_KIND_EXP;
                break;
            default:
                return;
        }
        TextView v = (TextView) findViewById(R.id.result);
        String strBuff = (String) v.getText();
        try {
            firstVal = Double.valueOf(strBuff);
        }
        catch (NumberFormatException e)
        {
            firstVal = 0;
        }
        
        v.setText(getText(R.string.text_result));
    }

    public void OnClick(View view) {
        TextView v = (TextView) findViewById(R.id.result);
        String strBuff = (String) v.getText();
        if (strBuff.equalsIgnoreCase((String) getText(R.string.text_result)))
            strBuff = "";
        int bid = view.getId();
        switch (bid){
            case R.id.button_0:
                strBuff += "0";
                break;
            case R.id.button_1:
                strBuff += "1";
                break;
            case R.id.button_2:
                strBuff += "2";
                break;
            case R.id.button_3:
                strBuff +="3";
                break;
            case R.id.button_4:
                strBuff += "4";
                break;
            case R.id.button_5:
                strBuff += "5";
                break;
            case R.id.button_6:
                strBuff += "6";
                break;
            case R.id.button_7:
                strBuff +="7";
                break;
            case R.id.button_8:
                strBuff += "8";
                break;
            case R.id.button_9:
                strBuff += "9";
                break;
            case R.id.button_comma:
                strBuff += ".";
                break;
            case R.id.button_sin:
                strBuff = "sin(" + strBuff + ")";
                break;
            default:
                return;
        }
        v.setText(strBuff);
    }
}