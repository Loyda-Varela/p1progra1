package com.example.p1programa.configuraciones;
//declarar y mportar paquetes
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteConexion extends SQLiteOpenHelper {

    public SQLiteConexion(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //ejecutar comanando
    //crear todas las tablas de la clase transacciones
        sqLiteDatabase.execSQL(transacciones.CreateTableEmpleados);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

       sqLiteDatabase.execSQL(transacciones.DropTableEmpleados);
        onCreate(sqLiteDatabase);
    }
}
