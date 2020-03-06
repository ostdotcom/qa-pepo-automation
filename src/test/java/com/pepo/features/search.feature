Feature: Verify all search functionality in App


  Background: Login with Twitter scenario
    Given User is ready to Login
    When User login with twitter credentials


  Scenario: Verify search functionality in all the tabs. Tags, people and Communities
    Given User is on home feed page
    When User navigates to Search Tab
    And Search with xyz text
    Then User should get the relevant results
    When User navigates to Communities page
    And Search with xyz text
    Then User should get the relevant results
    When User navigates to People page
#    And Search with xyz text
    Then User should get the relevant results
    When User navigates to Tags page
    And Search with xyz text
    Then User should get the relevant results



#  Scenario: Verify Swipe scroll and Tab of Search
#    Given User is on home feed page
#    When User navigates to Search Tab
#    And Perform Tab navigation and Swipe actions
#    Then User should perform all the actions correctly
#


