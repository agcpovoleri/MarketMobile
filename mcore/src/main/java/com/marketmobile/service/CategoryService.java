package com.marketmobile.service;

import java.util.List;

import com.marketmobile.common.service.GenericService;
import com.marketmobile.model.vo.CategoriaItemVo;
import com.marketmobile.model.vo.CategoriaVo;

public interface CategoryService extends GenericService{
	
	List<CategoriaVo> findAllVo();
	
	List<CategoriaVo> findAllSuperCategoriesVo();

	List<CategoriaItemVo> findItensByCategoria(Long id);
}
