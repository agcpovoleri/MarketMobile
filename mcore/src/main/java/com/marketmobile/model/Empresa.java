<<<<<<< Updated upstream
package com.marketmobile.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Empresa")
@SequenceGenerator( name = "id_empresa_seq", initialValue = 1, sequenceName = "empresa_id_seq")
public class Empresa implements Serializable{

	@Id
	@GeneratedValue(generator = "id_empresa_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cnpj")
	private String cnpj;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "ativo")
	private Boolean ativo;
	
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj
				+ ", website=" + website + ", ativo=" + ativo + "]";
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
}
=======
package com.marketmobile.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Empresa")
@SequenceGenerator( name = "id_empresa_seq", initialValue = 1, sequenceName = "empresa_id_seq")
public class Empresa implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "id_empresa_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cnpj")
	private String cnpj;
	
	@Column(name = "data_criacao")
	private Date dataCriacao;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "ativo")
	private Boolean ativo;
	
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj
				+ ", dataCriacao=" + dataCriacao + ", website=" + website
				+ ", ativo=" + ativo + "]";
	}

}
>>>>>>> Stashed changes
