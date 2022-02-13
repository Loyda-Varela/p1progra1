package com.example.p1programa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//importamos la clase del boton
public class MainActivity extends AppCompatActivity {
    Button btnagregar, btnpasar;
    EditText txtnombre;
    EditText txtapellido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //contiene todos los objetos que necesita para programar
        setContentView(R.layout.activity_main);
    //castear:convertir un objeto de un tipo de dato a otro tpo de dato

        btnagregar=(Button) findViewById(R.id.btnagregar);
        btnpasar=(Button) findViewById(R.id.btnpasar);
        txtnombre=(EditText) findViewById(R.id.txtnombre);
        txtapellido=(EditText) findViewById(R.id.txtapellido);

        //evento de escuchar
        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text;
                Toast.makeText(getApplicationContext(), text= "BIENVENIDO" + txtnombre.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
        btnpasar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //declarar un intem
                //pasa datos
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}