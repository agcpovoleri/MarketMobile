package com.marketmobile.model.usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="usuario_autorizacao")
@SequenceGenerator( name = "id_usuario_autorizacao_seq", initialValue = 1,sequenceName = "usuario_autorizacao_id_seq")
public class UsuarioAutorizacao  implements Serializable{

	private static final long serialVersionUID = -761192908083954925L;

	@Id
	@GeneratedValue(generator = "id_usuario_autorizacao_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "id_usuario")
	private Integer idUsuario;
	
	@Column(name = "id_autorizacao")
	private Integer idAutorizacao;
	
	public UsuarioAutorizacao(Integer id, Integer idUsuario,
			Integer idAutorizacao) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.idAutorizacao = idAutorizacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdAutorizacao() {
		return idAutorizacao;
	}

	public void setIdAutorizacao(Integer idAutorizacao) {
		this.idAutorizacao = idAutorizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((idAutorizacao == null) ? 0 : idAutorizacao.hashCode());
		result = prime * result
				+ ((idUsuario == null) ? 0 : idUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioAutorizacao other = (UsuarioAutorizacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idAutorizacao == null) {
			if (other.idAutorizacao != null)
				return false;
		} else if (!idAutorizacao.equals(other.idAutorizacao))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}
	
	
}
