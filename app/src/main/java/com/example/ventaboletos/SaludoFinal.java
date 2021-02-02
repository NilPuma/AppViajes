package com.example.ventaboletos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SaludoFinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo_final);

        //funcion del boton retornar
        Button volverButton=(Button) findViewById(R.id.Regresar7);
        volverButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent anteriorIntent=new Intent(v.getContext(),Bienvenida.class);
                startActivityForResult(anteriorIntent,0);

            }
        });
    }
}
