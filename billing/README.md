# Billing application for Charlene's Coffee Corner
# v1.0.0

Billing is a simple application for generating invoices on the standard output for customer orders.

# Main features

  - Generates invoices for products ordered by the customer.
  - Applies special discounts based on offers and the customer stamp card.
  - Maintains an extensible Product Catalog for the products offered to the customers.
  

##   Installation

###  Required software

	- Apache Maven 3.6.0
    - Java jdk 1.8

	Clone the content of the application repository and run:

		$ git clone https:github.com/jlorenz2/billing

##  Compiling

	On the root folder of the installation path:
	
		$ mvn install

##  Running Billing application

	On the target folder of the installation path:
	
		$ java -jar billing-1.0.0,jar <Product parameters>
	
	Example:
		
		java -jar billing-1.0.0.jar CS,FM BR
		
	
	Generic format:
	
	java -jar billing-1.0.0.jar [<#Stamps>] [<Offering Code>[,<Extra Code>…]] [<SPACE> [<Offering Code>[,<Extra Code>…]]]…


License
----

*** It's a Free Software, enjoy! **

