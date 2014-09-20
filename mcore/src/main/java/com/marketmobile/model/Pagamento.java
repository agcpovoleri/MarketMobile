package com.marketmobile.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pagamento")
@SequenceGenerator( name = "id_pagamento_seq", initialValue = 1, sequenceName = "pagamento_id_seq", allocationSize = 1)
public class Pagamento implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "id_pagamento_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private Venda venda;
	
	@Column(name= "comprovante")
	private String comprovante;
		
	@Column(name= "data_realizacao")
	private Date data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", venda=" + venda + ", comprovante="
				+ comprovante + ", data=" + data + "]";
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public String getComprovante() {
		return comprovante;
	}

	public void setComprovante(String comprovante) {
		this.comprovante = comprovante;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
