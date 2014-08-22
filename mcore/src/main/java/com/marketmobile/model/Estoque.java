package com.marketmobile.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "estoque")
@SequenceGenerator( name = "id_estoque_seq", initialValue = 1, sequenceName = "estoque_id_seq")
public class Estoque implements Serializable{

	@Id
	@GeneratedValue(generator = "id_estoque_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "id_estabelecimento")
	private Long idEstabelecimento;
	
	@Column(name = "id_produto")
	private Long idProduto;
	
	@Column(name = "quantidade")
	private Integer quantidade;
	
	@Transient
	private Estabelecimento estabelecimento;
	
	@Transient
	private Produto produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdEstabelecimento() {
		return idEstabelecimento;
	}

	public void setIdEstabelecimento(Long idEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", idEstabelecimento=" + idEstabelecimento
				+ ", idProduto=" + idProduto + ", quantidade=" + quantidade
				+ ", estabelecimento=" + estabelecimento + ", produto="
				+ produto + "]";
	}

	
}