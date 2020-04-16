package com.lec.android.a004_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    EditText et1, et2;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button Add = findViewById(R.id.btnPlus);
        Button Min = findViewById(R.id.btnMinus);
        Button Mul = findViewById(R.id.btnMul);
        Button Div = findViewById(R.id.btnDiv);
        tvResult = findViewById(R.id.tvResult);
        et1 = findViewById(R.id.op1);
        et2 = findViewById(R.id.op2);

        et1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            // hasFocus: true-포커스 받은 경우 false - 포커스 잃은 경우
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    ((EditText)v).setBackgroundColor(Color.YELLOW);
                } else {
                    // 투명색
                    ((EditText)v).setBackgroundColor(Color.parseColor("#00000000"));
                }
            }
        });

        et1.setOnKeyListener(new View.OnKeyListener() {
            // keyCode : 눌린 키의 코드값
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                return false;
            }
        });

        et2.setOnKeyListener(new View.OnKeyListener() {
            // keyCode : 눌린 키의 코드값
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                return false;
            }
        });

        Add.setOnClickListener(new View.OnClickListener() {
            int result = 0;
            @Override
            public void onClick(View v) {
                result = Integer.parseInt(et1.getText().toString()) + Integer.parseInt(et2.getText().toString());
                tvResult.setText(Integer.toString(result));
            }
        });

        Min.setOnClickListener(new View.OnClickListener() {
            int result = 0;
            @Override
            public void onClick(View v) {
                result = Integer.parseInt(et1.getText().toString()) - Integer.parseInt(et2.getText().toString());
                tvResult.setText(Integer.toString(result));
            }
        });

        Mul.setOnClickListener(new View.OnClickListener() {
            int result = 0;
            @Override
            public void onClick(View v) {
                result = Integer.parseInt(et1.getText().toString()) * Integer.parseInt(et2.getText().toString());
                tvResult.setText(Integer.toString(result));
            }
        });

        Div.setOnClickListener(new View.OnClickListener() {
            int result = 0;
            @Override
            public void onClick(View v) {
                result = Integer.parseInt(et1.getText().toString()) / Integer.parseInt(et2.getText().toString());
                tvResult.setText(Integer.toString(result));
            }
        });






    }

}
