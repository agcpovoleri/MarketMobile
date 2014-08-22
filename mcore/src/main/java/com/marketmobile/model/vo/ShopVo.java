package com.marketmobile.model.vo;

public class ShopVo {
	
	private Long id;
	
	private String name;
	
	private String website;

	public ShopVo() {
		// TODO Auto-generated constructor stub
	}
	
	public ShopVo(Long id, String name, String website) {
		super();
		this.id = id;
		this.name = name;
		this.website = website;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "ShopVo [id=" + id + ", name=" + name + ", website=" + website
				+ "]";
	}

	
	
	
}
