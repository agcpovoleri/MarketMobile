package com.marketmobile.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "item_venda")
@SequenceGenerator( name = "id_item_venda_seq", initialValue = 1, sequenceName = "item_venda_id_seq")
public class ItemVenda implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "id_item_venda_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "id_item")
	private Long idItem;
	
	@Column(name = "id_venda")
	private Long idVenda;
	
	@Column(name= "quantidade")
	private Integer quantidade;
	
	@Transient
	private Item item;
	
	@Transient
	private Venda venda;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public Long getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Long idVenda) {
		this.idVenda = idVenda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	@Override
	public String toString() {
		return "ItemVenda [id=" + id + ", idItem=" + idItem + ", idVenda="
				+ idVenda + ", quantidade=" + quantidade + ", item=" + item
				+ ", venda=" + venda + "]";
	}
	
}
