package com.example.ventaboletos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Botones de direccionamiento a login y registro

        //ir a Login
        Button loginButton=(Button) findViewById(R.id.irLogin);
        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intentLogin=new Intent(v.getContext(),Login.class);
                startActivityForResult(intentLogin,0);

            }
        });

        //ir a Registro
        Button registroButton=(Button) findViewById(R.id.irRegistrar);
        registroButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent registroIntent=new Intent(v.getContext(),RegistroUsuario.class);
                startActivityForResult(registroIntent,0);
            }
        });


    }
}
