package org.anupam.catalog;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService()
public class ProductCatalog {
	public List<String> getProducts(String userName){
		List<String> products = new ArrayList<String>();
		products.add(userName+" TV");
		products.add(userName+" Camera");
		products.add(userName+" DeskTop");
		products.add(userName+" Laptop");
		return products;
	}
}
