package com.marketmobile.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "imagem_item")
@SequenceGenerator( name = "id_imagem_item_seq", initialValue = 1,sequenceName = "imagem_item_id_seq")
public class ImagemItem {

	@Id
	@GeneratedValue(generator = "id_usuario_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String descricao;
	
	@Column(name = "url")
	private String url;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_item")
	private Item item;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ImagemItem [id=" + id + ", descricao=" + descricao + ", url="
				+ url + ", item=" + item + "]";
	}
	
	
}
