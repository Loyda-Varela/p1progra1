package com.example.p1programa;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.p1programa.configuraciones.SQLiteConexion;
import com.example.p1programa.configuraciones.transacciones;
import com.example.p1programa.tablas.Empleados;

import java.util.ArrayList;

public class ActivityCombo extends AppCompatActivity {
    //variables glovalles
    SQLiteConexion conexion;
    Spinner spempleados;
    EditText acnombre, acapellido, acedad,accorreo;
    ArrayList<String> lista_empleados;
    ArrayList<Empleados> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo);
        //levantar l conexion
        conexion = new SQLiteConexion( this, transacciones.NameDatabase, null, 1);
        //referenciar el spinner
        spempleados = (Spinner) findViewById(R.id.spempleados);
        acnombre = (EditText) findViewById(R.id.actxtnombre);
        acapellido = (EditText) findViewById(R.id.actxtapellido);
        acedad = (EditText) findViewById(R.id.sctxtedad);
        accorreo = (EditText) findViewById(R.id.actxtcorreo);
        //obtener lista de emleados
        ObtenerListaEmpleados();

        //despues del final hacer lo siguiente
        //obtener la lista de empleados
        ArrayAdapter<CharSequence> adp = new ArrayAdapter(this, android.R.layout.simple_spinner_item,lista_empleados);
        spempleados.setAdapter(adp);
        /////////////////////////////
        // obtener dato especifico de la base de datos
        spempleados.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                acnombre.setText(lista.get(i).getNombre());
                acapellido.setText(lista.get(i).getApellido());

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void ObtenerListaEmpleados() {

        ///////
        Empleados emple = null;
        lista = new ArrayList<Empleados>();
        //////
        //la base es de dao lectura
        SQLiteDatabase db = conexion.getReadableDatabase();
        //levantar conexion
        Cursor cursor = db.rawQuery("SELECT * FROM " + transacciones.tablaempleados, null);
        //movernos en el cursor al siguiente elemento
        while (cursor.moveToNext()){
            //referenciamos emple null
            emple = new Empleados();
            emple.setId(cursor.getInt(0));
            emple.setNombre(cursor.getString(1));
            emple.setApellido(cursor.getString(2));
            emple.setEdad(cursor.getInt(3));
            emple.setCorreo(cursor.getString(4));

            //arreglo de lista empleado agregar empleado
            lista.add(emple);
        }
        //cerrar rl cursor
        cursor.close();
        
        //llenar el combo
        fillCombo();
    }

    private void fillCombo() {
        lista_empleados = new ArrayList<String>();

        for (int i= 0; i < lista.size(); i++){
            lista_empleados.add(lista.get(1).getId() + " | " +
                    lista.get(1).getNombre() + " | " +
                    lista.get(1).getApellido());
        }
    }
}