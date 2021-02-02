package com.example.ventaboletos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class RegistroUsuario extends AppCompatActivity
{
    EditText nombreEditText,apellidoEditText,dniEditText,celularEditText,correoEditText,userEditText,passEditText;

    Button registrarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        //funcion del boton retornar
        Button volverButton=(Button) findViewById(R.id.Regresar2);
        volverButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent anteriorIntent=new Intent(v.getContext(),Principal.class);
                startActivityForResult(anteriorIntent,0);

            }
        });
        //Registrar usuarios-------------------------------------------------
        nombreEditText=(EditText)findViewById(R.id.txtUsuarioRegistro);
        apellidoEditText=(EditText)findViewById(R.id.txtApellido);
        dniEditText=(EditText)findViewById(R.id.txtDni);
        celularEditText=(EditText)findViewById(R.id.txtCelular);
        correoEditText=(EditText)findViewById(R.id.txtCorreo);
        userEditText=(EditText)findViewById(R.id.txtUsuarioRegistro);
        passEditText=(EditText)findViewById(R.id.txtPasswordRegistro);

        registrarButton=(Button)findViewById(R.id.btnRegistrarUsuario);

        //creamos el evento click para el boton registrar

        registrarButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ejecutarServicio("http://192.168.43.220/ViajesPC3/RegistroCliente.php");
            }
        });

    }
    //crear el metodo que enviara las peticiones al servidor

    private void ejecutarServicio(String URL)
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

                parametros.put("nombre",nombreEditText.getText().toString());
                parametros.put("apellido",apellidoEditText.getText().toString());
                parametros.put("dni",dniEditText.getText().toString());
                parametros.put("celular",celularEditText.getText().toString());
                parametros.put("correo",correoEditText.getText().toString());
                parametros.put("user",userEditText.getText().toString());
                parametros.put("passwords",passEditText.getText().toString());
                return parametros; //retoranmos toda la colccion de datos mediante la instanciaa creada
            }
        };

        // ahora usamos el objetos requestqueue procesarremos las peticiones hechas desde la app para que la libreria lo ejecute
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
