@RatesAPI

Feature: The Rates API is a free service for current and historical foreign exchange rates

  Scenario: Verify the success status of the response
    Given Rates API for Latest Foreign Exchange rates "/api/latest HTTP/2"
    When The API is available
    Then An automated test suite should run which will assert the success status of the response

  Scenario: Verify the test suite response
    Given Rates API for Latest Foreign Exchange rates "/api/latest HTTP/2"
    When The API is available
    Then An automated test suite should run which will assert the response


  Scenario: Verify the correct response supplied by the call
    Given Rates API for Latest Foreign Exchange rates "/api"
    When An incorrect or incomplete url is provided
    Then Test case should assert the correct supplied response by the call


  Scenario: Verify the  test suite should run which will assert the success status of the response
    Given Rates API for Specific dateForeign Exchange rates "/api/2010-01-12"
    When The API is available
    Then An automated test suite should run which will assert the success status of the response


  Scenario: Verify the test suite should run which will assert the response
    Given Rates API for Specific dateForeign Exchange rates "/api/2010-01-12"
    When The API is available
    Then An automated test suite should run which will assert the response date


  Scenario: Verify the response matches for the current date
    Given Rates API for Specific dateForeign Exchange rates "/api/2010-01-13"
    When The API is available
    Then An automated test suite should run which will validate that the response matches for the current date
