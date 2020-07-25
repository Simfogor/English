package com.stoiko.english;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class Achievement extends AppCompatActivity {

    int level1_ach;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);


        pref = getSharedPreferences("level1_ach", MODE_PRIVATE);
        level1_ach=(pref.getInt("level1_ach", 0));


        if (level1_ach == 1){
            LinearLayout line1 = findViewById(R.id.line1);
            line1.setVisibility(View.VISIBLE);



        }else{

            LinearLayout line1 = findViewById(R.id.line1);
            line1.setVisibility(View.INVISIBLE);

        }



        ImageButton imageButton6 = (ImageButton)findViewById(R.id.imageButton6);

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Achievement.this, MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        ImageButton imageButton67 = (ImageButton)findViewById(R.id.imageButton67);

        imageButton67.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Achievement.this, Stat.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });
    }
}
