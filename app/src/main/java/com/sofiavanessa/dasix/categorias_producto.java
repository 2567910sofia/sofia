package com.sofiavanessa.dasix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

        String[]categoriasList={"cereales","carnes","bebidas","enlatados","aseo"};
        ArrayAdapter<String>categoria=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,categoriasList);
        categorias.setAdapter(categoria);


        String[] productoslist={"arroz","pesacado","agua en botella","sardina","jabon de baño"};
        ArrayAdapter<String>producto=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, productoslist);
        productos.setAdapter(producto);


        
        
       
    }

}
