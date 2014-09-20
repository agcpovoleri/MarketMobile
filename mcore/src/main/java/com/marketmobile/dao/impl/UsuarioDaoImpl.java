package com.marketmobile.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.marketmobile.common.dao.GenericDAOImpl;
import com.marketmobile.dao.UsuarioDao;
import com.marketmobile.model.Usuario;
import com.marketmobile.model.UsuarioLogin;

@Repository
public class UsuarioDaoImpl extends GenericDAOImpl implements UsuarioDao{

	/**
	 * Busca usuario cadastrado com informações de email e senha
	 * Caso não encontrado, Nenhum usuário é retornado
	 */
	public Usuario findUsuarioByEmail(UsuarioLogin usuarioLogin) {
		String query = 
				"select u " +
						"FROM Usuario u INNER JOIN u.usuarioLogin ul  " +
						"WHERE " +
						"ul.email = :email";

		List<String>params = new ArrayList<String>();
		List<Object>paramsObj = new ArrayList<Object>();

		params.add("email");
		paramsObj.add(usuarioLogin.getEmail());

		String[] paramsArray = params.toArray(new String[params.size()]);		
		Object[] paramsObjArray= paramsObj.toArray();

		List<Usuario> usuarios = getHibernateTemplate().findByNamedParam(query, paramsArray, paramsObjArray);
		try {
			if(usuarios.size()>1){
				throw new Exception("Multiplos usuários com mesmo email.");
			}else if(usuarios.size() == 1){
				Usuario usuarioRetorno = usuarios.get(0);
				//usuarioRetorno.setPerfil(findPerfilUsuario(usuarioRetorno.getIdPerfil()));
				return usuarioRetorno;
			}else return null;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * Busca usuário com cellphone correspondente
	 */
	public Usuario findUsuarioByLogin(String login) {

		DetachedCriteria criteria = DetachedCriteria.forClass(UsuarioLogin.class);
		criteria.add(Restrictions.like("login", login ));
		
		UsuarioLogin ulogin = findUnique(criteria);
				
		return ulogin.getUsuario();
	}

	public UsuarioLogin findUsuarioLoginByEmail(String email) {

		DetachedCriteria criteria = DetachedCriteria.forClass(UsuarioLogin.class);
		criteria.add(Restrictions.eq("email", email ));

		return findUnique(criteria);
	}
}
