package com.marketmobile.mobile.model;

import java.io.Serializable;
import java.util.List;

public class InfoEmpresa implements Serializable{

	private Long id;

	private Long idEmpresa;
	
	private String nome;
	
	private String descricao;
	
	/**
	 * Categorias de itens vendidos
	 */
	private List<String> itensVendidos;
	
	private List<String> galeriaImagens;
	
	private String website;
	
	private String linkMap;
	
	private String tel;
	
	private Integer avaliacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
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

	public List<String> getItensVendidos() {
		return itensVendidos;
	}

	public void setItensVendidos(List<String> itensVendidos) {
		this.itensVendidos = itensVendidos;
	}

	public List<String> getGaleriaImagens() {
		return galeriaImagens;
	}

	public void setGaleriaImagens(List<String> galeriaImagens) {
		this.galeriaImagens = galeriaImagens;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLinkMap() {
		return linkMap;
	}

	public void setLinkMap(String linkMap) {
		this.linkMap = linkMap;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

	@Override
	public String toString() {
		return "InfoEmpresa [id=" + id + ", idEmpresa=" + idEmpresa + ", nome="
				+ nome + ", descricao=" + descricao + ", itensVendidos="
				+ itensVendidos + ", galeriaImagens=" + galeriaImagens
				+ ", website=" + website + ", linkMap=" + linkMap + ", tel="
				+ tel + ", avaliacao=" + avaliacao + "]";
	}
	
	
	
	
}
