package com.marketmobile.dao;

import com.marketmobile.model.Usuario;
import com.marketmobile.model.UsuarioLogin;

public interface UsuarioDao {
	
	Usuario findUsuarioByEmail(UsuarioLogin usuarioLogin);
	
	Usuario findUsuarioByCellphone(String cellphone);
	
	UsuarioLogin findUsuarioLoginByEmail(String email);
	
}
