package com.marketmobile.model.vo;

import java.util.List;

public class PedidoVo {
	
	private Long idUser;
	
	private String tipoEntrega;
	
	private String cep;
	
	private List<ItemCarrinhoVo> itensPedido;

	public PedidoVo() {
		super();
	}

	public PedidoVo(Long idUser, String tipoEntrega, String cep,
			List<ItemCarrinhoVo> itensPedido) {
		super();
		this.idUser = idUser;
		this.tipoEntrega = tipoEntrega;
		this.cep = cep;
		this.itensPedido = itensPedido;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getTipoEntrega() {
		return tipoEntrega;
	}

	public void setTipoEntrega(String tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public List<ItemCarrinhoVo> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemCarrinhoVo> itensPedido) {
		this.itensPedido = itensPedido;
	}

	@Override
	public String toString() {
		return "PedidoVo [idUser=" + idUser + ", tipoEntrega=" + tipoEntrega
				+ ", cep=" + cep + ", itensPedido=" + itensPedido + "]";
	}
	
	

}
