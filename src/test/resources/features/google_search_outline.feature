Feature: Scenario Outline: practice
 @googleSearchOutline @multithreading
  Scenario Outline:  Google search for capital cities
    Given user is on Google search page
    When user searches the the "<country>"
    Then user should see the "<capital>" in the result
    Examples:
      | country     | capital    |
      | Azerbaijan  | Baku       |
      | Ukraine     | Kyiv       |
      | Afghanistan | Kabul      |
      | USA         | Washington |
      | Turkiye     | Ankara     |
      | Uzbekistan  | Tashkent   |