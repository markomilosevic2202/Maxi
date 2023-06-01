Feature: Login

  Scenario: Logging in with the correct parameters
    Given go to the address "https://www.maxi.rs/online"
    When click on the page reg button Prihvatam
    When click on the page online link product group "Piće, kafa i čaj"
    When click on the page online link product "Energetski napici"
    Then verify that the page is located at the address "Picje-kafa-i-chaj/Energetski-napici"
  When add a product that is "1" in a row of "3" pieces
#    When click on the page online link maxi
#    When click on the page online link product group "Mlečni proizvodi i jaja"
#    When click on the page online link product "Mlečni pudinzi"
#    Then verify that the page is located at the address "Mlechni-proizvodi-i-jaja/Mlechni-pudinzi"
#    When click on the page online link maxi
#    When click on the page online link product group "Voće i povrće"
#    When click on the page online link product "Pakovane salate"
#    Then verify that the page is located at the address "Vocje-i-povrcje/Pakovane-salate"
#    When click on the page online link maxi
#    When click on the page online link product group "Slatki i slani konditori"
#    When click on the page online link product "Žvake"
#    Then verify that the page is located at the address "Slatki-i-slani-konditori/Zhvake"