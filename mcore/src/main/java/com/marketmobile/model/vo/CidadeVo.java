package com.marketmobile.model.vo;

public class CidadeVo {
	
	private Long id;
	
	private String nome;
	
	private Long quantidade;

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

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public CidadeVo(Long id, String nome, Long quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "CidadeVo [id=" + id + ", name=" + nome + ", website="
				+ quantidade + "]";
	}
	
	
}
