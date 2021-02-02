package com.example.ventaboletos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Comprar extends AppCompatActivity
{
    EditText usuarioEditText,fechaEditText,adultoEditText,ninioEditText,obsEditText;
    Button registraCopraButton;
    Spinner ciudadSpinner,modalidadSpinner;
    String total;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);

        //---------------funcion del boton retornar
        Button volverButton=(Button) findViewById(R.id.Regresar6);
        volverButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent anteriorIntent=new Intent(v.getContext(),Bienvenida.class);
                startActivityForResult(anteriorIntent,0);

            }
        });

        /*
        ///Sincronizamos las variables globales con lo layout
        usuarioEditText=(EditText)findViewById(R.id.txtNombre);
        fechaEditText=(EditText)findViewById(R.id.txtFecha);
        ciudadSpinner=(Spinner) findViewById(R.id.spnCiudad);
        adultoEditText=(EditText)findViewById(R.id.txtCantidadAdulto);
        ninioEditText=(EditText)findViewById(R.id.txtCantidadNinio);
        modalidadSpinner=(Spinner)findViewById(R.id.spnModalidad);
        obsEditText=(EditText)findViewById(R.id.txtObservacion);
        registraCopraButton=(Button)findViewById(R.id.btnRegistrarCompra);

        //operaciones


        //evento del boton
        registraCopraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }
        });*/
    }

   /* private void ejecutarServicio(String URL)
    {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_SHORT).show();
            }
            //el error inicial que sale es por que no se a genrado el listener on Error esponse
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();

            }
        })
                //aqui abajo generamos el metodo getParamn porque se utiliza el metodo post
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String,String> parametros=new HashMap<String, String>(); //usamos el objeto map para manejar datos

                return parametros; //retoranmos toda la colccion de datos mediante la instanciaa creada
            }
        };

        // ahora usamos el objetos requestqueue procesarremos las peticiones hechas desde la app para que la libreria lo ejecute
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }*/
}
