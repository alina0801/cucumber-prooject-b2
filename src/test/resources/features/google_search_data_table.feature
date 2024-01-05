Feature: Passing multiple parameters to the same step
  @googleSearch
  Scenario: Searching multiple items
    Given user is on Google search page
    Then user searches the following item
      | loop academy |
      | java         |
      | selenium bdd |
      | cucumber bdd |
      | sql          |
      | nadir        |
      | zahid        |
      | anna         |

