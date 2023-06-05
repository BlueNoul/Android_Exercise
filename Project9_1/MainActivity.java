package com.cookandroid.project9_1;

import static android.graphics.drawable.GradientDrawable.LINE;
import static android.icu.lang.UCharacter.DecompositionType.CIRCLE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    final static int LINE =1, CIRCLE =2 , SQUARE =3, RED =4, GREEN=5, BLUE=6;
    static int curShape =LINE;
    static int curColor =RED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("간단 그림판");
    }
    private static class MyGraphicView extends View {
        int startX = -1, startY = -1, stopX = -1, stopY = -1;
        public MyGraphicView (Context context){
            super(context);

        }


        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.RED);
            switch (curColor){
                case RED:
                    paint.setColor(Color.RED);
                    break;

                case GREEN:
                    paint.setColor(Color.GREEN);
                    break;

                case BLUE:
                    paint.setColor(Color.BLUE);
                    break;
            }
            switch (curShape){
                case LINE:
                        canvas.drawLine(startX, startY, stopX, stopY, paint);
                        break;
                case CIRCLE:
                        int radius =(int)Math.sqrt(Math.pow(stopX -startX, 2)+Math.pow(stopY -startY, 2));
                        canvas.drawCircle(startX, startY, radius, paint);
                        break;
                case SQUARE:
                        canvas.drawRect(startX,startY,stopX,stopY, paint);
                        break;

            }

        }
        @Override
        public boolean onTouchEvent(MotionEvent event){
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    startX = (int) event.getX();
                    startY = (int) event.getY();
                    break;

                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    stopX = (int) event.getX();
                    stopY = (int) event.getY();
                    this.invalidate();
                    break;
            }
            return true;
        }
    }
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"선 그리기");
        menu.add(0,2,0,"원 그리기");
        menu.add(0,3,0,"사각형 그리기");
        SubMenu etc = menu.addSubMenu("색상 변경");
        etc.add(0,4,0,"빨강");//서브메뉴에는 우동과 만두가 들어있음
        etc.add(0,5,0,"초록");
        etc.add(0,6,0,"파랑");
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case 1: curShape = LINE;
                    return true;
            case 2: curShape = CIRCLE;
                    return true;
            case 3: curShape = SQUARE;
                    return true;
            case 4: curColor = RED;
                    return true;
            case 5: curColor = GREEN;
                    return true;
            case 6: curColor = BLUE;
                    return true;
        }
        return  super.onOptionsItemSelected((item));
    }


}