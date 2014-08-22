package com.marketmobile.model;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "pedido")
@SequenceGenerator( name = "id_pedido_seq", initialValue = 1, sequenceName = "pedido_id_seq")
public class Pedido implements Serializable{

	@Id
	@GeneratedValue(generator = "id_pedido_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "id_cliente")
	private Long idCliente;
	
	@Column(name = "data")
	private Date data;
	
	@Column(name = "valor")
	private Double valor;
	
	@Column(name = "valor_valor")
	private Double valorFinal;
	
	@Column(name = "pago")
	private boolean pago;

	@Transient
	private Cliente cliente;

	@Transient
	private List<ItemPedido> itensPedido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", idCliente=" + idCliente + ", data="
				+ data + ", valor=" + valor + ", valorFinal=" + valorFinal
				+ ", pago=" + pago + ", cliente=" + cliente + ", itensPedido="
				+ itensPedido + "]";
	}

	
	
}
