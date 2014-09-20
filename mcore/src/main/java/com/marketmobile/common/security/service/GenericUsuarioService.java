package com.marketmobile.common.security.service;

import java.util.List;

import com.marketmobile.common.dao.exception.ServiceException;
import com.marketmobile.common.security.entity.dao.MyUser;

public interface GenericUsuarioService {
	
	void criarUsuario(MyUser user) throws ServiceException;
	
	void alterarSenha(String oldPassword, String newPassword) throws ServiceException;

	void alterarUsuario(MyUser user) throws ServiceException;
	
	void apagarUsuario(String username) throws ServiceException;
	
	List<MyUser> obterTodosUsuarios() throws ServiceException;
	
	MyUser obterUsuario(String username) throws ServiceException;

	boolean existeUsuario(String username) throws ServiceException;
}
