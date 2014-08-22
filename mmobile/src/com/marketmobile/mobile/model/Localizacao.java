package com.marketmobile.mobile.model;

import java.util.Date;

public class Localizacao {

	private Long id;
	
	private Double coordx;
	
	private Double coordy;
	
	private String logradouro;
	
	private int numero;
	
	private String complemento;
	
	private String bairro;
	
	private String cidade;
	
	private String pais;
	
	private Date timestamp;

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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Localizacao [id=" + id + ", coordx=" + coordx + ", coordy="
				+ coordy + ", logradouro=" + logradouro + ", numero=" + numero
				+ ", complemento=" + complemento + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", pais=" + pais + ", timestamp="
				+ timestamp + "]";
	}

	
	
	
	
}
