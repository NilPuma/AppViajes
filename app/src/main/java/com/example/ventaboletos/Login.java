package com.example.ventaboletos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Login extends AppCompatActivity
{
    //Variables globales
    EditText idEditText;
    EditText passEditText;
    Button loginButton;
    String user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //---------------funcion del boton retornar
        Button volverButton=(Button) findViewById(R.id.Regresar1);
        volverButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent anteriorIntent=new Intent(v.getContext(),Principal.class);
                startActivityForResult(anteriorIntent,0);

            }
        });

        //---------------------vinculamos nuestras variables declaradas con los controles del layout
        idEditText=findViewById(R.id.txtUsuario);
        passEditText=findViewById(R.id.txtPassword);
        loginButton=findViewById(R.id.btnLogin);


        //Genramos el click del boton login

        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {


                user=idEditText.getText().toString();
                pass=passEditText.getText().toString();

                if (!user.isEmpty() && !pass.isEmpty())
                {
                    validarUsuario("http://192.168.43.220/ViajesPC3/Login.php");
                }
                else
                {
                    Toast.makeText(Login.this,"No se permiten campos vacios",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    //creamos un metodo co el nombre login destinado al servicio nuevo
    private void validarUsuario(String URL)
    {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                //Aqui verificamos que nuestro response no este vacion, si la consicion se cumple
                //nos envia a la pantalla de saludo.
                //En caso de que user ni pass no existan no muestra un sms
                if (!response.isEmpty())
                {
                    Intent intentNex=new Intent(getApplicationContext(),Bienvenida.class);
                    startActivity(intentNex);
                }
                else
                {
                    Toast.makeText(Login.this,"Usuario o Contraseña incorrecta",Toast.LENGTH_LONG).show();

                }

            }
        }, new Response.ErrorListener()
        {
            //dentro de este metodo capturamos el error
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(Login.this,error.toString(),Toast.LENGTH_LONG).show();
            }
        })
            //aqui colocamos los parmetros qeu nuestro servicio solicita para devolver una resp
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {

                Map<String,String> parametros=new HashMap<String,String>();
                
                parametros.put("usuario",idEditText.getText().toString());
                parametros.put("password",passEditText.getText().toString());
                // colocamos valor

                //retornamos toda la coleccion mediante la instacncia creada
                return parametros;
            }
        };

        //Haciendo el uso de la clase REQ creamis la instacnia
        RequestQueue requestQueue= Volley.newRequestQueue(this);

        //abregamos la instancia de nuestro objeto request
        //esta  nos ayuda a procesa todas nuestra peticiones desde nuestra app
        requestQueue.add(stringRequest);
    }
}
