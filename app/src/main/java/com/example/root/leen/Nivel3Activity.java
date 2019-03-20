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

public class Nivel3Activity extends AppCompatActivity {

    private Button btnRegresar;
    private Button btnReproducir;
    private ImageView btnPrimeraOP;
    private ImageView btnSegundaOP;
    private ImageView btnTerceraOP;
    private ImageView btnCuartaOP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel3);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        btnReproducir = (Button) findViewById(R.id.btnReproducir);
        btnPrimeraOP = (ImageView) findViewById(R.id.btnPrimeraOP);
        btnSegundaOP = (ImageView) findViewById(R.id.btnSegundaOP);
        btnTerceraOP = (ImageView) findViewById(R.id.btnTerceraOP);
        btnCuartaOP = (ImageView) findViewById(R.id.btnCuartaOP);


        int num = generarNum();
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;

        if(num==1){
            num1 = R.drawable.one;
            num2 = R.drawable.two;
            num3 = R.drawable.three;
            num4 = R.drawable.four;
            int direc[] = {num1, num2, num3, num4};

            int array[] = desordenar(direc);
            btnPrimeraOP.setImageResource(array[0]);
            btnSegundaOP.setImageResource(array[1]);
            btnTerceraOP.setImageResource(array[2]);
            btnCuartaOP.setImageResource(array[3]);
        }
        else if(num==2){
            num1 = R.drawable.two;
            num2 = R.drawable.three;
            num3 = R.drawable.four;
            num4 = R.drawable.five;
            int direc[] = {num1, num2, num3, num4};

            int array[] = desordenar(direc);
            btnPrimeraOP.setImageResource(array[0]);
            btnSegundaOP.setImageResource(array[1]);
            btnTerceraOP.setImageResource(array[2]);
            btnCuartaOP.setImageResource(array[3]);
        }
        else if(num==3){
            num1 = R.drawable.three;
            num2 = R.drawable.four;
            num3 = R.drawable.five;
            num4 = R.drawable.six;
            int direc[] = {num1, num2, num3, num4};

            int array[] = desordenar(direc);
            btnPrimeraOP.setImageResource(array[0]);
            btnSegundaOP.setImageResource(array[1]);
            btnTerceraOP.setImageResource(array[2]);
            btnCuartaOP.setImageResource(array[3]);
        }
        else if(num==4){
            num1 = R.drawable.four;
            num2 = R.drawable.five;
            num3 = R.drawable.six;
            num4 = R.drawable.seven;
            int direc[] = {num1, num2, num3, num4};

            int array[] = desordenar(direc);
            btnPrimeraOP.setImageResource(array[0]);
            btnSegundaOP.setImageResource(array[1]);
            btnTerceraOP.setImageResource(array[2]);
            btnCuartaOP.setImageResource(array[3]);
        }
        else if(num==5){
            num1 = R.drawable.five;
            num2 = R.drawable.four;
            num3 = R.drawable.seven;
            num4 = R.drawable.eight;
            int direc[] = {num1, num2, num3, num4};

            int array[] = desordenar(direc);
            btnPrimeraOP.setImageResource(array[0]);
            btnSegundaOP.setImageResource(array[1]);
            btnTerceraOP.setImageResource(array[2]);
            btnCuartaOP.setImageResource(array[3]);
        }
        else if(num==6){
            num1 = R.drawable.six;
            num2 = R.drawable.seven;
            num3 = R.drawable.eight;
            num4 = R.drawable.nine;
            int direc[] = {num1, num2, num3, num4};

            int array[] = desordenar(direc);
            btnPrimeraOP.setImageResource(array[0]);
            btnSegundaOP.setImageResource(array[1]);
            btnTerceraOP.setImageResource(array[2]);
            btnCuartaOP.setImageResource(array[3]);
        }
        else {
            num1 = R.drawable.seven;
            num2 = R.drawable.eight;
            num3 = R.drawable.nine;
            num4 = R.drawable.one;
            int direc[] = {num1, num2, num3, num4};

            int array[] = desordenar(direc);
            btnPrimeraOP.setImageResource(array[0]);
            btnSegundaOP.setImageResource(array[1]);
            btnTerceraOP.setImageResource(array[2]);
            btnCuartaOP.setImageResource(array[3]);
        }

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Nivel3Activity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

    public int generarNum(){
        java.util.Random r = new Random();
        return r.nextInt(8)+1;
    }

    public int[] desordenar(int[] array){
        int lon = array.length-1;
        for(int i = lon; i>1; i--){
            int x = (int) Math.floor(i*Math.random());
            int y = array[i];
            array[i] = array[x];
            array[x] = y;
        }
        return (array);
    }
}
