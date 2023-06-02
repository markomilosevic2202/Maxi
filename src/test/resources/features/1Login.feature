Feature: Login
#
#  Scenario: Logging in with the correct parameters
#    Given go to the address "https://www.maxi.rs/reg/welcome?lastViewedPage=%2Fonline"
#    When click on the page reg button Prihvatam
#    Given enter your login email "marko.milosevic2203@gmail.com"
#    When click on the page reg button Submit
#    Given enter your password "Marko018"
#    When click on the page reg button Submit
#    Then verify that there is an element with text "Dobro došli"
#    When click on the page online link Dobro dosli
#    When click on the page online link Odjava
#    Then verify that there is no element with text "Dobro došli"
#
#
#  Scenario: Login will not be corrected by email
#    Given go to the address "https://www.maxi.rs/reg/welcome?lastViewedPage=%2Fonline"
#    When click on the page reg button Prihvatam
#    Given enter your login email "marko.milosevic2205@gmail.com"
#    When click on the page reg button Submit
#    Then verify that the page is located at the address "/create-account"
#    Then verify that there is an element with text "Kreiraj moj nalog"
#
#Scenario: Login will not be corrected by pass
#    Given go to the address "https://www.maxi.rs/reg/welcome?lastViewedPage=%2Fonline"
#    When click on the page reg button Prihvatam
#    Given enter your login email "marko.milosevic2203@gmail.com"
#    When click on the page reg button Submit
#    Given enter your password ""
#    When click on the page reg button Submit
#    Then verify that there is a message window "Molimo unesite Vašu sadašnju lozinku"
#    Given enter your password "Marko01"
#    When click on the page reg button Submit
#    Then verify that there is a message window "Korisničko ime ili lozinka nisu tačni."
