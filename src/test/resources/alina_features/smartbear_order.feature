Feature: Placing an Order and Verifying Order Visibility
  User Story: As a logged-in user, I want to be able to place an order for the "FamilyAlbum" product, So that I can have my order details recorded and visible on the order page.
  @B2G3-150 @B2G3-224 @B2G3-243
  Scenario: user should be able to place order and order should be seen in page
  Given user is already logged in and navigated to order page
  When user selects product type "FamilyAlbum"
  And user enters quantity 2
  And user enters customer name "Chuck Norris"
  And user enters street "1100 Long way dr"
  And user enters city "Chantilly"
  And user enters state "Virginia"
  And user enters zip "22011"
  And user selects credit card type "American Express"
  And user enters credit card number "1111222233334444"
  And user enters expiration date "12/25"
  And user enters process order button
  Then user should see "Chuck Norris" in the first row of the table