package com.sofiavanessa.dasix.models;

import android.content.Context;

import com.sofiavanessa.dasix.conexion.BdOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class productos {
    private int id;
    private String nombre;
    private String descripcion;

    public productos() {
    }

    public productos(Context miContexto, int id) {
        String cadenaSql="select * from productos where id="+id;
        String [][] miproducto= BdOpenHelper.consultaConRetorno(miContexto, cadenaSql);

        if(miproducto !=null && miproducto.length> 0) {
            this.id = id;
            nombre=miproducto[0][1];
            descripcion=miproducto[0][2];
        }
    }
    @Override
    public String toString(){
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public static String[][] listarproductos(Context context,String filtro, String orden){
        String miCadenaSql="select * from productos";
        if(filtro !=null) miCadenaSql +=" where "+filtro;
        if(orden !=null) miCadenaSql +=" order by "+orden;
        return BdOpenHelper.consultaConRetorno(context, miCadenaSql);
    }
    public static List<productos> listarproductossObj(Context context, String filtro, String orden){
        String[][] datosMarcas=productos.listarproductos(context,filtro,orden);
        List<productos> productosList=new ArrayList<>();
        if(datosMarcas !=null){
            // Recorrer los datos
            for(int contador=0; contador < datosMarcas.length; contador++){
                productos miObjetoproductos=new productos();
                miObjetoproductos.id= Integer.parseInt(datosMarcas[contador][0]);
                miObjetoproductos.nombre=datosMarcas[contador][1];
                miObjetoproductos.descripcion=datosMarcas[contador][2];
                productosList.add( miObjetoproductos);
            }
        }
        return productosList;
    }
    // Eliminar una marca
    public void eliminar(Context context) {
        List<productos> listproductos = productos.listarproductossObj(context,"idMarca="+id,null);
        if ((long)listproductos.size()>0){
            for (int i =0;i<(long) listproductos.size();i++){
                listproductos.get(i).eliminar(context);
            }
        }
        String cadenaSql = "delete from productos where id=" + id;
        BdOpenHelper.consultaSinRetorno(context, cadenaSql);
    }
}
