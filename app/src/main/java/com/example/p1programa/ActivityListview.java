package com.example.p1programa;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.p1programa.configuraciones.SQLiteConexion;
import com.example.p1programa.configuraciones.transacciones;
import com.example.p1programa.tablas.Empleados;

import java.util.ArrayList;

public class ActivityListview extends AppCompatActivity {
    //declarar variables globales
    SQLiteConexion conexion;
    //declara listview
    ListView lista;
    ArrayList<Empleados> listaempleados;
    ArrayList<String> ArregloEmpleados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        //inicializar variable de conexion
        conexion = new SQLiteConexion(this, transacciones.NameDatabase, null, 1);
        //castear el objeto
        lista = (ListView) findViewById(R.id.lista);
        //obtenemos la lista
        obtenerListaEmpleados();
        //////////llamar
        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ArregloEmpleados);
        lista.setAdapter(adp);
        //////////

    }
// funcion para obtener la lista de empleados
    private void obtenerListaEmpleados() {
        //modo lectura
        SQLiteDatabase db = conexion.getReadableDatabase();
        Empleados list_emple = null;
        //inicializar
        listaempleados = new ArrayList<Empleados>();
        //consulta directa
        Cursor cursor = db.rawQuery("SELECT * FROM " + transacciones.tablaempleados, null);
       //setear columnas por medio arreglo
        while(cursor.moveToNext()){
            list_emple = new Empleados();
            list_emple.setId(cursor.getInt(0));
            list_emple.setNombre(cursor.getString(1));
            list_emple.setApellido(cursor.getString(2));
            list_emple.setEdad(cursor.getInt(3));
            list_emple.setCorreo(cursor.getString(4));

            //agregar la lista
            listaempleados.add(list_emple);
        }

        //cerrar cursor para que no quede en memoria
        cursor.close();
        //funion para llenar lista
        llenarlista();
    }

    private void llenarlista() {
        ArregloEmpleados = new ArrayList<String>();
        //empesamos a concatenar
        for(int i=0; i<listaempleados.size(); i++){
            //concatenar
            ArregloEmpleados.add(listaempleados.get(i).getId() +"|"+
                    listaempleados.get(i).getNombre() +" | "+
                    listaempleados.get(i).getApellido());

        }
    }

}