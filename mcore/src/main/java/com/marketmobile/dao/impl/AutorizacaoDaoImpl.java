package com.marketmobile.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.marketmobile.common.dao.GenericDAOImpl;
import com.marketmobile.dao.AutorizacaoDao;
import com.marketmobile.model.Autorizacao;
import com.marketmobile.model.Usuario;
import com.marketmobile.model.vo.ItemCardapioVo;

@Repository
public class AutorizacaoDaoImpl extends GenericDAOImpl implements AutorizacaoDao{

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

	public Autorizacao findByRole(String role) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Autorizacao.class);
		
		Criterion cr1 = Restrictions.eq("nome", role);
		criteria.add(cr1);
		
		List<Autorizacao> autorizacoes = getHibernateTemplate().findByCriteria(criteria);
		if (autorizacoes!=null && autorizacoes.size()!=0){
			return autorizacoes.get(0);
		}
		
		return null;
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

