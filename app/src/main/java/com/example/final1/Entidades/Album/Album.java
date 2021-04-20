package com.example.final1.Entidades.Album;

public class Album
{
    Long AlbumPk;
    String AlbumNombre;
    String AlbumAño;
    Long ArtistaPk;

    public Album(Long albumPk, String albumnombre, String albumaño, Long artistaPk)
    {
        AlbumPk = albumPk;
        AlbumNombre = albumnombre;
        AlbumAño = albumaño;
        ArtistaPk = artistaPk;
    }

    public Album()
    {
        AlbumPk=Long.valueOf(0);
        AlbumNombre="";
        AlbumAño="";
        ArtistaPk=Long.valueOf(0);

    }

    public Long getArtistaPk() {
        return ArtistaPk;
    }

    public void setArtistaPk(Long artistaPk) {
        ArtistaPk = artistaPk;
    }

    public Long getAlbumPk() {
        return AlbumPk;
    }

    public void setAlbumPk(Long albumPk) {
        AlbumPk = albumPk;
    }

    public String getAlbumNombre() {
        return AlbumNombre;
    }

    public void setAlbumNombre(String albumNombre) {
        AlbumNombre = albumNombre;
    }

    public String getAlbumAño() {
        return AlbumAño;
    }

    public void setAlbumAño(String albumAño) {
        AlbumAño = albumAño;
    }



    @Override
    public String toString() {
        return ("PK="+getAlbumPk()+" "+"Nombre="+getAlbumNombre()+"  Año="+getAlbumAño());
    }
}
