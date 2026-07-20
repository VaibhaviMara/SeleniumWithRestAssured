Feature: Swagger Username Password Extraction
  Background: Creating user
    Given I create new user

  Scenario:
    Given I have a chrome opened with URL
    When I see the SwaggerPetStore Homepage
    And I scroll to operations user TAG
    And I select Get user by user name method
    And I select Try It Out
    And I provide Username in the textbox
    And I click on execute
    Then I fetch Password from the respone
    And I validate the login success or failure
