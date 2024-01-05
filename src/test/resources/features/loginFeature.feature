Feature: DOCUPORT Login Logout Feature
  Background:  #precondition, runs  before each scenario, scenarios should follow
    Given user is on  Docuport login page
@B2G3-214 @B2G3-161 @wip #testexecution
 #@userstory @testplan @testexecution @B2G3-214
# feature file is linked to our step definition
  Scenario: Login as a client

    #given step matching with code snippet
    When user enters username for client
    And user enters password for client
    And user clicks login button
    Then user should see the home page for client
    

  @regression @closed
  Scenario: Login as an employee
    When user enters username for employee
    And user enters password for employee
    And user clicks login button
    Then user should see the home page for employee

  @smoke @vip
  Scenario: Login as an advisor
    When user enters username for advisor
    And user enters password for advisor
    And user clicks login button
    Then user should see the home page for advisor

  @smoke
  Scenario: Login as an supervisor
    When user enters username for supervisor
    And user enters password for supervisor
    And user clicks login button
    Then user should see the home page for supervisor

  @dataTableMap
    Scenario: Login as a client map practice
      When user enters credentials
      |username|b1g1_client@gmail.com|
      |password|Group1               |
      Then user should see the home page for client