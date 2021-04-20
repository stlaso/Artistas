package com.example.final1.Entidades.Cancion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.final1.DaoGenerico.DaoGenerica;
import com.example.final1.DaoGenerico.MetodosComunes;
import com.example.final1.Entidades.Album.Album;
import com.example.final1.Entidades.Artista.Artista;

import java.util.ArrayList;
import java.util.List;

public class CancionDao extends DaoGenerica implements MetodosComunes <Cancion,Long,CancionExtendida>
{

    public CancionDao(Context myContext)
    {
        super(myContext);
    }

    @Override
    public Cancion AddRecord(Cancion ObjetoParaAgregar)
    {

        Cancion ObjetoAuxiliar=new Cancion();

        ContentValues MyContentValues=new ContentValues();

        MyContentValues.put("CancionNombre",ObjetoParaAgregar.getCancionNombre());
        MyContentValues.put("CancionFecha",ObjetoParaAgregar.getCancionFecha());
        MyContentValues.put("CancionDuracion",ObjetoParaAgregar.getCancionDuracion());
        MyContentValues.put("AlbumPK",ObjetoParaAgregar.getAlbumPK());

        Long PK=getConnection().insertOrThrow("Cancion",null,MyContentValues);

        if(PK>0)
        {
            ObjetoAuxiliar=ObjetoParaAgregar;
            ObjetoAuxiliar.setCancionPK(PK);
            return ObjetoAuxiliar;
        }
        return (ObjetoAuxiliar);

    }

    @Override
    public Boolean UpdateRecord(Cancion ObjetoParaActualizar)
    {
        ContentValues MyContentValues=new ContentValues();
        MyContentValues.put("CancionNombre",ObjetoParaActualizar.getCancionNombre());
        MyContentValues.put("CancionFecha",ObjetoParaActualizar.getCancionFecha());
        MyContentValues.put("CancionDuracion",ObjetoParaActualizar.getCancionDuracion());

        int CantidadDeRegistros=0;

        CantidadDeRegistros=getConnection().update("Cancion",MyContentValues,"CancionPK="+ObjetoParaActualizar.getCancionPK(),null);

        if(CantidadDeRegistros>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public Boolean DeleteRecord(Cancion ObjetoParaEliminar)
    {
        int CantidadDeRegistros=0;
        CantidadDeRegistros=getConnection().delete("Cancion","CancionPK="+ObjetoParaEliminar.getCancionPK(),null);

        if(CantidadDeRegistros>0)
        {
            return true;

        }
        else
        {
            return false;
        }
    }

    @Override
    public Cancion LoadRedcord(Long PK)
    {
        Cancion ObjetoAuxiliar=new Cancion();
        Cursor MyCursor=null;
        MyCursor=getConnection().rawQuery("Select * From Cancion Where CancionPK ="+PK,null);

        while(MyCursor.moveToNext())
        {
            String cancionNombre=MyCursor.getString(0);
            String cancionfecha=MyCursor.getString(1);
            String cancionduracion=MyCursor.getString(2);

            ObjetoAuxiliar.setCancionNombre(cancionNombre);
            ObjetoAuxiliar.setCancionFecha(cancionfecha);
            ObjetoAuxiliar.setCancionDuracion(cancionduracion);

            return (ObjetoAuxiliar);
        }
        return ObjetoAuxiliar;
    }

    @Override
    public List<Cancion> getAll(String ComandoSql)
    {
        List<Cancion> List=new ArrayList<>();
        Cursor MyCursor=null;
        MyCursor=getConnection().rawQuery(ComandoSql,null);
        while(MyCursor.moveToNext())
        {
            Long cancionPK=MyCursor.getLong(0);
            String cancionNombre=MyCursor.getString(1);
            String cancionFecha=MyCursor.getString(2);
            String cancionDuracion=MyCursor.getString(3);
            Long albumPK=MyCursor.getLong(4);

            Cancion ObjetoAuxiliar=new Cancion(cancionPK,cancionNombre,cancionFecha,cancionDuracion,albumPK);

            List.add(ObjetoAuxiliar);

        }
        return List;
    }

    @Override
    public List<CancionExtendida> getJoinAll(String ComandoSql)
    {
        List<CancionExtendida> MyList=new ArrayList<>();

        Cursor MyCursor=null;

        MyCursor=getConnection().rawQuery(ComandoSql,null);

        CancionExtendida CancionExtendidaAuxiliar=null;

        Cancion CancionAuxiliar=null;

        Album AlbumAuxiliar=null;

        Artista ArtistaAuxiliar=null;

        while(MyCursor.moveToNext())
        {
            CancionAuxiliar=new Cancion();

            AlbumAuxiliar=new Album();

            ArtistaAuxiliar=new Artista();

            CancionAuxiliar.setCancionPK(MyCursor.getLong(0));
            CancionAuxiliar.setCancionNombre(MyCursor.getString(1));
            CancionAuxiliar.setCancionFecha(MyCursor.getString(2));
            CancionAuxiliar.setCancionDuracion(MyCursor.getString(3));
            CancionAuxiliar.setAlbumPK(MyCursor.getLong(4));

            AlbumAuxiliar.setAlbumPk(MyCursor.getLong(5));
            AlbumAuxiliar.setAlbumNombre(MyCursor.getString(6));
            AlbumAuxiliar.setAlbumAño(MyCursor.getString(7));
            AlbumAuxiliar.setArtistaPk(MyCursor.getLong(8));

            ArtistaAuxiliar.setArtistaPk(MyCursor.getLong(9));
            ArtistaAuxiliar.setArtistaNombre(MyCursor.getString(10));
            ArtistaAuxiliar.setArtistaApellido(MyCursor.getString(11));
            ArtistaAuxiliar.setArtistaFecha(MyCursor.getString(12));

            CancionExtendidaAuxiliar=new CancionExtendida(CancionAuxiliar,AlbumAuxiliar,ArtistaAuxiliar);

            MyList.add(CancionExtendidaAuxiliar);

        }
        return MyList;
    }
}
