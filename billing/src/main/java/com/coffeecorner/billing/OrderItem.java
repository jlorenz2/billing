package com.coffeecorner.billing;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderItem {
	private ArrayList<String> itemElements;
	
	public OrderItem(String item) {
		
		itemElements = new ArrayList<>(Arrays.asList((item.toUpperCase()).split(",")));
	}

	public ArrayList<String> getItemElements() {
		return itemElements;
	}

	public void setItemElements(ArrayList<String> itemElements) {
		this.itemElements = itemElements;
	}
}
