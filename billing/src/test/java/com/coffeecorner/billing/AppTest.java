package com.coffeecorner.billing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TestProduct {

	@Test
	void testNewBeverage() {
		Product product = new Beverage("CS", "Coffee Small", 2.5);
		assert((product.getCode()).equals("CS"));
		assert((product.getDescription()).contentEquals("Coffee Small"));
		assert(product.getPrice()== 2.5);
	}
	
	@Test
	void testNewExtra() {
		Product product = new Extra("EM", "Extra milk", 0.30);
		assert((product.getCode()).equals("EM"));
		assert((product.getDescription()).equals("Extra milk"));
		assert(product.getPrice()== 0.30);
	}

	@Test
	void testNewSnack() {
		Product product = new Snack("FSOJ", "Freshly squeezed orange juice (0.25l)", 3.95);
		assert((product.getCode()).equals("FSOJ"));
		assert((product.getDescription()).equals("Freshly squeezed orange juice (0.25l)"));
		assert(product.getPrice()== 3.95);
	}
	
	@Test
	void testProductCatalogaAdd() {
		Product product = new Snack("FSOJ", "Freshly squeezed orange juice (0.25l)", 3.95);
		ProductCatalog pc = new ProductCatalog();
		pc.add(product);
		
		Product product2 = pc.searchProduct("FSOJ");
		assert((product2.getCode()).equals("FSOJ"));
	}
}
