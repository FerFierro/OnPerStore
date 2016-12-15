package com.escom.tt2016.onperstore;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Angel on 15/12/2016.
 */

public class Metodos {


    //Este metodo recoge la url que ingresemos
    public String downloadUrl(String myurl) throws IOException {
        Log.i("URL",""+myurl);
        myurl=myurl.replace(" ","%20");
        InputStream is = null;
        // Mostrar los primeros 500 caracteres
        // contenido de la pagina web
        int len = 500;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Inicia la consulta
            conn.connect();
            int response = conn.getResponseCode();//crea un codigo de respuesta en este caso 200 si tuvo exito
            Log.d("Respuesta", "The response is: " + response);
            is = conn.getInputStream();

            // Convierte el InputStream en una cadena
            String contentAsString = readIt(is,len);
            return contentAsString;

            // Se asegura de que el InputStream esté cerrado después de que la aplicación esté
            // terminó de usarlo
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }


    // Lee un InputStream y lo convierte en String.
    public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }
}
