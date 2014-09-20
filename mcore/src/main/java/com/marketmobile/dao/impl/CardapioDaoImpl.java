package com.marketmobile.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.marketmobile.common.dao.GenericDAOImpl;
import com.marketmobile.dao.CardapioDao;
import com.marketmobile.model.vo.CardapioVo;
import com.marketmobile.model.vo.CategoriaCardapioVo;
import com.marketmobile.model.vo.ItemCardapioVo;

@Repository
public class CardapioDaoImpl extends GenericDAOImpl implements CardapioDao{

	public CardapioVo getInfoByIdCardapio(Long idCardapio) {
		
		String query = "SELECT new com.marketmobile.model.vo.CardapioVo(c.id, c.nome, c.dataAtualizacao) " +
				"FROM Cardapio c  "+
				"WHERE c.id = :idCardapio";
		
		List<String>params = new ArrayList<String>();
		List<Object>paramsObj = new ArrayList<Object>();

		params.add("idCardapio");
		paramsObj.add(idCardapio);

		String[] paramsArray = params.toArray(new String[params.size()]);		
		Object[] paramsObjArray= paramsObj.toArray();
	
		List<CardapioVo> cardapios = getHibernateTemplate().findByNamedParam(query, paramsArray, paramsObjArray);
		if (cardapios!=null) return cardapios.get(0);
		else return null;
	}
	
	public List<CategoriaCardapioVo> getCategoriasByIdCardapio(Long idCardapio) {
		
		String query = "SELECT new com.marketmobile.model.vo.CategoriaCardapioVo(cc.id, cc.nome, cc.descricao) " +
				"FROM Cardapio c, CategoriaCardapio cc "+
				"WHERE cc.idCardapio = c.id AND c.id = :idCardapio";
		
		List<String>params = new ArrayList<String>();
		List<Object>paramsObj = new ArrayList<Object>();

		params.add("idCardapio");
		paramsObj.add(idCardapio);

		String[] paramsArray = params.toArray(new String[params.size()]);		
		Object[] paramsObjArray= paramsObj.toArray();
	
		List<CategoriaCardapioVo> categoriasCardapio = getHibernateTemplate().findByNamedParam(query, paramsArray, paramsObjArray);
		return categoriasCardapio;
	}

	public List<ItemCardapioVo> getItensCategoriaCardapioByIdCategoria(Long idCategoria) {
		String query = "SELECT new com.marketmobile.model.vo.ItemCardapioVo" +
				"(ic.id, cc.id, i.imagem, i.nome, i.descricao, i.customizado, ic.valor) " +
				"FROM CategoriaCardapio cc, ItemCardapio ic, Item i "+
				"WHERE ic.idCategoriaCardapio = cc.id AND ic.idItem = i.id AND cc.id = :idCategoria";
		
		List<String>params = new ArrayList<String>();
		List<Object>paramsObj = new ArrayList<Object>();

		params.add("idCategoria");
		paramsObj.add(idCategoria);

		String[] paramsArray = params.toArray(new String[params.size()]);		
		Object[] paramsObjArray= paramsObj.toArray();
	
		List<ItemCardapioVo> itensCardapioVo = getHibernateTemplate().findByNamedParam(query, paramsArray, paramsObjArray);
		return itensCardapioVo;
	}

	/*
	public List<Amizade> findAmizadesByUsuario(Long idUsuario, List<Long> listaIdUsuarios) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Amizade.class);
		
		Criterion cr1 = Restrictions.eq("idUsuario1", idUsuario);
        Criterion cr2 = Restrictions.in("idUsuario2", listaIdUsuarios.toArray());
        Criterion cr1andCr2 = Restrictions.and(cr1, cr2); 
        
        Criterion cr3 = Restrictions.eq("idUsuario2", idUsuario);
        Criterion cr4 = Restrictions.in("idUsuario1", listaIdUsuarios.toArray());
        Criterion cr3andCr4 = Restrictions.and(cr1, cr2); 
        
        
		criteria.add(Restrictions.or(cr1andCr2, cr3andCr4));
		
		return getHibernateTemplate().findByCriteria(criteria);
		
	}

	*/

}

