Feature: Checkout

  Scenario: Adding the quantity of a product

    Given go to the address "https://www.maxi.rs/online"
    When click on the page reg button Prihvatam
    When click on the page online link product group "Piće, kafa i čaj"
    When click on the page online link product "Energetski napici"
    Then verify that the page is located at the address "Picje-kafa-i-chaj/Energetski-napici"
    When add a product that is "1" in a row of "3" pieces
    Then verify that the basket has the correct number of selected items
    When click on the page online on basket
    Then take the parameters of the product in the basket
    When add article number for "2" pieces
    Then refresh page
    Then verify that the product number is correct
    Then verify that the total price of the product is correct
    Then verify that the total purchase price is correct
    When remove article number for "1" pieces
    Then refresh page
    Then verify that the product number is correct
    Then verify that the total price of the product is correct
    Then verify that the total purchase price is correct


#
#  Scenario: Removing an item from the cart
#
#  Scenario: Adding a note on the product
#
#  Scenario: Sorting the product list
#
#  Scenario: Empty the basket