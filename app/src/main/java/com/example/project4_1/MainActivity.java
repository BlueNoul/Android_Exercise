package com.example.project4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

        EditText edit1, edit2;
        Button bt1, bt2, bt3, bt4 ;
        TextView textresult;
        String num1,num2;
        Integer result;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            bt1 = findViewById(R.id.BtAdd);
            bt2 = findViewById(R.id.BtSub);
            bt3 = findViewById(R.id.BtMul);
            bt4 = findViewById(R.id.BtDiv);

            edit1 = (EditText)findViewById(R.id.Edit1);
            edit2 = (EditText)findViewById(R.id.Edit2);

            textresult = (TextView)findViewById(R.id.TextResult);



            bt1.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    if((num1.equals("")) || (num2.equals(""))){
                        Toast.makeText(getApplicationContext(), "값을 입력하세요!",
                                Toast.LENGTH_LONG).show();
                        return false;
                    }
                    else {
                        result = Integer.parseInt(num1) +Integer.parseInt(num2);

                        textresult.setText("계산 결과 : " + result.toString());

                        return false;
                    }
                }
            });

            bt2.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    if((num1.equals("")) || (num2.equals(""))){
                        Toast.makeText(getApplicationContext(), "값을 입력하세요!",
                                Toast.LENGTH_LONG).show();
                        return false;
                    }
                    else {
                        result = Integer.parseInt(num1) - Integer.parseInt(num2);

                        textresult.setText("계산 결과 : " + result.toString());

                        return false;
                    }
                }
            });

            bt3.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    if((num1.equals("")) || (num2.equals(""))){
                        Toast.makeText(getApplicationContext(), "값을 입력하세요!",
                                Toast.LENGTH_LONG).show();
                        return false;
                    }
                    else {
                        result = Integer.parseInt(num1) * Integer.parseInt(num2);

                        textresult.setText("계산 결과 : " + result.toString());

                        return false;
                    }
                }
            });
            bt4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    if((num1.equals("")) || (num2.equals(""))){
                        Toast.makeText(getApplicationContext(), "값을 입력하세요!",
                                Toast.LENGTH_LONG).show();
                        return false;
                    }
                    else if(num2.equals("0")){
                        Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.!",
                                Toast.LENGTH_LONG).show();
                        return false;
                    }
                    else {
                        result = Integer.parseInt(num1) /Integer.parseInt(num2);

                        textresult.setText("계산 결과 : " + result.toString());

                        return false;
                    }
                }
            });


        }
    }
