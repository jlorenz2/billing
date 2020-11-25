package com.coffeecorner.billing;


public class App 
{
    public static void main( String[] args )
    {
		ProductCatalog productCatalog = new ProductCatalog();
		
		productCatalog.add(new Beverage("CS",   "Coffee Small" , 2.5));
		productCatalog.add(new Beverage("CM",   "Coffee Medium", 3.0));
		productCatalog.add(new Beverage("CL",   "Coffee Large" , 3.5));
		productCatalog.add(new Snack   ("BR",   "Bacon Roll"   , 4.5));
		productCatalog.add(new Beverage("FS",   "Freshly squeezed orange juice (0.25l)", 3.95));
		productCatalog.add(new Extra   ("EM",   "Extra milk"   , 0.30));
		productCatalog.add(new Extra   ("FM",   "Foamed milk"  , 0.50));
		productCatalog.add(new Extra   ("SR",   "Special roast coffee", 0.50));	
		
		Receipt receipt = new Receipt(args, productCatalog);
		
		
		receipt.print(Receipt.PRINT_DATE_TIME);

    }
}