#Feature: Link
#
#  Scenario: Checking all links on the home page, verifying the text from them, URL addresses and that the images are displayed
#    Given go to the address "https://www.maxi.rs/online"
#    When click on the page reg button Prihvatam
#    When click on the page online link "O kompaniji"
#    Then verify that the page is located at the address "company"
#    Then verify that there is a subtitle with the text "O kompaniji"
#    Then verify that all images have loaded