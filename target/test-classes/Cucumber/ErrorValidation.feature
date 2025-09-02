
@tag
Feature: Error Validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Check with multiple username and Password
     Given I Landed on Ecommerce Page
     When  Logged in with username <name> and password <password>
     Then "Incorrect email  password." message is displayed

    Examples: 
      | name                |  password         |  productname |
      | keerthika@gmail.com |  Keerthika        |  ZARA COAT 3 |  
    