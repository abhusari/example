package com.one.controller;

import java.util.HashMap;
import java.util.Map;

public class Cataloague {
	Map<String,Product> productList;

	
	public Cataloague(Map<String, Product> productList) {
		super();
		this.productList = productList;
	}

	public Map getProductList() {
		return productList;
	}

	public void setProductList(HashMap<String, Product> productList) {
		this.productList = productList;
	} 
	
	public Product getProduct(String name){
		return this.productList.get(name);
	}
}
