package com.marketmobile.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
@SequenceGenerator( name = "id_categoria_seq", initialValue = 1, sequenceName = "categoria_id_seq")
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "id_categoria_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_parent")
    private Categoria parent;
	
	@OneToMany(mappedBy="parent", fetch = FetchType.LAZY)
    private Set<Categoria> subcategorias;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="categoria_item", 
		joinColumns={
			@JoinColumn(name="id_categoria")
		},
		inverseJoinColumns={
			@JoinColumn(name="id_item")
		})
	private Set<Item> itens;
	
	public Set<Item> getItens() {
		return itens;
	}

	public void setItens(Set<Item> itens) {
		this.itens = itens;
	}

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

	public Categoria getParent() {
		return parent;
	}

	public void setParent(Categoria parent) {
		this.parent = parent;
	}

	public Set<Categoria> getSubcategorias() {
		return subcategorias;
	}

	public void setSubcategorias(Set<Categoria> subcategorias) {
		this.subcategorias = subcategorias;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", descricao="
				+ descricao + ", parent=" + parent + ", subcategorias="
				+ subcategorias + ", itens=" + itens + "]";
	}
}
