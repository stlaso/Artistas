package com.example.final1.Metodos.Album;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.final1.DaoGenerico.EntornoDeDatos;
import com.example.final1.Entidades.Album.Album;
import com.example.final1.Entidades.Album.AlbumDao;
import com.example.final1.Entidades.Artista.Artista;
import com.example.final1.Entidades.Artista.ArtistaDao;
import com.example.final1.R;

public class Album_Modificar extends AppCompatActivity implements View.OnClickListener
{
    EditText Modificar_PK;
    EditText Modificar_Nombre;
    EditText Modificar_Año;
    Button Modificar_Boton;
    ListView ListView;
    ArrayAdapter MyArrayAdapter;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_modificar);
        Modificar_PK=findViewById(R.id.Modificar_PK);
        Modificar_Nombre=findViewById(R.id.Modificar_Nombre);
        Modificar_Año=findViewById(R.id.Modificar_Año);
        Modificar_Boton=findViewById(R.id.Modificar_Boton);
        ListView=findViewById(R.id.ListView);

        MyArrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, EntornoDeDatos.ListaAlbum);
        ListView.setAdapter(MyArrayAdapter);


        Modificar_Boton.setOnClickListener(this);
    }

    public boolean Validar()
    {
        if (Modificar_PK.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Ingrese PK!!",Toast.LENGTH_LONG).show();
            return false;
        }
        if(Modificar_Nombre.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Ingrese nombre!!",Toast.LENGTH_LONG).show();
            return false;
        }

        if (Modificar_Año.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Ingrese Año!!",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
    @Override
    public void onClick(View v)
    {
        if (Modificar_Boton.getId()==v.getId())
        {
            if (Validar())
            {
                String Respuesta=Modificar_PK.getText().toString();
                for (int i = 0; i< EntornoDeDatos.ListaAlbum.size(); i++)
                {

                    if (Respuesta==EntornoDeDatos.ListaAlbum.get(i).getAlbumPk().toString())
                    {
                        Respuesta=Respuesta.valueOf(EntornoDeDatos.ListaAlbum.get(i).getAlbumPk());
                    }
                }

                String nombre=Modificar_Nombre.getText().toString();
                String Año=Modificar_Año.getText().toString();


                Album Album1=new Album(Long.valueOf(Respuesta),nombre,Año,0L);
                AlbumDao MyAlbumDao=new AlbumDao(this);
                if(MyAlbumDao.UpdateRecord(Album1))
                {
                    Toast.makeText(getApplicationContext(),"El Artista se modificio",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"El Artista no se modificio",Toast.LENGTH_LONG).show();
                }


            }
        }

    }
}
