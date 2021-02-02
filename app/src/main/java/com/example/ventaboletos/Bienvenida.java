package com.example.ventaboletos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Bienvenida extends AppCompatActivity
{
    //Bundle datos;
    //TextView mostrarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        getSupportActionBar().hide();

        //funcion de boton VER
        Button verButton=(Button) findViewById(R.id.btnVer);
        verButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent verIntent=new Intent(v.getContext(),VerViaje.class);
                startActivityForResult(verIntent,0);

            }
        });

        //funcion de boton COMPRAR
        Button comprarButton=(Button) findViewById(R.id.btnComprar);
        comprarButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent comprarIntent=new Intent(v.getContext(),ComprarViaje.class);
                startActivityForResult(comprarIntent,0);

            }
        });

        //funcion del boton retornar
        Button volverButton=(Button) findViewById(R.id.Regresar3);
        volverButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent anteriorIntent=new Intent(v.getContext(),Principal.class);
                startActivityForResult(anteriorIntent,0);

            }
        });

         // saludos
       /** mostrarDatos=(TextView)findViewById(R.id.lblSaludo);
        datos=getIntent().getExtras();
        String datosRecibidos=datos.getString("usuario");
        mostrarDatos.setText(datosRecibidos);*/



    }
}
