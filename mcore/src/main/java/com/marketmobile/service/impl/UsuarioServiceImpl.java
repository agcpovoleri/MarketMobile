package com.marketmobile.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marketmobile.common.service.GenericServiceImpl;
import com.marketmobile.dao.UsuarioDao;
import com.marketmobile.model.Usuario;
import com.marketmobile.model.UsuarioLogin;
import com.marketmobile.service.UsuarioService;

@Repository
@Transactional
public class UsuarioServiceImpl extends GenericServiceImpl implements UsuarioService{

	@Autowired
	UsuarioDao usuarioDao;
	
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

	public Usuario findUsuarioByCellphone(String cellphone) {
		
		return usuarioDao.findUsuarioByCellphone(cellphone);
	}

	public void salvarUsuario(Usuario usuario) {
		
//		try{
//			
//			usuario.setSenha(DigestUtils.md5DigestAsHex(usuario.getSenha().getBytes()));
//			save(usuario);
//			if(recuperacaoSenha!=null && recuperacaoSenha.getIdPergunta()!=null){
//				recuperacaoSenha.setLogin(usuario.getLogin());
//				recuperacaoSenhaService.salvarRecuperacaoSenha(recuperacaoSenha);
//			}
//			UsuarioAutorizacao autorizacoes = new UsuarioAutorizacao();
//			autorizacoes.setLogin(usuario.getLogin());
//			autorizacoes.setAutorizacao("ROLE_INTEGRANTE_FUNDO");
//			autorizacoesUsuarioService.salvarAutorizacoesUsuario(autorizacoes);
//			usuarioConfirmacaoService.salvarUsuarioConfirmacao(usuarioConfirmacao);
//		}catch (Exception e) {
//			logger.error("Erro ao tentar salvar usuario: ",e);
//		}
		
	}
	

	
	

}
