package com.coffeecorner.billing;


import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class outputTest {


	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outputStreamCaptor));;

    }
 
    @Test
	public void testReceiptPrint() {
		System.out.println("Testing Receipt Item Add ...");
		
		ProductCatalog productCatalog = new ProductCatalog();
		productCatalog.add(new Beverage("CS", "Coffee Small" , 2.5));
		Receipt receipt = new Receipt(new String[] {"CS"}, productCatalog);
		receipt.print(Receipt.NO_DATE_TIME);
		assertEquals("Testing Receipt Item Add ...\r\n" + 
				"Charlene's Coffee Corner\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Coffee Small                                                       2,50 CHF\r\n" + 
				"\r\n" + 
				"Total amount...                                                    2,50 CHF\r\n", outputStreamCaptor.toString());
		
	}

}
