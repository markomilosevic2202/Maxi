#Feature: Login
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


#  Scenario: Logging in with the correct parameters
#    Given go to the address "https://www.maxi.rs/reg/welcome?lastViewedPage=%2Fonline"
#    When click on the page reg button Prihvatam
#    Given enter your login email "marko.milosevic2205@gmail.com"
#    When click on the page reg button Submit
#    Then verify that the page is located at the address "/create-account"
#    Then verify that there is an element with text "Kreiraj moj nalog"
#
