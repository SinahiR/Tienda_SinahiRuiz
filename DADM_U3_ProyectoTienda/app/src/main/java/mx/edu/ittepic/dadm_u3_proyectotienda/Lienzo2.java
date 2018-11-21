package mx.edu.ittepic.dadm_u3_proyectotienda;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo2 extends View {

    ClasesLienzo2 logo, categoria, sueter1, sueter2, sueter3, puntero, puntero2, sueterr, sueterb, suetern;
    Main2Activity ob;
    String mensaje;

    public Lienzo2(Context context) {
        super(context);

        //mensaje="NO se ha tocado nada";
        logo=new ClasesLienzo2(R.drawable.sudaderalogito,60,50,this);
        categoria=new ClasesLienzo2(R.drawable.categoriass,580,50,this);
        sueter1=new ClasesLienzo2(R.drawable.sueter,60,600,this);
        sueter2=new ClasesLienzo2(R.drawable.sueter2,60,1200,this);
        sueter3=new ClasesLienzo2(R.drawable.sueter3,60,1800,this);
        sueterr=new ClasesLienzo2(R.drawable.sueterrojo,650,800,this);
        sueterb=new ClasesLienzo2(R.drawable.sueterb,650,800,this);
        suetern=new ClasesLienzo2(R.drawable.suetern,650,800,this);
        ob=(Main2Activity)context;

        puntero=null;
        puntero2=null;

        sueterr.hacerVisible(false);
        sueterb.hacerVisible(false);
        suetern.hacerVisible(false);
    }

    public void onDraw(Canvas c)
    {
        super.onDraw(c);
        Paint p=new Paint();

        c.drawColor(Color.WHITE);

        p.setColor(Color.parseColor("#CEECF5"));
        c.drawRect(10,0,550,2300,p);


       /* p.setTextSize(50);
        c.drawText(mensaje, 600, 500,p);*/

        logo.pintar(c,p);
        categoria.pintar(c,p);
        sueter1.pintar(c,p);
        sueter2.pintar(c,p);
        sueter3.pintar(c,p);
        sueterr.pintar(c,p);
        sueterb.pintar(c,p);
        suetern.pintar(c,p);
    }

    public boolean onTouchEvent(MotionEvent e)
    {
        float xtoque=e.getX();
        float ytoque=e.getY();

        switch (e.getAction())
        {
            case MotionEvent.ACTION_DOWN:

                if(sueter1.siSeToco(xtoque,ytoque))
                {
                    puntero=sueter1;
                    sueterr.hacerVisible(true);
                    sueterb.hacerVisible(false);
                    suetern.hacerVisible(false);
                   // mensaje="Se toco el sueter 1";
                }
                else
                {
                    if(sueter2.siSeToco(xtoque,ytoque))
                    {
                        puntero=sueter2;
                        sueterr.hacerVisible(false);
                        suetern.hacerVisible(false);
                        sueterb.hacerVisible(true);
                       // mensaje="Se toco el sueter 2";
                    }
                    else
                    {
                        if(sueter3.siSeToco(xtoque,ytoque))
                        {
                            puntero=sueter3;
                            sueterr.hacerVisible(false);
                            sueterb.hacerVisible(false);
                            suetern.hacerVisible(true);
                           // mensaje="Se toco el sueter 3";
                        }
                    }
                }
                break;


            case MotionEvent.ACTION_MOVE:

                    if (puntero == sueter1) {
                        sueter1.mover(ytoque);
                         sueter2.mover(ytoque+600);
                        sueter3.mover(ytoque+1200);
                        if(ytoque>=400)
                        {
                            logo.hacerVisible(true);
                        }
                    }

                if (puntero == sueter2) {
                    sueter2.mover(ytoque);
                    sueter1.mover(ytoque-600);
                    sueter3.mover(ytoque+600);
                    if(ytoque>=800)
                    {
                        logo.hacerVisible(true);
                    }

                }

                if (puntero == sueter3) {
                    sueter3.mover(ytoque);
                    sueter1.mover(ytoque-1200);
                    sueter2.mover(ytoque-600);
                    if(ytoque>=1200)
                    {
                        logo.hacerVisible(true);
                    }

                }

                puntero2=sueter1;
                    if (puntero2.colision(logo)) {
                        logo.hacerVisible(false);
                    }



                break;

            case MotionEvent.ACTION_UP:
                break;


        }
        invalidate();
        return true;
    }

}
