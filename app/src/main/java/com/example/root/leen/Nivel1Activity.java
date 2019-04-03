package com.example.root.leen;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Nivel1Activity extends AppCompatActivity {

   private ImageButton btnRegresar;
    private ImageButton btnSig;
    private ImageButton numUno;
    private ImageView imgUno;
    private ImageButton help;
    public MediaPlayer ayuda;
    public MediaPlayer numero;
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel1);

        btnRegresar = (ImageButton) findViewById(R.id.btnRegresar);
        btnSig = (ImageButton) findViewById(R.id.btnSig);
        imgUno = (ImageView) findViewById(R.id.imgUno);
        numUno = (ImageButton) findViewById(R.id.numUno);
        help=(ImageButton) findViewById(R.id.btnAyuda);
        x=0;

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ayuda= MediaPlayer.create(this, R.raw.precionanum);


        changeImg(R.drawable.one,R.drawable.uno,150,200,R.raw.uno);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x++;
                if (x>9)
                    x=0;
                if (x==0){
                    changeImg(R.drawable.animauno,R.drawable.uno,150,200,R.raw.uno);
                }
                else if (x==1){
                    changeImg(R.drawable.animados,R.drawable.dos,150,300,R.raw.dos);
                }
                else if (x==2){
                    changeImg(R.drawable.animatres,R.drawable.tres,150,300,R.raw.tres);
                }
                else if (x==3){
                    changeImg(R.drawable.animacuatro,R.drawable.cuatro,180,320,R.raw.cuatro);
                }
                else if (x==4){
                    changeImg(R.drawable.animacinco,R.drawable.cinco,180,180,R.raw.cinco);
                }
                else if (x==5){
                    changeImg(R.drawable.animaseis,R.drawable.seis,200,330,R.raw.seis);
                }else if (x==6){
                    changeImg(R.drawable.animasiete,R.drawable.siete,210,350,R.raw.siete);
                }else if (x==7){
                    changeImg(R.drawable.animaocho,R.drawable.ocho,210,350,R.raw.ocho);
                }else if (x==8){
                    changeImg(R.drawable.animanueve,R.drawable.nueve,210,350,R.raw.nueve);
                }
                else if (x==9){
                    changeImg(R.drawable.animadiez,R.drawable.diez,210,350,R.raw.diez);
                }

            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ayuda.start();
            }
        });
        numUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero.start();
            }
        });

    }


    private void changeImg(int one, int uno, int height, int width,int audio) {
        numUno.setImageResource(one);
        imgUno.setImageResource(uno);
        imgUno.getLayoutParams().height=dpToPx(height);
        imgUno.getLayoutParams().width=dpToPx(width);
        numero= MediaPlayer.create(this,audio);
    }

    private int dpToPx(float dip) {
        Resources r = getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, r.getDisplayMetrics());
        return (int)px;
    }

}
