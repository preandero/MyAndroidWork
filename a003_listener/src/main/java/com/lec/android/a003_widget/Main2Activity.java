package com.lec.android.a003_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.StringTokenizer;

public class Main2Activity extends AppCompatActivity {

    EditText et;
    double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btnP = findViewById(R.id.btnP);
        Button btnM = findViewById(R.id.btnM);
        Button btnX = findViewById(R.id.btnX);
        Button btnD = findViewById(R.id.btnD);


        et = findViewById(R.id.etResult);

        class MyListener implements View.OnClickListener {

            Button Num;

            public MyListener(Button Num) {
                this.Num = Num;
            }

            @Override
            public void onClick(View v) {
                et.setText(et.getText().append(Num.getText()));
            }
        }


        btn0.setOnClickListener(new MyListener(btn0));
        btn1.setOnClickListener(new MyListener(btn1));
        btn2.setOnClickListener(new MyListener(btn2));
        btn3.setOnClickListener(new MyListener(btn3));
        btn4.setOnClickListener(new MyListener(btn4));
        btn5.setOnClickListener(new MyListener(btn5));
        btn6.setOnClickListener(new MyListener(btn6));
        btn7.setOnClickListener(new MyListener(btn7));
        btn8.setOnClickListener(new MyListener(btn8));
        btn9.setOnClickListener(new MyListener(btn9));
        btnP.setOnClickListener(new MyListener(btnP));
        btnM.setOnClickListener(new MyListener(btnM));
        btnX.setOnClickListener(new MyListener(btnX));
        btnD.setOnClickListener(new MyListener(btnD));


        Button btnC = findViewById(R.id.btnC);

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText("");
                result = 0;
            }
        });


        Button btnE = findViewById(R.id.btnE);

        btnE.setOnClickListener(new View.OnClickListener() {


            double Value = 0;

            String Operator = "";

            @Override
            public void onClick(View v) {
                StringTokenizer tokens = new StringTokenizer(et.getText().toString(), "+-*/", true);
                while (tokens.hasMoreTokens()) {
                    String token1 = tokens.nextToken().trim();

                    if (token1.equals("+")) {
                        Operator = token1;
                    } else if (token1.equals("-")) {
                        Operator = token1;
                    } else if (token1.equals("*")) {
                        Operator = token1;
                    } else if (token1.equals("/")) {
                        Operator = token1;
                    }

                    else if(Value !=0 && result != 0){
                        if (Operator.equals("+")) {
                            result += Double.parseDouble(token1);
                        }
                        else if (Operator.equals("-")) {
                            result -= Double.parseDouble(token1);
                        }
                        else if (Operator.equals("*")) {
                            result *= Double.parseDouble(token1);
                        }
                        else if (Operator.equals("/")) {
                            result /= Double.parseDouble(token1);
                        }
                    }
                    else if (Value != 0) {
                        if (Operator.equals("+")) {
                            result = Value + Double.parseDouble(token1);
                        }
                        else if (Operator.equals("-")) {
                            result = Value - Double.parseDouble(token1);
                        }
                        else if (Operator.equals("*")) {
                            result = Value * Double.parseDouble(token1);
                        }
                        else if (Operator.equals("/")) {
                            result = Value / Double.parseDouble(token1);
                        }
                    }
                    else {
                        Value = Double.parseDouble(token1);
                    }

                }
                et.setText(Double.toString(result));
                Value = 0;


            }

        });


    }


}
