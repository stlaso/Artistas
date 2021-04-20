package com.example.final1.Metodos.Cancion;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.final1.DaoGenerico.EntornoDeDatos;
import com.example.final1.Entidades.Cancion.Cancion;
import com.example.final1.Entidades.Cancion.CancionDao;
import com.example.final1.R;

public class Cancion_Borrar extends AppCompatActivity implements View.OnClickListener
{

    EditText Borrar_PK;
    Button Borrar_Boton;
    ArrayAdapter MyArrayAdapter;
    ListView ListView;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancion_borrar);
        Borrar_Boton=findViewById(R.id.Borrar_Boton);
        Borrar_PK=findViewById(R.id.Borrar_PK);
        ListView=findViewById(R.id.ListView);

        Borrar_Boton.setOnClickListener(this);



        MyArrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, EntornoDeDatos.ListaCancion);
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
                for (int i=0; i<EntornoDeDatos.ListaCancion.size(); i++)
                {
                    if (Respuesta==EntornoDeDatos.ListaCancion.get(i).getCancionPK().toString())
                    {
                        Respuesta=Respuesta.valueOf(EntornoDeDatos.ListaCancion.get(i).getCancionPK());
                    }
                }

                Cancion cancion1=new Cancion(Long.valueOf(Respuesta),null,null,null,null);
                CancionDao MyCancionDao=new CancionDao(this);
                if (MyCancionDao.DeleteRecord(cancion1))
                {
                    Toast.makeText(getApplicationContext(),"Se pudo eliminar la cancion",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No se pudo eliminar la cancion",Toast.LENGTH_LONG).show();
                }
            }
        }

    }
}
