package com.coffeecorner.billing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;


class TestProduct {

	@Test
	void testNewBeverage() {
	    System.out.println("Testing Beverage object create...");
		Product product = new Beverage("CS", "Coffee Small", 2.5);
		assert((product.getCode()).equals("CS"));
		assert((product.getDescription()).contentEquals("Coffee Small"));
		assert(product.getPrice()== 2.5);
	}
	
	@Test
	void testNewExtra() {
	    System.out.println("Testing Extra object create...");
		Product product = new Extra("EM", "Extra milk", 0.30);
		assert((product.getCode()).equals("EM"));
		assert((product.getDescription()).equals("Extra milk"));
		assert(product.getPrice()== 0.30);
	}

	@Test
	void testNewSnack() {
	    System.out.println("Testing Snack object create...");
		Product product = new Snack("FSOJ", "Freshly squeezed orange juice (0.25l)", 3.95);
		assert((product.getCode()).equals("FSOJ"));
		assert((product.getDescription()).equals("Freshly squeezed orange juice (0.25l)"));
		assert(product.getPrice()== 3.95);
	}

	
	@Test
	public void testReceiptLineProperties() {
		System.out.println("Testing Receipt Line Properties ...");
		ReceiptLine r = new ReceiptLine("Coffee Double", 5.0);
	  
		assertTrue(r.getDescription().equals("Coffee Double"));
		assertTrue(r.getTotal() == 5.0);
   }
	   

	@Test
	public void testfeedReceiptLine() {
		System.out.println("Testing Receipt Line Properties ...");
		ReceiptLine r = new ReceiptLine("Coffee Double", 5.0);
		r.feedReceiptLine("Especial Price", 10);
		assertTrue(r.getDescription().equals("Coffee Double Especial Price"));
		assertTrue(r.getTotal() == 15.0);
   }
	   

	@Test
	public void testGetLine() {
		System.out.println("Testing Get Line ...");
		ReceiptLine r = new ReceiptLine("Coffee Double", 5.0);

 	    assertTrue(r.getLine().equals("Coffee Double                                                      5,00 CHF"));
   }


	@Test
	public void checkProductSearch() {
		System.out.println("Testing Product Catalog search ...");
		ProductCatalog productCatalog = new ProductCatalog();
		productCatalog.add(new Beverage("CS", "Coffee Small" , 2.5));
		Product p = productCatalog.searchProduct("CS");
		assertTrue(p.getDescription().equals("Coffee Small"));
   }
	   

	@Test
	public void checkProductSearchNotFound() {
		System.out.println("Testing Product Catalog search Not Found ...");
		ProductCatalog productCatalog = new ProductCatalog();
		productCatalog.add(new Beverage("CS", "Coffee Small" , 2.5));
		Product p = productCatalog.searchProduct("XX");
		assertTrue(p == null);
   }	
	
	@Test
	public void checkReceiptIemAdd() {
		System.out.println("Testing Receipt Item Add ...");
		
		ProductCatalog productCatalog = new ProductCatalog();
		productCatalog.add(new Beverage("CS", "Coffee Small" , 2.5));
		Receipt receipt = new Receipt(new String[] {"CS"}, productCatalog);
		

		List<ReceiptLine> receiptLines = receipt.getReceiptLines();
		assertTrue(receiptLines.size() == 1, "...test 1 element");
		assertTrue((receiptLines.get(0)).getTotal() == 2.5, "...test Total value");
		assertTrue(((receiptLines.get(0)).getLine()).equals("Coffee Small                                                       2,50 CHF")
				, "... test line");
   }	
}
