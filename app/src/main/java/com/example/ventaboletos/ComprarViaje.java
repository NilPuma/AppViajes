package com.example.ventaboletos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ComprarViaje extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_viaje);

        //funcion del boton comprar Arequipa
        Button comprarArequipaButton=(Button) findViewById(R.id.btnComprarArequipa);
        comprarArequipaButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent comprarArequipaIntent=new Intent(v.getContext(),Comprar.class);
                startActivityForResult(comprarArequipaIntent,0);
            }
        });

        //funcion del boton comprar cusco
        Button comprarCuscoButton=(Button) findViewById(R.id.btnComprarCusco);
        comprarCuscoButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent comprarCuscoIntent=new Intent(v.getContext(),Comprar.class);
                startActivityForResult(comprarCuscoIntent,0);
            }
        });
        //funcion del boton comprar cusco
        Button comprarPunoButton=(Button) findViewById(R.id.btnComprarPuno);
        comprarPunoButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent comprarPunoIntent=new Intent(v.getContext(),Comprar.class);
                startActivityForResult(comprarPunoIntent,0);
            }
        });


        //funcion del boton retornar
        Button volverButton=(Button) findViewById(R.id.Regresar5);
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
