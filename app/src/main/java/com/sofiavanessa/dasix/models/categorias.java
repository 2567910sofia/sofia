package com.sofiavanessa.dasix.models;

import android.content.Context;

import com.sofiavanessa.dasix.conexion.BdOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class categorias {
    private int id;
    private String nombre;

    //METODOS - FUNCIONES - ACCIONES

    //Constructor vacio
    public categorias() {
    }

    //Constructor con parametros
    //Me servira para construir un objeto tipo Marca con el id
    public categorias(Context miContexto, int id) {
        String cadenaSql="select * from categoria where id="+id;
        String [][] micategoria= BdOpenHelper.consultaConRetorno(miContexto, cadenaSql);

        if(micategoria !=null && micategoria.length> 0) {
            this.id = id;
            nombre=micategoria[0][1];

        }
    }
    @Override
    public String toString(){
        return id +" "+nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    //CRUD - metodos
    // Listar
    public static String[][] listarcategoria(Context context,String filtro, String orden){
        String miCadenaSql="select * from categoria";
        if(filtro !=null) miCadenaSql +=" where "+filtro;
        if(orden !=null) miCadenaSql +=" order by "+orden;
        return BdOpenHelper.consultaConRetorno(context, miCadenaSql);
    }
    public static List<categorias> listarArticuloObj(Context context, String filtro, String orden){
        String[][] datoscategoria=categorias.listarcategoria(context,filtro,orden);
        List<categorias> articulosList=new ArrayList<>();
        if(datoscategoria !=null){
            // Recorrer los datos
            for(int contador=0; contador < datoscategoria.length; contador++){
                categorias miObjetocategoria=new categorias();
                miObjetocategoria.id= Integer.parseInt(datoscategoria[contador][0]);
                miObjetocategoria.nombre=datoscategoria[contador][1];
                articulosList.add(miObjetocategoria);
            }
        }
        return articulosList;
    }

    public void modificar(Context context){
        String cadenaSql="update categoria set nombre='"+ nombre;
        BdOpenHelper.consultaSinRetorno(context, cadenaSql);
    }
    public void eliminar(Context context){
        String cadenaSql="delete from categoria where id="+id;
        BdOpenHelper.consultaSinRetorno(context, cadenaSql);
    }
}


