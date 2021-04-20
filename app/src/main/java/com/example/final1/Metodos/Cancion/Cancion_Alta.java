package com.example.final1.Metodos.Cancion;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.final1.DaoGenerico.EntornoDeDatos;
import com.example.final1.Entidades.Album.AlbumDao;
import com.example.final1.Entidades.Artista.ArtistaDao;
import com.example.final1.Entidades.Cancion.Cancion;
import com.example.final1.Entidades.Cancion.CancionDao;
import com.example.final1.R;

public class Cancion_Alta extends AppCompatActivity implements View.OnClickListener
{
    EditText Alta_Nombre;
    EditText Alta_Fecha;
    EditText Alta_Duracion;
    Spinner Alta_Spinner;
    Button Cancion_Agregar;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancion_alta);
        Alta_Nombre=findViewById(R.id.Alta_Nombre);
        Alta_Fecha=findViewById(R.id.Alta_Fecha);
        Alta_Duracion=findViewById(R.id.Alta_Duracion);
        Alta_Spinner=findViewById(R.id.Alta_Spinner);
        Cancion_Agregar=findViewById(R.id.Cancion_Agregar);
        Cancion_Agregar.setOnClickListener(this);


        EntornoDeDatos.List2.clear();
        EntornoDeDatos.ListaCancion.clear();


        AlbumDao MyAlbumDao=new AlbumDao(this);
        EntornoDeDatos.ListaAlbum=MyAlbumDao.getAll("Select * FROM Album");
        ArrayAdapter<Character> adaptador=new ArrayAdapter(this, android.R.layout.simple_spinner_item,EntornoDeDatos.List2);
        ObtenerLista();
        Alta_Spinner.setAdapter(adaptador);

    }

    private void ObtenerLista()
    {
        EntornoDeDatos.List2.add("Seleccionar");
        for (int i=0;  i<EntornoDeDatos.ListaAlbum.size(); i++)
        {
            EntornoDeDatos.List2.add(EntornoDeDatos.ListaAlbum.get(i).getAlbumNombre());
        }
    }

    public boolean Validar()
    {
        if(Alta_Nombre.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Ingrese nombre!!",Toast.LENGTH_LONG).show();
            return false;
        }
        if (Alta_Duracion.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Ingrese duracion!!",Toast.LENGTH_LONG).show();
            return false;
        }
        if(Alta_Fecha.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Ingrese fecha!!",Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    @Override
    public void onClick(View v)
    {
        if (Cancion_Agregar.getId()==v.getId())
        {
            if(Validar())
            {
            String Respuesta="";
            Respuesta=Alta_Spinner.getSelectedItem().toString();

            for (int j=0; j<EntornoDeDatos.ListaAlbum.size(); j++)
            {
                if (EntornoDeDatos.ListaAlbum.get(j).getAlbumNombre()==Respuesta)
                {
                    Respuesta=Respuesta.valueOf(EntornoDeDatos.ListaAlbum.get(j).getAlbumPk());
                }
            }

                Cancion MyCancion=new Cancion(Long.valueOf(0),Alta_Nombre.getText().toString(),Alta_Fecha.getText().toString(),Alta_Duracion.getText().toString(),Long.valueOf(Respuesta));
                CancionDao MyCancionDao=new CancionDao(getApplicationContext());
                Cancion cancion1=new Cancion();
                cancion1=MyCancionDao.AddRecord(MyCancion);

                Toast.makeText(getApplicationContext(),"Se agrego la cancion correctamente",Toast.LENGTH_SHORT).show();



            }

        }

    }
}
