package com.example.ventaboletos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VerViaje extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_viaje);
        getSupportActionBar().setTitle("DESTINOS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //boton ver Arequipa
        Button arequipaButton=(Button) findViewById(R.id.btnVerArequipa);
        arequipaButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent arequipaIntent=new Intent(v.getContext(),verArequipa.class);
                startActivityForResult(arequipaIntent,0);

            }
        });

        //boton ver Cusco
        Button cuscoButton=(Button) findViewById(R.id.btnVerCusco);
        cuscoButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent cuscoIntent=new Intent(v.getContext(),verCusco.class);
                startActivityForResult(cuscoIntent,0);

            }
        });

        //boton ver Puno
        Button punoButton=(Button) findViewById(R.id.btnVerPuno);
        punoButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent punoIntent=new Intent(v.getContext(),verPuno.class);
                startActivityForResult(punoIntent,0);

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp()
    {
        onBackPressed();
        return false;
    }
}
