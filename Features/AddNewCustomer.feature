Feature:Admin


@tag3
  Scenario Outline: Login with data driven
    Given User Launch Chrome Browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "<email>" and password as "<password>"
    And User click on Login button
    And User verify page title should be "Dashboard / nopCommerce administration" 
    And User click on customer menu
    And User click on customer menu item
    And User click on new add button
    Then User can view add new customer page
    When User enter customer info as "<newEmail>" and "<NewPassword>" and "<firstName>" and "<lastName>" and "<gender>" and "<compName>" and "<adminComment>"
    And User click on save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser
    
Examples:
   |email|password|newEmail|NewPassword|firstName|lastName|gender|compName|adminComment|
   |admin@yourstore.com|admin|raj126523@gmail.com|1234|Ajay|Prabha|Male|ABC|Test1|
   |admin@yourstore.com|admin|radh1ika13iutwe@gmail.com|4537|Udhay|Viraj|Female|xyz|Test2|