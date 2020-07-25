package com.stoiko.english;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Level0 extends AppCompatActivity {

    public int numLeft = 0;
    Array array = new Array();
    public int count = 0;
    Dialog dialog;
    public int Num = 8;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level0);



        pref = getSharedPreferences("stat", MODE_PRIVATE);

        // Dialog
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.enddialog1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        // btn closed
        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        TextView buttoncontinue = (TextView)dialog.findViewById(R.id.buttoncontinue);
        buttoncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level0.this, Level1.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });



        // end dialog
        // create text level
        TextView text_level = findViewById(R.id.text_levels);
        text_level.setText(R.string.level0);


        //end text level

        final ImageView img_left = (ImageView) findViewById(R.id.img_left);
        img_left.setClipToOutline(true);


        final TextView text_left = findViewById(R.id.text_left);
        final TextView text_left1 = findViewById(R.id.text_left1);


        Button button_back = (Button) findViewById(R.id.button_back);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level0.this, GameLevel1.class);
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
        final Animation a = AnimationUtils.loadAnimation(Level0.this, R.anim.alpha);


        //end anim


        img_left.setImageResource(array.images1[numLeft]);
        text_left.setText(array.texts1[numLeft]);
        text_left1.setText(array.texts11[numLeft]);
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        img_left.setImageResource(R.drawable.img_true);
                        if (count < Num) {
                            count = count + 1;
                            numLeft = numLeft + 2;
                        }
                        for (int i = 0; i < Num; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                } else if (count == Num) {
                    // back level
                    SharedPreferences.Editor edit = pref.edit();
                    edit.putInt("stat",8);
                    edit.apply();
                    dialog.show();
                } else {
                    img_left.setImageResource(array.images1[numLeft]);
                    img_left.startAnimation(a);
                    text_left.setText(array.texts1[numLeft]);
                    text_left1.setText(array.texts11[numLeft]);
                }
                return true;
            }
        });


///Right !!!!!!!!!!!!!!!!!!!!!!!

    }


    // end true fals


    @Override
    public void onBackPressed () {
        try {
            Intent intent = new Intent(Level0.this, GameLevel1.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }

}