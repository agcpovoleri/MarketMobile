package com.marketmobile.model.vo;

import java.util.ArrayList;
import java.util.List;

public class CategoriaCardapioVo {

	
	private Long id;
	
	private String nome;
	
	private String descricao;
	
	//private List<ItemCardapioVo> items;

	public CategoriaCardapioVo(Long id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		//this.items = new ArrayList<ItemCardapioVo>();
	}

	public CategoriaCardapioVo() {
		super();
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

//	public List<ItemCardapioVo> getItems() {
//		return items;
//	}
//
//	public void setItems(List<ItemCardapioVo> items) {
//		this.items = items;
//	}

	@Override
	public String toString() {
		return "CategoriaCardapioVo [id=" + id + ", nome=" + nome
				+ ", descricao=" + descricao + "]";
	}

		
}
