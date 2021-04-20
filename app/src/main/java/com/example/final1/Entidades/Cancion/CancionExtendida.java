package com.example.final1.Entidades.Cancion;

import com.example.final1.Entidades.Album.Album;
import com.example.final1.Entidades.Artista.Artista;

public class CancionExtendida
{
    Cancion MyCancion;
    Album MyAlbum;
    Artista MyArtista;

    public CancionExtendida(Cancion myCancion, Album myAlbum, Artista myArtista) {
        MyCancion = myCancion;
        MyAlbum = myAlbum;
        MyArtista = myArtista;
    }

    public CancionExtendida()
    {
        MyCancion=new Cancion();
        MyAlbum=new Album();
        MyArtista=new Artista();
    }

    public Cancion getMyCancion() {
        return MyCancion;
    }

    public void setMyCancion(Cancion myCancion) {
        MyCancion = myCancion;
    }

    public Album getMyAlbum() {
        return MyAlbum;
    }

    public void setMyAlbum(Album myAlbum) {
        MyAlbum = myAlbum;
    }

    public Artista getMyArtista() {
        return MyArtista;
    }

    public void setMyArtista(Artista myArtista) {
        MyArtista = myArtista;
    }

    @Override
    public String toString() {
        return ("Artista Nombre="+MyArtista.getArtistaNombre()+" "+MyArtista.getArtistaApellido()+" Fecha de nacimiento="+MyArtista.getArtistaFecha()+" Album nombre="+MyAlbum.getAlbumNombre()+" Fecha del album"+MyAlbum.getAlbumAño()+" Cancion="+getMyCancion().getCancionNombre()+" Fecha="+getMyCancion().getCancionFecha()+" Duracion="+getMyCancion().getCancionDuracion());
    }
}
