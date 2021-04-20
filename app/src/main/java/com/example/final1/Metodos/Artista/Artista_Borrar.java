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

public class Artista_Borrar extends AppCompatActivity implements View.OnClickListener
{
    EditText Borrar_PK;
    Button Borrar_Boton;
    ListView ListView;
    ArrayAdapter MyArrayAdapter;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artista_borrar);
        Borrar_PK=findViewById(R.id.Borrar_PK);
        Borrar_Boton=findViewById(R.id.Borrar_Boton);
        ListView=findViewById(R.id.ListView);

        Borrar_Boton.setOnClickListener(this);

        MyArrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, EntornoDeDatos.ListaArtista);
        ListView.setAdapter(MyArrayAdapter);
    }

    public Boolean Validar()
    {
        if(Borrar_PK.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Ingrese PK!!",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v)
    {
        if (v.getId()==Borrar_Boton.getId())
        {
            if (Validar())
            {
                String Respuesta=Borrar_PK.getText().toString();
                for (int i=0; i<EntornoDeDatos.ListaArtista.size(); i++)
                {

                    if (Respuesta==EntornoDeDatos.ListaArtista.get(i).getArtistaPk().toString())
                    {
                        Respuesta=Respuesta.valueOf(EntornoDeDatos.ListaArtista.get(i).getArtistaPk());
                    }
                }



                Artista Artista1=new Artista(Long.valueOf(Respuesta),null,null,null);

                ArtistaDao MyArtistaDao=new ArtistaDao(this);

                if (MyArtistaDao.DeleteRecord(Artista1))
                {
                    Toast.makeText(getApplicationContext(),"Se pudo eliminar el artista",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No se pudo eliminar el artista",Toast.LENGTH_LONG).show();
                }

            }



        }

    }
}
