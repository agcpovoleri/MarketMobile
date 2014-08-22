package com.marketmobile.model.vo;

public class CategoriaVo {
	
	private Long id;
	
	private String nome;
	
	private String descricao;
	
	private String imagem;
	
	private Integer avaliacao;

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

	public CategoriaVo(Long id, String nome, String descricao,
			String imagem, Integer avaliacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
		this.avaliacao = avaliacao;
	}

	@Override
	public String toString() {
		return "EstabelecimentoVo [id=" + id + ", nome=" + nome
				+ ", descricao=" + descricao + ", imagem=" + imagem
				+ ", avaliacao=" + avaliacao + "]";
	}


	
}
