package com.marketmobile.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.marketmobile.common.dao.GenericDAOImpl;
import com.marketmobile.dao.CategoriaDao;
import com.marketmobile.model.Categoria;
import com.marketmobile.model.vo.CategoriaItemVo;
import com.marketmobile.model.vo.CategoriaVo;

@Repository
public class CategoriaDaoImpl extends GenericDAOImpl implements CategoriaDao{

	public List<Categoria> findAll() {
		String query = 
				"SELECT c " +
				"FROM Categoria c " +
				"LEFT JOIN c.parent cparent " +
				"WHERE c.parent IS null "+
				"ORDER BY c.nome";
		
		List<Categoria> categorias = getHibernateTemplate().find(query);
		return categorias;
	}

	public List<CategoriaVo> findAllSuperCategoriesVo() {

		String query = 
				"SELECT new com.marketmobile.model.vo.CategoriaVo(c.id, c.nome, c.descricao) " +
				"FROM Categoria c " +
				"WHERE c.parent is NULL";
		
		List<CategoriaVo> categorias = getHibernateTemplate().find(query);
		return categorias;
	}
	
	public List<CategoriaVo> findAllSubcategoriesVo() {

		String query = 
				"SELECT new com.marketmobile.model.vo.CategoriaVo(c.id, c.nome, c.descricao) " +
				"FROM Categoria c " +

				"WHERE p.idParent is NOT NULL";
		
		List<CategoriaVo> categorias = getHibernateTemplate().find(query);
		return categorias;
	}

	public List<CategoriaItemVo> findItensByCategoria(Long idCategoria) {
		String query = 
				"SELECT new com.marketmobile.model.vo.CategoriaItemVo(" +
				"	i.id, i.nome, i.imagem, i.preco, i.preco - i.desconto as oldPrice, 5, 42, i.desconto) " +
				"FROM CategoriaItem ci "+
				"INNER JOIN ci.item i "+
				"INNER JOIN ci.categoria c "+
				"WHERE c.id = :idCategoria ";

		List<String>params = new ArrayList<String>();
		List<Object>paramsObj = new ArrayList<Object>();

		params.add("idCategoria");
		paramsObj.add(idCategoria);
		
		String[] paramsArray = params.toArray(new String[params.size()]);		
		Object[] paramsObjArray= paramsObj.toArray();
		
		

		List<CategoriaItemVo> itemsCategoria = getHibernateTemplate().findByNamedParam(query, paramsArray, paramsObjArray);

		return itemsCategoria;
	}

}

