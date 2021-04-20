package com.example.final1.Metodos.Album;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.final1.DaoGenerico.EntornoDeDatos;
import com.example.final1.R;

public class Album_Mostrar extends AppCompatActivity
{
    ListView ListView;
    ArrayAdapter MyArrayAdapter;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_mostrar);
        ListView=findViewById(R.id.ListView);


        MyArrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, EntornoDeDatos.ListaAlbum);
        ListView.setAdapter(MyArrayAdapter);
    }

}
