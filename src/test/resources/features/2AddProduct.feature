Feature: Login

  Scenario: Logging in with the correct parameters
    Given go to the address "https://www.maxi.rs/online"
    When click on the page reg button Prihvatam
    When click on the page online link product group "Smrznuti proizvodi"
    When click on the page online link product "Smrznute torte i deserti"
    Then verify that the page is located at the address "Smrznuti-proizvodi/Smrznute-torte-i-deserti"
    When click on the page online link maxi
    When click on the page online link product group "Slatki i slani konditori"
    When click on the page online link product "Žvake"
   // Then verify that the page is located at the address "Slatki-i-slani-konditori/Žvake"