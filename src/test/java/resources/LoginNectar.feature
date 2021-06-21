
Feature: Login scenarios

 Scenario Outline: User Registers for the Nectar application
    When I click "Register" button
    And  I click "No" option for nectar card
    And  I click on the "continue" button
    And  I enter email address as "<emailId>"
    And  I click on the "continue" button
    Then I should be in "Check your email" page
   # When I open Browser "<emailId>"
    
    Examples:
      | emailId 						| 
      | amat903@yopmail.com |


#Test is failing in IOS as Error messages are different for IOS and Android

  Scenario Outline: Validate User gets proper error message when inavlid email id is given
    When I click "Login" button
    And  I enter card number "<cardNumber>"
    And  I click on the "continue" button
		Then I should get proper error message "<errorMsg>"    
    
    Examples:
      | cardNumber  | errorMsg |  
      | 12312   |  Enter a Nectar card number that has 11 numbers    |  
      
      
  Scenario Outline: Validate User is able to login to the Nectar Application
    When I click "Login" button
    And  I enter card number "<cardNumber>"
    And  I click on the "continue" button
    Then I should be in "Log in" page
    When I enter email id as "<emailId>"
    And  I enter password as "<password>"
    And  I click on the "login" button
    Then I should be in "Home" page
    
    
    Examples:
      | cardNumber  | emailId 												|  password 		|
      | 10087802018 | testautomationuser1@yopmail.com |  Nectar123@   |
          
   
   @RegressionSuite
  Scenario Outline: Validate the username, emailId, Cardnumber in the personal details page
  
  	Given I am Logged in
 		When  I click logout button inside Accounts section
 		Then  I should be in "Welcome" page
  
    When I click "Login" button
    And  I enter card number "<cardNumber>"
    And  I click on the "continue" button
    Then I should be in "Log in" page
    When I enter email id as "<emailId>"
    And  I enter password as "<password>"
    And  I click on the "login" button
    Then I should be in "Home" page
    And  I click on the "Accounts" button
    Then I should be in "Your_account" page
    And  I click on the "Your_details" button
    And  I should be in "Your_details" page
    Then I should be able to validate the "username" "<username>"
    Then I should be able to validate the "emailId" "<emailId>"
    Then I should be able to validate the "cardNumber" "<cardNumber>"
    
    
    Examples:
      | cardNumber  | emailId 									  |  password 		| username 			  |
      | 10089100015 | amatargospopup1@yopmail.com |  Nectar123@   |	amatargos jango |
             
      