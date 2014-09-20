package com.marketmobile.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "localizacao")
@SequenceGenerator( name = "id_localizacao_seq", initialValue = 1, sequenceName = "localizacao_id_seq")
public class Localizacao implements Serializable{

	@Id
	@GeneratedValue(generator = "id_localizacao_seq", strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "coordx")
	private Double coordx;
	
	@Column(name = "coordy")
	private Double coordy;
	
	@Column(name = "logradouro")
	private String logradouro;
	
	@Column(name = "numero")
	private Integer numero;
	
	@Column(name = "complemento")
	private String complemento;
	
	@Column(name = "bairro")
	private String bairro;
	
	@Column(name = "postcode")
	private Integer postcode;
	
	@Column(name = "id_cidade")
	private Long idCidade;
	
	@Transient
	@ManyToOne(fetch = FetchType.LAZY)
	private Cidade cidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getCoordx() {
		return coordx;
	}

	public void setCoordx(Double coordx) {
		this.coordx = coordx;
	}

	public Double getCoordy() {
		return coordy;
	}

	public void setCoordy(Double coordy) {
		this.coordy = coordy;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Integer getPostcode() {
		return postcode;
	}

	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return "Localizacao [id=" + id + ", coordx=" + coordx + ", coordy="
				+ coordy + ", logradouro=" + logradouro + ", numero=" + numero
				+ ", complemento=" + complemento + ", bairro=" + bairro
				+ ", postcode=" + postcode + ", idCidade=" + idCidade
				+ ", cidade=" + cidade + "]";
	}
	
}
