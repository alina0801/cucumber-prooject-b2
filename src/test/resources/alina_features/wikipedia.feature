Feature:  Wikipedia Search Functionality
  User Story: Story: As a user interested in quickly accessing information about a topic,
  I want to utilize an improved Wikipedia search functionality,
  So that I can efficiently find relevant information without navigating through multiple pages.
  Background:
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button

  @B2G3-225 @B2G3-215
  Scenario: Wikipedia Search Functionality Title Verification
    Then User sees "Steve Jobs - Wikipedia" is in the wiki title

  @B2G3-226 @B2G3-216
  Scenario: Wikipedia Search Functionality Header Verification
    Then User sees "Steve Jobs" is in the main header

  @B2G3-227 @B2G3-217
  Scenario: Wikipedia Search Functionality Image Header Verification
    Then User sees "Steve Jobs" is in the image header




