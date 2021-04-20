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

public class Cancion_Modificar extends AppCompatActivity implements View.OnClickListener
{
    EditText Modificar_PK;
    EditText Modificar_Nombre;
    EditText Modificar_Año;
    EditText Modificar_Duracion;
    Button Modificar_Boton;
    ListView ListView;
    ArrayAdapter MyArrayAdapter;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancion_modificar);
        Modificar_PK=findViewById(R.id.Modificar_PK);
        Modificar_Nombre=findViewById(R.id.Modificar_Nombre);
        Modificar_Año=findViewById(R.id.Modificar_Año);
        Modificar_Duracion=findViewById(R.id.Modificar_Duracion);
        Modificar_Boton=findViewById(R.id.Modificar_Boton);
        ListView=findViewById(R.id.ListView);
        Modificar_Boton.setOnClickListener(this);

        MyArrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, EntornoDeDatos.ListaCancion);
        ListView.setAdapter(MyArrayAdapter);


    }


    public boolean Validar() {
        if (Modificar_PK.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Ingrese PK!!", Toast.LENGTH_LONG).show();
            return false;
        }

        if (Modificar_Nombre.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Ingrese nombre!!", Toast.LENGTH_LONG).show();
            return false;
        }
        if (Modificar_Duracion.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Ingrese duracion!!", Toast.LENGTH_LONG).show();
            return false;
        }
        if (Modificar_Año.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Ingrese fecha!!", Toast.LENGTH_LONG).show();
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

                for (int i=0; i<EntornoDeDatos.ListaCancion.size(); i++)
                {
                    if (Respuesta==EntornoDeDatos.ListaCancion.get(i).getCancionPK().toString())
                    {
                        Respuesta=Respuesta.valueOf(EntornoDeDatos.ListaCancion.get(i).getCancionPK());
                    }
                }

                Cancion cancion1=new Cancion(Long.valueOf(Respuesta),Modificar_Nombre.getText().toString(),Modificar_Año.getText().toString(),Modificar_Duracion.getText().toString(),0L);
                CancionDao MyCancionDao=new CancionDao(this);
                if (MyCancionDao.UpdateRecord(cancion1))
                {
                    Toast.makeText(getApplicationContext(),"La cancion se modificio",Toast.LENGTH_LONG).show();
                }
                else
                    {
                        Toast.makeText(getApplicationContext(),"La cancion no se modificio",Toast.LENGTH_LONG).show();
                    }


            }
        }


    }
}
