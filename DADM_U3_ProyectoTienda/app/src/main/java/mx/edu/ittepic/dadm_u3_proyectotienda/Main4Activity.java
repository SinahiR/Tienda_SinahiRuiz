package mx.edu.ittepic.dadm_u3_proyectotienda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Lienzo4(this));
    }
}
