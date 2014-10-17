package com.marketmobile.controller.beans;

public class ProductVo{
	
	private Integer id;
	
	private String name;
	
	private String oldPrice;
	
	private String price;
	
	private boolean isAvailable;
	
	private String status;
	
	private String brand;
	
	private String overview;
	
	private String description;
	
	private String review;
	
	private String additionalInfo;
	
	private String video;

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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return "ProductVo [id=" + id + ", name=" + name + ", oldPrice="
				+ oldPrice + ", price=" + price + ", isAvailable="
				+ isAvailable + ", status=" + status + ", brand=" + brand
				+ ", overview=" + overview + ", description=" + description
				+ ", review=" + review + ", additionalInfo=" + additionalInfo
				+ ", video=" + video + "]";
	}

}
