package com.marketmobile.service;

import java.util.List;

import com.marketmobile.common.service.GenericService;
import com.marketmobile.model.vo.CardapioVo;
import com.marketmobile.model.vo.ItemCardapioVo;

public interface CardapioService extends GenericService{

	public CardapioVo getByIdCardapio(Long idEstabelecimento);

	public List<ItemCardapioVo> getItensCategoriaCardapioByIdCategoria(
			Long idCategoria);
	
}
