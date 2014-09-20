package com.marketmobile.model;

import java.io.Serializable;
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
@Table(name = "item_pedido")
@SequenceGenerator( name = "id_item_pedido_seq", initialValue = 1, sequenceName = "item_pedido_id_seq")
public class ItemPedido implements Serializable{

	@Id
	@GeneratedValue(generator = "id_item_pedido_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "id_pedido")
	private Long idPedido;
	
	@Column(name = "id_categoria")
	private Long idCategoria;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "imagem")
	private String imagem;
	
	@Column(name = "valor")
	private Double valor;
	
	@Transient
	private Pedido pedido;
	
	@Transient
	private Categoria categoria;
	
	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", idPedido=" + idPedido
				+ ", idCategoria=" + idCategoria + ", nome=" + nome
				+ ", descricao=" + descricao + ", imagem=" + imagem
				+ ", valor=" + valor + ", pedido=" + pedido + ", categoria="
				+ categoria + "]";
	}
	
}
