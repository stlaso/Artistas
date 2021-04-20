package com.example.final1.DaoGenerico;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public abstract class DaoGenerica
{
    Context MyContext;
    DriverDB MyDriverDB;
    SQLiteDatabase MySQLiteDatabase;

    public DaoGenerica(Context myContext)
    {
        MyContext=myContext;
        MyDriverDB=new DriverDB(myContext);
        MySQLiteDatabase=MyDriverDB.getWritableDatabase();
    }

    public SQLiteDatabase getConnection()
    {
        if(MySQLiteDatabase!=null)
        {
            return (MySQLiteDatabase);
        }
        else
        {
            MySQLiteDatabase=MyDriverDB.getWritableDatabase();
            return (MySQLiteDatabase);
        }
    }

    public boolean closeConnection()
    {
        if(MySQLiteDatabase!=null)
        {
            MySQLiteDatabase.close();
            MySQLiteDatabase=null;
            return true;
        }

        return false;

    }
}
