
@tag
Feature: Purchase the order from Ecommerce Website
  I want to place my order this template for my feature file

 Background:
 Given I landed on Ecommerce Page
 
  @Regression
  Scenario Outline: Positive Testof submitting the order
    Given Logged in with username <name> and password <password>
    When I add the product <produtname> to Cart
    And  Checkout  <produtname> and submit the order
    Then "Thankyou for the order." message is displayed on Confirmation Page
    Examples: 
      | name                |  password         |  productname |
      | keerthika@gmail.com |  Keerthika_2014   |  ZARA COAT 3 |  
    
