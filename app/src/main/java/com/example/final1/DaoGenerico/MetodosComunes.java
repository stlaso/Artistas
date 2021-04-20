package com.example.final1.DaoGenerico;

import java.util.List;

public interface MetodosComunes <Clase,ClavePrimaria,ClaseExtendida>
{
    public Clase AddRecord(Clase ObjetoParaAgregar);
    public Boolean UpdateRecord(Clase ObjetoParaActualizar);
    public Boolean DeleteRecord(Clase ObjetoParaEliminar);
    public Clase LoadRedcord(ClavePrimaria PK);
    public List<Clase> getAll(String ComandoSql);
    public List<ClaseExtendida>getJoinAll(String ComandoSql);
}
