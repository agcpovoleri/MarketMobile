package com.marketmobile.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
@SequenceGenerator( name = "id_cliente_seq", initialValue = 1,sequenceName = "cliente_id_seq")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "id_cliente_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "idUsuario")
	private Long idUsuario;
	
	@Column(name = "cpf")
	private String cpf;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="localizacao_cliente", 
		joinColumns={
			@JoinColumn(name="id_cliente")
		},
		inverseJoinColumns={
			@JoinColumn(name="id_localizacao")
		})
	private Set<Localizacao> localizacoes = new HashSet<Localizacao>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Set<Localizacao> getLocalizacoes() {
		return localizacoes;
	}

	public void setLocalizacoes(Set<Localizacao> localizacoes) {
		this.localizacoes = localizacoes;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", idUsuario=" + idUsuario + ", cpf="
				+ cpf + "]";
	}
}
