package com.escom.tt2016.onperstore;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

public class Login extends AppCompatActivity {
    EditText et_usuario,et_password;
    TextView tv_olvido_contrasena;
    Button btn_iniciar_sesion,btn_crear_cuenta;
    Metodos metodos=new Metodos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_usuario=             (EditText) findViewById(R.id.et_login_usuario);
        et_password=            (EditText) findViewById(R.id.et_login_password);
        tv_olvido_contrasena=   (TextView) findViewById(R.id.tv_olvido_contrasena);
        btn_iniciar_sesion=     (Button) findViewById(R.id.btn_iniciar_sesion);
        btn_crear_cuenta=       (Button) findViewById(R.id.btn_crear_cuenta);

        btn_iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="http://192.168.0.3/WebService/28/Login.php?usu=";
                       url=    url+ et_usuario.getText().toString();
                       url=    url+"&pas="+et_password.getText().toString();
                //Toast.makeText(Login.this, url, Toast.LENGTH_SHORT).show();//para mostrar de que los datos se introjeron correctamente y solo para testeo
                new Login.ValidarDatos().execute(url);

            }
        });

        btn_crear_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Crear_Cuenta.class);
                startActivity(intent);
            }
        });

        tv_olvido_contrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


    private class ValidarDatos extends AsyncTask<String, Void, String> {
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
            JSONArray ja=null;

            try {
                ja=new JSONArray(result);
                Toast.makeText(getApplicationContext(),"Bienvenido "+ja.getString(0), Toast.LENGTH_SHORT).show();//para mostrar contenido del JSON para pruebas
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();//para mostrar contenido del JSON para pruebas
            }

        }
    }//fin de CargarDatos


}
