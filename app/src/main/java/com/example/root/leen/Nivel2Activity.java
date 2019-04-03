package com.example.root.leen;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Nivel2Activity extends AppCompatActivity {

    private Button btnRegresar;
    private Button btnReproducir;
    private ImageView imgNivel2;
    private ImageView btnPrimeraOP;
    private ImageView btnSegundaOP;
    private ImageView btnTerceraOP;
    private ImageView imgVida1;
    private ImageView imgVida2;
    private ImageView imgVida3;

    int num=0, limite=0, vidas=3;
    int mostrar[]= new int[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel2);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        btnReproducir = (Button) findViewById(R.id.btnReproducir);
        btnPrimeraOP = (ImageView) findViewById(R.id.btnPrimeraOP);
        btnSegundaOP = (ImageView) findViewById(R.id.btnSegundaOP);
        btnTerceraOP = (ImageView) findViewById(R.id.btnTerceraOP);
        imgNivel2 = (ImageView) findViewById(R.id.imgNivel2);
        imgVida1 = (ImageView)  findViewById(R.id.imgVida1);
        imgVida2 = (ImageView)  findViewById(R.id.imgVida2);
        imgVida3 = (ImageView)  findViewById(R.id.imgVida3);

        guardarJuego();

        btnPrimeraOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarBoton(mostrar[1]);

            }
        });
        btnSegundaOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarBoton(mostrar[2]);
            }
        });
        btnTerceraOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarBoton(mostrar[3]);
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Nivel2Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    public int generarNum(){
        java.util.Random r = new Random();
        return r.nextInt(10)+1;
    }

    public void guardarJuego(){

        if(limite < 5){

            imgNivel2.setImageResource(0);
            btnPrimeraOP.setImageResource(0);
            btnSegundaOP.setImageResource(0);
            btnTerceraOP.setImageResource(0);

            num = generarNum();

            if (num == 1) {
                mostrar[0] = R.drawable.uno;
                mostrar[1] = R.drawable.two;
                mostrar[2] = R.drawable.one;
                mostrar[3] = R.drawable.four;

            } else if (num == 2) {
                mostrar[0] = R.drawable.dos;
                mostrar[1] = R.drawable.two;
                mostrar[2] = R.drawable.three;
                mostrar[3] = R.drawable.four;
            } else if (num == 3) {
                mostrar[0] = R.drawable.tres;
                mostrar[1] = R.drawable.five;
                mostrar[2] = R.drawable.four;
                mostrar[3] = R.drawable.three;
            } else if (num == 4) {
                mostrar[0] = R.drawable.cuatro;
                mostrar[1] = R.drawable.two;
                mostrar[2] = R.drawable.four;
                mostrar[3] = R.drawable.six;
            } else if (num == 5) {
                mostrar[0] = R.drawable.cinco;
                mostrar[1] = R.drawable.five;
                mostrar[2] = R.drawable.six;
                mostrar[3] = R.drawable.four;
            } else if (num == 6) {
                mostrar[0] = R.drawable.seis;
                mostrar[1] = R.drawable.eight;
                mostrar[2] = R.drawable.three;
                mostrar[3] = R.drawable.six;
            } else if (num == 7) {
                mostrar[0] = R.drawable.siete;
                mostrar[1] = R.drawable.seven;
                mostrar[2] = R.drawable.six;
                mostrar[3] = R.drawable.nine;
            } else if (num == 8) {
                mostrar[0] = R.drawable.ocho;
                mostrar[1] = R.drawable.teen;
                mostrar[2] = R.drawable.eight;
                mostrar[3] = R.drawable.nine;
            } else if (num == 9) {
                mostrar[0] = R.drawable.nueve;
                mostrar[1] = R.drawable.six;
                mostrar[2] = R.drawable.nine;
                mostrar[3] = R.drawable.eight;
            } else {
                mostrar[0] = R.drawable.diez;
                mostrar[1] = R.drawable.teen;
                mostrar[2] = R.drawable.eight;
                mostrar[3] = R.drawable.nine;
            }

            imgNivel2.setImageResource(mostrar[0]);
            btnPrimeraOP.setImageResource(mostrar[1]);
            btnSegundaOP.setImageResource(mostrar[2]);
            btnTerceraOP.setImageResource(mostrar[3]);
        }
        else{
            Toast.makeText(Nivel2Activity.this, "Ganaste", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Nivel2Activity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    public void verificarBoton(int img){



        if (num == 1) {
            if (mostrar[2]==img){
                limite++;
                Toast.makeText(Nivel2Activity.this,"Felicidades.", Toast.LENGTH_SHORT).show();
                limpiar();
                guardarJuego();
            }
            else{
                vidas();
            }

        } else if (num == 2) {
            if (mostrar[1]==img){
                limite++;

                limpiar();
                guardarJuego();
            }
            else{
                vidas();
            }
        } else if (num == 3) {
            if (mostrar[3]==img){
                limite++;
                Toast.makeText(Nivel2Activity.this,"Felicidades.", Toast.LENGTH_SHORT).show();
                limpiar();
                guardarJuego();
            }
            else{
                vidas();
            }

        } else if (num == 4) {
            if (mostrar[2]==img){
                limite++;
                Toast.makeText(Nivel2Activity.this,"Felicidades.", Toast.LENGTH_SHORT).show();
                limpiar();
                guardarJuego();
            }
            else{
                vidas();
            }

        } else if (num == 5) {
            if (mostrar[1]==img){
                limite++;
                Toast.makeText(Nivel2Activity.this,"Felicidades.", Toast.LENGTH_SHORT).show();
                limpiar();
                guardarJuego();
            }
            else{
                vidas();
            }

        } else if (num == 6) {
            if (mostrar[3]==img){
                limite++;
                Toast.makeText(Nivel2Activity.this,"Felicidades.", Toast.LENGTH_SHORT).show();
                limpiar();
                guardarJuego();
            }
            else{
                vidas();
            }

        } else if (num == 7) {
            limite++;
            if (mostrar[1]==img){
                Toast.makeText(Nivel2Activity.this,"Felicidades.", Toast.LENGTH_SHORT).show();
                limpiar();
                guardarJuego();
            }
            else{
                vidas();
            }

        } else if (num == 8) {
            limite++;
            if (mostrar[2]==img){
                Toast.makeText(Nivel2Activity.this,"Felicidades.", Toast.LENGTH_SHORT).show();
                limpiar();
                guardarJuego();
            }
            else{
                vidas();
            }

        } else if (num == 9) {
            limite++;
            if (mostrar[2]==img){
                Toast.makeText(Nivel2Activity.this,"Felicidades.", Toast.LENGTH_SHORT).show();
                limpiar();
                guardarJuego();
            }
            else{
                vidas();
            }

        } else {
            limite++;
            if (mostrar[1]==img){
                Toast.makeText(Nivel2Activity.this,"Felicidades.", Toast.LENGTH_SHORT).show();
                limpiar();
                guardarJuego();
            }
            else{
                vidas();
            }
        }
    }

    public void vidas(){
        vidas--;
        if(vidas == 2){
            Toast.makeText(Nivel2Activity.this,"Vuelve a intentarlo.", Toast.LENGTH_SHORT).show();
            imgVida1.setImageResource(0);
            imgVida1.setImageResource(R.drawable.sol);
        }
        else if(vidas == 1){
            Toast.makeText(Nivel2Activity.this,"Vuelve a intentarlo.", Toast.LENGTH_SHORT).show();
            imgVida2.setImageResource(0);
            imgVida2.setImageResource(R.drawable.sol);
        }
        else
        {
            imgVida3.setImageResource(0);
            imgVida3.setImageResource(R.drawable.sol);
            Toast.makeText(Nivel2Activity.this,"Has perdido, sorry.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Nivel2Activity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void limpiar(){
        for (int i=0;i>=4;i++){
            mostrar[i]=0;
        }
        num=0;
    }
}
