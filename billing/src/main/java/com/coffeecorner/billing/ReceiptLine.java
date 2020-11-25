package com.coffeecorner.billing;

public class ReceiptLine {
	String description;
	double	total;
	
	public String getDescription() {
		return description;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setDescription(String myDescription) {
		description = myDescription;
	}
	
	public void setTotal(double myTotal) {
		total = myTotal;
	}
	
	public ReceiptLine(String myDescription, double myTotal) {
		description = myDescription;
		total 		= myTotal;
	}
	
	public void feedReceiptLine(String myDescription, double myPrice) {
		setDescription(getDescription() + " " + myDescription); 
		setTotal(getTotal() + myPrice);
	}
	
	public String getLine() {
		return String.format("%-60s %10.2f CHF", getDescription(), getTotal());
		//return getDescription() + " " + getTotal();
	}

}