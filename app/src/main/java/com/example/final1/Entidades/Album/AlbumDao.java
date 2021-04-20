package com.example.final1.Entidades.Album;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.final1.DaoGenerico.DaoGenerica;
import com.example.final1.DaoGenerico.MetodosComunes;
import com.example.final1.Entidades.Artista.Artista;

import java.util.ArrayList;
import java.util.List;

public class AlbumDao extends DaoGenerica implements MetodosComunes <Album,Long,AlbumExtendido>
{
    public AlbumDao(Context myContext) {
        super(myContext);
    }

    @Override
    public Album AddRecord(Album ObjetoParaAgregar)
    {
        Album ObjetoAuxiliar=new Album();
        ContentValues MyContentValues=new ContentValues();
        MyContentValues.put("AlbumNombre",ObjetoParaAgregar.getAlbumNombre());
        MyContentValues.put("AlbumAño",ObjetoParaAgregar.getAlbumAño());
        MyContentValues.put("ArtistaPK",ObjetoParaAgregar.getArtistaPk());

        Long PK=getConnection().insertOrThrow("Album",null,MyContentValues);

        if(PK>0)
        {
            ObjetoAuxiliar=ObjetoParaAgregar;
            ObjetoAuxiliar.setAlbumPk(PK);
            return ObjetoAuxiliar;
        }
        return ObjetoAuxiliar;



    }

    @Override
    public Boolean UpdateRecord(Album ObjetoParaActualizar)
    {
        ContentValues MyContentVaules=new ContentValues();
        MyContentVaules.put("AlbumNombre",ObjetoParaActualizar.getAlbumNombre());
        MyContentVaules.put("AlbumAño",ObjetoParaActualizar.getAlbumAño());

        int CantidadDeRegistros=0;
        CantidadDeRegistros=getConnection().update("Album",MyContentVaules,"AlbumPK="+ObjetoParaActualizar.getAlbumPk(),null);

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
    public Boolean DeleteRecord(Album ObjetoParaEliminar)
    {
        int CantidadDeRegistros=0;
        CantidadDeRegistros=getConnection().delete("Album","AlbumPK="+ObjetoParaEliminar.getAlbumPk(),null);
        if (CantidadDeRegistros>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public Album LoadRedcord(Long PK)
    {
        Album ObjetoAuxiliar=new Album();
        Cursor MyCursor=null;
        MyCursor=getConnection().rawQuery("Select * From Album Where AlbumPK="+PK,null);

        while(MyCursor.moveToNext())
        {
            String albumnombre=MyCursor.getString(0);
            String albumaño=MyCursor.getString(1);
            return (ObjetoAuxiliar);
        }
        return (ObjetoAuxiliar);
    }

    @Override
    public List<Album> getAll(String ComandoSql)
    {
        List<Album> List=new ArrayList<>();
        Cursor MyCursor=null;
        MyCursor=getConnection().rawQuery(ComandoSql,null);

        while(MyCursor.moveToNext())
        {
            Long albumPK=MyCursor.getLong(0);
            String albumnombre=MyCursor.getString(1);
            String albumaño=MyCursor.getString(2);
            Long artistaPK=MyCursor.getLong(3);

            Album ObjetoAuxiliar=new Album(albumPK,albumnombre,albumaño,artistaPK);

            List.add(ObjetoAuxiliar);
        }
        return List;
    }

    @Override
    public List<AlbumExtendido> getJoinAll(String ComandoSql)
    {
        List<AlbumExtendido> MyList=new ArrayList<>();

        Cursor MyCursor=null;

        MyCursor=getConnection().rawQuery(ComandoSql,null);

        Album AlbumAuxiliar=null;

        AlbumExtendido AlbumExtendidoAuxiliar=null;

        Artista ArtistaAuxiliar=null;

        while(MyCursor.moveToNext())
        {
            AlbumAuxiliar=new Album();

            ArtistaAuxiliar=new Artista();

            AlbumAuxiliar.setAlbumPk(MyCursor.getLong(0));
            AlbumAuxiliar.setAlbumNombre(MyCursor.getString(1));
            AlbumAuxiliar.setAlbumAño(MyCursor.getString(2));
            AlbumAuxiliar.setArtistaPk(MyCursor.getLong(3));

            ArtistaAuxiliar.setArtistaPk(MyCursor.getLong(4));
            ArtistaAuxiliar.setArtistaNombre(MyCursor.getString(5));
            ArtistaAuxiliar.setArtistaApellido(MyCursor.getString(6));
            ArtistaAuxiliar.setArtistaFecha(MyCursor.getString(7));

            AlbumExtendidoAuxiliar=new AlbumExtendido(AlbumAuxiliar,ArtistaAuxiliar);

            MyList.add(AlbumExtendidoAuxiliar);
        }
        return MyList;
    }
}
