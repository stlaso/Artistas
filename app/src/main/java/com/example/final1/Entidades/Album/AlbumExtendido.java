package com.example.final1.Entidades.Album;

import com.example.final1.Entidades.Artista.Artista;
import com.example.final1.Entidades.Cancion.Cancion;

public class AlbumExtendido
{

    Album MyAlbum;
    Artista MyArtista;

    public AlbumExtendido( Album myAlbum ,Artista myArtista)
    {
        MyAlbum = myAlbum;
        MyArtista = myArtista;
    }


    public AlbumExtendido()
    {
        MyAlbum=new Album();
        MyArtista=new Artista();
    }


    @Override
    public String toString()
    {
        return ("Artista Nombre="+MyArtista.getArtistaNombre()+" "+MyArtista.getArtistaApellido()+" Fecha de nacimiento="+MyArtista.getArtistaFecha()+" Album nombre="+MyAlbum.getAlbumNombre()+" Fecha del album"+MyAlbum.getAlbumAño());
    }
}
