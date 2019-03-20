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

public class Nivel1Activity extends AppCompatActivity {

   private ImageButton btnRegresar;
    private ImageButton btnSig;
    private ImageView numUno;
    private ImageView imgUno;
    int x;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel1);

        btnRegresar = (ImageButton) findViewById(R.id.btnRegresar);
        btnSig = (ImageButton) findViewById(R.id.btnSig);
        imgUno = (ImageView) findViewById(R.id.imgUno);
        numUno = (ImageView) findViewById(R.id.numUno);
        x=0;

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x++;
                if (x>8)
                    x=0;
                if (x==0){
                    numUno.setImageResource(R.drawable.one);
                    imgUno.setImageResource(R.drawable.uno);
                }
                else if (x==1){
                    numUno.setImageResource(R.drawable.two);
                    imgUno.setImageResource(R.drawable.dos);
                }
                else if (x==2){
                    numUno.setImageResource(R.drawable.three);
                    imgUno.setImageResource(R.drawable.tres);
                }
                else if (x==3){
                    numUno.setImageResource(R.drawable.four);
                    imgUno.setImageResource(R.drawable.cuatro);
                }
                else if (x==4){
                    numUno.setImageResource(R.drawable.five);
                    imgUno.setImageResource(R.drawable.cinco);
                }
                else if (x==5){
                    numUno.setImageResource(R.drawable.six);
                    imgUno.setImageResource(R.drawable.seis);
                }else if (x==6){
                    numUno.setImageResource(R.drawable.seven);
                    imgUno.setImageResource(R.drawable.siete);
                }else if (x==7){
                    numUno.setImageResource(R.drawable.eight);
                    imgUno.setImageResource(R.drawable.ocho);
                }else if (x==8){
                    numUno.setImageResource(R.drawable.nine);
                    imgUno.setImageResource(R.drawable.nueve);
                }
                else if (x==9)
                {
                    numUno.setImageResource(R.drawable.teen);
                    imgUno.setImageResource(R.drawable.diez);
                }

            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Nivel1Activity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
