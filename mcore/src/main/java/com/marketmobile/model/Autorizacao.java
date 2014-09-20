package com.marketmobile.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "autorizacao")
@SequenceGenerator( name = "id_autorizacao_seq", initialValue = 1,sequenceName = "autorizacao_id_seq")
public class Autorizacao implements Serializable{

	public static final String ROLE_USER = "ROLE_USER";
	public static final String ROLE_VENDOR = "ROLE_VENDOR";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "id_autorizacao_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@ManyToMany(mappedBy="autorizacoes", targetEntity = UsuarioLogin.class)
    private Set<UsuarioLogin> usuariosLogin = new HashSet<UsuarioLogin>();
	
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
	
	public Set<UsuarioLogin> getUsuariosLogin() {
		return usuariosLogin;
	}

	public void setUsuariosLogin(Set<UsuarioLogin> usuarioLogins) {
		this.usuariosLogin = usuarioLogins;
	}

	@Override
	public String toString() {
		return "Autorizacao [id=" + id + ", nome=" + nome + "]";
	}

}
