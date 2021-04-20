package com.example.final1.Metodos.Artista;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.final1.DaoGenerico.EntornoDeDatos;
import com.example.final1.R;

public class Artista_Mostrar extends AppCompatActivity
{

    ListView Lista;
    ArrayAdapter MyArrayAdapter;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artista_mostrar);
        Lista=findViewById(R.id.Lista);


        MyArrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, EntornoDeDatos.ListaArtista);
        Lista.setAdapter(MyArrayAdapter);

    }

}
