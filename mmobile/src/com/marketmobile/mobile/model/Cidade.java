package com.marketmobile.mobile.model;

import java.io.Serializable;

public class Cidade implements Serializable{

	private Long id;
	
	private String nome;
	
	private Integer quantidadeEmpresa;
	
	public Cidade(Long id, String nome, Integer quantidadeEmpresa) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidadeEmpresa = quantidadeEmpresa;
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

	public Integer getQuantidadeEmpresa() {
		return quantidadeEmpresa;
	}

	public void setQuantidadeEmpresa(Integer quantidadeEmpresa) {
		this.quantidadeEmpresa = quantidadeEmpresa;
	}

	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", quantidadeEmpresa="
				+ quantidadeEmpresa + "]";
	}

	
	
}
