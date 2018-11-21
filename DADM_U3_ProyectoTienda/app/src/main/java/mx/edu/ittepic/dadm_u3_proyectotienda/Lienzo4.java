package mx.edu.ittepic.dadm_u3_proyectotienda;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo4 extends View {
    clasesLienzo4 logoM, categoria, mochila1, mochila2, mochila3, puntero, puntero2, mochilad1, mochilad2, mochilad3;

    public Lienzo4(Context context) {
        super(context);

        //mensaje="NO se ha tocado nada";
        logoM=new clasesLienzo4(R.drawable.logomochila,60,50,this);
        categoria=new clasesLienzo4(R.drawable.mochilacategoria,580,50,this);
        mochila1=new clasesLienzo4(R.drawable.mochila1,60,600,this);
        mochila2=new clasesLienzo4(R.drawable.mochila2,60,1200,this);
        mochila3=new clasesLienzo4(R.drawable.mochila3,60,1800,this);
        mochilad1=new clasesLienzo4(R.drawable.mochilad1,650,800,this);
        mochilad2=new clasesLienzo4(R.drawable.mochilad2,650,800,this);
        mochilad3=new clasesLienzo4(R.drawable.mochilad3,650,800,this);

        puntero=null;
        puntero2=null;

        mochilad1.hacerVisible(false);
        mochilad2.hacerVisible(false);
        mochilad3.hacerVisible(false);
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

        logoM.pintar(c,p);
        categoria.pintar(c,p);
        mochila1.pintar(c,p);
        mochila2.pintar(c,p);
        mochila3.pintar(c,p);
        mochilad1.pintar(c,p);
        mochilad2.pintar(c,p);
        mochilad3.pintar(c,p);
    }

    public boolean onTouchEvent(MotionEvent e)
    {
        float xtoque=e.getX();
        float ytoque=e.getY();

        switch (e.getAction())
        {
            case MotionEvent.ACTION_DOWN:

                if(mochila1.siSeToco(xtoque,ytoque))
                {
                    puntero=mochila1;
                    mochilad1.hacerVisible(true);
                    mochilad2.hacerVisible(false);
                    mochilad3.hacerVisible(false);
                    // mensaje="Se toco el sueter 1";
                }
                else
                {
                    if(mochila2.siSeToco(xtoque,ytoque))
                    {
                        puntero=mochila2;
                        mochilad3.hacerVisible(false);
                        mochilad1.hacerVisible(false);
                        mochilad2.hacerVisible(true);
                        // mensaje="Se toco el sueter 2";
                    }
                    else
                    {
                        if(mochila3.siSeToco(xtoque,ytoque))
                        {
                            puntero=mochila3;
                           mochilad1.hacerVisible(false);
                            mochilad2.hacerVisible(false);
                            mochilad3.hacerVisible(true);
                            // mensaje="Se toco el sueter 3";
                        }
                    }
                }
                break;


            case MotionEvent.ACTION_MOVE:

                if (puntero == mochila1) {
                    mochila1.mover(ytoque);
                    mochila2.mover(ytoque+600);
                    mochila3.mover(ytoque+1200);
                    if(ytoque>=400)
                    {
                        logoM.hacerVisible(true);
                    }
                }

                if (puntero == mochila2) {
                    mochila2.mover(ytoque);
                    mochila1.mover(ytoque-600);
                    mochila3.mover(ytoque+600);
                    if(ytoque>=800)
                    {
                        logoM.hacerVisible(true);
                    }

                }

                if (puntero == mochila3) {
                    mochila3.mover(ytoque);
                    mochila1.mover(ytoque-1200);
                    mochila2.mover(ytoque-600);
                    if(ytoque>=1200)
                    {
                        logoM.hacerVisible(true);
                    }

                }

                puntero2=mochila1;
                if (puntero2.colision(logoM)) {
                    logoM.hacerVisible(false);
                }



                break;

            case MotionEvent.ACTION_UP:
                break;


        }
        invalidate();
        return true;

    }
}
