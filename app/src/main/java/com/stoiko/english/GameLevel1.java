package com.stoiko.english;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevel1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels1);

        Button button_back = (Button)findViewById(R.id.button_back);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(GameLevel1.this, MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(GameLevel1.this, Level0.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });


        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(GameLevel1.this, Level1.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        TextView textView3 = (TextView)findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(GameLevel1.this, Level3.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        TextView textView4 = (TextView)findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(GameLevel1.this, Level2.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });
    }


    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(GameLevel1.this, MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }
}
