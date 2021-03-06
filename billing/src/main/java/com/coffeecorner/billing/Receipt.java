package com.coffeecorner.billing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

public class Receipt {
	List<ReceiptLine> receiptLines = new ArrayList<ReceiptLine>();
	
	public static final int NO_DATE_TIME = 1;
	public static final int PRINT_DATE_TIME = 2;
	
	String line; 
	OrderItem orderItem;
	
	int i;
	Product product;
	ReceiptLine receiptLine;
	double priceLine;
	int orderedBeverages = 0;
	boolean orderedSnack    = false;
	Product orderedExtra;
	Product freeBeverage;
	int stampCard = 0;
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	
	
	List<ReceiptLine> getReceiptLines() {
		return receiptLines;
	}
	
	public Receipt(String args[], ProductCatalog productCatalog) {
		for (String item: args) {
			receiptLine = null;
			orderItem = new OrderItem(item);
			i = 0;
			for (String itemElement : orderItem.getItemElements()) {	

				if (isNumeric(itemElement)) {
					stampCard = Integer.parseInt(itemElement);
					continue;
				}
				if (i == 0) {
					product = productCatalog.searchProduct(itemElement);
					if (product != null && (product instanceof Beverage || product instanceof Snack)) {
						receiptLine = new ReceiptLine(product.getDescription(), product.getPrice());
						if (product instanceof Beverage) {
							orderedBeverages++;
							if (orderedBeverages + stampCard == 5)
								freeBeverage = product;
						}
						else
							if (product instanceof Snack)
								orderedSnack = true;
					}
					else {
						receiptLine = new ReceiptLine("*** Invalid item ***", 0);
						continue;
					}	
				}
				else {
					product = productCatalog.searchProduct(itemElement);

					if (product instanceof Extra) {
						receiptLine.feedReceiptLine(" " + product.getDescription(), product.getPrice());
						orderedExtra = product;

					}
				}		

				i++;
			}
			if (receiptLine != null)
					receiptLines.add(receiptLine);
		}
		if (orderedBeverages > 0 & orderedSnack) {
			if (orderedExtra != null) {
				receiptLine = new ReceiptLine(orderedExtra.getDescription() + " (Snack + Beverage discount)", -orderedExtra.getPrice());
				receiptLines.add(receiptLine);
			}
		}
		if (freeBeverage != null) {
			receiptLine = new ReceiptLine(freeBeverage.getDescription() + " (Stamp Card discount)", -freeBeverage.getPrice());
			receiptLines.add(receiptLine);
		}
			
	}

	
	void print(int date_time) {
		double total = 0;
		
		System.out.println("Charlene's Coffee Corner");
		System.out.println("");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  

		if (date_time == PRINT_DATE_TIME)
			System.out.println(dtf.format(now));  
		
		System.out.println("");
	    	
		for (ReceiptLine receiptLine : this.getReceiptLines()) {
			total += receiptLine.getTotal();
			System.out.println(receiptLine.getLine());

		}
		System.out.println("");
		System.out.println(String.format("%-60s %10.2f CHF", "Total amount...", total));

	}
}
