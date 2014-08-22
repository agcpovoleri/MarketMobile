package com.marketmobile.mobile.model;

import java.io.Serializable;

public class Empresa implements Serializable{

	private Long id;

	private String nome;
	
	private String descricao;
	
	private String imagem;
	
	private Integer avaliacao;
	
	public Empresa(Long id, String nome, String imagem, int avaliacao) {
		super();
		
		this.id = id;
		this.nome = nome;
		this.imagem = imagem;
		this.avaliacao = avaliacao;
	}

	public Empresa() {
		// TODO Auto-generated constructor stub
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

	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nome=" + nome + ", descricao="
				+ descricao + ", imagem=" + imagem + ", avaliacao=" + avaliacao
				+ "]";
	}
	
	
	
}
