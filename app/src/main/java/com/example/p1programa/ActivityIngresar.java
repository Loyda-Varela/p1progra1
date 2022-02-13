package com.example.p1programa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.p1programa.configuraciones.SQLiteConexion;
import com.example.p1programa.configuraciones.transacciones;

public class ActivityIngresar extends AppCompatActivity {
    EditText nombre, apellido, edad, correo;
    Button btnadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        nombre = (EditText) findViewById(R.id.txtnombre);
        apellido = (EditText) findViewById(R.id.txtapellidos);
        edad = (EditText) findViewById(R.id.txtedad);
        correo = (EditText) findViewById(R.id.txtcorreo);

        //evento del boton
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarPersonas();
            }
        });

    }

    private void AgregarPersonas() {
        SQLiteConexion conexion = new SQLiteConexion(this, transacciones.NameDatabase, null, 1);
        //modo sobrelectura
        SQLiteDatabase db = conexion.getWritableDatabase();
        //valores para pasar parametros
        ContentValues valores = new ContentValues();
        //
        valores.put(transacciones.nombre, nombre.getText().toString());
        valores.put(transacciones.apellido, apellido.getText().toString());
        valores.put(transacciones.edad, edad.getText().toString());
        valores.put(transacciones.correo, correo.getText().toString());

        //insertat los resultados en la base de datos
        Long resultado =db.insert(transacciones.tablaempleados, transacciones.id, valores);
        //pasar en un toast los resultados
        String text;
        Toast.makeText(getApplicationContext(), text = "Registro Ingresado con Exito" + resultado.toString(),
                Toast.LENGTH_LONG).show();
        //cerrar la conexion con la base de datos
        db.close();
        //limpiar pantalla
        LipiarPantalla();
    }

    private void LipiarPantalla() {
        nombre.setText("");
        apellido.setText("");
        edad.setText("");
        correo.setText("");
    }
}