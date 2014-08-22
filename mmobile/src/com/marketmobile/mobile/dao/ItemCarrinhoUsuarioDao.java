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
import com.marketmobile.mobile.model.local.ItemCarrinhoUsuario;
import com.marketmobile.mobile.utils.DateTimeUtils;
import com.marketmobile.mobile.utils.LogUtils;
import com.marketmobile.mobile.utils.dao.Dao;

public class ItemCarrinhoUsuarioDao implements Dao<ItemCarrinhoUsuario> {

	private static final String TAG = UsuarioDao.class.getSimpleName();
	private SQLiteDatabase db;  
	private SQLiteStatement insertStatement;
	private static final String TABELA = "carrinho_usuario";
	private static final String INSERT = "INSERT INTO "+ TABELA +" (cid, iditem) VALUES (?,?)";
	private static final String[] COLUNAS =  new String[] {"id","cid","iditem"};
//	private static final int DATABASE_VERSION = 1;

	public ItemCarrinhoUsuarioDao(SQLiteDatabase _db) {
		this.db = _db;
		insertStatement = db.compileStatement(INSERT);
	    
	}

	public long save(ItemCarrinhoUsuario c){  
		
		insertStatement.clearBindings();
		insertStatement.bindLong(1,c.getCid());
		insertStatement.bindLong(2,c.getIditem());
		
		return insertStatement.executeInsert();
    } 
	
	public void update(ItemCarrinhoUsuario c){  
		
		//LogUtils.LogDebug(TAG, "Atualizar Usuario enviada: "+c);
		
		db.beginTransaction();
		try {
	        ContentValues cv = new ContentValues();  
	        cv.put("cid", c.getCid());
	        cv.put("iditem", c.getIditem());
	        
	        db.update(TABELA, cv, "id = ?",  new String[]{ String.valueOf(c.getId())});  
	        db.setTransactionSuccessful();
		} finally {
			db.endTransaction();
		}
    } 
	
	public void delete(long id){  
        db.delete(TABELA, "id = ?", new String[]{ String.valueOf(id) });  
    } 
	
	public ItemCarrinhoUsuario get(long id) {
		ItemCarrinhoUsuario itemCarrinhoUsuario = null;
		Cursor c = null;
		try{
			c = db.rawQuery("select * from item_carrinho_usuario WHERE cid = " + id, null);
			if(c.getCount() >0){
				c.moveToFirst();
				itemCarrinhoUsuario = this.buildItemCarrinhoUsuarioFromCursor(c);
			}
		}catch (Exception e) {
			LogUtils.LogError(TAG,"Erro", e);
		}finally{
			if(c != null && !c.isClosed()){
				c.close();
			}
		}
		
		return itemCarrinhoUsuario;
	}
	
	 
	public List<ItemCarrinhoUsuario> getAll() {
		
		List<ItemCarrinhoUsuario> itensCarrinho = new ArrayList<ItemCarrinhoUsuario>();
		Cursor c =
			db.query(TABELA, COLUNAS,null, null, null, null, "id");
		
		if (c.moveToFirst()) {
			do { 
				ItemCarrinhoUsuario questionario = this.buildItemCarrinhoUsuarioFromCursor(c);
				if (questionario != null) {
					itensCarrinho.add(questionario);
				}
			} while (c.moveToNext()); 
		}
		if (!c.isClosed()) {
			c.close();
		}
		
		return itensCarrinho;
	}
	

	
	private ItemCarrinhoUsuario buildItemCarrinhoUsuarioFromCursor(Cursor c) {  
        
		ItemCarrinhoUsuario itemCarrinho = new ItemCarrinhoUsuario();         
		itemCarrinho.setId(c.getLong(0));
		itemCarrinho.setCid(c.getLong(1));
		itemCarrinho.setIditem(c.getLong(2)); 
		
        return itemCarrinho;  
    }  
	
}
