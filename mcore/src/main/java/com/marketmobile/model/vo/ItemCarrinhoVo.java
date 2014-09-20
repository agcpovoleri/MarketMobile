package com.marketmobile.model.vo;

public class ItemCarrinhoVo {
	
	private Long id;
	
	private boolean customizado;
	
	private Integer quantidade;

	public ItemCarrinhoVo(Long id, boolean customizado, Integer quantidade) {
		super();
		this.id = id;
		this.customizado = customizado;
		this.quantidade = quantidade;
	}

	public ItemCarrinhoVo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isCustomizado() {
		return customizado;
	}

	public void setCustomizado(boolean customizado) {
		this.customizado = customizado;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "ItemCarrinhoVo [id=" + id + ", customizado=" + customizado
				+ ", quantidade=" + quantidade + "]";
	}

	
}
