package com.example.final1.DaoGenerico;

import com.example.final1.Entidades.Album.Album;
import com.example.final1.Entidades.Album.AlbumExtendido;
import com.example.final1.Entidades.Artista.Artista;
import com.example.final1.Entidades.Cancion.Cancion;
import com.example.final1.Entidades.Cancion.CancionExtendida;

import java.util.ArrayList;
import java.util.List;

public class EntornoDeDatos
{
    public static java.util.List<String> List1=new ArrayList<String>();
    public static java.util.List<String> List2=new ArrayList<String>();
    public static List<String> List3=new ArrayList<>();


    public static List<Artista> ListaArtista=new ArrayList<>();

    public static List<Album> ListaAlbum=new ArrayList<>();
    public static List<AlbumExtendido> ListaAlbumExtendido=new ArrayList<>();

    public static List<Cancion> ListaCancion=new ArrayList<>();
    public static List<CancionExtendida> ListaCancionExtendida=new ArrayList<>();
 }
