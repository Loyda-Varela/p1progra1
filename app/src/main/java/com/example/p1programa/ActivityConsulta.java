package com.example.p1programa;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.p1programa.configuraciones.SQLiteConexion;
import com.example.p1programa.configuraciones.transacciones;

public class ActivityConsulta extends AppCompatActivity {
    //levantar la conexion
    SQLiteConexion conexion;
    EditText id, nombre, apellido, edad, correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        //levatar la conexion

        conexion = new SQLiteConexion( this, transacciones.NameDatabase, null, 1);
        //buscar con el boton cnsulta

        Button btnconsulta = (Button) findViewById(R.id.btnconsulta);

        id = (EditText)findViewById(R.id.codigofind);
        nombre = (EditText) findViewById(R.id.txtnom);
        apellido = (EditText) findViewById(R.id.txtape);
        edad = (EditText) findViewById(R.id.txtage);
        correo = (EditText) findViewById(R.id.txtemail);

        //crear el listener de consulta
        btnconsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //crear funcin buscar
                Buscar();
            }
        });
    }

    private void Buscar() {
        SQLiteDatabase db = conexion.getWritableDatabase();
        //parametros de consulta para sentencia select
        String [] params = {id.getText().toString()};
        String [] fields = {transacciones.nombre,
                            transacciones.apellido,
                            transacciones.edad,
                            transacciones.correo};

        //crear el werw condichion
         String whereCondition = transacciones.id + "=?";

        try {
        //cursor para recorrer registro de la base de datos
            Cursor cdata = db.query(transacciones.tablaempleados, fields, whereCondition,params, null, null, null);
            //que se mueva el cursor
            cdata.moveToFirst();

            //llenar campos
            nombre.setText(cdata.getString(0));
            apellido.setText(cdata.getString(1));
            edad.setText(cdata.getString(2));
            correo.setText(cdata.getString(3));

            String text;
            Toast.makeText(getApplicationContext(), text= "Consulta con Exito", Toast.LENGTH_LONG).show();

        }
        catch (Exception ex){
            String text;
            Toast.makeText(getApplicationContext(), text= "Elemento no Encontrado", Toast.LENGTH_LONG).show();
        }
    }
}