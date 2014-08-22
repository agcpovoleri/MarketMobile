package com.marketmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marketmobile.common.service.GenericServiceImpl;
import com.marketmobile.dao.EstabelecimentoDao;
import com.marketmobile.model.Empresa;
import com.marketmobile.model.vo.CategoriaVo;
import com.marketmobile.model.vo.InfoEstabelecimentoVo;
import com.marketmobile.service.EstabelecimentoService;

@Repository
@Transactional
public class EstabelecimentoServiceImpl extends GenericServiceImpl implements EstabelecimentoService{

	@Autowired
	EstabelecimentoDao estabelecimentoDao;

	public List<CategoriaVo> findByCity(Long idCity){
		
		return estabelecimentoDao.findByCidade(idCity);
	}
	
	public List<Empresa> findByAddress(String address){
		
		if (address.trim()!=""){
			return estabelecimentoDao.findByAddress(address);
		}else 
			return estabelecimentoDao.findAllEstabelecimentos();
	}

	public List<CategoriaVo> filtrarByPostcode(Long idCidade, Integer postcode) {
		return estabelecimentoDao.filterByPostcode(idCidade, postcode);
	}

	public InfoEstabelecimentoVo findById(Long idEstabelecimento) {
		
		return estabelecimentoDao.findById(idEstabelecimento);
	}

	public List<CategoriaVo> findAllVo() {
		
		return estabelecimentoDao.findAllVo();
	}

	public List<String> findCategoriasMenuById(Long id) {
		return estabelecimentoDao.findCategoriasMenuById( id);
	}

	public List<CategoriaVo> findBy(String string) {
		return estabelecimentoDao.findBy(string);
	}
	
	
}
