package com.marketmobile.dao;

import com.marketmobile.model.Usuario;
import com.marketmobile.model.UsuarioLogin;

public interface UsuarioDao {
	
	Usuario findUsuarioByEmail(UsuarioLogin usuarioLogin);
	
	Usuario findUsuarioByLogin(String login);
	
	UsuarioLogin findUsuarioLoginByEmail(String email);
	
}
