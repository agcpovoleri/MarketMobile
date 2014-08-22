package com.marketmobile.mobile.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.marketmobile.mobile.model.local.LocalizacaoUsuario;
import com.marketmobile.mobile.utils.DateTimeUtils;
import com.marketmobile.mobile.utils.LogUtils;
import com.marketmobile.mobile.utils.dao.Dao;

public class LocalizacaoUsuarioDao implements Dao<LocalizacaoUsuario>{
	
	private static final String TAG = LocalizacaoUsuarioDao.class.getSimpleName();
	
	private SQLiteDatabase db;  
	private SQLiteStatement insertStatement;
	private static final String TABELA = "localizacao_usuario";
	private static final String INSERT = "INSERT INTO "+TABELA+" (id, uid, data, coordx, coordy) VALUES (?,?,?,?,?)";
	private static final String[] COLUNAS =  new String[] {"id","uid","data","coordx","coordy"};
//	private static final int DATABASE_VERSION = 1;

	public LocalizacaoUsuarioDao(SQLiteDatabase _db) {
		this.db = _db;
		//SQLiteHelper dbHelper = new SQLiteHelper(context,"localizador.db", DATABASE_VERSION, SCRIPT_DB_CREATE, SCRIPT_DB_DELETE);  
	    //db = dbHelper.getWritableDatabase();  
		insertStatement = db.compileStatement(INSERT);
	    
	}
	
	
	/*public void closeDB() {
		db.close();
	}*/

	public long save(LocalizacaoUsuario c){  
		//DecimalFormat df = new DecimalFormat("#.0000000");
		insertStatement.clearBindings();
		insertStatement.bindLong(1,c.getUid());
		insertStatement.bindString(2,DateTimeUtils.dateToString(c.getData()));
		insertStatement.bindString(3,c.getCoordx());
		insertStatement.bindString(4,c.getCoordy());
	
		return insertStatement.executeInsert();
    } 
	
	public void update(LocalizacaoUsuario c){  
		
		LogUtils.LogDebug(TAG, "Atualizar Coordenada enviada: "+c);
		
		db.beginTransaction();
		try {
	        ContentValues cv = new ContentValues();  
	        cv.put("uid", c.getUid());  
	        cv.put("data", DateTimeUtils.dateToString(c.getData()));  
	        cv.put("coordx", c.getCoordx());
	        cv.put("coordy", c.getCoordy());
	        db.update(TABELA, cv, "id = ?", new String[]{ String.valueOf(c.getId())});  
	         db.setTransactionSuccessful();
		} finally {
			db.endTransaction();
		}
    } 
	
	public void delete(long id){  
        db.delete(TABELA, "id = ?", new String[]{ String.valueOf(id) });  
    } 
	
	public void deleteCoordenadasEnviadas(){  
		
		String whereClause = "data_envio is not null";
		String[] whereArgs = null; 
		
		db.beginTransaction();
		try {
			db.delete(TABELA, whereClause ,whereArgs);  
			db.setTransactionSuccessful();
		} finally {
			db.endTransaction();
		}
    }
	
	public LocalizacaoUsuario get(long id) {
		LocalizacaoUsuario localizacao = null;
		
		return localizacao;
	}
	
	 
	public List<LocalizacaoUsuario> getAll() {
		
		List<LocalizacaoUsuario> localizacoes = new ArrayList<LocalizacaoUsuario>();
		Cursor c = db.query(TABELA, COLUNAS,null, null, null, null, null, "id");
		
		if (c.moveToLast()) {
			do { 
				
				LocalizacaoUsuario localizacao = this.buildLocalizacaoFromCursor(c);
				if (localizacao != null) {
					localizacoes.add(localizacao);
				}
			} while (c.moveToNext()); 
		}
		if (!c.isClosed()) {
			c.close();
		}
		
		return localizacoes;
	}
	
	private LocalizacaoUsuario buildLocalizacaoFromCursor(Cursor c) {  
       
		LocalizacaoUsuario localizacao = new LocalizacaoUsuario();         
        
        localizacao.setId(c.getLong(0));
        localizacao.setUid(c.getLong(1));
        try {
        	localizacao.setData(DateTimeUtils.stringToDate(c.getString(2)));
        } catch (ParseException pe) {
        	Log.e("DATABASE", "Erro ao efetuar parsing de data:" + c.getString(2),pe);
        }
        localizacao.setCoordx(c.getString(3));
        localizacao.setCoordy(c.getString(4));
        return localizacao;  
    }


	
    
}
