package com.example.final1.Metodos.Album;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.final1.DaoGenerico.EntornoDeDatos;
import com.example.final1.Entidades.Album.Album;
import com.example.final1.Entidades.Album.AlbumDao;
import com.example.final1.Entidades.Artista.Artista;
import com.example.final1.Entidades.Artista.ArtistaDao;
import com.example.final1.R;

public class Album_Alta extends AppCompatActivity implements View.OnClickListener
{
    EditText Alta_Nombre;
    EditText Alta_Año;
    Spinner Alta_Spinner;
    Button Album_Agregar;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_alta);
        Alta_Nombre=findViewById(R.id.Alta_Nombre);
        Alta_Año=findViewById(R.id.Alta_Año);
        Alta_Spinner=findViewById(R.id.Alta_Spinner);
        Album_Agregar=findViewById(R.id.Album_Agregar);

        Album_Agregar.setOnClickListener(this);

        EntornoDeDatos.List1.clear();
        EntornoDeDatos.ListaArtista.clear();


        ArtistaDao MyArtistaDao=new ArtistaDao(this);
        EntornoDeDatos.ListaArtista=MyArtistaDao.getAll("Select * FROM Artista");
        ArrayAdapter<Character> adaptador=new ArrayAdapter(this, android.R.layout.simple_spinner_item,EntornoDeDatos.List1);
        ObtenerLista();
        Alta_Spinner.setAdapter(adaptador);

    }

    private void ObtenerLista()
    {
        EntornoDeDatos.List1.add("Seleccionar");
        for (int i=0;  i<EntornoDeDatos.ListaArtista.size(); i++)
        {
            EntornoDeDatos.List1.add(EntornoDeDatos.ListaArtista.get(i).getArtistaNombre());
        }
    }

    public boolean Validar()
    {
        if(Alta_Nombre.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Ingrese nombre!!",Toast.LENGTH_LONG).show();
            return false;
        }
        if (Alta_Año.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Ingrese año!!",Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }


    @Override
    public void onClick(View v)
    {
        if (v.getId()==Album_Agregar.getId())
        {
            String Respuesta="";
            Respuesta=Alta_Spinner.getSelectedItem().toString();

            for (int j=0; j<EntornoDeDatos.ListaArtista.size(); j++)
            {
                if (EntornoDeDatos.ListaArtista.get(j).getArtistaNombre()==Respuesta)
                {
                    Respuesta=Respuesta.valueOf(EntornoDeDatos.ListaArtista.get(j).getArtistaPk());
                }
            }
            if (Validar())
            {
                Album MyAlbum=new Album(Long.valueOf(0),Alta_Nombre.getText().toString(),Alta_Año.getText().toString(),Long.valueOf(Respuesta));
                AlbumDao MyAlbumDao=new AlbumDao(getApplicationContext());
                Album Respuesta1=new Album();
                Respuesta1=MyAlbumDao.AddRecord(MyAlbum);

                Toast.makeText(getApplicationContext(),"Se agrego el album correctamente",Toast.LENGTH_SHORT).show();



            }
        }
    }
}
