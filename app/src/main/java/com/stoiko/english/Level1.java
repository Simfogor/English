package com.stoiko.english;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Level1 extends AppCompatActivity {

    public int numLeft;
    public int numRight;
    Array array = new Array();
    Random random = new Random();
    public int count = 0;
    int ach = 0;
    private SharedPreferences pref;


    public int Num = 16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        // create text level
        pref = getSharedPreferences("level1_ach", MODE_PRIVATE);
        TextView text_level = findViewById(R.id.text_levels);
        text_level.setText(R.string.level1);


        //end text level

        final ImageView img_left = (ImageView) findViewById(R.id.img_left);
        img_left.setClipToOutline(true);
        final ImageView img_right = (ImageView) findViewById(R.id.img_right);
        img_right.setClipToOutline(true);


        final TextView text_left = findViewById(R.id.text_left);

        final TextView text_right = findViewById(R.id.text_right);


        Button button_back = (Button) findViewById(R.id.button_back);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level1.this, GameLevel1.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });


        // begin progress
        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4,
                R.id.point5, R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10, R.id.point11, R.id.point12, R.id.point13,
                R.id.point14, R.id.point15, R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20,
        };


        // end progress

        //anim
        final Animation a = AnimationUtils.loadAnimation(Level1.this, R.anim.alpha);


        //end anim


        numLeft = random.nextInt(Num);
        img_left.setImageResource(array.images1[numLeft]);
        text_left.setText(array.texts1[numLeft]);

        numRight = random.nextInt(Num);
        while (numLeft == numRight | (array.power1[numLeft] == array.power1[numRight])) {
            numRight = random.nextInt(Num);
        }

        img_right.setImageResource(array.images1[numRight]);
        text_right.setText(array.texts1[numRight]);


        //  true or false

        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    img_right.setEnabled(false);
                    if (array.power1[numLeft] > array.power1[numRight]) {
                        img_left.setImageResource(R.drawable.img_true);
                        if (count < 20) {
                            count = count + 1;
                        }

                        for (int i = 0; i < 20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }


                    } else {
                        img_left.setImageResource(R.drawable.img_false);
                        if (count > 0) {
                            if (count == 1) {
                                count = 0;

                            } else {
                                count = count - 2;
                            }
                        }
                        for (int i = 0; i < 19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }


                } else if (count == 20) {
                    ach = ach + 1;
                    SharedPreferences.Editor edit = pref.edit();
                    edit.putInt("level1_ach",ach);
                    edit.apply();

                } else {
                    numLeft = random.nextInt(Num);
                    img_left.setImageResource(array.images1[numLeft]);
                    img_left.startAnimation(a);
                    text_left.setText(array.texts1[numLeft]);

                    numRight = random.nextInt(Num);
                    while (numLeft == numRight | (array.power1[numLeft] == array.power1[numRight])) {
                        numRight = random.nextInt(Num);
                    }

                    img_right.setImageResource(array.images1[numRight]);
                    img_right.startAnimation(a);
                    text_right.setText(array.texts1[numRight]);
                    img_right.setEnabled(true);

                }

                return true;
            }
        });


///Right !!!!!!!!!!!!!!!!!!!!!!!


        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    img_left.setEnabled(false);
                    if (array.power1[numRight] > array.power1[numLeft]) {
                        img_right.setImageResource(R.drawable.img_true);
                        if (count < 20) {
                            count = count + 1;
                        }

                        for (int i = 0; i < 20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    } else {
                        img_right.setImageResource(R.drawable.img_false);

                        if (count > 0) {
                            if (count == 1) {
                                count = 0;

                            } else {
                                count = count - 2;
                            }
                        }
                        for (int i = 0; i < 19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }


                } else if (count == 20) {
                    // back level
                    ach = ach + 1;
                    SharedPreferences.Editor edit = pref.edit();
                    edit.putInt("level1_ach",ach);
                    edit.putInt("stat",8);
                    edit.apply();

                } else {
                    numLeft = random.nextInt(Num);
                    img_left.setImageResource(array.images1[numLeft]);
                    img_left.startAnimation(a);
                    text_left.setText(array.texts1[numLeft]);

                    numRight = random.nextInt(Num);
                    while (numLeft == numRight | (array.power1[numLeft] == array.power1[numRight])) {
                        numRight = random.nextInt(Num);
                    }

                    img_right.setImageResource(array.images1[numRight]);
                    img_right.startAnimation(a);
                    text_right.setText(array.texts1[numRight]);
                    img_left.setEnabled(true);

                }

                return true;
            }
        });

    }


        // end true fals


        @Override
        public void onBackPressed () {
            try {
                Intent intent = new Intent(Level1.this, GameLevel1.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {

            }
        }

}
