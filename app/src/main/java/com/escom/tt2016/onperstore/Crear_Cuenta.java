package com.escom.tt2016.onperstore;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

public class Crear_Cuenta extends AppCompatActivity {
    EditText et_crear_cuenta_usuario,
             et_crear_cuenta_nombre,
             et_crear_cuenta_ap,
             et_crear_cuenta_am,
             et_crear_cuenta_telefono,
             et_crear_cuenta_direccion,
             et_crear_cuenta_email,
             et_crear_cuenta_password;
    Button btn_registar_usuario;
    Metodos metodos=new Metodos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear__cuenta);

        et_crear_cuenta_usuario=         (EditText) findViewById(R.id.et_crear_cuenta_usuario);
        et_crear_cuenta_nombre=          (EditText) findViewById(R.id.et_crear_cuenta_nombre);
        et_crear_cuenta_ap=              (EditText) findViewById(R.id.et_crear_cuenta_ap);
        et_crear_cuenta_am=              (EditText) findViewById(R.id.et_crear_cuenta_am);
        et_crear_cuenta_telefono=        (EditText) findViewById(R.id.et_crear_cuenta_telefono);
        et_crear_cuenta_direccion=       (EditText) findViewById(R.id.et_crear_cuenta_direccion);
        et_crear_cuenta_email=           (EditText) findViewById(R.id.et_crear_cuenta_email);
        et_crear_cuenta_password=        (EditText) findViewById(R.id.et_crear_cuenta_password);
        btn_registar_usuario=            (Button)   findViewById(R.id.btn_registrar_usuario);


        btn_registar_usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="http://192.168.0.3/WebService/28/Crear_cuenta.php?usu=";
                url=url            +et_crear_cuenta_usuario.getText().toString();
                url=url+"&name="   +et_crear_cuenta_nombre.getText().toString();
                url=url+"&ap="     +et_crear_cuenta_ap.getText().toString();
                url=url+"&am="     +et_crear_cuenta_am.getText().toString();
                url=url+"&tel="    +et_crear_cuenta_telefono.getText().toString();
                url=url+"&dir="    +et_crear_cuenta_direccion.getText().toString();
                url=url+"&email="  +et_crear_cuenta_email.getText().toString();
                url=url+"&pas="    +et_crear_cuenta_password.getText().toString();
                //Toast.makeText(Login.this, url, Toast.LENGTH_SHORT).show();//para mostrar de que los datos se introjeron correctamente y solo para testeo
                new Crear_Cuenta.RegistrarDatosUsuario().execute(url);
            }
        });
    }

    private class RegistrarDatosUsuario extends AsyncTask<String, Void, String> {
        @Override

        protected String doInBackground(String... urls) {

            //Params proviene de la llamada execute (): params [0] es la url.
            try {
                return metodos.downloadUrl(urls[0]);
            } catch (IOException e) {
                return "No se puede recuperar la página web. La URL puede no ser válida.";
            }
        }

        // OnPostExecute muestra los resultados de AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), "Se registro el usuario ", Toast.LENGTH_SHORT).show();

            et_crear_cuenta_usuario.setText("");
            et_crear_cuenta_nombre.setText("");
            et_crear_cuenta_ap.setText("");
            et_crear_cuenta_am.setText("");
            et_crear_cuenta_telefono.setText("");
            et_crear_cuenta_direccion.setText("");
            et_crear_cuenta_email.setText("");
            et_crear_cuenta_password.setText("");

        }
    }//fin de CargarDatos


}
