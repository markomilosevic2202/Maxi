Feature: Checkout

  Scenario: Adding the quantity of a product

#    Given go to the address "https://www.maxi.rs/online"
#    When click on the page reg button Prihvatam
#    When click on the page online link product group "Piće, kafa i čaj"
#    When click on the page online link product "Energetski napici"
#    Then verify that the page is located at the address "Picje-kafa-i-chaj/Energetski-napici"
#    When add a product that is "1" in a row of "3" pieces
#    Then verify that the basket has the correct number of selected items
#    When click on the page online on basket
#    Then take the parameters of the product in the basket
#    When add article number for "2" pieces
#    Then refresh page
#    Then verify that the product number is correct
#    Then verify that the total price of the product is correct
#    Then verify that the total purchase price is correct
#    When remove article number for "1" pieces
#    Then refresh page
#    Then verify that the product number is correct
#    Then verify that the total price of the product is correct
#    Then verify that the total purchase price is correct


#  Scenario: Removing an item from the cart
#    Given go to the address "https://www.maxi.rs/online"
#    When click on the page reg button Prihvatam
#    When click on the page online link product group "Voće i povrće"
#    When click on the page online link product "Pakovane salate"
#    Then verify that the page is located at the address "Vocje-i-povrcje/Pakovane-salate"
#    When add a product that is "2" in a row of "2" pieces
#    When click on the page online link maxi
#    When click on the page online link product group "Slatki i slani konditori"
#    When click on the page online link product "Žvake"
#    Then verify that the page is located at the address "Slatki-i-slani-konditori/Zhvake"
#    When add a product that is "2" in a row of "3" pieces
#    When click on the page online link maxi
#    Then wait for the window to select the delivery date to appear and click on the decision later
#    When click on the page online link product group "Mlečni proizvodi i jaja"
#    When click on the page online link product "Mlečni pudinzi"
#    Then verify that the page is located at the address "Mlechni-proizvodi-i-jaja/Mlechni-pudinzi"
#    When add a product that is "3" in a row of "5" pieces
#    Then verify that the basket has the correct number of selected items
#    When click on the page online on basket
#    Then take the parameters of the product in the basket
#    When click on the page checkout button remove first items
#    Then refresh page
#    Then verify that the basket has the correct number of selected items after remove product
#    Then verify that there are no items with the name of the removed product
#    Then verify that the total purchase price is correct after remove product


  Scenario: Adding a note on the product
    Given go to the address "https://www.maxi.rs/online"
    When click on the page reg button Prihvatam
    When click on the page online link product group "Voće i povrće"
    When click on the page online link product "Pakovane salate"
    Then verify that the page is located at the address "Vocje-i-povrcje/Pakovane-salate"
    When add a product that is "2" in a row of "2" pieces
    Then verify that the basket has the correct number of selected items
    When click on the page online on basket

    When click on the button for notification of the first product
    Given enter notification "Notification is correct"
    When click on the button save
    Then verify that the number of notifications is visible
    When click on the button for notification of the first product
    Then verify that the text of the notification is correct

    When click on the button for notification of the first product
    Given enter notification ""
    When click on the button save
    Then verify that the number of notifications is not visible
    When click on the button for notification of the first product
    Then verify that the text of the notification is correct


#
#  Scenario: Sorting the product list
#
#  Scenario: Empty the basket