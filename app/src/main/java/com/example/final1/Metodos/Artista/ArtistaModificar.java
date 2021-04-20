package com.example.final1.Metodos.Artista;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.final1.DaoGenerico.EntornoDeDatos;
import com.example.final1.Entidades.Artista.Artista;
import com.example.final1.Entidades.Artista.ArtistaDao;
import com.example.final1.R;

public class ArtistaModificar extends AppCompatActivity implements View.OnClickListener
{
    EditText Modificar_PK;
    EditText Modificar_Nombre;
    EditText Modificar_Apellido;
    EditText Modificar_Fecha;
    Button Modificar_Boton;
    ListView ListView;
    ArrayAdapter MyArrayAdapter;




    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artista_modificar);
        Modificar_PK=findViewById(R.id.Modificar_PK);
        Modificar_Nombre=findViewById(R.id.Modificar_Nombre);
        Modificar_Apellido=findViewById(R.id.Modificar_Apellido);
        Modificar_Fecha=findViewById(R.id.Modificar_Fecha);
        Modificar_Boton=findViewById(R.id.Modificar_Boton);
        ListView=findViewById(R.id.ListView);

        Modificar_Boton.setOnClickListener(this);


        MyArrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, EntornoDeDatos.ListaArtista);
        ListView.setAdapter(MyArrayAdapter);
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

        if(Modificar_Apellido.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Ingrese apellido!!",Toast.LENGTH_LONG).show();
            return false;
        }

        if(Modificar_Fecha.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Ingrese fecha de nacimiento!!",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v)
    {
        if (v.getId()==Modificar_Boton.getId())
        {
            if (Validar())
            {
                String Respuesta=Modificar_PK.getText().toString();
                for (int i=0; i<EntornoDeDatos.ListaArtista.size(); i++)
                {

                    if (Respuesta==EntornoDeDatos.ListaArtista.get(i).getArtistaPk().toString())
                    {
                        Respuesta=Respuesta.valueOf(EntornoDeDatos.ListaArtista.get(i).getArtistaPk());
                    }
                }

                String nombre=Modificar_Nombre.getText().toString();
                String apellido=Modificar_Apellido.getText().toString();
                String fecha=Modificar_Fecha.getText().toString();

                Artista Artista1=new Artista(Long.valueOf(Respuesta),nombre,apellido,fecha);
                ArtistaDao MyArtistaDao=new ArtistaDao(this);
                if(MyArtistaDao.UpdateRecord(Artista1))
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
