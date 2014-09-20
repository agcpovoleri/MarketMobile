package com.marketmobile.dao;

import java.util.List;

import com.marketmobile.model.vo.CardapioVo;
import com.marketmobile.model.vo.CategoriaCardapioVo;
import com.marketmobile.model.vo.ItemCardapioVo;

public interface CardapioDao {
	
	CardapioVo getInfoByIdCardapio(Long idCardapio);
	
	List<CategoriaCardapioVo> getCategoriasByIdCardapio(Long idCardapio);
	
	List<ItemCardapioVo> getItensCategoriaCardapioByIdCategoria(Long idCategoria);
	
}
