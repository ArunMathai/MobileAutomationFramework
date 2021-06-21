#Author: your.email@your.domain.com
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@tag
#Feature: Title of your feature
  #I want to use this template for my feature file
#
  #@tag1
  #Scenario: Title of your scenario
    #Given I want to write a step with precondition
    #And some other precondition
    #When I complete action
    #And some other action
    #And yet another action
    #Then I validate the outcomes
    #And check more outcomes
#
  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
      #
      #
    #
#


Feature: Login scenarios and Validations

  Scenario Outline: Validate the username, Cardnumber in the Card tab
   	
    When I click "Login" button
    And  I enter card number "<cardNumber>"
    And  I click on the "continue" button
    Then I should be in "Log in" page
    When I enter email id as "<emailId>"
    And  I enter password as "<password>"
    And  I click on the "login" button
    Then I should be in "Home" page
    And  I click on the "Card" button
    Then I should be in "Card" page
    Then I should be able to validate the "CardPage_Username" "<username>"
    Then I should be able to validate the "CardPage_Cardnumber" "<cardNumber>"
    
    
    Examples:
      | cardNumber  | emailId 												|  password 		| username 					  |
      | 10087802018 | testautomationuser1@yopmail.com |  Nectar123@   |	TestAutomation User |
          
          