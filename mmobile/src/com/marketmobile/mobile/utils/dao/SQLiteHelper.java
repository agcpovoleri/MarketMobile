package com.marketmobile.mobile.utils.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    private String[] scriptCreate;
    private String[] scriptDelete;

    public SQLiteHelper(Context ctx, String nomeBd, 
        int versaoBanco, String[] scriptCreate, 
        String[] scriptDelete) {

        super(ctx, nomeBd, null, versaoBanco);
        this.scriptCreate = scriptCreate;
        this.scriptDelete = scriptDelete;
    }

    @Override
	public void onCreate(SQLiteDatabase db) {
    	for (String script : scriptCreate) {
    		db.execSQL(script);
		}
        
    }

    @Override
	public void onUpgrade(SQLiteDatabase db, 
        int oldVersion, int newVersion) {

    	for (String script : scriptDelete) {
    		db.execSQL(script);
    	}
        onCreate(db);
    }
}
