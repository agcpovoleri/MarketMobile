package com.marketmobile.model.vo;

public class ItemCardapioVo {
	
	private Long id;
	
	private Long idCategoriaCardapio;
	
	private String imagemItem;
	
	private String nome;
	
	private String descricao;
	
	private boolean customizado;
	
	private Double valor;

	public ItemCardapioVo() {
		super();
	}
	
	public ItemCardapioVo(Long id, Long idCategoriaCardapio, String imagemItem, String nome,
			String descricao, boolean customizado, Double valor) {
		super();
		this.id = id;
		this.idCategoriaCardapio = idCategoriaCardapio;
		this.imagemItem = imagemItem;
		this.nome = nome;
		this.descricao = descricao;
		this.customizado = customizado;
		this.valor = valor;
	}

	
	public Long getIdCategoriaCardapio() {
		return idCategoriaCardapio;
	}

	public void setIdCategoriaCardapio(Long idCategoriaCardapio) {
		this.idCategoriaCardapio = idCategoriaCardapio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImagemItem() {
		return imagemItem;
	}

	public void setImagemItem(String imagemItem) {
		this.imagemItem = imagemItem;
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

	public boolean isCustomizado() {
		return customizado;
	}

	public void setCustomizado(boolean customizado) {
		this.customizado = customizado;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "ItemCardapioVo [id=" + id + ", idCategoriaCardapio=" + idCategoriaCardapio
				+ ", imagemItem=" + imagemItem + ", nome=" + nome
				+ ", descricao=" + descricao + ", customizado=" + customizado
				+ ", valor=" + valor + "]";
	}

}
