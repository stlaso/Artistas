package com.example.final1.Metodos.Album;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.final1.DaoGenerico.EntornoDeDatos;
import com.example.final1.Entidades.Album.AlbumDao;
import com.example.final1.Entidades.Artista.ArtistaDao;
import com.example.final1.Metodos.Artista.ArtistaModificar;
import com.example.final1.R;

public class Album_Metodos extends AppCompatActivity implements View.OnClickListener
{

    Button Album_alta;
    Button Album_Modificar;
    Button Album_Borrar;
    Button Album_Mostrar;
    Button Album_Mostrar_Todo;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_metodos);
        Album_alta=findViewById(R.id.Album_alta);
        Album_Modificar=findViewById(R.id.Album_Modificar);
        Album_Borrar=findViewById(R.id.Album_Borrar);
        Album_Mostrar=findViewById(R.id.Album_Mostrar);
        Album_Mostrar_Todo=findViewById(R.id.Album_Mostrar_Todo);

        Album_alta.setOnClickListener(this);
        Album_Modificar.setOnClickListener(this);
        Album_Borrar.setOnClickListener(this);
        Album_Mostrar.setOnClickListener(this);
        Album_Mostrar_Todo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if (v.getId()==Album_alta.getId())
        {
            Intent iniciar1=new Intent(this,Album_Alta.class);
            startActivity(iniciar1);

        }

        if (v.getId()==Album_Modificar.getId())
        {
            AlbumDao MyAlbumDao=new AlbumDao(this);
            EntornoDeDatos.ListaAlbum=MyAlbumDao.getAll("Select * FROM Album");

            Intent Intencion2=new Intent(this, Album_Modificar.class);
            startActivity(Intencion2);

        }

        if (v.getId()==Album_Borrar.getId())
        {
            AlbumDao MyAlbumDao=new AlbumDao(this);
            EntornoDeDatos.ListaAlbum=MyAlbumDao.getAll("Select * FROM Album");

            Intent Intencion3=new Intent(this, Album_Borrar.class);
            startActivity(Intencion3);

        }

        if (v.getId()==Album_Mostrar.getId())
        {
            AlbumDao MyAlbumDao=new AlbumDao(this);
            EntornoDeDatos.ListaAlbum=MyAlbumDao.getAll("Select * FROM Album");

            Intent Intencion4=new Intent(this, Album_Mostrar.class);
            startActivity(Intencion4);

        }

        if (v.getId()==Album_Mostrar_Todo.getId())
        {

            AlbumDao MyAlbumDao=new AlbumDao(this);
            EntornoDeDatos.ListaAlbumExtendido=MyAlbumDao.getJoinAll("Select * FROM Album Inner join Artista on Album.ArtistaPK=Artista.ArtistaPK");

            Intent Intencion5=new Intent(this, Album_Mostrar_Todo.class);
            startActivity(Intencion5);

        }

    }
}
