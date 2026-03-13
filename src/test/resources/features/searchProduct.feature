Feature: Product search and checkout validation in Albertsons mobile application

  Background:
    Given the user lands on the home screen with search functionality available

  @androidApp
  Scenario Outline: Verify user can search product and validate checkout behavior and remove product
    When the user searches for "<product>" from the home screen
    And the user selects "<product>" from the search suggestions
    Then the results page should display text containing "Results for '<resultText>'"
    And list of products displayed with product name and price information
    When the user opens a product from the search results
    Then the product details screen should display the product name and price
    And the user scrolls through the product details screen to view details sections displaying
    When the user adds the product to the cart
    And the user navigates to the cart screen
    Then the cart should display the added product
    When the user adds a substitution for the selected product
    And the user proceeds to the checkout flow
    Then the application should display available delivery time slots
    And the FreshPass promotional banner should be visible
    Then the place order button should remain disabled until required details are completed
    When the user navigates back to the cart
    And the user removes the product from the cart
    Then the cart should display an empty cart message "Your cart is berry lonely. Let's add to it."

    Examples:
      | product | resultText |
      | bread   | bread |
      | milk    | milk |
      | eggs    | eggs |
