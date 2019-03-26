package com.example.root.leen;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
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

        changeImg(R.drawable.one,R.drawable.uno,150,200);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Nivel1Activity.this, MainActivity.class);
                startActivity(intent);
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
                    changeImg(R.drawable.one,R.drawable.uno,150,200);
                }
                else if (x==1){
                    changeImg(R.drawable.two,R.drawable.dos,150,300);
                }
                else if (x==2){
                    changeImg(R.drawable.three,R.drawable.tres,150,300);
                }
                else if (x==3){
                    changeImg(R.drawable.four,R.drawable.cuatro,180,320);
                }
                else if (x==4){
                    changeImg(R.drawable.five,R.drawable.cinco,200,300);
                }
                else if (x==5){
                    changeImg(R.drawable.six,R.drawable.seis,200,330);
                }else if (x==6){
                    changeImg(R.drawable.seven,R.drawable.siete,210,350);
                }else if (x==7){
                    changeImg(R.drawable.eight,R.drawable.ocho,210,350);
                }else if (x==8){
                    changeImg(R.drawable.nine,R.drawable.nueve,210,350);
                }
                else if (x==9){
                    changeImg(R.drawable.teen,R.drawable.diez,210,350);
                }

            }
        });
    }

    private void changeImg(int one, int uno, int height, int width) {
        numUno.setImageResource(one);
        imgUno.setImageResource(uno);
        imgUno.getLayoutParams().height=dpToPx(height);
        imgUno.getLayoutParams().width=dpToPx(width);
    }

    private int dpToPx(float dip) {
        Resources r = getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, r.getDisplayMetrics());
        return (int)px;
    }
}
