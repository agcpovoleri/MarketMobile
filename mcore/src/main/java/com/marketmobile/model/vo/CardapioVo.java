package com.marketmobile.model.vo;

import java.util.Date;
import java.util.List;

public class CardapioVo {
	
	private Long id;
	
	private String nome;
	
	private Date dataAtualizacao;
	
	private List<CategoriaCardapioVo> categoriasItem;

	public CardapioVo() {
		super();
	}

	public CardapioVo(Long id, String nome, Date dataAtualizacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataAtualizacao = dataAtualizacao;
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

	public List<CategoriaCardapioVo> getCategoriasItem() {
		return categoriasItem;
	}

	public void setCategoriasItem(List<CategoriaCardapioVo> categoriasItem) {
		this.categoriasItem = categoriasItem;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public String toString() {
		return "CardapioVo [id=" + id + ", nome=" + nome + ", dataAtualizacao="
				+ dataAtualizacao + ", categoriasItem=" + categoriasItem + "]";
	}
	
}
