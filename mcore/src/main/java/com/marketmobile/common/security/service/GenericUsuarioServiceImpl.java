package com.marketmobile.common.security.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marketmobile.common.dao.exception.ServiceException;
import com.marketmobile.common.security.dao.MyJdbcUserDetailsManager;
import com.marketmobile.common.security.entity.dao.MyUser;
import com.marketmobile.common.service.GenericServiceImpl;


@Repository
@Transactional
public class GenericUsuarioServiceImpl implements GenericUsuarioService {
	private Logger logger = org.slf4j.LoggerFactory.getLogger(GenericUsuarioServiceImpl.class);

    @Autowired
    @Qualifier("jdbcUserService")
    MyJdbcUserDetailsManager userManager;

	public void alterarSenha(String oldPassword, String newPassword) throws ServiceException {
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		try {
			userManager.changePassword(oldPassword, newPassword);
		} catch (Exception e) {
			logger.error("Erro ao alterar senha do usuario:" + currentUser.getPrincipal(),e);
			throw new ServiceException("Erro ao alterar senha do usuario:" + currentUser.getPrincipal(),e);
		}

	}

	public void alterarUsuario(MyUser user) throws ServiceException {
		try {
			userManager.updateUser(user);
		} catch (Exception e) {
			logger.error("Erro ao alterar usuario:" + user,e);
			throw new ServiceException("Erro ao alterar usuario:" + user,e);
		}

	}


	public void apagarUsuario(String username) throws ServiceException {
		try {
			userManager.deleteUser(username);
		} catch (Exception e) {
			logger.error("Erro ao apagar usuario:" + username,e);
			throw new ServiceException("Erro ao apagar usuario:" + username,e);
		}

	}

	public void criarUsuario(MyUser user) throws ServiceException {
		try {
			userManager.createUser(user);
		} catch (Exception e) {
			logger.error("Erro ao criar usuario:" + user,e);
			throw new ServiceException("Erro ao criar usuario:" + user,e);
		}

	}


	@Transactional(readOnly=true)
	public List<MyUser> obterTodosUsuarios() throws ServiceException {
		List<MyUser> usuarios = new ArrayList<MyUser>();
		try {
			usuarios = userManager.loadAllUsers();
		} catch (Exception e) {
			logger.error("Erro ao obter usuarios",e);
			throw new ServiceException("Erro ao obter usuarios", e);
		}
		return usuarios;
	}


	@Transactional(readOnly=true)
	public MyUser obterUsuario(String username) throws ServiceException {
		MyUser usuario = null;
		try {
			usuario = (MyUser) userManager.loadUserByUsername(username);
		} catch (Exception e) {
			logger.error("Erro ao obter usuario:" + username,e);
			throw new ServiceException("Erro ao obter usuario:" + username,e);
		}

		return usuario;
	}

	public boolean existeUsuario(String username) throws ServiceException {
		boolean existe = false;
		try {
			existe =  userManager.userExists(username);
		} catch (Exception e) {
			logger.error("Erro ao verificar existencia de usuario:" + username,e);
			throw new ServiceException("Erro ao verificar existencia de usuario:" + username,e);
		}
		return existe;
	}


}
