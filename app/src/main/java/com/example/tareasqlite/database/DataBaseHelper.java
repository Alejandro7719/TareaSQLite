package com.example.tareasqlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "applicationdata.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_CREATE = "create table todo (_id integer primary key autoincrement,"
            + "category text not null, summary text not null, description text not null);";

    //Consulta para crear la base de datos
    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase database = this.getWritableDatabase();
    }

    // Este método se llama al momento en el que se crea la BD
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(TABLE_CREATE);
    }
    // Método que se llama cada vez que se actualiza la BD
    // Sirve para manejar las versiones de la misma
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        Log.w(DataBaseHelper.class.getName(),"Upgrading database from version " + oldVersion + "to" + newVersion + ", " +
                        "which will destroy all old data");
                database.execSQL("DROP TABLE IF EXISTS todo");
        onCreate(database);
    }
}
