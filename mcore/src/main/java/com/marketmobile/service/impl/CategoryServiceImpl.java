package com.marketmobile.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marketmobile.common.service.GenericServiceImpl;
import com.marketmobile.dao.CategoriaDao;
import com.marketmobile.model.Categoria;
import com.marketmobile.model.vo.CategoriaItemVo;
import com.marketmobile.model.vo.CategoriaVo;
import com.marketmobile.service.CategoryService;

@Repository
@Transactional
public class CategoryServiceImpl extends GenericServiceImpl implements CategoryService{

	@Autowired
	CategoriaDao categoriaDao;

	public List<CategoriaVo> findAllVo() {
		
		List<CategoriaVo> categoriasVo = new ArrayList<CategoriaVo>();
		try {
			for (Categoria categoria : categoriaDao.findAll()) 
			{
				CategoriaVo categoriaVo = new CategoriaVo(categoria);
				categoriasVo.add(categoriaVo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  categoriasVo;
	}

	public List<CategoriaVo> findAllSuperCategoriesVo() {
		
		List<CategoriaVo> superCategories = categoriaDao.findAllSuperCategoriesVo();
		List<CategoriaVo> subCategories = categoriaDao.findAllSuperCategoriesVo();
		return  superCategories;
	}

	public List<CategoriaItemVo> findItensByCategoria(Long id) {
		return categoriaDao.findItensByCategoria(id);
	}

}
