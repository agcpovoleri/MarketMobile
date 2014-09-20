package com.marketmobile.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "estoque")
@SequenceGenerator( name = "id_estoque_seq", initialValue = 1, sequenceName = "estoque_id_seq")
public class Estoque implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "id_estoque_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "id_produto")
	private Long idProduto;

	@Column(name = "quantidade")
	private Integer quantidade;
	
	@Transient
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_empresa")
	private Empresa empresa;
	
	@Transient
	private Produto produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", idProduto=" + idProduto
				+ ", quantidade=" + quantidade + ", empresa=" + empresa
				+ ", produto=" + produto + "]";
	}
}
