Feature: Customers

#Background: it is tag used to add same features in it it will add that feature in every scenario before executing it

#Given User Launch Chrome browser 
#	When User opnes URL "https://admin-demo.nopcommerce.com/login"
#	And User enters Email as "admin@yourstore.com" and Password as "admin"
#	And Click on Login
#	Then User can view Dashboard
# remove this features from scenario so before executing each scenario it will execute first those files which are in background tag

Scenario: Add new customer
	Given User Launch Chrome browser 
	When User opnes URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then User can view Dashboard
	When User click on customers menu
	And Click on customer menu Item
	And Click on Add new button
	Then User can view Add new customer page
	When user enter customer info
	And click on Save button
	Then User can view confirmation message "The new customer has been added successfully."
	And Close browser	
	
	
Scenario: Search customer by EmailID
	Given User Launch Chrome browser 
	When User opnes URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then User can view Dashboard
	When User click on customers menu
	And Click on customer menu Item
	And Enter customer Email
	When Click on search button
	Then User should found Email in the search table
	And Close browser	
	
	
Scenario: Search customer by Name	
Given User Launch Chrome browser 
	When User opnes URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then User can view Dashboard
	When User click on customers menu
	And Click on customer menu Item
	And Enter customer FirstName
	And Enter customer LastName
	When Click on search button
	Then User should found Name in the search table
	And Close browser	
	
	
	