package com.marketmobile.model.vo;


public class CategoriaItemVo {

	private Long id;

	private String nome;

	private String descricao;

	private String imagem;
	
	private Double oldPrice;
	
	private Double newPrice;
	
	private int reviews;
	
	private int ratings;
	
	private Double discount;

	public CategoriaItemVo() {
		// TODO Auto-generated constructor stub
	}
	
	public CategoriaItemVo(
			Long id, 
			String nome, String imagem, Double oldPrice, Double newPrice,
			int reviews, int ratings, Double discount) {
		super();
		this.id = id;
		this.nome = nome;
		this.imagem = imagem;
		this.oldPrice = oldPrice;
		this.newPrice = newPrice;
		this.reviews = reviews;
		this.ratings = ratings;
		this.discount = discount;
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

	public Double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(Double oldPrice) {
		this.oldPrice = oldPrice;
	}


	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	
	public Double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(Double newPrice) {
		this.newPrice = newPrice;
	}

	public int getReviews() {
		return reviews;
	}

	public void setReviews(int reviews) {
		this.reviews = reviews;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}


	
}
