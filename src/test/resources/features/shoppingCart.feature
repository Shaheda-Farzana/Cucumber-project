Feature: Shopping Cart Functionality
  
  
		Background: User Opens landing page
			Given	 	User launches chrome browser
			When 		User opens Islahi portal link
			Then 		User should see the page title 
 
	  Scenario: Add item to cart
	    Given 	User is on the product page
	    When  	User select an item to purchase
	    And   	User click the Add to cart button
	    Then  	User should see the item in the cart
	
	        
		Scenario: Remove item from cart
	    Given 	User is on cart page
	    When  	User remove the item from the cart
	    Then  	User should not see the item in the cart
	    And     User quits the browser
	        

