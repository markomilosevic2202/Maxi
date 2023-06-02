#Feature: Add product
#
#  Scenario: Add several products for purchase and check if all parameters are correct on the basket page
#    Given go to the address "https://www.maxi.rs/online"
#    When click on the page reg button Prihvatam
#    When click on the page online link product group "Piće, kafa i čaj"
#    When click on the page online link product "Energetski napici"
#    Then verify that the page is located at the address "Picje-kafa-i-chaj/Energetski-napici"
#    When add a product that is "1" in a row of "1" pieces
#    When click on the page online link maxi
#    When click on the page online link product group "Mlečni proizvodi i jaja"
#    When click on the page online link product "Mlečni pudinzi"
#    Then verify that the page is located at the address "Mlechni-proizvodi-i-jaja/Mlechni-pudinzi"
#    When add a product that is "3" in a row of "5" pieces
#    Then wait for the window to select the delivery date to appear and click on the decision later
#    When click on the page online link maxi
#    When click on the page online link product group "Voće i povrće"
#    When click on the page online link product "Pakovane salate"
#    Then verify that the page is located at the address "Vocje-i-povrcje/Pakovane-salate"
#    When add a product that is "2" in a row of "2" pieces
#    When click on the page online link maxi
#    When click on the page online link product group "Slatki i slani konditori"
#    When click on the page online link product "Žvake"
#    Then verify that the page is located at the address "Slatki-i-slani-konditori/Zhvake"
#    When add a product that is "2" in a row of "3" pieces
#    Then verify that the basket has the correct number of selected items
#    When click on the page online on basket
#    Then verify that the item number on the checkout page is correct
#    Then verify that the total purchase amount is correct
#    Then check whether all parameters for each item are displayed correctly