package com.sofiavanessa.dasix.conexion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BdOpenHelper extends SQLiteOpenHelper {
    static  String bdNombre="categorias";
    static  int bdVersion=1;


    public BdOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String cadenaSql="create table categorias (id integer primary key autoincrement, nombre text)";
        sqLiteDatabase.execSQL(cadenaSql);

        cadenaSql="create table productos  (id integer primary key autoincrement, nombre text, descripcion text)";
        sqLiteDatabase.execSQL(cadenaSql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String cadenaSql="drop table if exists categorias";
        sqLiteDatabase.execSQL(cadenaSql);
        cadenaSql="drop table if exists productos";
        sqLiteDatabase.execSQL(cadenaSql);
        onCreate(sqLiteDatabase);
    }
    public static void consultaSinRetorno(Context context, String cadenaSql){
        // update, delete, insert
        BdOpenHelper miConector=new BdOpenHelper(context,bdNombre,null,bdVersion);
        SQLiteDatabase miBd=miConector.getWritableDatabase();
        miBd.execSQL(cadenaSql);
        miBd.close();
        miConector.close();
    }
    public static String[][] consultaConRetorno(Context context,String cadenaSql){
        // select
        String [][] datos=null;
        BdOpenHelper miConector=new BdOpenHelper(context,bdNombre, null,bdVersion);
        SQLiteDatabase miBd=miConector.getReadableDatabase();
        Cursor miCursor= miBd.rawQuery(cadenaSql, null);
        //CONTAR FILAS Y COLUMNAS
        int filas=miCursor.getCount();
        int columnas=miCursor.getColumnCount();

        //DOY LONGITUD A LA MATRIZ

        datos=new String[filas][columnas];
        int contadorFila=0;
        while (miCursor.moveToNext()){ //verdadero si tiene almenos una fila
            // recorrer las columnas de cada fila
            for (int contadorCol=0; contadorCol< columnas; contadorCol++){
                //ASIGNAMOS EL VALOR DE LA TABLA A CADA POSICION
                datos[contadorFila][contadorCol]=miCursor.getString(contadorCol);
            }
            contadorFila++;
        }
        return datos;
    }


}
