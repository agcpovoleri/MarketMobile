package com.marketmobile.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "item")
@SequenceGenerator( name = "id_item_seq", initialValue = 1, sequenceName = "item_id_seq")
public class Item implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "id_item_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;

	@Column(name = "ativo")
	private boolean ativo;

	@Column(name = "overview")
	private String overview;
	
	@Column(name = "customizado")
	private boolean customizado;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_estoque")
	private Estoque estoque;
	
	@OneToMany(mappedBy = "item")  
	private List<ImagemItem> imagens;
	
	@OneToMany(mappedBy = "item")  
	private List<Review> reviews;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="item_produto", 
		joinColumns={
			@JoinColumn(name="id_item")
		},
		inverseJoinColumns={
			@JoinColumn(name="id_produto")
		})
	private List<Produto> produtos;
	
	
	
	@OneToMany(mappedBy = "item")  
	private List<PrecoItem> precos;
	
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	

	public boolean isAtivo() {
		return ativo;
	}

	public List<ImagemItem> getImagens() {
		return imagens;
	}

	public void setImagens(List<ImagemItem> imagens) {
		this.imagens = imagens;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public List<PrecoItem> getPrecos() {
		return precos;
	}

	public void setPrecos(List<PrecoItem> precos) {
		this.precos = precos;
	}

	public boolean isCustomizado() {
		return customizado;
	}

	public void setCustomizado(boolean customizado) {
		this.customizado = customizado;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", nome=" + nome + ", descricao=" + descricao
				+ ", ativo=" + ativo + ", overview=" + overview
				+ ", customizado=" + customizado + ", estoque=" + estoque
				+ ", imagens=" + imagens + ", reviews=" + reviews
				+ ", produtos=" + produtos + ", precos=" + precos + "]";
	}
	
}
