package mx.edu.ittepic.dadm_u3_proyectotienda;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class LienzoPrincipal extends View {

    Imagen c1,c2, c3, c4, c5,c6,puntero, go, mensaC1, mensaC2, mensaC3, c7,c8;
    String mensaje, mensaje2;
    MainActivity ob;

    public LienzoPrincipal(Context context) {
        super(context);

        puntero=null;
        mensaje2="Selecciona Una Categoria";

        c1=new Imagen(R.drawable.shein, 10, 50, this);
        c2=new Imagen(R.drawable.sudadera3, 50, 700,this);
        c3=new Imagen(R.drawable.shopcar, 1100, 1900,this);
        c4=new  Imagen(R.drawable.vestido,650, 700,this);
        c5=new Imagen(R.drawable.catalogo, 420,40,this);
        c6=new Imagen(R.drawable.mochila,1250,700,this);
        c7=new Imagen(R.drawable.shopcar2, 1100,1900,this);
        c8=new Imagen(R.drawable.shopcar3, 1100,1900,this);
        go=new Imagen(R.drawable.go,1140,2100,this);
        mensaC1=new Imagen(R.drawable.categoriasuda, 80, 1350,this);
        mensaC2=new Imagen(R.drawable.categoriavesti, 80, 1350,this);
        mensaC3=new Imagen(R.drawable.categoriamochi, 80, 1350,this);


        ob=(MainActivity)context;


        c3.hacerVisible(false);
        c7.hacerVisible(false);
        c8.hacerVisible(false);
        go.hacerVisible(false);
        mensaC1.hacerVisible(false);
        mensaC2.hacerVisible(false);
        mensaC3.hacerVisible(false);

    }

    public void onDraw(Canvas c)
    {
        super.onDraw(c);
        Paint p=new Paint();
        c.drawColor(Color.WHITE);

        //MENSAJE

        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(mensaje2, 0, 1400, p);


        //RECTANGULO
        p.setColor(Color.parseColor("#CEECF5"));
        c.drawRect(0,600,1440,1300,p);


        //IMAGENES
        c1.pintar(c,p);
        c2.pintar(c,p);
        c3.pintar(c,p);
        c4.pintar(c,p);
        c5.pintar(c,p);
        c6.pintar(c,p);
        c7.pintar(c,p);
        c8.pintar(c,p);
        go.pintar(c,p);
        mensaC1.pintar(c,p);
        mensaC2.pintar(c,p);
        mensaC3.pintar(c,p);

    }

    public boolean onTouchEvent(MotionEvent e)
    {
        float xtoque= e.getX();
        float ytoque=e.getY();


        switch (e.getAction())
        {
            //TOCAR
            case MotionEvent.ACTION_DOWN:

                if(c3.siSeToco(xtoque,ytoque))
                {
                    Intent otraventana=new Intent(ob, Main2Activity.class);
                    ob.startActivity(otraventana);
                }

                if(c7.siSeToco(xtoque,ytoque))
                {
                    Intent otraventana2=new Intent(ob, Main3Activity.class);
                    ob.startActivity(otraventana2);
                }

                if(c8.siSeToco(xtoque,ytoque))
                {
                    Intent otraventana3=new Intent(ob, Main4Activity.class);
                    ob.startActivity(otraventana3);
                }


                //TOQUES CATEGORIAS
                if(c2.siSeToco(xtoque, ytoque)) {
                   // mensaje2 = "Categoria: Sueteres";
                    puntero = c2;
                    c3.hacerVisible(true);
                    go.hacerVisible(true);
                    mensaC1.hacerVisible(true);
                    mensaje2="";

                    //
                    mensaC2.hacerVisible(false);
                    mensaC3.hacerVisible(false);
                    c7.hacerVisible(false);
                    c8.hacerVisible(false);


                }

                else {

                    if (c4.siSeToco(xtoque, ytoque)) {
                        //mensaje2 = "Se toco vestidos";
                        puntero = c4;

                        c7.hacerVisible(true);
                        go.hacerVisible(true);
                        mensaC2.hacerVisible(true);
                        mensaje2="";

                        //Ocultas las otras informacionde categoria
                        mensaC1.hacerVisible(false);
                        mensaC3.hacerVisible(false);
                        c3.hacerVisible(false);
                        c8.hacerVisible(false);

                    }

                    else
                    {
                        if (c6.siSeToco(xtoque, ytoque)) {
                            mensaje2 = "";
                            puntero = c6;

                            c8.hacerVisible(true);
                            c3.hacerVisible(true);
                            go.hacerVisible(true);
                            mensaC3.hacerVisible(true);

                            //Ocultar otros mensajes de categoria
                            mensaC1.hacerVisible(false);
                            mensaC2.hacerVisible(false);
                            c3.hacerVisible(false);
                            c7.hacerVisible(false);
                        }
                    }
                }

                break;

                //Mover
            case MotionEvent.ACTION_MOVE:
                if(puntero==c2)
                {
                    c2.mover(xtoque);
                    c4.mover(xtoque+600);
                    c6.mover(xtoque+1200);
                }

                if(puntero==c4)
                {
                    c4.mover(xtoque);
                    c2.mover(xtoque-600);
                    c6.mover(xtoque+600);
                }

                if(puntero==c6)
                {
                    c6.mover(xtoque);
                    c2.mover(xtoque-1200);
                    c4.mover(xtoque-600);
                }

                break;

            case MotionEvent.ACTION_UP:
                puntero=null;
                break;
        }

        invalidate();
        return true;

    }

}
