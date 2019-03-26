package com.example.root.leen;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;

public class Nivel3Activity extends AppCompatActivity {

    private Button btnRegresar;
    private Button btnReproducir;
    private ImageButton btnPrimeraOP;
    private ImageButton btnSegundaOP;
    private ImageButton btnTerceraOP;
    private ImageButton btnCuartaOP;
    private ImageButton btnElegir1;
    private ImageButton btnElegir2;
    private ImageButton btnElegir3;
    private ImageButton btnElegir4;

    int[] direc = new int[4];
    int[] imagEleccion = new int[4];
    int[] very = new int[4];
    int verificar = 0;
    int vali = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel3);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        btnReproducir = (Button) findViewById(R.id.btnReproducir);
        btnPrimeraOP = (ImageButton) findViewById(R.id.btnPrimeraOP);
        btnSegundaOP = (ImageButton) findViewById(R.id.btnSegundaOP);
        btnTerceraOP = (ImageButton) findViewById(R.id.btnTerceraOP);
        btnCuartaOP = (ImageButton) findViewById(R.id.btnCuartaOP);
        btnElegir1 = (ImageButton) findViewById(R.id.btnElegir1);
        btnElegir2 = (ImageButton) findViewById(R.id.btnElegir2);
        btnElegir3 = (ImageButton) findViewById(R.id.btnElegir3);
        btnElegir4 = (ImageButton) findViewById(R.id.btnElegir4);

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
        }

        else if(num==2){
            num1 = R.drawable.two;
            num2 = R.drawable.three;
            num3 = R.drawable.four;
            num4 = R.drawable.five;
        }

        else if(num==3){
            num1 = R.drawable.three;
            num2 = R.drawable.four;
            num3 = R.drawable.five;
            num4 = R.drawable.six;
        }

        else if(num==4){
            num1 = R.drawable.four;
            num2 = R.drawable.five;
            num3 = R.drawable.six;
            num4 = R.drawable.seven;
        }

        else if(num==5){
            num1 = R.drawable.five;
            num2 = R.drawable.six;
            num3 = R.drawable.seven;
            num4 = R.drawable.eight;
        }

        else if(num==6){
            num1 = R.drawable.six;
            num2 = R.drawable.seven;
            num3 = R.drawable.eight;
            num4 = R.drawable.nine;
        }

        else {
            num1 = R.drawable.seven;
            num2 = R.drawable.eight;
            num3 = R.drawable.nine;
            num4 = R.drawable.teen;
        }

        very[0]=num1;
        very[1]=num2;
        very[2]=num3;
        very[3]=num4;

        direc = desordenar(num1, num2, num3, num4);

        btnPrimeraOP.setImageResource(direc[0]);
        btnSegundaOP.setImageResource(direc[1]);
        btnTerceraOP.setImageResource(direc[2]);
        btnCuartaOP.setImageResource(direc[3]);

        btnPrimeraOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnElegir1.getDrawable() == null)
                    btnElegir1.setImageResource(direc[0]);

                else if(btnElegir2.getDrawable() == null)
                    btnElegir2.setImageResource(direc[0]);

                else if(btnElegir3.getDrawable() == null)
                    btnElegir3.setImageResource(direc[0]);

                else
                    btnElegir4.setImageResource(direc[0]);

                btnPrimeraOP.setImageResource(0);
                btnPrimeraOP.setEnabled(false);

                ValidarNum(direc[0]);
            }
        });

        btnSegundaOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnElegir1.getDrawable() == null)
                    btnElegir1.setImageResource(direc[1]);

                else if(btnElegir2.getDrawable() == null)
                    btnElegir2.setImageResource(direc[1]);


                else if(btnElegir3.getDrawable() == null)
                    btnElegir3.setImageResource(direc[1]);

                else
                    btnElegir4.setImageResource(direc[1]);

                btnSegundaOP.setImageResource(0);
                btnSegundaOP.setEnabled(false);

                ValidarNum(direc[1]);
            }
        });

        btnTerceraOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnElegir1.getDrawable() == null)
                    btnElegir1.setImageResource(direc[2]);

                else if(btnElegir2.getDrawable() == null)
                    btnElegir2.setImageResource(direc[2]);

                else if(btnElegir3.getDrawable() == null)
                    btnElegir3.setImageResource(direc[2]);

                else
                    btnElegir4.setImageResource(direc[2]);

                btnTerceraOP.setImageResource(0);
                btnTerceraOP.setEnabled(false);

                ValidarNum(direc[2]);
            }
        });

        btnCuartaOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnElegir1.getDrawable() == null)
                    btnElegir1.setImageResource(direc[3]);

                else if(btnElegir2.getDrawable() == null)
                    btnElegir2.setImageResource(direc[3]);

                else if(btnElegir3.getDrawable() == null)
                    btnElegir3.setImageResource(direc[3]);
                else
                    btnElegir4.setImageResource(direc[3]);

                btnCuartaOP.setImageResource(0);
                btnCuartaOP.setEnabled(false);

                ValidarNum(direc[3]);
            }
        });

        btnElegir1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnElegir1.getDrawable() != null){
                    ActivarbtnOp();
                }
            }
        });

        btnElegir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnElegir2.getDrawable() != null){
                    ActivarbtnOp();
                }
            }
        });

        btnElegir3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnElegir3.getDrawable() != null){
                    ActivarbtnOp();
                }
            }
        });

        btnElegir4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnElegir4.getDrawable() != null){
                    ActivarbtnOp();
                }
            }
        });

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

    public int[] desordenar(int num1, int num2, int num3, int num4){
        int array[]= {num1, num2, num3, num4};
        int lon = array.length-1;

        for(int i = lon; i>1; i--){
            int x = (int) Math.floor(i*Math.random());
            int y = array[i];
            array[i] = array[x];
            array[x] = y;
        }
        return array;
    }

    public void ValidarNum(int numDirec){
        if(vali < 4){
            imagEleccion[vali] = numDirec;
            vali++;
        }

        if(vali == 4){
            for(int i=0; i<4; i++){
                if(very[i] == imagEleccion[i])
                    verificar++;
                else
                    i=4;
            }

            if(verificar == 4) {
                Toast.makeText(Nivel3Activity.this, "¡Felicidades secuencia correcta! ♥", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(Nivel3Activity.this, "Vuelve a intentarlo", Toast.LENGTH_SHORT).show();
                ActivarbtnOp();
            }
        }
    }

    public void ActivarbtnOp(){
        btnElegir1.setImageResource(0);
        btnElegir2.setImageResource(0);
        btnElegir3.setImageResource(0);
        btnElegir4.setImageResource(0);

        btnPrimeraOP.setEnabled(true);
        btnSegundaOP.setEnabled(true);
        btnTerceraOP.setEnabled(true);
        btnCuartaOP.setEnabled(true);

        btnPrimeraOP.setImageResource(direc[0]);
        btnSegundaOP.setImageResource(direc[1]);
        btnTerceraOP.setImageResource(direc[2]);
        btnCuartaOP.setImageResource(direc[3]);

        vali = 0;
        verificar = 0;
    }
}