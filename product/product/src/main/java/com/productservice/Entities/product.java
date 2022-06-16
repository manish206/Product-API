package com.productservice.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class product {
	@Id
	@Column(name="productId")
	private String productId;
	@Column(name="productName")
	private String productName;
	@Column(name="productType")
	private String productType;
	@Column(name="productCategory")
	private String productCategory;
	@Column(name="productPrice")
	private double productPrice;
	@Column(name="sellerId")
	private String sellerId;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public product(String productId, String productName, String productType, String productCategory,
			double productPrice, String sellerId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.sellerId = sellerId;
	}
	public product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
