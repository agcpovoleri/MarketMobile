package com.marketmobile.dao;

import java.util.List;

import com.marketmobile.model.Categoria;
import com.marketmobile.model.vo.CategoriaItemVo;
import com.marketmobile.model.vo.CategoriaVo;

public interface CategoriaDao{
	
	List<Categoria> findAll();
	
	List<CategoriaVo> findAllSuperCategoriesVo();
	
	List<CategoriaVo> findAllSubcategoriesVo();

	List<CategoriaItemVo> findItensByCategoria(Long id);
}

