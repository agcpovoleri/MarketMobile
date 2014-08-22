package com.marketmobile.mobile.model.local;

public class ItemCarrinhoUsuario {
	
	private Long id;
	
	private Long cid;
	
	private Long iditem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getIditem() {
		return iditem;
	}

	public void setIditem(Long iditem) {
		this.iditem = iditem;
	}

	@Override
	public String toString() {
		return "ItemCarrinhoUsuario [id=" + id + ", cid=" + cid + ", iditem="
				+ iditem + "]";
	}
	
	
}
