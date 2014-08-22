package com.marketmobile.mobile.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.marketmobile.mobile.model.local.CarrinhoUsuario;
import com.marketmobile.mobile.utils.DateTimeUtils;
import com.marketmobile.mobile.utils.LogUtils;
import com.marketmobile.mobile.utils.dao.Dao;

public class CarrinhoUsuarioDao implements Dao<CarrinhoUsuario> {

	private static final String TAG = UsuarioDao.class.getSimpleName();
	private SQLiteDatabase db;  
	private SQLiteStatement insertStatement;
	private static final String TABELA = "carrinho_usuario";
	private static final String INSERT = "INSERT INTO "+ TABELA +" (uid, data_criacao, data_atualizacao) VALUES (?,?,?)";
	private static final String[] COLUNAS =  new String[] {"id","uid","data_criacao","data_atualizacao"};
//	private static final int DATABASE_VERSION = 1;

	public CarrinhoUsuarioDao(SQLiteDatabase _db) {
		this.db = _db;
		insertStatement = db.compileStatement(INSERT);
	    
	}

	public long save(CarrinhoUsuario c){  
		
		insertStatement.clearBindings();
		insertStatement.bindLong(1,c.getUid());
		insertStatement.bindString(2,DateTimeUtils.dateToString(c.getDataCriacao()));
		insertStatement.bindString(3,DateTimeUtils.dateToString(c.getDataCriacao()));
		
		return insertStatement.executeInsert();
    } 
	
	public void update(CarrinhoUsuario c){  
		
		//LogUtils.LogDebug(TAG, "Atualizar Usuario enviada: "+c);
		
		db.beginTransaction();
		try {
	        ContentValues cv = new ContentValues();  
	        cv.put("uid", c.getUid());
	        cv.put("data_criacao", DateTimeUtils.dateToString(c.getDataCriacao()));
	        cv.put("data_atualizacao", DateTimeUtils.dateToString(c.getDataAtualizacao()));
	        
	        db.update(TABELA, cv, "id = ?",  new String[]{ String.valueOf(c.getId())});  
	        db.setTransactionSuccessful();
		} finally {
			db.endTransaction();
		}
    } 
	
	public void delete(long id){  
        db.delete(TABELA, "id = ?", new String[]{ String.valueOf(id) });  
    } 
	
	public CarrinhoUsuario get(long id) {
		CarrinhoUsuario questionario = null;
		Cursor c = null;
		try{
			c = db.rawQuery("select * from carrinho_usuario WHERE uid = " + id, null);
			if(c.getCount() >0){
				c.moveToFirst();
				questionario = this.buildCarrinhoUsuarioFromCursor(c);
			}
		}catch (Exception e) {
			LogUtils.LogError(TAG,"Erro", e);
		}finally{
			if(c != null && !c.isClosed()){
				c.close();
			}
		}
		
		return questionario;
	}
	
	 
	public List<CarrinhoUsuario> getAll() {
		
		List<CarrinhoUsuario> carrinhos = new ArrayList<CarrinhoUsuario>();
		Cursor c =
			db.query(TABELA, COLUNAS,null, null, null, null, "id");
		
		if (c.moveToFirst()) {
			do { 
				CarrinhoUsuario questionario = this.buildCarrinhoUsuarioFromCursor(c);
				if (questionario != null) {
					carrinhos.add(questionario);
				}
			} while (c.moveToNext()); 
		}
		if (!c.isClosed()) {
			c.close();
		}
		
		return carrinhos;
	}
	

	
	private CarrinhoUsuario buildCarrinhoUsuarioFromCursor(Cursor c) {  
        
		CarrinhoUsuario carrinho = new CarrinhoUsuario();         
		carrinho.setId(c.getLong(0));
		carrinho.setUid(c.getLong(1)); 
		try {
			carrinho.setDataCriacao(DateTimeUtils.stringToDate(c.getString(2)));
		} catch (ParseException e) {
			Log.e("DATABASE", "Erro ao efetuar parsing de data:" + c.getString(2), e);
			//e.printStackTrace();
		}
		try {
			carrinho.setDataAtualizacao(DateTimeUtils.stringToDate(c.getString(3)));
		} catch (ParseException e) {
			Log.e("DATABASE", "Erro ao efetuar parsing de data:" + c.getString(3), e);
			//e.printStackTrace();
		}
        
        return carrinho;  
    }  
	
}
