package com.marketmobile.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.marketmobile.common.dao.GenericDAOImpl;
import com.marketmobile.dao.EstabelecimentoDao;
import com.marketmobile.model.Empresa;
import com.marketmobile.model.vo.CategoriaVo;
import com.marketmobile.model.vo.InfoEstabelecimentoVo;

@Repository
public class EstabelecimentoDaoImpl extends GenericDAOImpl implements EstabelecimentoDao{

	public List<CategoriaVo> findAllVo() {
		String query = 
				"select new com.marketmobile.model.vo.EstabelecimentoVo(e.id, e.nome, e.descricao, e.imagem, e.avaliacao) " +
						"FROM Estabelecimento e";

		List<String>params = new ArrayList<String>();
		List<Object>paramsObj = new ArrayList<Object>();

		String[] paramsArray = params.toArray(new String[params.size()]);		
		Object[] paramsObjArray= paramsObj.toArray();

		List<CategoriaVo> estabelecimento =  getHibernateTemplate().findByNamedParam(query, paramsArray, paramsObjArray);


		return estabelecimento;
	}

	public List<CategoriaVo> findByCidade(Long idCidade) {
		// TODO Find Estabelecimento By Cidade

		String query = 
				"select new com.marketmobile.model.vo.EstabelecimentoVo(e.id, e.nome, e.descricao, e.imagem, e.avaliacao) " +
						"FROM Estabelecimento e, Localizacao l, Cidade c " +
						"WHERE " +
						"	e.idLocalizacao = l.id AND " +
						"	l.idCidade = c.id AND " +
						"	c.id = :idCidade ";

		List<String>params = new ArrayList<String>();
		List<Object>paramsObj = new ArrayList<Object>();

		params.add("idCidade");
		paramsObj.add(idCidade);

		String[] paramsArray = params.toArray(new String[params.size()]);		
		Object[] paramsObjArray= paramsObj.toArray();

		List<CategoriaVo> estabelecimento =  getHibernateTemplate().findByNamedParam(query, paramsArray, paramsObjArray);


		return estabelecimento;
	}

	public List<Empresa> findAllEstabelecimentos() {

		String sqlText = "SELECT e "+
				"FROM Empresa e";;

				List<Empresa> empresas = getHibernateTemplate().find(sqlText);
				return empresas;
	}

	public List<Empresa> findByAddress(String address) {
		// TODO findEmpresasByAddress SQL


		return new ArrayList<Empresa>();
	}

	public List<CategoriaVo> filterByPostcode(Long idCidade, Integer postcode) {

		String query = 
				"select new com.marketmobile.model.vo.EstabelecimentoVo(e.id, e.nome, e.descricao, e.imagem, e.avaliacao) " +
						"FROM Estabelecimento e, Localizacao l, Cidade c " +
						"WHERE " +
						"	e.idLocalizacao = l.id AND " +
						"	l.idCidade = c.id AND " +
						"	c.id = :idCidade AND l.postcode = :postcode";

		List<String>params = new ArrayList<String>();
		List<Object>paramsObj = new ArrayList<Object>();

		params.add("idCidade");
		paramsObj.add(idCidade);

		params.add("postcode");
		paramsObj.add(postcode);

		String[] paramsArray = params.toArray(new String[params.size()]);		
		Object[] paramsObjArray= paramsObj.toArray();

		List<CategoriaVo> estabelecimento =  getHibernateTemplate().findByNamedParam(query, paramsArray, paramsObjArray);


		return estabelecimento;

	}

	public InfoEstabelecimentoVo findById(Long idEstabelecimento) {

		String sqlText = "Select new com.marketmobile.model.vo.InfoEstabelecimentoVo(e.id, c.id, e.nome, e.descricao, e.imagem, e1.website, e.telefone) "+
				" FROM Estabelecimento e, Empresa e1, Localizacao l, Cardapio c "+
				" WHERE e.idEmpresa = e1.id AND e.idLocalizacao = l.id AND c.idEstabelecimento = e.id "+
				" AND e.id = :idEstabelecimento";

		List<String>params = new ArrayList<String>();
		List<Object>paramsObj = new ArrayList<Object>();

		params.add("idEstabelecimento");
		paramsObj.add(idEstabelecimento);

		String[] paramsArray = params.toArray(new String[params.size()]);		
		Object[] paramsObjArray= paramsObj.toArray();

		List<InfoEstabelecimentoVo> estabelecimentos =  getHibernateTemplate().findByNamedParam(sqlText, paramsArray, paramsObjArray);
		return estabelecimentos.get(0);
	}

	public List<String> findCategoriasMenuById(Long idEstabelecimento) {
		String sqlText = "Select cc.nome "+
						 "FROM Estabelecimento e, Cardapio c, CategoriaCardapio cc "+ 
						 "WHERE c.idEstabelecimento = e.id AND cc.idCardapio = c.id "+
						 "AND e.id = :idEstabelecimento";

		List<String>params = new ArrayList<String>();
		List<Object>paramsObj = new ArrayList<Object>();

		params.add("idEstabelecimento");
		paramsObj.add(idEstabelecimento);

		String[] paramsArray = params.toArray(new String[params.size()]);		
		Object[] paramsObjArray= paramsObj.toArray();

		List<String> categoriasMenuEstabelecimento =  getHibernateTemplate().findByNamedParam(sqlText, paramsArray, paramsObjArray);
		return categoriasMenuEstabelecimento;
	}

	public List<CategoriaVo> findBy(String string) {
		
		String query = 
				"SELECT DISTINCT new com.marketmobile.model.vo.EstabelecimentoVo(e.id, e.nome, e.descricao, e.imagem, e.avaliacao) " +
						"FROM Estabelecimento e, Empresa e1, Localizacao l, Cardapio c , CategoriaCardapio cc " +
						"WHERE " +
						"	e.idLocalizacao = l.id AND " +
						"	e.idEmpresa = e1.id AND " +
						"	c.idEstabelecimento = e.id AND " +
						"	c.id = cc.idCardapio AND (";
						
		try {
			Integer postcode = Integer.parseInt(string);
			query += "l.postcode = "+postcode+" OR ";
		} catch (NumberFormatException e) {
			
		}
		query +=  "	 l.logradouro	LIKE 	:strSearch OR "+
				  "	 e.nome 		LIKE 	:strSearch OR "+
				  "	 e.descricao 	LIKE 	:strSearch OR "+
				  "	 cc.descricao 	LIKE 	:strSearch)";

		List<String>params = new ArrayList<String>();
		List<Object>paramsObj = new ArrayList<Object>();

		params.add("strSearch");
		paramsObj.add("'%"+string+"%'");

		String[] paramsArray = params.toArray(new String[params.size()]);		
		Object[] paramsObjArray= paramsObj.toArray();

		List<CategoriaVo> estabelecimento =  getHibernateTemplate().findByNamedParam(query, paramsArray, paramsObjArray);


		return estabelecimento;
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

