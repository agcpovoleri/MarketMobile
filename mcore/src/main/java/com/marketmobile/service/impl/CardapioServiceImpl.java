package com.marketmobile.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marketmobile.common.service.GenericServiceImpl;
import com.marketmobile.dao.CardapioDao;
import com.marketmobile.model.Cardapio;
import com.marketmobile.model.vo.CardapioVo;
import com.marketmobile.model.vo.CategoriaCardapioVo;
import com.marketmobile.model.vo.ItemCardapioVo;
import com.marketmobile.service.CardapioService;



@Repository
@Transactional
public class CardapioServiceImpl extends GenericServiceImpl implements CardapioService{

	@Autowired
	CardapioDao cardapioDao;

	public CardapioVo getByIdCardapio(Long idCardapio) {
		
		Cardapio cardapio = load(Cardapio.class, idCardapio);
		
		CardapioVo cardapioVo = new CardapioVo(cardapio.getId(), cardapio.getNome(), cardapio.getDataAtualizacao());
		cardapioVo.setCategoriasItem(cardapioDao.getCategoriasByIdCardapio(idCardapio));
		
		//get items
//		List<ItemCardapioVo> itens = cardapioDao.getItensByCardapio(idCardapio);
//		
//		HashMap<Long, CategoriaCardapioVo> hash = new HashMap<Long, CategoriaCardapioVo>();
//		for (CategoriaCardapioVo categoria : cardapioVo.getCategoriasItem()) {
//			hash.put(categoria.getId(), categoria);
//		}
//		
//		for (ItemCardapioVo itemCardapioVo : itens) {
//			if (hash.get(itemCardapioVo.getIdCategoriaCardapio())!=null){
//				hash.get(itemCardapioVo.getIdCategoriaCardapio()).getItems().add(itemCardapioVo);
//			}
//			
//		}
		return cardapioVo;
	}

	public List<ItemCardapioVo> getItensCategoriaCardapioByIdCategoria(Long idCategoria) {
		
		return cardapioDao.getItensCategoriaCardapioByIdCategoria(idCategoria);
	}

		

}
