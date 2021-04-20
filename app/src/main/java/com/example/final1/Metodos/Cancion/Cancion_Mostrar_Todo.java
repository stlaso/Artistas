package com.example.final1.Metodos.Cancion;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.final1.DaoGenerico.EntornoDeDatos;
import com.example.final1.R;

public class Cancion_Mostrar_Todo extends AppCompatActivity
{
    android.widget.ListView ListView;
    ArrayAdapter MyArrayAdapter;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancion_mostrar_todo);
        ListView = findViewById(R.id.ListView);

        MyArrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, EntornoDeDatos.ListaCancionExtendida);
        ListView.setAdapter(MyArrayAdapter);
    }
}
