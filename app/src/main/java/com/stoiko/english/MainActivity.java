package com.stoiko.english;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    Dialog dialog;
    int a = 1;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button)findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(MainActivity.this, GameLevel1.class);
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
                    Intent intent = new Intent(MainActivity.this, Achievement.class);
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
                    Intent intent = new Intent(MainActivity.this, Stat.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        pref = getSharedPreferences("name", MODE_PRIVATE);
        a=(pref.getInt("name", 0));


        // Call dialog
        if (a == 0){
            a = a + 1;
            SharedPreferences.Editor edit = pref.edit();
            edit.putInt("name",a);
            edit.apply();

            dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.previewdialog);
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
                    dialog.dismiss();
                }
            });

            dialog.show();


        }

    }


//Системная кнопка начало

    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        } else{
            backToast = Toast.makeText(this, "Нажмите ещё раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    //Системная кнопка конец


}
