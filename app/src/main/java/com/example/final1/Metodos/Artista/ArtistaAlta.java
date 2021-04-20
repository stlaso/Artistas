package com.example.final1.Metodos.Artista;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.final1.Entidades.Artista.Artista;
import com.example.final1.Entidades.Artista.ArtistaDao;
import com.example.final1.R;

public class ArtistaAlta extends AppCompatActivity implements View.OnClickListener
{
    EditText Alta_Nombre;
    EditText Alta_Apellido;
    EditText Alta_Fecha;
    Button Alta_Boton;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artista_alta);
        Alta_Nombre=findViewById(R.id.Alta_Nombre);
        Alta_Apellido=findViewById(R.id.Alta_Apellido);
        Alta_Fecha=findViewById(R.id.Alta_Fecha);
        Alta_Boton=findViewById(R.id.Alta_Boton);

        Alta_Boton.setOnClickListener(this);
    }

    public boolean Validar()
    {
        if(Alta_Nombre.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Ingrese nombre!!",Toast.LENGTH_LONG).show();
            return false;
        }

        if(Alta_Apellido.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Ingrese apellido!!",Toast.LENGTH_LONG).show();
            return false;
        }

        if(Alta_Fecha.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Ingrese fecha de nacimiento!!",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
    @Override
    public void onClick(View v)
    {
        if(v.getId()==Alta_Boton.getId())
        {
            if (Validar())
            {
                Artista artistas=new Artista(Long.valueOf(10),Alta_Nombre.getText().toString(),Alta_Apellido.getText().toString(),Alta_Fecha.getText().toString());

                ArtistaDao MyArtistaDao=new ArtistaDao(getApplicationContext());

                Artista Resultado=new Artista();

                Resultado=MyArtistaDao.AddRecord(artistas);

                Toast.makeText(getApplicationContext(),"Se agrego al artista correctamente",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
