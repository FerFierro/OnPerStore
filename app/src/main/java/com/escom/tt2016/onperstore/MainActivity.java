package com.escom.tt2016.onperstore;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText et_id,et_categoria,et_nombre,et_descripcion,et_cantidad_articulos,et_precio;
    Button btn_guardar,btn_consultar,btn_eliminar;
    Metodos metodos=new Metodos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id=                  (EditText) findViewById(R.id.et_id);
        et_categoria=           (EditText) findViewById(R.id.et_categoria);
        et_nombre=              (EditText) findViewById(R.id.et_nombre);
        et_descripcion=         (EditText) findViewById(R.id.et_descripcion);
        et_cantidad_articulos=  (EditText) findViewById(R.id.et_cantidad_disponible);
        et_precio=              (EditText) findViewById(R.id.et_precio);
        btn_guardar=            (Button) findViewById(R.id.btn_guardar);
        btn_consultar=          (Button) findViewById(R.id.btn_consultar);
        btn_eliminar=          (Button) findViewById(R.id.btn_eliminar);


        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url="http://192.168.0.3/WebService/28/insertar_articulo.php?cat=";
                url=url + et_categoria.getText().toString();
                url=url+"&name="+et_nombre.getText().toString();
                url=url+"&des="+et_descripcion.getText().toString();
                url=url+"&cant="+et_cantidad_articulos.getText().toString();
                url=url+"&pre="+et_precio.getText().toString();
               // Toast.makeText(MainActivity.this, url, Toast.LENGTH_SHORT).show();//para mostrar de que los datos se introjeron correctamente y solo para testeo
                new CargarDatos().execute(url);
            }
        });

        btn_consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url="http://192.168.0.3/WebService/28/consultar_articulo.php?id="+et_id.getText().toString();
                //Toast.makeText(MainActivity.this, url, Toast.LENGTH_SHORT).show();//para mostrar de que los datos se introjeron correctamente y solo para testeo
                new ConsultarDatos().execute(url);

            }
        });

        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="http://192.168.0.3/WebService/28/Eliminar_Articulo.php?id="+et_id.getText().toString();
                //Toast.makeText(MainActivity.this, url, Toast.LENGTH_SHORT).show();//para mostrar de que los datos se introjeron correctamente y solo para testeo
                new EliminarDatos().execute(url);
            }
        });

    }//Fin de onCreate


    // Utiliza AsyncTask para crear una tarea fuera del subproceso principal de la interfaz de usuario. Esta tarea
    // URL y lo usa para crear una HttpUrlConnection. Una vez que la conexión
    // se ha establecido, el AsyncTask descarga el contenido de la página web como
    // un InputStream. Por último, el InputStream se convierte en una cadena, que es
    // se muestra en la interfaz de usuario mediante el método onPostExecute de AsyncTask.

    private class CargarDatos extends AsyncTask<String, Void, String> {
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
            Toast.makeText(getApplicationContext(), "Se almacenaron los datos correctamente", Toast.LENGTH_SHORT).show();

            et_id.setText("");
            et_categoria.setText("");
            et_nombre.setText("");
            et_descripcion.setText("");
            et_cantidad_articulos.setText("");
            et_precio.setText("");

        }
    }//fin de CargarDatos


    private class ConsultarDatos extends AsyncTask<String, Void, String> {
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
            //Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();//para mostrar contenido del JSON para pruebas

            try {
                ja=new JSONArray(result);

                et_categoria.setText(ja.getString(1));
                et_nombre.setText(ja.getString(2));
                et_descripcion.setText(ja.getString(3));
                et_cantidad_articulos.setText(ja.getString(4));
                et_precio.setText(ja.getString(5));
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }//Fin de ConsultarDatos


    private class EliminarDatos extends AsyncTask<String, Void, String> {
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
            Toast.makeText(getApplicationContext(), "Se eliminaron los datos correctamente", Toast.LENGTH_SHORT).show();

            et_id.setText("");
            et_categoria.setText("");
            et_nombre.setText("");
            et_descripcion.setText("");
            et_cantidad_articulos.setText("");
            et_precio.setText("");

        }
    }//fin de CargarDatos


}//Fin de MainActivity
