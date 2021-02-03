package com.example.productcomparison.model.ProductsEcomm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table
public class ProductsEcomm {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;

	@Column(name = "productId")
	String productId;

	@Column(name = "productName")
	String productName;

	@Column(name = "productPrice")
	String productPrice;

	@Column(name = "productDiscountedPrice")
	String productDiscountedPrice;

	@Column(name = "category")
	String category;
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "source")
	String source;

	public ProductsEcomm(Integer id, String productId, String productName, String productPrice,
			String productDiscountedPrice, String category,String source) {
		super();
		this.id = id;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDiscountedPrice = productDiscountedPrice;
		this.category = category;
		this.source=source;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDiscountedPrice() {
		return productDiscountedPrice;
	}

	public void setProductDiscountedPrice(String productDiscountedPrice) {
		this.productDiscountedPrice = productDiscountedPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ProductsEcomm() {
	}

	public static String created(HttpStatus CREATED) {
		// TODO Auto-generated method stub
		final String successCode = "201";
		return successCode;
	}

	public static String updated(HttpStatus CREATED) {
		// TODO Auto-generated method stub
		final String successCode = "204";
		return successCode;
	}

	public ResponseEntity<ProductsEcomm> orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}