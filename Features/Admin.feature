Feature:Admin

@tag1
  Scenario: Login with valid credential
    Given User Launch Chrome Browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "admin@yourstore.com" and password as "admin"
    And User click on Login button
    Then User verify page title should be "Dashboard / nopCommerce administration" 
    And Close browser

@tag2
  Scenario Outline: Login with data driven
    Given User Launch Chrome Browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "<email>" and password as "<password>"
    And User click on Login button
    Then User verify page title should be "Dashboard / nopCommerce administration" 
    And Close browser
Examples:
|email							      |password     |
|admin@yourstore.com      |admin        |
|admin123@yourstore.com   |admin123     |
