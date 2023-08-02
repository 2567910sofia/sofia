package com.sofiavanessa.dasix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activityingresar extends AppCompatActivity {

    Button btnlogin;
    EditText TEXcontraseña;
    EditText TEXnombre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityingresar);
        btnlogin=findViewById(R.id.btnlogin);
        TEXnombre=findViewById(R.id.TEXnombre);
        TEXcontraseña=findViewById(R.id.TEXcontraseña);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre=TEXnombre.getText().toString();
                String contraseña=TEXcontraseña.getText().toString();
                guardarInformaciondeusuario(TEXnombre,TEXcontraseña);

                if (nombre.isEmpty() ||contraseña.isEmpty() ){
                    if (nombre.isEmpty()){
                        TEXnombre.setError("DEBES DE INGRESAR TU NOMBRE");
                    }
                    if (contraseña.isEmpty()){
                        TEXcontraseña.setError("CONTRASEÑA INCORRECTA");
                    }
                }else {
                    Intent intentovalores =getIntent();
                    String accion =intentovalores.getStringExtra("accion");
                }

            };

            private void guardarInformaciondeusuario(EditText teXnombre, EditText teXcontraseña) {
                SharedPreferences sharedPreferences = null;
                sharedPreferences =sharedPreferences;
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("usuario", String.valueOf(teXnombre));
                editor.putString("contraseña", String.valueOf(teXcontraseña));
                editor.putBoolean("secciion_iniciada", true);

                editor.apply();
            }
        });
    }
}