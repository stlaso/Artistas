package com.example.final1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.final1.Metodos.Album.Album_Metodos;
import com.example.final1.Metodos.Artista.Artista_Metodos;
import com.example.final1.Metodos.Cancion.Cancion_Metodos;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button Artista;
    Button Album;
    Button Cancion;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        Artista=findViewById(R.id.Artista);
        Album=findViewById(R.id.Album);
        Cancion=findViewById(R.id.Cancion);

        Artista.setOnClickListener(this);
        Album.setOnClickListener(this);
        Cancion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==Artista.getId())
        {
            Intent pantalla1=new Intent(this,Artista_Metodos.class);
            startActivity(pantalla1);
        }
        if (v.getId()==Album.getId())
        {
            Intent pantalla2=new Intent(this, Album_Metodos.class);
            startActivity(pantalla2);
        }
        if (v.getId()==Cancion.getId())
        {
            Intent pantalla3=new Intent(this, Cancion_Metodos.class);
            startActivity(pantalla3);
        }
    }
}