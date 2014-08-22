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

import org.hibernate.cache.ReadWriteCache.Item;

@Entity
@Table(name = "item_cardapio")
@SequenceGenerator( name = "id_item_cardapio_seq", initialValue = 1,sequenceName = "item_cardapio_id_seq")
public class ItemCardapio implements Serializable{

	@Id
	@GeneratedValue(generator = "id_item_cardapio_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "id_categoria_cardapio")
	private Long idCategoriaCardapio;
	
	@Column(name = "id_item")
	private Long idItem;
	
	@Column(name="valor")
	private Double valor;

	@Transient
	private CategoriaCardapio categoriaCardapio;
	
	@Transient
	private Item Item;

	public ItemCardapio() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCategoriaCardapio() {
		return idCategoriaCardapio;
	}

	public void setIdCategoriaCardapio(Long idCategoriaCardapio) {
		this.idCategoriaCardapio = idCategoriaCardapio;
	}

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public CategoriaCardapio getCategoriaCardapio() {
		return categoriaCardapio;
	}

	public void setCategoriaCardapio(CategoriaCardapio categoriaCardapio) {
		this.categoriaCardapio = categoriaCardapio;
	}

	public Item getItem() {
		return Item;
	}

	public void setItem(Item item) {
		Item = item;
	}

	@Override
	public String toString() {
		return "ItemCardapio [id=" + id + ", idCategoriaCardapio="
				+ idCategoriaCardapio + ", idItem=" + idItem + ", valor="
				+ valor + ", categoriaCardapio=" + categoriaCardapio
				+ ", Item=" + Item + "]";
	}

	
}
