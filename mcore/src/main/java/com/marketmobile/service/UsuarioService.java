package com.marketmobile.service;

import com.marketmobile.common.service.GenericService;
import com.marketmobile.model.Usuario;
import com.marketmobile.model.UsuarioLogin;

public interface UsuarioService extends GenericService{
	
	Long registrarUsuario(Usuario usuario);
	
	Usuario findUsuarioByEmail(UsuarioLogin usuarioLogin);
	
	Usuario findUsuarioByCellphone(String cellphone);
		
	UsuarioLogin findUsuarioLoginByEmail(String email);

	void salvarUsuario(Usuario usuario);
	
}
