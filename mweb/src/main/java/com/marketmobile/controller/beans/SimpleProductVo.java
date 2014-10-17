package com.marketmobile.controller.beans;

public class SimpleProductVo {
	
	private Integer id;
	
	private String name;
	
	private String oldPrice;
	
	private String price;
	
	private boolean isAvailable;
	
	private String status;
	
	@Override
	public String toString() {
		return "SimpleProductVo [id=" + id + ", name=" + name + ", oldPrice="
				+ oldPrice + ", price=" + price + ", isAvailable="
				+ isAvailable + ", status=" + status + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(String oldPrice) {
		this.oldPrice = oldPrice;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
