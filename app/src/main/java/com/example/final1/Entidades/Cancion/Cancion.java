package com.example.final1.Entidades.Cancion;

public class Cancion
{
    Long CancionPK;
    String CancionNombre;
    String CancionFecha;
    String CancionDuracion;
    Long AlbumPK;

    public Cancion(Long cancionPK, String cancionnombre, String cancionfecha, String cancionduracion, Long albumPK)
    {
        CancionPK = cancionPK;
        CancionNombre = cancionnombre;
        CancionFecha = cancionfecha;
        CancionDuracion = cancionduracion;
        AlbumPK = albumPK;
    }
    public Cancion()
    {
        CancionPK=Long.valueOf(0);
        CancionNombre="";
        CancionFecha="";
        CancionDuracion="";
        AlbumPK=Long.valueOf(0);

    }

    public Long getAlbumPK() {
        return AlbumPK;
    }

    public void setAlbumPK(Long albumPK) {
        AlbumPK = albumPK;
    }

    public Long getCancionPK() {
        return CancionPK;
    }

    public void setCancionPK(Long cancionPK) {
        CancionPK = cancionPK;
    }

    public String getCancionNombre() {
        return CancionNombre;
    }

    public void setCancionNombre(String cancionNombre) {
        CancionNombre = cancionNombre;
    }

    public String getCancionFecha() {
        return CancionFecha;
    }

    public void setCancionFecha(String cancionFecha) {
        CancionFecha = cancionFecha;
    }

    public String getCancionDuracion() {
        return CancionDuracion;
    }

    public void setCancionDuracion(String cancionDuracion) {
        CancionDuracion = cancionDuracion;
    }

    @Override
    public String toString() {
        return "PK="+getCancionPK()+"Nombre="+getCancionNombre()+" Fecha="+getCancionFecha()+" Duracion="+getCancionDuracion();
    }
}
