package com.sofiavanessa.dasix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class categorias_producto extends AppCompatActivity {

     Spinner categorias;
     Spinner productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias_producto);
        categorias=findViewById(R.id.categorias);
        productos=findViewById(R.id.productos);


        String[]categorias={"cereales","carnes","bebidas","enlatados"};


        /*
        listacategoria=new ArrayList<>();
        listacategoria=(new categoria("cereales"));
        listacategoria=(new categoria("carnes"));
        listacategoria=(new categoria("productos de aseo"));
        
        listaproducto=(new productos("arroz,5000"));
        listaproducto=(new productos("pollo,4500"));
        listaproducto=(new productos("crema dental"));


         */

/*
        ArrayAdapter<categoria>categoriasArrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,);
        categoriasArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorias.setAdapter(categoriasArrayAdapter);





        categorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


 */
            }







    }
