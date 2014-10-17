package com.marketmobile.service;

import java.util.List;

import com.marketmobile.common.service.GenericService;
import com.marketmobile.model.Empresa;
import com.marketmobile.model.vo.CategoriaVo;
import com.marketmobile.model.vo.InfoEstabelecimentoVo;

public interface ProductService extends GenericService{

	public List<CategoriaVo> filtrarByPostcode(Long idCidade, Integer postcode);
	
	public List<CategoriaVo> findAllVo();
	
	public List<CategoriaVo> findByCity(Long idCity);
	
	public List<Empresa> findByAddress(String address);
	
	public InfoEstabelecimentoVo findById(Long idEstabelecimento);
	
	public List<String> findCategoriasMenuById(Long id);
	
	public List<CategoriaVo> findBy(String string);
	
}
