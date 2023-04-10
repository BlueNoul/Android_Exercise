package com.example.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox check1;
    TextView text1, text2;
    RadioGroup radioGroup;
    RadioButton rbt1, rbt2, rbt3;
    Button bt1;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("애완동물 사진보기");
        check1 = findViewById(R.id.ChkAgree);
        text1 = findViewById(R.id.Text1);
        text2 = findViewById(R.id.Text2);

        radioGroup = findViewById(R.id.Rgroup1);

        rbt1 = findViewById(R.id.RdoDog);
        rbt2 = findViewById(R.id.RdoCat);
        rbt3 = findViewById(R.id.RdoRabbit);

        bt1 = findViewById(R.id.BtonOK);
        image = findViewById(R.id.ImgPet);

/*


*/
        // 선택완료 버튼을 클릭 하면 이미지 변경
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (radioGroup.getCheckedRadioButtonId()) {

                    case R.id.RdoDog:
                        image.setImageResource(R.drawable.dog);
                        break;
                    case R.id.RdoCat:
                        image.setImageResource(R.drawable.cat);
                        break;
                    case R.id.RdoRabbit:
                        image.setImageResource(R.drawable.rabbit);
                        break;

                    default:
                        Toast.makeText(getApplicationContext(),"동물 먼저 선택하세요",Toast.LENGTH_SHORT).show();
                }
            }
        });


        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    text2.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);
                    bt1.setVisibility(View.VISIBLE);
                    image.setVisibility(View.VISIBLE);
                } else {

                    text2.setVisibility(View.INVISIBLE);
                    radioGroup.setVisibility(View.INVISIBLE);
                    bt1.setVisibility(View.INVISIBLE);
                    image.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

}