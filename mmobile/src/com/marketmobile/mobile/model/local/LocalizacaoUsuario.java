package com.marketmobile.mobile.model.local;

import java.util.Date;

public class LocalizacaoUsuario {

	private Long id;
	
	private Long uid;
	
	private Date data;
	
	private String coordx;
	
	private String coordy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCoordx() {
		return coordx;
	}

	public void setCoordx(String coordx) {
		this.coordx = coordx;
	}

	public String getCoordy() {
		return coordy;
	}

	public void setCoordy(String coordy) {
		this.coordy = coordy;
	}

	@Override
	public String toString() {
		return "LocalizacaoUsuario [id=" + id + ", uid=" + uid + ", data="
				+ data + ", coordx=" + coordx + ", coordy=" + coordy + "]";
	}
	
}
