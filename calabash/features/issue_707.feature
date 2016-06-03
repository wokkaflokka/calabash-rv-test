Feature: Calabash Issue #707
  As a calabash user
  I want to test dynamic recycler views

  # https://groups.google.com/forum/#!topic/calabash-android/-CDfNr_hqCU
  Scenario: I can click an element in a static recycler view
    Given I am on the landing screen
    When I click the first photo on the screen
    Then I see a new screen that says "You should be seeing this text right now."

  # https://groups.google.com/forum/#!topic/calabash-android/-CDfNr_hqCU
  Scenario: Calabash clicks fail after changing the data set in a recycler view
    Given I am on the landing screen
    And I choose "Archived" from the toolbar dropdown
    And I choose "Published" from the toolbar dropdown
    When I click the first photo on the screen
    Then I see a new screen that says "You should be seeing this text right now."