package com.marketmobile.dao;

import java.util.List;

import com.marketmobile.model.Empresa;
import com.marketmobile.model.vo.CategoriaVo;
import com.marketmobile.model.vo.InfoEstabelecimentoVo;

public interface EstabelecimentoDao{
	
	List<CategoriaVo> filterByPostcode(Long idCidade, Integer postcode);
	
	List<CategoriaVo> findByCidade(Long idCidade);
	
	List<CategoriaVo> findAllVo();
	
	InfoEstabelecimentoVo findById(Long idEstabelecimento);
	
	List<Empresa> findByAddress(String address);
	
	List<Empresa> findAllEstabelecimentos();
		
	List<String> findCategoriasMenuById(Long id);
	
	List<CategoriaVo> findBy(String string);
}
