package com.marketmobile.model.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.marketmobile.model.Categoria;

public class CategoriaVo {

	private Long id;

	private String nome;

	private String descricao;

	private List<CategoriaVo> subcategorias;

	public CategoriaVo(Long id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public CategoriaVo(Long id, String nome, String descricao, List<CategoriaVo> subcategoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.subcategorias = subcategoria;
	}

	public CategoriaVo(Categoria categoria) {

		super();
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
		this.subcategorias = this.createSubcategoriasVo(categoria.getSubcategorias());
	}

	private List<CategoriaVo> createSubcategoriasVo(Set<Categoria> categorias)
	{
		List<CategoriaVo> categoriasVo = null;
		if (categorias != null)
		{
			categoriasVo = new ArrayList<CategoriaVo>();
			for (Categoria categoria : categorias) 
			{
				CategoriaVo catVo = new CategoriaVo(categoria);
				categoriasVo.add(catVo);
			}
		}
		return categoriasVo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<CategoriaVo> getSubcategorias() {
		return subcategorias;
	}

	public void setSubcategorias(List<CategoriaVo> subcategorias) {
		this.subcategorias = subcategorias;
	}

	@Override
	public String toString() {
		return "CategoriaVo [id=" + id + ", nome=" + nome + ", descricao="
				+ descricao + ", subcategorias=" + subcategorias + "]";
	}

}
