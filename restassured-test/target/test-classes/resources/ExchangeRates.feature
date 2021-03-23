Feature: Demo for rest assured framework using cucumber and maven selenium project

Background: I have generated valid token for exchange rates API
Given I have a valid api key

@tc_01 @positive @smoke
Scenario: Verify the functionality of get method on given api
Given I have valid request specification for exchange rates api
When I perform get operation using above request
Then User should get success message for result status

@tc_02 @positive
Scenario: Verify various fields of correct response on valid input
Given Rest API for "latest" Foreign Exchange rates
When The API is called for "valid_input" using get method
Then User should get proper details for latest exchange rates

@tc_03 @negative
Scenario: Verify various fields of response on INvalid input 
Given Rest API for "latest" Foreign Exchange rates
When The API is called for "invalid_input" using get method
Then User should get error message for result status

@tc_04 @positive @smoke
Scenario: Verify exchange rates availability for Specific_date
Given Rest API for "specific_date" Foreign Exchange rates
When The API is called for "specific_date" using get method
Then User should get success message for result status 

@tc_05 @positive
Scenario: Verify exchange rates details for Specific_date
Given Rest API for "Specific_date" Foreign Exchange rates
When The API is called for "specific_date" using get method
Then User should get proper details for Specific date exchange rates

@tc_06 @positive
Scenario: Verify exchange rates for future date
Given Rest API for "specific_date" Foreign Exchange rates
When The API is called for "future_date" using get method
Then User should get proper details for current date exchange rates
