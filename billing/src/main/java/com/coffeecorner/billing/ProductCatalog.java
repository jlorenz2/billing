package com.coffeecorner.billing;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog       
{
	private Map <String, Product> products;
	
	public ProductCatalog() {
		products = new HashMap<String, Product>(); 

	}
	
	public void add(Product myProduct) {
		products.put(myProduct.getCode(), myProduct);
	}
	
	public Product searchProduct(String myCode) {
		return products.get(myCode);
	}
}