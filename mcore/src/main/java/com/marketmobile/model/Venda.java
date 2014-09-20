package com.marketmobile.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "venda")
@SequenceGenerator( name = "id_venda_seq", initialValue = 1, sequenceName = "venda_id_seq")
public class Venda implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "id_venda_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "id_cliente")
	private Long idCliente;
	
	@Column(name = "data")
	private Date data;
	
	@Column(name = "valor_desconto")
	private Double valorDesconto;
	
	@Column(name = "valor_final")
	private Double valorFinal;
	
	@Column(name = "pago")
	private boolean pago;

	@OneToOne(fetch = FetchType.EAGER)
	private Pagamento pagamento;
	
	@Transient
	private Cliente cliente;

	@Transient
	private List<ItemVenda> itensVenda;

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

	public Double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(Double valorDesconto) {
		this.valorDesconto = valorDesconto;
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

	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", idCliente=" + idCliente + ", data="
				+ data + ", valorDesconto=" + valorDesconto + ", valorFinal="
				+ valorFinal + ", pago=" + pago + ", pagamento=" + pagamento
				+ ", cliente=" + cliente + ", itensVenda=" + itensVenda + "]";
	}

}
