package com.example.p1programa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ActivityPhoto extends AppCompatActivity {
    //variables globales
    ImageView objimagen;
    Button btn;
    String CurrentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        //castear el objeto de imagen
        objimagen = (ImageView) findViewById(R.id.fotografia);
        //castear el objeto del boton
        btn = (Button) findViewById(R.id.btnimagen);

        //bsetonclic listener de escuchar
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //crear permisos
                permisos();

            }
        });
    }

    private void permisos() {
        //permisos para obtener fotografia

    }
}