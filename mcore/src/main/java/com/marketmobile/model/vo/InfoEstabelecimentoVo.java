package com.marketmobile.model.vo;

import java.util.List;

public class InfoEstabelecimentoVo {
	
	private Long id;
	
	private Long idCardapio;
	
	private String nome;
	
	private String descricao;
	
	private String imagem;
	
	private Integer avaliacao;
	
	private List<String> categoriasMenu;
	
	private String website;
	
	private String endereco;
	
	private String telefone;

	public InfoEstabelecimentoVo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCardapio() {
		return idCardapio;
	}

	public void setIdCardapio(Long idCardapio) {
		this.idCardapio = idCardapio;
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

	public List<String> getCategoriasMenu() {
		return categoriasMenu;
	}

	public void setCategoriasMenu(List<String> categoriasMenu) {
		this.categoriasMenu = categoriasMenu;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	//(e.id, c.id, e.nome, e.descricao, e.imagem, e1.website, e.telefone)
	public InfoEstabelecimentoVo(
			Long id, 
			Long idCardapio, 
			String nome,
			String descricao, 
			String imagem, 
			String website,
			String telefone) {
		super();
		this.id = id;
		this.idCardapio = idCardapio;
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
		this.website = website;
		this.telefone = telefone;
	}
	
}
