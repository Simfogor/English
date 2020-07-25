package com.stoiko.english;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Level3 extends AppCompatActivity {
    public int numLeft;
    public int numRight;
    Array array = new Array();
    Random random = new Random();
    public int count = 0;
    public int Num = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);
        // create text level
        TextView text_level = findViewById(R.id.text_levels);
        text_level.setText(R.string.level1);


        //end text level

        final ImageView img_left = (ImageView) findViewById(R.id.img_left);
        img_left.setClipToOutline(true);


        final TextView text1 = findViewById(R.id.text1);
        final TextView text2 = findViewById(R.id.text2);
        final TextView text3 = findViewById(R.id.text3);
        final TextView text4 = findViewById(R.id.text4);


        Button button_back = (Button) findViewById(R.id.button_back);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level3.this, GameLevel1.class);
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
        final Animation a = AnimationUtils.loadAnimation(Level3.this, R.anim.alpha);


        //end anim


        numLeft = random.nextInt(Num);
        img_left.setImageResource(array.images1[numLeft+numLeft]);
        text1.setText(array.texts1_3_1[numLeft]);
        text2.setText(array.texts1_3_2[numLeft]);
        text3.setText(array.texts1_3_3[numLeft]);
        text4.setText(array.texts1_3_4[numLeft]);


        // Текст 1 ______________________

        text1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    text2.setEnabled(false);
                    text3.setEnabled(false);
                    text4.setEnabled(false);
                    if (array.power1_3_1[numLeft] == 2) {
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



                } else {

                    numLeft = random.nextInt(Num);
                    img_left.setImageResource(array.images1[numLeft+numLeft]);
                    img_left.startAnimation(a);
                    text1.setText(array.texts1_3_1[numLeft]);
                    text2.setText(array.texts1_3_2[numLeft]);
                    text3.setText(array.texts1_3_3[numLeft]);
                    text4.setText(array.texts1_3_4[numLeft]);

                    text2.setEnabled(true);
                    text3.setEnabled(true);
                    text4.setEnabled(true);

                }

                return true;
            }
        });


///Right !!!!!!!!!!!!!!!!!!!!!!!


        // Текст 2 ______________________

        text2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    text1.setEnabled(false);
                    text3.setEnabled(false);
                    text4.setEnabled(false);
                    if (array.power1_3_2[numLeft] == 2) {
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



                } else {

                    numLeft = random.nextInt(Num);
                    img_left.setImageResource(array.images1[numLeft+numLeft]);
                    img_left.startAnimation(a);
                    text1.setText(array.texts1_3_1[numLeft]);
                    text2.setText(array.texts1_3_2[numLeft]);
                    text3.setText(array.texts1_3_3[numLeft]);
                    text4.setText(array.texts1_3_4[numLeft]);

                    text1.setEnabled(true);
                    text3.setEnabled(true);
                    text4.setEnabled(true);

                }

                return true;
            }
        });



        // Текст 3 ______________________

        text3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    text1.setEnabled(false);
                    text2.setEnabled(false);
                    text4.setEnabled(false);
                    if (array.power1_3_3[numLeft] == 2) {
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



                } else {

                    numLeft = random.nextInt(Num);
                    img_left.setImageResource(array.images1[numLeft+numLeft]);
                    img_left.startAnimation(a);
                    text1.setText(array.texts1_3_1[numLeft]);
                    text2.setText(array.texts1_3_2[numLeft]);
                    text3.setText(array.texts1_3_3[numLeft]);
                    text4.setText(array.texts1_3_4[numLeft]);

                    text1.setEnabled(true);
                    text2.setEnabled(true);
                    text4.setEnabled(true);

                }

                return true;
            }
        });





        // Текст 4 ______________________

        text4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    text1.setEnabled(false);
                    text3.setEnabled(false);
                    text2.setEnabled(false);
                    if (array.power1_3_4[numLeft] == 2) {
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



                } else {

                    numLeft = random.nextInt(Num);
                    img_left.setImageResource(array.images1[numLeft+numLeft]);
                    img_left.startAnimation(a);
                    text1.setText(array.texts1_3_1[numLeft]);
                    text2.setText(array.texts1_3_2[numLeft]);
                    text3.setText(array.texts1_3_3[numLeft]);
                    text4.setText(array.texts1_3_4[numLeft]);

                    text1.setEnabled(true);
                    text3.setEnabled(true);
                    text2.setEnabled(true);

                }

                return true;
            }
        });


    }


    // end true fals


    @Override
    public void onBackPressed () {
        try {
            Intent intent = new Intent(Level3.this, GameLevel1.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }

}
