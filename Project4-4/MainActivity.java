package com.example.project4_4;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch switch1;
    TextView text1, text2;
    RadioGroup radioGroup;
    RadioButton rbt1, rbt2, rbt3;
    Button bt1,bt2;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("안드로이드 사진보기");
        switch1 = findViewById(R.id.ChkAgree);
        text1 = findViewById(R.id.Text1);
        text2 = findViewById(R.id.Text2);

        radioGroup = findViewById(R.id.Rgroup1);

        rbt1 = findViewById(R.id.RdoDog);
        rbt2 = findViewById(R.id.RdoCat);
        rbt3 = findViewById(R.id.RdoRabbit);

        bt1 = findViewById(R.id.BtnEnd);
        bt2 = findViewById(R.id.BtnFirst);
        image = findViewById(R.id.ImgPet);

        // 라디오 박스 클릭시마다 이미지 변경
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.RdoDog) {
                    image.setImageResource(R.drawable.q);
                } else if (i == R.id.RdoCat) {
                    image.setImageResource(R.drawable.r);
                } else {
                    image.setImageResource(R.drawable.s);
                }
            }
        });


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    text2.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);
                    bt1.setVisibility(View.VISIBLE);
                    bt2.setVisibility(View.VISIBLE);
                    image.setVisibility(View.VISIBLE);
                } else {

                    text2.setVisibility(View.INVISIBLE);
                    radioGroup.setVisibility(View.INVISIBLE);
                    bt1.setVisibility(View.INVISIBLE);
                    bt2.setVisibility(View.INVISIBLE);
                    image.setVisibility(View.INVISIBLE);
                }
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch1.setChecked(false);
                rbt1.setChecked(false);
                rbt2.setChecked(false);
                rbt3.setChecked(false);
                image.setImageResource(0);
            }
        });
    }



}