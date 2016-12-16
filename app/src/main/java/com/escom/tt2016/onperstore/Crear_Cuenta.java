package com.escom.tt2016.onperstore;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import java.io.IOException;
import java.util.regex.Pattern;


public class Crear_Cuenta extends AppCompatActivity {

    EditText et_crear_cuenta_usuario,
             et_crear_cuenta_nombre,
             et_crear_cuenta_ap,
             et_crear_cuenta_am,
             et_crear_cuenta_telefono,
             et_crear_cuenta_direccion,
             et_crear_cuenta_email,
             et_crear_cuenta_password;

    private TextInputLayout til_crear_cuenta_usuario,
            til_crear_cuenta_nombre,
            til_crear_cuenta_ap,
            til_crear_cuenta_am,
            til_crear_cuenta_telefono,
            til_crear_cuenta_direccion,
            til_crear_cuenta_email,
            til_crear_cuenta_password;

    Button btn_registrar_usuario;
    Metodos metodos=new Metodos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        // Referencias TILs
        til_crear_cuenta_usuario =        (TextInputLayout) findViewById(R.id.til_crear_cuenta_usuario);
        til_crear_cuenta_nombre =         (TextInputLayout) findViewById(R.id.til_crear_cuenta_nombre);
        til_crear_cuenta_ap =             (TextInputLayout) findViewById(R.id.til_crear_cuenta_ap);
        til_crear_cuenta_am =             (TextInputLayout) findViewById(R.id.til_crear_cuenta_am);
        til_crear_cuenta_telefono =       (TextInputLayout) findViewById(R.id.til_crear_cuenta_telefono);
        til_crear_cuenta_direccion =      (TextInputLayout) findViewById(R.id.til_crear_cuenta_direccion);
        til_crear_cuenta_email =          (TextInputLayout) findViewById(R.id.til_crear_cuenta_email);
        til_crear_cuenta_password =       (TextInputLayout) findViewById(R.id.til_crear_cuenta_password);

        // Referencias ETs
        et_crear_cuenta_usuario=         (EditText) findViewById(R.id.et_crear_cuenta_usuario);
        et_crear_cuenta_nombre=          (EditText) findViewById(R.id.et_crear_cuenta_nombre);
        et_crear_cuenta_ap=              (EditText) findViewById(R.id.et_crear_cuenta_ap);
        et_crear_cuenta_am=              (EditText) findViewById(R.id.et_crear_cuenta_am);
        et_crear_cuenta_telefono=        (EditText) findViewById(R.id.et_crear_cuenta_telefono);
        et_crear_cuenta_direccion=       (EditText) findViewById(R.id.et_crear_cuenta_direccion);
        et_crear_cuenta_email=           (EditText) findViewById(R.id.et_crear_cuenta_email);
        et_crear_cuenta_password=        (EditText) findViewById(R.id.et_crear_cuenta_password);

        // Referencias btn
        btn_registrar_usuario=           (Button)   findViewById(R.id.btn_registrar_usuario);

