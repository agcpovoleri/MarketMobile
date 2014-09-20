package com.marketmobile.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marketmobile.common.service.GenericServiceImpl;
import com.marketmobile.dao.AutorizacaoDao;
import com.marketmobile.dao.UsuarioDao;
import com.marketmobile.model.Autorizacao;
import com.marketmobile.model.Usuario;
import com.marketmobile.model.UsuarioLogin;
import com.marketmobile.service.UsuarioService;

@Repository
@Transactional
public class UsuarioServiceImpl extends GenericServiceImpl implements UsuarioService{

	@Autowired
	UsuarioDao usuarioDao;
	
	@Autowired
	AutorizacaoDao autorizacaoDao;
	
	@Autowired
	UserDetailsManager userDetailsManager;
	
	public Long registrarUsuario(Usuario usuario) {
		
		/*
		Perfil perfilUsuario = usuario.getPerfil();
		save(perfilUsuario);
		
		UsuarioLogin usuarioLogin = usuario.getUsuarioLogin();
		save(usuarioLogin);
		
		usuario.setIdPerfil(perfilUsuario.getId());
		usuario.setIdUsuarioLogin(usuarioLogin.getId());
		save(usuario);
		
		return usuario.getId();
		*/
		return null;
	}

	

	public Usuario findUsuarioByEmail(UsuarioLogin usuarioLogin) {
		
		return usuarioDao.findUsuarioByEmail(usuarioLogin); 
	}

	public UsuarioLogin findUsuarioLoginByEmail(String email) {
		
		return usuarioDao.findUsuarioLoginByEmail(email); 
	}

	public void salvarUsuario(final Usuario usuario) {
		
		try{
			
			Set<Autorizacao> autorizacoesUser = new HashSet<Autorizacao>();
			Autorizacao authUser = autorizacaoDao.findByRole(Autorizacao.ROLE_USER);
			if (authUser != null){
				autorizacoesUser.add(authUser);
			}
			
			UsuarioLogin usuarioLogin = usuario.getUsuarioLogin();
			usuarioLogin.setAutorizacoes(autorizacoesUser);
			
			save(usuario);
			
			
		}catch (Exception e) {
			e.printStackTrace();
			//logger.error("Erro ao tentar salvar usuario: ",e);
		}
		
	}

	public Usuario findUsuarioByLogin(String login) {
		return usuarioDao.findUsuarioByLogin(login);
	}
}
