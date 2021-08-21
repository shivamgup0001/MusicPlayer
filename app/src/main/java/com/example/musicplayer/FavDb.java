package com.example.musicplayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class FavDb extends SQLiteOpenHelper {
    public FavDb(Context context)
    {
        super(context, parameters.DB_NAME,null, parameters.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE "+ parameters.TABLE_NAME + "(" + parameters.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + parameters.KEY_DATA + " TEXT(255)," + parameters.KEY_TITTLE + " TEXT(255)," + parameters.KEY_ALBUM + " TEXT," + parameters.KEY_ARTIST + " TEXT)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addFav(Audio audio)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values =  new ContentValues();
        values.put(parameters.KEY_DATA,audio.getData());
        values.put(parameters.KEY_TITTLE,audio.getTitle());
        values.put(parameters.KEY_ALBUM,audio.getAlbum());
        values.put(parameters.KEY_ARTIST,audio.getArtist());
        db.insert(parameters.TABLE_NAME,null,values);
        db.close();
    }
    public List<Audio> getalldata(){
        List<Audio> favlist = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "SELECT * FROM "+ parameters.TABLE_NAME;
        Cursor cursor = db.rawQuery(select,null);
        if(cursor.moveToFirst())
        {
            do{
                Audio data = new Audio();
                data.setData(cursor.getString(1));
                data.setTitle(cursor.getString(2));
                data.setAlbum(cursor.getString(3));
                data.setArtist(cursor.getString(4));
                favlist.add(data);
            }while(cursor.moveToNext());
        }
        return favlist;
    }

}