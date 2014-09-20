package com.marketmobile.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "categoria_cardapio")
@SequenceGenerator( name = "id_categoria_cardapio_seq", initialValue = 1, sequenceName = "categoria_cardapio_id_seq")
public class CategoriaCardapio implements Serializable{

	@Id
	@GeneratedValue(generator = "id_categoria_cardapio_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "id_cardapio")
	private Long idCardapio;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Transient
	private Cardapio cardapio;
	
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

	@Override
	public String toString() {
		return "CategoriaCardapio [id=" + id + ", idCardapio=" + idCardapio
				+ ", nome=" + nome + ", descricao=" + descricao + ", cardapio="
				+ cardapio + "]";
	}

	public Long getIdCardapio() {
		return idCardapio;
	}

	public void setIdCardapio(Long idCardapio) {
		this.idCardapio = idCardapio;
	}

	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	
	
	
}
