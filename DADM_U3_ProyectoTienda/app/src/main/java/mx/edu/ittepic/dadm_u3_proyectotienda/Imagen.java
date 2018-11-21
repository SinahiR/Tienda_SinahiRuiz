package mx.edu.ittepic.dadm_u3_proyectotienda;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Imagen {


   private Bitmap icono;
   private float x,y;
   int desplazamiento;
  private  boolean visible;


    public Imagen(int resource, float _x, float _y, final LienzoPrincipal l)

    {
        icono=BitmapFactory.decodeResource(l.getResources(),resource);
        x=_x;
        y=_y;
        visible=true;

    }

    public void pintar(Canvas c, Paint p)
    {
      if(visible)  c.drawBitmap(icono, x, y,p);
    }

    public void hacerVisible(boolean v)
    {
        visible=v;

    }


    //xp y yp son del toque
    public Boolean siSeToco(float xp, float yp)
    {
        if(!visible)
        {
            return false;
        }
        float x2, y2;

        x2=x+icono.getWidth();
        y2=y+icono.getHeight();

        if(xp>=x && xp<=x2)
        {
            if(yp>=y && yp<=y2)
            {
                return  true; //Regresara verdadero si ambos if son verdaderos
            }
        }

        return false;
    }

    public void mover( float xp)
    {
        x=xp-(icono.getWidth()/2);
       // y=yp-(icono.getHeight()/2);
    }

    //Si se tocan
    public boolean colision(Imagen objetoB)
    {
        float x2=x+icono.getWidth(); //Calculas el tocque
        float y2=y+icono.getHeight();

        if(objetoB.siSeToco(x2,y))
        {
            //revisando caso 1
            return true;
        }

        if(objetoB.siSeToco(x,y))
        {
            //revisando caso 2
            return true;
        }

        if(objetoB.siSeToco(x2,y2))
        {
            //revisando caso 3
            return true;
        }

        if(objetoB.siSeToco(x,y2))
        {
            //revisando caso 4
            return true;
        }

       return false;
    }


}
