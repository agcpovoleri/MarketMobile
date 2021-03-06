package com.marketmobile.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_login")
@SequenceGenerator(name = "id_usuario_login_seq", initialValue = 1, sequenceName = "usuario_login_id_seq")
public class UsuarioLogin implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "id_usuario_login_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "login")
	private String login;

	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String senha;

	@Column(name = "first_access")
	private Date firstAccess;

	@Column(name = "last_access")
	private Date lastAcess;

	@Column(name = "is_ativo")
	private Boolean isAtivo;

	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private Usuario usuario;

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="usuario_login_autorizacao", 
		joinColumns={
			@JoinColumn(name="id_usuario_login")
		},
		inverseJoinColumns={
			@JoinColumn(name="id_autorizacao")
		})
	private Set<Autorizacao> autorizacoes = new HashSet<Autorizacao>();

	public Date getFirstAccess() {
		return firstAccess;
	}

	public void setFirstAccess(Date firstAccess) {
		this.firstAccess = firstAccess;
	}

	public Date getLastAcess() {
		return lastAcess;
	}

	public void setLastAcess(Date lastAcess) {
		this.lastAcess = lastAcess;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public Set<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}

	public void setAutorizacoes(Set<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}

	@Override
	public String toString() {
		return "UsuarioLogin [id=" + id + ", username=" + login + ", email="
				+ email + ", senha=" + senha + ", firstAccess=" + firstAccess
				+ ", lastAcess=" + lastAcess + ", isAtivo=" + isAtivo
				+ ", usuario=" + usuario + "]";
	}
}
