Feature: FaceBook Login flow
  Verify if user is able to Login in to the site

  Scenario: Login as a authenticated user
    Given user is  on homepage
    When user enters username and Password as "shalini.test@gmail.com" and "Password@123"
    And clicks login
    Then profile information is displayed
    
    Scenario: Login as a invalid user
    Given user is  on homepage
    When user enters username and Password as "invalid_user@gmail.com" and "Password@123"
    And clicks login
    Then invalid credentials message is displayed