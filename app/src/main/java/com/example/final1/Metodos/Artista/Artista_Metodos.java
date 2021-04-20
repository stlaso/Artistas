package com.example.final1.Metodos.Artista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.final1.DaoGenerico.EntornoDeDatos;
import com.example.final1.Entidades.Artista.Artista;
import com.example.final1.Entidades.Artista.ArtistaDao;
import com.example.final1.R;

public class Artista_Metodos extends AppCompatActivity implements View.OnClickListener
{
    Button Artista_Alta;
    Button Artista_Modificar;
    Button Artista_Borrar;
    Button Artista_Mostrar;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artista_metodos);
        Artista_Alta=findViewById(R.id.Artista_Alta);
        Artista_Modificar=findViewById(R.id.Artista_Modificar);
        Artista_Borrar=findViewById(R.id.Artista_Borrar);
        Artista_Mostrar=findViewById(R.id.Artista_Mostrar);

        Artista_Alta.setOnClickListener(this);
        Artista_Modificar.setOnClickListener(this);
        Artista_Borrar.setOnClickListener(this);
        Artista_Mostrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if (v.getId()==Artista_Alta.getId())
        {
            Intent Intencion1=new Intent(this, ArtistaAlta.class);
            startActivity(Intencion1);
        }

        if (v.getId()==Artista_Modificar.getId())
        {
            ArtistaDao MyArtistaDao=new ArtistaDao(this);
            EntornoDeDatos.ListaArtista=MyArtistaDao.getAll("Select * FROM Artista");

            Intent Intencion2=new Intent(this,ArtistaModificar.class);
            startActivity(Intencion2);

        }

        if (v.getId()==Artista_Borrar.getId())
        {
            ArtistaDao MyArtistaDao=new ArtistaDao(this);
            EntornoDeDatos.ListaArtista=MyArtistaDao.getAll("Select * FROM Artista");

            Intent Intencion3=new Intent(this,Artista_Borrar.class);
            startActivity(Intencion3);
        }
        if (v.getId()==Artista_Mostrar.getId())
        {
            ArtistaDao MyArtistaDao=new ArtistaDao(this);
            EntornoDeDatos.ListaArtista=MyArtistaDao.getAll("Select * FROM Artista");

            Intent Intencion4=new Intent(this,Artista_Mostrar.class);
            startActivity(Intencion4);
        }
    }
}
