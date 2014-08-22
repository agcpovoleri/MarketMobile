package com.marketmobile.mobile.utils.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.marketmobile.mobile.dao.CarrinhoUsuarioDao;
import com.marketmobile.mobile.dao.ItemCarrinhoUsuarioDao;
import com.marketmobile.mobile.dao.LocalizacaoUsuarioDao;
import com.marketmobile.mobile.dao.UsuarioDao;

public class DataManager  {
	
	private Context context;
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mmobile.sqlite";
    
    private static final String[] SCRIPT_DB_DELETE = {"DROP TABLE IF EXISTS usuario;",
    												  "DROP TABLE IF EXISTS localizacao_usuario;",
     											   	  "DROP TABLE IF EXISTS carrinho_usuario;",
    												  "DROP TABLE IF EXISTS itens_carrinho_usuario;"};
     											   	  

    private static final String[] SCRIPT_DB_CREATE = {"CREATE TABLE IF NOT EXISTS usuario (" 
    												 + " id LONG PRIMARY KEY,"
													 + " username TEXT,"
													 + " email TEXT);",
													 
													   "CREATE TABLE IF NOT EXISTS localizacao_usuario (" 
													 + " id LONG PRIMARY KEY," 
													 + " uid LONG,"
													 + " data DATETIME,"
													 + " coordx TEXT,"
    												 + " coordy TEXT);",
													 
													   "CREATE TABLE IF NOT EXISTS carrinho_usuario (" 
													 + " id INTEGER PRIMARY KEY," 
													 + " uid LONG,"
													 + " data_criacao INTEGER,"
													 + " data_atualizacao TEXT);",
													 
													  "CREATE TABLE IF NOT EXISTS itens_carrinho_usuario (" 
													 + " id LONG PRIMARY KEY," 
													 + " cid LONG,"
													 + " iditem TEXT);"};
													
    
    private UsuarioDao usuarioDao;
    private LocalizacaoUsuarioDao localizacaoUsuarioDao;
    private CarrinhoUsuarioDao carrinhoUsuarioDao;
    private ItemCarrinhoUsuarioDao itemCarrinhoUsuarioDao;
    	
	public DataManager(Context context) {
		setContext(context);
		dbHelper = new SQLiteHelper(context,DATABASE_NAME, DATABASE_VERSION, SCRIPT_DB_CREATE, SCRIPT_DB_DELETE);
		setDatabase(dbHelper.getWritableDatabase());
	}

	
	public void closeDB() {
		database.close();
	} 
	
	
	
	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}


	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}


	public LocalizacaoUsuarioDao getLocalizacaoUsuarioDao() {
		return localizacaoUsuarioDao;
	}


	public void setLocalizacaoUsuarioDao(LocalizacaoUsuarioDao localizacaoUsuarioDao) {
		this.localizacaoUsuarioDao = localizacaoUsuarioDao;
	}


	public CarrinhoUsuarioDao getCarrinhoUsuarioDao() {
		return carrinhoUsuarioDao;
	}


	public void setCarrinhoUsuarioDao(CarrinhoUsuarioDao carrinhoUsuarioDao) {
		this.carrinhoUsuarioDao = carrinhoUsuarioDao;
	}


	public ItemCarrinhoUsuarioDao getItemCarrinhoUsuarioDao() {
		return itemCarrinhoUsuarioDao;
	}


	public void setItemCarrinhoUsuarioDao(
			ItemCarrinhoUsuarioDao itemCarrinhoUsuarioDao) {
		this.itemCarrinhoUsuarioDao = itemCarrinhoUsuarioDao;
	}


	public Context getContext() {
		return context;
	}


	public void setContext(Context context) {
		this.context = context;
	}


	public SQLiteDatabase getDatabase() {
		return database;
	}


	public void setDatabase(SQLiteDatabase database) {
		this.database = database;
	}


	
	
}
