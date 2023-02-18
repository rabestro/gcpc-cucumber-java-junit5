Feature: User searches Google Cloud Pricing Calculator
  As a Google Cloud user
  I want to find a Pricing Calculator
  So I'm able to estimate the cost of equipment

  Background: Google Cloud page open
    Given I have already opened the Google Cloud page

  Scenario Outline: Use Google Cloud search to find calculator
    Given I type a "<Term>" in the search field
    When I press the button to search
    Then I find a link "Google Cloud Pricing Calculator" in the search results

    Examples:
      | Term                                     |
      | pricing calculator                       |
      | Google cloud platform pricing calculator |
      | calculator                               |
