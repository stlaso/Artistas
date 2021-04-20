package com.example.final1.DaoGenerico;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DriverDB extends SQLiteOpenHelper
{
    Context MyContext;
    public static String DB_NAME="BaseDeDatos.sqlite";
    public static int DB_VERSION=1;

    public DriverDB(Context context)
    {
        super(context,DB_NAME,null,DB_VERSION);
        MyContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("Create Table Artista (ArtistaPK integer primary key autoincrement, ArtistaNombre text not null,ArtistaApellido text not null,ArtistaFecha text not null)");
        db.execSQL("Create Table Album (AlbumPK integer primary key autoincrement, AlbumNombre text not null,AlbumAño text not null,ArtistaPK integer)");
        db.execSQL("Create Table Cancion(CancionPK integer primary key autoincrement,CancionNombre text not null,CancionFecha text not null,CancionDuracion text not null,AlbumPK integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
