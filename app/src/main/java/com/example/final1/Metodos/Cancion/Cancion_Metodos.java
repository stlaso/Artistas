package com.example.final1.Metodos.Cancion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.final1.DaoGenerico.EntornoDeDatos;
import com.example.final1.Entidades.Album.AlbumDao;
import com.example.final1.Entidades.Cancion.CancionDao;
import com.example.final1.Metodos.Album.Album_Borrar;
import com.example.final1.R;

public class Cancion_Metodos extends AppCompatActivity implements View.OnClickListener
{
    Button Cancion_alta;
    Button Cancion_Modificar;
    Button Cancion_Borrar;
    Button Cancion_Mostrar;
    Button Cancion_Mostrar_Todo;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancion_metodos);
        Cancion_alta=findViewById(R.id.Cancion_alta);
        Cancion_Modificar=findViewById(R.id.Cancion_Modificar);
        Cancion_Borrar=findViewById(R.id.Cancion_Borrar);
        Cancion_Mostrar=findViewById(R.id.Cancion_Mostrar);
        Cancion_Mostrar_Todo=findViewById(R.id.Cancion_Mostrar_Todo);

        Cancion_alta.setOnClickListener(this);
        Cancion_Modificar.setOnClickListener(this);
        Cancion_Borrar.setOnClickListener(this);
        Cancion_Mostrar.setOnClickListener(this);
        Cancion_Mostrar_Todo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if (v.getId()==Cancion_alta.getId())
        {
            Intent intencion1=new Intent(this,Cancion_Alta.class);
            startActivity(intencion1);
        }
        if (v.getId()==Cancion_Modificar.getId())
        {
            CancionDao MyCancionDao=new CancionDao(this);
            EntornoDeDatos.ListaCancion=MyCancionDao.getAll("Select * FROM Cancion");

            Intent intencion2=new Intent(this,Cancion_Modificar.class);
            startActivity(intencion2);

        }
        if (v.getId()==Cancion_Borrar.getId())
        {
            CancionDao MyCancionDao=new CancionDao(this);
            EntornoDeDatos.ListaCancion=MyCancionDao.getAll("Select * FROM Cancion");

            Intent Intencion3=new Intent(this, Cancion_Borrar.class);
            startActivity(Intencion3);

        }
        if (v.getId()==Cancion_Mostrar.getId())
        {
            CancionDao MyCancionDao=new CancionDao(this);
            EntornoDeDatos.ListaCancion=MyCancionDao.getAll("Select * FROM Cancion");

            Intent Intencion4=new Intent(this, Cancion_Mostrar.class);
            startActivity(Intencion4);

        }
        if (v.getId()==Cancion_Mostrar_Todo.getId())
        {
            CancionDao MyCancionDao=new CancionDao(this);
            EntornoDeDatos.ListaCancionExtendida=MyCancionDao.getJoinAll("Select * FROM Cancion Inner join Album on Cancion.AlbumPK=Album.AlbumPK Inner join Artista on Album.ArtistaPK=Artista.ArtistaPK");

            Intent Intencion5=new Intent(this, Cancion_Mostrar_Todo.class);
            startActivity(Intencion5);
        }

    }
}
