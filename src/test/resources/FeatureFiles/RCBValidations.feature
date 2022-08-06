Feature: RCB Team Validations

@TestCase1
  Scenario: Validating foreign players count
    Given The RCB team member details is present
    When Performing the count validations
    Then Team should have only four foreign players

  @TestCase2
  Scenario: Validating foreign players count
    Given The RCB team member details is present
    When Performing the count validations
    Then Team should have at least one wicketkeeper
