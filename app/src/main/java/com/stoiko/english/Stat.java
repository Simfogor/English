package com.stoiko.english;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class Stat extends AppCompatActivity {
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);

        pref = getSharedPreferences("stat", MODE_PRIVATE);
        int stat1=pref.getInt("stat", 0);


        TextView textView9 = (TextView) findViewById(R.id.textView9);

        textView9.setText("Кількість вивчених слів:" + stat1);




        ImageButton imageButton6 = (ImageButton)findViewById(R.id.imageButton6);

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Stat.this, MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        ImageButton imageButton66 = (ImageButton)findViewById(R.id.imageButton66);

        imageButton66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Stat.this, Achievement.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });
    }
}
