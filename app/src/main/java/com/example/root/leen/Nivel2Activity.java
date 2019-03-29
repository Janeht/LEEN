package com.example.root.leen;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Nivel2Activity extends AppCompatActivity {

    private Button btnRegresar;
    private Button btnReproducir;
    private ImageView btnPrimeraOP;
    private ImageView btnSegundaOP;
    private ImageView btnTerceraOP;
    //private TextView lblprueba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel2);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //lblprueba = (TextView) findViewById(R.id.lblprueba);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        btnReproducir = (Button) findViewById(R.id.btnReproducir);
        btnPrimeraOP = (ImageView) findViewById(R.id.btnPrimeraOP);
        btnSegundaOP = (ImageView) findViewById(R.id.btnSegundaOP);
        btnTerceraOP = (ImageView) findViewById(R.id.btnTerceraOP);


        int num = generarNum();
        //lblprueba.setText("ESTOS ES UNA PRUEBA"+num);

        if(num==7){
            btnPrimeraOP.setImageResource(R.drawable.seven);
            btnSegundaOP.setImageResource(R.drawable.three);
            btnTerceraOP.setImageResource(R.drawable.nine);
        }
        else if(num==6){
            btnPrimeraOP.setImageResource(R.drawable.six);
            btnSegundaOP.setImageResource(R.drawable.three);
            btnTerceraOP.setImageResource(R.drawable.eight);
        }
        else if(num==5){
            btnPrimeraOP.setImageResource(R.drawable.five);
            btnSegundaOP.setImageResource(R.drawable.six);
            btnTerceraOP.setImageResource(R.drawable.three);
        }
        else if(num==4){
            btnPrimeraOP.setImageResource(R.drawable.three);
            btnSegundaOP.setImageResource(R.drawable.two);
            btnTerceraOP.setImageResource(R.drawable.six);
        }
        else if(num==3){
            btnPrimeraOP.setImageResource(R.drawable.three);
            btnSegundaOP.setImageResource(R.drawable.four);
            btnTerceraOP.setImageResource(R.drawable.five);
        }
        else if(num==2){
            btnPrimeraOP.setImageResource(R.drawable.two);
            btnSegundaOP.setImageResource(R.drawable.three);
            btnTerceraOP.setImageResource(R.drawable.four);
        }
        else {
            btnPrimeraOP.setImageResource(R.drawable.one);
            btnSegundaOP.setImageResource(R.drawable.two);
            btnTerceraOP.setImageResource(R.drawable.three);
        }


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public int generarNum(){
        java.util.Random r = new Random();
        return r.nextInt(8)+1;
    }
}
