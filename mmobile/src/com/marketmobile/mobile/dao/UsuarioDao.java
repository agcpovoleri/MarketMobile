package com.marketmobile.mobile.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.marketmobile.mobile.model.local.Usuario;
import com.marketmobile.mobile.utils.dao.Dao;

public class UsuarioDao implements Dao<Usuario>{
	
	private static final String TAG = UsuarioDao.class.getSimpleName();
	private SQLiteDatabase db;  
	private SQLiteStatement insertStatement;
	private static final String TABELA = "usuario";
	private static final String INSERT = "INSERT INTO "+TABELA+" (id, username, email) VALUES (?,?,?)";
	private static final String[] COLUNAS =  new String[] {"id","username","email"};
//	private static final int DATABASE_VERSION = 1;

	public UsuarioDao(SQLiteDatabase _db) {
		this.db = _db;
		//SQLiteHelper dbHelper = new SQLiteHelper(context,"localizador.db", DATABASE_VERSION, SCRIPT_DB_CREATE, SCRIPT_DB_DELETE);  
	    //db = dbHelper.getWritableDatabase();  
		insertStatement = db.compileStatement(INSERT);
	    
	}

	public long save(Usuario c){  
		
		insertStatement.clearBindings();
		
		insertStatement.bindLong(1,c.getId());
		insertStatement.bindString(2,c.getUsername());
		insertStatement.bindString(3,c.getEmail());
		
		return insertStatement.executeInsert();
    } 
	
	public void update(Usuario c){  
		
		//LogUtils.LogDebug(TAG, "Atualizar Usuario enviada: "+c);
		
		db.beginTransaction();
		try {
	        ContentValues cv = new ContentValues();  
	        cv.put("username", c.getUsername());
	        cv.put("email", c.getEmail());
        
	        db.update(TABELA, cv, "id = ?",  new String[]{ String.valueOf(c.getId())});  
	        db.setTransactionSuccessful();
		} finally {
			db.endTransaction();
		}
    } 
	
	public void delete(long id){  
        db.delete(TABELA, "id = ?", new String[]{ String.valueOf(id) });  
    } 
	
	
	public Usuario get(long id) {
		Usuario Usuario = null;
		
		return Usuario;
	}
	
	 
	public List<Usuario> getAll() {
		
		List<Usuario> Usuarios = new ArrayList<Usuario>();
		
		Cursor c = null;
		try {
			c = db.query(TABELA, COLUNAS, null, null, null, null, "id");
			
			if (c.moveToFirst()) {
				do { 
					Usuario Usuario = this.buildUsuarioFromCursor(c);
					if (Usuario != null) {
						Usuarios.add(Usuario);
					}
				} while (c.moveToNext()); 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (c!=null && !c.isClosed()) c.close();
		}
		
		return Usuarios;
	}
	
		
	private Usuario buildUsuarioFromCursor(Cursor c) {  
        
		Usuario usuario = new Usuario();         
        usuario.setId(c.getLong(0));
        usuario.setUsername(c.getString(1)); 
        usuario.setEmail(c.getString(2));
       
        return usuario;  
    }  
    
}
