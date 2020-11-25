# Billing application for Charlene's Coffee Corner

Billing is a simple application made for generating invoices on the standard ouput from customer orders.

# Main features

  - Generate invoices on products ordered by the customer.
  - Maintains an extensible Product Catalog for the products offered to the customers.

### Required software

	- Apache Maven 3.6.0
	- Java jdk 1.8
	
### Installation

	Clone the content of the application repository:

	$ git clone https:github.com/jlorenz2/billing

### Compiling

	On the root folder of the installation path:
	
	mvn install

# Running

	On the target folder of the installation path:
	
	java -jar billing-1.0.0,jar <Product parameters>
	
	Example:
		
		java -jar billint-1.0.0.jar CS,FM BR
		
	
	Generic format:
	
	java -jar billint-1.0.0.jar [<Offering Code>[,<Extra Code>…]] [<SPACE> [<Offering Code>[,<Extra Code>…]]]…


License
----

MIT


*** It's a Free Software, enjoy! **

