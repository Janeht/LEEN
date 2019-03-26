package com.example.root.leen;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout fondo;
    AnimationDrawable animacion;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    public ImageButton musica;
    public MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn1 = (Button)  findViewById(R.id.btn1);
        btn2 = (Button)  findViewById(R.id.btn2);
        btn3 = (Button)  findViewById(R.id.btn3);

        this.fondo = (ConstraintLayout) findViewById(R.id.prueba);
        this.animacion = (AnimationDrawable) this.fondo.getBackground();
        this.animacion.setEnterFadeDuration(10);
        this.animacion.setExitFadeDuration(3500);
        this.animacion.start();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Nivel1Activity.class);
                startActivity(intent);
                finish();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Nivel2Activity.class);
                startActivity(intent);
                finish();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Nivel3Activity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
