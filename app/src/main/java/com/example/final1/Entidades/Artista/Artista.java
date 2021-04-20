package com.example.final1.Entidades.Artista;

public class Artista
{
    Long ArtistaPk;
    String ArtistaNombre;
    String ArtistaApellido;
    String ArtistaFecha;

    public Artista(Long artistaPk, String artistanombre, String artistaapellido, String artistafecha)
    {
        ArtistaPk = artistaPk;
        ArtistaNombre = artistanombre;
        ArtistaApellido = artistaapellido;
        ArtistaFecha = artistafecha;
    }

    public Artista()
    {
        ArtistaPk=Long.valueOf(0);
        ArtistaNombre="";
        ArtistaApellido="";
        ArtistaFecha="";
    }

    public Long getArtistaPk() {
        return ArtistaPk;
    }

    public void setArtistaPk(Long artistaPk) {
        ArtistaPk = artistaPk;
    }

    public String getArtistaNombre() {
        return ArtistaNombre;
    }

    public void setArtistaNombre(String artistaNombre) {
        ArtistaNombre = artistaNombre;
    }

    public String getArtistaApellido() {
        return ArtistaApellido;
    }

    public void setArtistaApellido(String artistaApellido) {
        ArtistaApellido = artistaApellido;
    }

    public String getArtistaFecha() {
        return ArtistaFecha;
    }

    public void setArtistaFecha(String artistaFecha) {
        ArtistaFecha = artistaFecha;
    }

    @Override
    public String toString() {
        return "PK="+getArtistaPk()+" "+"Nombre="+getArtistaNombre() +"-"+getArtistaApellido()+ " Fecha="+getArtistaFecha();
    }
}
