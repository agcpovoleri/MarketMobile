package com.marketmobile.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "item")
@SequenceGenerator( name = "id_item_seq", initialValue = 1, sequenceName = "item_id_seq")
public class Item implements Serializable{

	@Id
	@GeneratedValue(generator = "id_item_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "imagem")
	private String imagem;
	
	@Column(name = "customizado")
	private boolean customizado;

	@Column(name = "valor")
	private Double valor;

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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", nome=" + nome + ", descricao=" + descricao
				+ ", imagem=" + imagem + ", customizado=" + customizado
				+ ", valor=" + valor + "]";
	}

	public boolean isCustomizado() {
		return customizado;
	}

	public void setCustomizado(boolean customizado) {
		this.customizado = customizado;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	
	
}
