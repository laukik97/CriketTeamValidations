Feature: RCB Team Validations

  Scenario: Validating foreign players count
    Given All the team member's details is present
    When Performing the count validations
    Then Team should have only four foreign players