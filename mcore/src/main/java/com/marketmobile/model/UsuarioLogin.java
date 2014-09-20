package com.marketmobile.model;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "usuario_login")
@SequenceGenerator(name = "id_usuario_login_seq", initialValue = 1, sequenceName = "usuario_login_id_seq")
public class UsuarioLogin implements Serializable{
	
	@Id
	@GeneratedValue(generator = "id_usuario_login_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "senha")
	private String senha;
	
	@Column(name = "id_usuario")
	private Long idUsuario;
	
	@Column(name = "first_access")
	private Date firstAccess;
	
	@Column(name = "last_access")
	private Date lastAcess;
	
	@Transient
	@OneToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	
	
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

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "UsuarioLogin [id=" + id + ", email=" + email + ", senha="
				+ senha + ", idUsuario=" + idUsuario + ", firstAcess="
				+ firstAccess + ", lastAccess=" + lastAcess + ", usuario="
				+ usuario + "]";
	}

}
