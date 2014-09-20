<<<<<<< Updated upstream
package com.marketmobile.dao;

import com.marketmobile.model.Usuario;
import com.marketmobile.model.UsuarioLogin;

public interface UsuarioDao {
	
	Usuario findUsuarioByEmail(UsuarioLogin usuarioLogin);
	
	Usuario findUsuarioByCellphone(String cellphone);
	
	UsuarioLogin findUsuarioLoginByEmail(String email);
	
}
=======
package com.marketmobile.dao;

import com.marketmobile.model.Usuario;
import com.marketmobile.model.UsuarioLogin;

public interface UsuarioDao {
	
	Usuario findUsuarioByEmail(UsuarioLogin usuarioLogin);
	
	Usuario findUsuarioByLogin(String login);
	
	UsuarioLogin findUsuarioLoginByEmail(String email);
	
}
>>>>>>> Stashed changes
