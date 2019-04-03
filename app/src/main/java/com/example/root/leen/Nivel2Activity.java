package com.example.root.leen;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
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
    private ImageButton help;
    private MediaPlayer ayuda;
    private Intent intento;

    int num=0, limite=0, vidas=3;
    int mostrar[]= new int[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel2);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnRegresar = (Button) findViewById(R.id.btnRegresar);
//        btnReproducir = (Button) findViewById(R.id.btnReproducir);
        btnPrimeraOP = (ImageView) findViewById(R.id.btnPrimeraOP);
        btnSegundaOP = (ImageView) findViewById(R.id.btnSegundaOP);
        btnTerceraOP = (ImageView) findViewById(R.id.btnTerceraOP);
        imgNivel2 = (ImageView) findViewById(R.id.imgNivel2);
        imgVida1 = (ImageView)  findViewById(R.id.imgVida1);
        imgVida2 = (ImageView)  findViewById(R.id.imgVida2);
        imgVida3 = (ImageView)  findViewById(R.id.imgVida3);
        help=(ImageButton) findViewById(R.id.btnHelp);
        ayuda= MediaPlayer.create(this, R.raw.cuantos_objetos);

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
                finish();
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ayuda.start();
            }
        });


    }

    public int generarNum(){
        java.util.Random r = new Random();
        return r.nextInt(10)+1;
    }

    public void guardarJuego(){

        if(limite <  5){

            imgNivel2.setImageResource(0);
            btnPrimeraOP.setImageResource(0);
            btnSegundaOP.setImageResource(0);
            btnTerceraOP.setImageResource(0);

            num = generarNum();

            if (num == 1) {
                mostrar[0] = R.drawable.uno;
                mostrar[1] = R.drawable.animados;
                mostrar[2] = R.drawable.animauno;
                mostrar[3] = R.drawable.animacuatro;

            } else if (num == 2) {
                mostrar[0] = R.drawable.dos;
                mostrar[1] = R.drawable.animados;
                mostrar[2] = R.drawable.animatres;
                mostrar[3] = R.drawable.animacuatro;
            } else if (num == 3) {
                mostrar[0] = R.drawable.tres;
                mostrar[1] = R.drawable.animacinco;
                mostrar[2] = R.drawable.animacuatro;
                mostrar[3] = R.drawable.animatres;
            } else if (num == 4) {
                mostrar[0] = R.drawable.cuatro;
                mostrar[1] = R.drawable.animados;
                mostrar[2] = R.drawable.animacuatro;
                mostrar[3] = R.drawable.animaseis;
            } else if (num == 5) {
                mostrar[0] = R.drawable.cinco;
                mostrar[1] = R.drawable.animacinco;
                mostrar[2] = R.drawable.animaseis;
                mostrar[3] = R.drawable.four;
            } else if (num == 6) {
                mostrar[0] = R.drawable.seis;
                mostrar[1] = R.drawable.animaocho;
                mostrar[2] = R.drawable.animatres;
                mostrar[3] = R.drawable.animaseis;
            } else if (num == 7) {
                mostrar[0] = R.drawable.siete;
                mostrar[1] = R.drawable.animasiete;
                mostrar[2] = R.drawable.animaseis;
                mostrar[3] = R.drawable.animanueve;
            } else if (num == 8) {
                mostrar[0] = R.drawable.ocho;
                mostrar[1] = R.drawable.animadiez;
                mostrar[2] = R.drawable.animaocho;
                mostrar[3] = R.drawable.animanueve;
            } else if (num == 9) {
                mostrar[0] = R.drawable.nueve;
                mostrar[1] = R.drawable.animaseis;
                mostrar[2] = R.drawable.animanueve;
                mostrar[3] = R.drawable.animaocho;
            } else {
                mostrar[0] = R.drawable.diez;
                mostrar[1] = R.drawable.animadiez;
                mostrar[2] = R.drawable.animaocho;
                mostrar[3] = R.drawable.animanueve;
            }

            imgNivel2.setImageResource(mostrar[0]);
            btnPrimeraOP.setImageResource(mostrar[1]);
            btnSegundaOP.setImageResource(mostrar[2]);
            btnTerceraOP.setImageResource(mostrar[3]);
        }
    }

    private void audios(int ini, int fin,String lugar) {
        intento= new Intent(this, ServicioSonidos.class);
        intento.putExtra("action", ServicioMusica.START);
        Random r = new Random();

        int num=(int)Math.floor(Math.random()*(fin-ini+1)+ini);
        if(num==1)
            intento.putExtra("music", R.raw.correcto);
        else if(num==2)
            intento.putExtra("music", R.raw.correcto2);
        else if(num==3)
            intento.putExtra("music", R.raw.genial);
        else if(num==4)
            intento.putExtra("music", R.raw.genial2);
        else if(num==5)
            intento.putExtra("music", R.raw.lo_lograste);
        else if(num==6)
            intento.putExtra("music", R.raw.lo_lograste2);
        else if(num==7)
            intento.putExtra("music", R.raw.intentalo_otra_vez);
        else if(num==8)
            intento.putExtra("music", R.raw.intentalo_otra_vez2);
        else if(num==9)
            intento.putExtra("music", R.raw.felicidades);
        else if(num==10)
            intento.putExtra("music", R.raw.felicidades2);
        else if(num==11)
            intento.putExtra("music", R.raw.hiciste_muy_bien);
        else if(num==12)
            intento.putExtra("music", R.raw.hiciste_muy_bien2);
        else if(num==13)
            intento.putExtra("music", R.raw.repasa_uno);
        else if(num==14)
            intento.putExtra("music", R.raw.repasa_uno2);
        startService(intento);
    }

    public void verificarBoton(int img){

        if(limite <4)
        {
            if (num == 1) {
                if (mostrar[2]==img){
                    limite++;
                    //Toast.makeText(Nivel2Activity.this,"Felicidades.", Toast.LENGTH_SHORT).show();
                    audios(1,6,"secuencia correcta");
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
                    //Toast.makeText(Nivel2Activity.this,"Felicidades.", Toast.LENGTH_SHORT).show();
                    audios(1,6,"secuencia correcta");
                    limpiar();
                    guardarJuego();
                }
                else{
                    vidas();
                }

            } else if (num == 4) {
                if (mostrar[2]==img){
                    limite++;
                    //Toast.makeText(Nivel2Activity.this,"Felicidades.", Toast.LENGTH_SHORT).show();
                    audios(1,6,"secuencia correcta");
                    limpiar();
                    guardarJuego();
                }
                else{
                    vidas();
                }

            } else if (num == 5) {
                if (mostrar[1]==img){
                    limite++;
                    //Toast.makeText(Nivel2Activity.this,"Felicidades.", Toast.LENGTH_SHORT).show();
                    audios(1,6,"secuencia correcta");
                    limpiar();
                    guardarJuego();
                }
                else{
                    vidas();
                }

            } else if (num == 6) {
                if (mostrar[3]==img){
                    limite++;
                    //Toast.makeText(Nivel2Activity.this,"Felicidades.", Toast.LENGTH_SHORT).show();
                    audios(1,6,"secuencia correcta");
                    limpiar();
                    guardarJuego();
                }
                else{
                    vidas();
                }

            } else if (num == 7) {
                limite++;
                if (mostrar[1]==img){
                    //Toast.makeText(Nivel2Activity.this,"Felicidades.", Toast.LENGTH_SHORT).show();
                    audios(1,6,"secuencia correcta");
                    limpiar();
                    guardarJuego();
                }
                else{
                    vidas();
                }

            } else if (num == 8) {
                limite++;
                if (mostrar[2]==img){
                    //Toast.makeText(Nivel2Activity.this,"Felicidades.", Toast.LENGTH_SHORT).show();
                    audios(1,6,"secuencia correcta");
                    limpiar();
                    guardarJuego();
                }
                else{
                    vidas();
                }

            } else if (num == 9) {
                limite++;
                if (mostrar[2]==img){
                    //Toast.makeText(Nivel2Activity.this,"Felicidades.", Toast.LENGTH_SHORT).show();
                    audios(1,6,"secuencia correcta");
                    limpiar();
                    guardarJuego();
                }
                else{
                    vidas();
                }

            } else {
                limite++;
                if (mostrar[1]==img){
                    //Toast.makeText(Nivel2Activity.this,"Felicidades.", Toast.LENGTH_SHORT).show();
                    audios(1,6,"secuencia correcta");
                    limpiar();
                    guardarJuego();
                }
                else{
                    vidas();
                }
            }

        }
        else{
            //Toast.makeText(Nivel2Activity.this, "Ganaste", Toast.LENGTH_SHORT).show();
            audios(9,12, "ganaste el juego");
            finish();
        }
    }

    public void vidas(){
        vidas--;
        if(vidas == 2){
            //Toast.makeText(Nivel2Activity.this,"Vuelve a intentarlo.", Toast.LENGTH_SHORT).show();
            audios(7,8,"vuelve a intentarlo 1");
            imgVida1.setImageResource(0);
            imgVida1.setImageResource(R.drawable.sol);
        }
        else if(vidas == 1){
            //Toast.makeText(Nivel2Activity.this,"Vuelve a intentarlo.", Toast.LENGTH_SHORT).show();
            audios(7,8,"vuelve a intentarlo 1");
            imgVida2.setImageResource(0);
            imgVida2.setImageResource(R.drawable.sol);
        }
        else
        {
            imgVida3.setImageResource(0);
            imgVida3.setImageResource(R.drawable.sol);
            //Toast.makeText(Nivel2Activity.this,"Has perdido, sorry.", Toast.LENGTH_SHORT).show();
            audios(13,14,"sin vidas");
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
