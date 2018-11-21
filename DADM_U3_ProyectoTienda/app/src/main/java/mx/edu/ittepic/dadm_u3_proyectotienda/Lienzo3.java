package mx.edu.ittepic.dadm_u3_proyectotienda;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo3 extends View {
    clasesLienzo3 logoV, categoria, vestido1, vestido2, vestido3, puntero, puntero2, vestidod1, vestidod2, vestidod3;

    String mensaje;
    public Lienzo3(Context context) {
        super(context);

        //mensaje="NO se ha tocado nada";
        logoV=new clasesLienzo3(R.drawable.logov,60,50,this);
        categoria=new clasesLienzo3(R.drawable.vestidoscategoria,580,50,this);
        vestido1=new clasesLienzo3(R.drawable.vestido1,60,600,this);
        vestido2=new clasesLienzo3(R.drawable.vestido2,60,1200,this);
        vestido3=new clasesLienzo3(R.drawable.vestido3,60,1800,this);
        vestidod1=new clasesLienzo3(R.drawable.desv1,650,800,this);
        vestidod2=new clasesLienzo3(R.drawable.desv2,650,800,this);
        vestidod3=new clasesLienzo3(R.drawable.desv3,650,800,this);


        puntero=null;
        puntero2=null;

        vestidod1.hacerVisible(false);
        vestidod2.hacerVisible(false);
        vestidod3.hacerVisible(false);
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

        logoV.pintar(c,p);
        categoria.pintar(c,p);
       vestido1.pintar(c,p);
        vestido2.pintar(c,p);
        vestido3.pintar(c,p);
        vestidod1.pintar(c,p);
        vestidod2.pintar(c,p);
        vestidod3.pintar(c,p);
    }

    public boolean onTouchEvent(MotionEvent e)
    {
        float xtoque=e.getX();
        float ytoque=e.getY();

        switch (e.getAction())
        {
            case MotionEvent.ACTION_DOWN:

                if(vestido1.siSeToco(xtoque,ytoque))
                {
                    puntero=vestido1;
                    vestidod1.hacerVisible(true);
                    vestidod2.hacerVisible(false);
                    vestidod3.hacerVisible(false);
                    // mensaje="Se toco el sueter 1";
                }
                else
                {
                    if(vestido2.siSeToco(xtoque,ytoque))
                    {
                        puntero=vestido2;
                        vestidod3.hacerVisible(false);
                        vestidod1.hacerVisible(false);
                        vestidod2.hacerVisible(true);
                        // mensaje="Se toco el sueter 2";
                    }
                    else
                    {
                        if(vestido3.siSeToco(xtoque,ytoque))
                        {
                            puntero=vestido3;
                            vestidod1.hacerVisible(false);
                            vestidod2.hacerVisible(false);
                            vestidod3.hacerVisible(true);
                            // mensaje="Se toco el sueter 3";
                        }
                    }
                }
                break;


            case MotionEvent.ACTION_MOVE:

                if (puntero == vestido1) {
                    vestido1.mover(ytoque);
                    vestido2.mover(ytoque+600);
                    vestido3.mover(ytoque+1200);
                    if(ytoque>=400)
                    {
                        logoV.hacerVisible(true);
                    }
                }

                if (puntero == vestido2) {
                    vestido2.mover(ytoque);
                    vestido1.mover(ytoque-600);
                    vestido3.mover(ytoque+600);
                    if(ytoque>=800)
                    {
                        logoV.hacerVisible(true);
                    }

                }

                if (puntero == vestido3) {
                    vestido3.mover(ytoque);
                    vestido1.mover(ytoque-1200);
                    vestido2.mover(ytoque-600);
                    if(ytoque>=1200)
                    {
                        logoV.hacerVisible(true);
                    }

                }

                puntero2=vestido1;
                if (puntero2.colision(logoV)) {
                    logoV.hacerVisible(false);
                }


                break;

            case MotionEvent.ACTION_UP:
                break;


        }
        invalidate();
        return true;
    }


}
