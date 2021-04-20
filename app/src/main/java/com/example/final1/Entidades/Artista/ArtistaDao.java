package com.example.final1.Entidades.Artista;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.final1.DaoGenerico.DaoGenerica;
import com.example.final1.DaoGenerico.MetodosComunes;

import java.util.ArrayList;
import java.util.List;

public class ArtistaDao extends DaoGenerica implements MetodosComunes<Artista,Long,Artista>
{

    public ArtistaDao(Context myContext)
    {
        super(myContext);
    }

    @Override
    public Artista AddRecord(Artista ObjetoParaAgregar)
    {
        Artista ObjetoAuxiliar=new Artista();

        ContentValues MyContentValues=new ContentValues();
        MyContentValues.put("ArtistaNombre",ObjetoParaAgregar.getArtistaNombre());
        MyContentValues.put("ArtistaApellido",ObjetoParaAgregar.getArtistaApellido());
        MyContentValues.put("ArtistaFecha",ObjetoParaAgregar.getArtistaFecha());


        Long PK= getConnection().insertOrThrow("Artista",null,MyContentValues);
        if(PK>0)
        {
            ObjetoAuxiliar=ObjetoParaAgregar;
            ObjetoAuxiliar.setArtistaPk(PK);
            return (ObjetoAuxiliar);
        }

        return ObjetoAuxiliar;
    }

    @Override
    public Boolean UpdateRecord(Artista ObjetoParaActualizar)
    {
        ContentValues MyContentValues= new ContentValues();

        MyContentValues.put("ArtistaNombre",ObjetoParaActualizar.getArtistaNombre());
        MyContentValues.put("ArtistaApellido",ObjetoParaActualizar.getArtistaApellido());
        MyContentValues.put("ArtistaFecha",ObjetoParaActualizar.getArtistaFecha());

        int CantidadDeRegistros=0;

        CantidadDeRegistros=getConnection().update("Artista",MyContentValues,"ArtistaPK="+ObjetoParaActualizar.getArtistaPk(),null);

        if(CantidadDeRegistros>0)
        {
            return true;
        }
        return false;
    }

    @Override
    public Boolean DeleteRecord(Artista ObjetoParaEliminar)
    {
        int CantidadDeRegistros=0;

        CantidadDeRegistros=getConnection().delete("Artista","ArtistaPK="+ObjetoParaEliminar.getArtistaPk(),null);
        if(CantidadDeRegistros>0)
        {
            return true;
        }
        else
        {
            getConnection().close();
            return false;
        }
    }

    @Override
    public Artista LoadRedcord(Long PK)
    {
        Artista ObjetoAuxiliar=new  Artista();

        Cursor MyCursor=null;
        MyCursor=getConnection().rawQuery("Select * From Artista Where ArtistaPK="+PK,null);

        while(MyCursor.moveToNext())
        {
            String artistanombre=MyCursor.getString(1);
            String artistaapellido=MyCursor.getString(2);
            String artistafecha=MyCursor.getString(3);
            return ObjetoAuxiliar;
        }
        return ObjetoAuxiliar;
    }

    @Override
    public List<Artista> getAll(String ComandoSql)
    {
        List<Artista> List=new ArrayList<>();
        Cursor MyCursor=null;

        MyCursor=getConnection().rawQuery(ComandoSql,null);
        while(MyCursor.moveToNext())
        {
            Long artistaPK= MyCursor.getLong(0);
            String artistaNombre=MyCursor.getString(1);
            String artistaApellido=MyCursor.getString(2);
            String artistaFecha=MyCursor.getString(3);

            Artista Auxiliar=new Artista(artistaPK,artistaNombre,artistaApellido,artistaFecha);
            List.add(Auxiliar);

        }
        return List;

    }

    @Override
    public List<Artista> getJoinAll(String ComandoSql)
    {
        return null;
    }
}
