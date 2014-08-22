package com.marketmobile.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "cardapio")
@SequenceGenerator( name = "id_cardapio_seq", initialValue = 1,sequenceName = "cardapio_id_seq")
public class Cardapio implements Serializable{

	@Id
	@GeneratedValue(generator = "id_cardapio_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "id_estabelecimento")
	private Long idEstabelecimento;
	
	@Column(name = "data_atualizacao")
	private Date dataAtualizacao;
	
	@Column(name = "nome")
	private String nome;

	@Transient
	private List<CategoriaCardapio> categorias;
	
	@Transient
	private Estabelecimento estabelecimento;

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

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public List<CategoriaCardapio> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaCardapio> categorias) {
		this.categorias = categorias;
	}

	@Override
	public String toString() {
		return "Cardapio [id=" + id + ", idEstabelecimento="
				+ idEstabelecimento + ", dataAtualizacao=" + dataAtualizacao
				+ ", nome=" + nome + ", categorias=" + categorias
				+ ", estabelecimento=" + estabelecimento + "]";
	}

}