        et_crear_cuenta_usuario.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                til_crear_cuenta_usuario.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_crear_cuenta_nombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                til_crear_cuenta_nombre.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        et_crear_cuenta_ap.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                til_crear_cuenta_ap.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_crear_cuenta_am.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                til_crear_cuenta_am.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_crear_cuenta_telefono.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                til_crear_cuenta_telefono.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_crear_cuenta_direccion.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                til_crear_cuenta_direccion.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_crear_cuenta_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                esCorreoValido(String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_crear_cuenta_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                til_crear_cuenta_password.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        btn_registrar_usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ValidarDatos();
            }
        });


    }//Fin de onCreate


    private void ValidarDatos() {
        String usuario =           til_crear_cuenta_usuario.getEditText()      .getText().toString();
        String nombre =            til_crear_cuenta_nombre.getEditText()       .getText().toString();
        String ap =                til_crear_cuenta_ap.getEditText()           .getText().toString();
        String am =                til_crear_cuenta_am.getEditText()           .getText().toString();
        String telefono =          til_crear_cuenta_telefono.getEditText()     .getText().toString();
        String direccion =         til_crear_cuenta_direccion.getEditText()    .getText().toString();
        String email =             til_crear_cuenta_email.getEditText()        .getText().toString();
        String password =          til_crear_cuenta_password.getEditText()     .getText().toString();

        boolean a = esUsuarioValido(usuario);
        boolean b = esNombreValido(nombre);
        boolean c = esApellidoPaternoValido(ap);
        boolean d = esApellidoMaternoValido(am);
        boolean e = esTelefonoValido(telefono);
        boolean f = esDireccionValido(direccion);
        boolean g = esCorreoValido(email);



        if (a && b && c && d && e && f && g) {
            // OK, se pasa a la siguiente acción
            String url="http://192.168.0.3/WebService/28/Crear_cuenta.php?usu=";
                   url=      url            +et_crear_cuenta_usuario.getText().toString();
                   url=      url+"&name="   +et_crear_cuenta_nombre.getText().toString();
                   url=      url+"&ap="     +et_crear_cuenta_ap.getText().toString();
                   url=      url+"&am="     +et_crear_cuenta_am.getText().toString();
                   url=      url+"&tel="    +et_crear_cuenta_telefono.getText().toString();
                   url=      url+"&dir="    +et_crear_cuenta_direccion.getText().toString();
                   url=      url+"&email="  +et_crear_cuenta_email.getText().toString();
                   url=      url+"&pas="    +et_crear_cuenta_password.getText().toString();
                //Toast.makeText(Login.this, url, Toast.LENGTH_SHORT).show();//para mostrar de que los datos se introjeron correctamente y solo para testeo
                new Crear_Cuenta.RegistrarDatosUsuario().execute(url);
        }

    }


    private boolean esUsuarioValido(String usuario) {
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        if (!patron.matcher(usuario).matches() || usuario.length() >15) {
            til_crear_cuenta_usuario.setError("Usuario inválido");
            return false;
        } else {
            til_crear_cuenta_usuario.setError(null);
        }

        return true;
    }

    private boolean esNombreValido(String nombre) {
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        if (!patron.matcher(nombre).matches() || nombre.length() > 30) {
            til_crear_cuenta_nombre.setError("Nombre inválido");
            return false;
        } else {
            til_crear_cuenta_nombre.setError(null);
        }

        return true;
    }


    private boolean esApellidoPaternoValido(String ap) {
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        if (!patron.matcher(ap).matches() || ap.length() > 30) {
            til_crear_cuenta_ap.setError("Apellido Paterno inválido");
            return false;
        } else {
            til_crear_cuenta_ap.setError(null);
        }

        return true;
    }


    private boolean esApellidoMaternoValido(String am) {
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        if (!patron.matcher(am).matches() || am.length() > 30) {
            til_crear_cuenta_am.setError("Apellido Materno inválido");
            return false;
        } else {
            til_crear_cuenta_am.setError(null);
        }

        return true;
    }


    private boolean esTelefonoValido(String telefono) {
        if (!Patterns.PHONE.matcher(telefono).matches() || telefono.length() > 10) {
            til_crear_cuenta_telefono.setError("Teléfono inválido");
            return false;
        } else {
            til_crear_cuenta_telefono.setError(null);
        }

        return true;
    }


    private boolean esDireccionValido(String direccion) {
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        if (!patron.matcher(direccion).matches() || direccion.length() > 100) {
            til_crear_cuenta_direccion.setError("Dirección invalida");
            return false;
        } else {
            til_crear_cuenta_direccion.setError(null);
        }

        return true;
    }


    private boolean esCorreoValido(String correo) {
        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            til_crear_cuenta_email.setError("Correo electrónico inválido");
            return false;
        } else {
            til_crear_cuenta_email.setError(null);
        }

        return true;
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




}//Fin de Crear_Cuenta
