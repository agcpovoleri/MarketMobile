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
@Table(name = "estabelecimento")
@SequenceGenerator( name = "id_estabelecimento_seq", initialValue = 1, sequenceName = "estabelecimento_id_seq")
public class Estabelecimento implements Serializable{

	@Id
	@GeneratedValue(generator = "id_estabelecimento_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "imagem")
	private String imagem;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "avaliacao")
	private Integer avaliacao;
	
	@Column(name = "id_localizacao")
	private Integer idLocalizacao;
	
	@Column(name = "id_empresa")
	private Integer idEmpresa;
	
	@Column(name = "ativo")
	private Boolean ativo;
	
	@Transient
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "idLocalizacao")
	private Localizacao Localizacao;
	
	@Transient
	private Empresa empresa;
	
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

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Integer getIdLocalizacao() {
		return idLocalizacao;
	}

	public void setIdLocalizacao(Integer idLocalizacao) {
		this.idLocalizacao = idLocalizacao;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Localizacao getLocalizacao() {
		return Localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		Localizacao = localizacao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Estabelecimento [id=" + id + ", nome=" + nome + ", descricao="
				+ descricao + ", imagem=" + imagem + ", telefone=" + telefone
				+ ", avaliacao=" + avaliacao + ", idLocalizacao="
				+ idLocalizacao + ", idEmpresa=" + idEmpresa + ", ativo="
				+ ativo + ", Localizacao=" + Localizacao + ", empresa="
				+ empresa + "]";
	}
	
}
