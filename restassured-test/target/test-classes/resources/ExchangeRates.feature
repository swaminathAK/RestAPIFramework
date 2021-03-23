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
Given Rest API for "Latest" Foreign Exchange rates
When The API is called for "valid input" using get method
Then User should get proper details for latest exchange rates

@tc_03 @negative
Scenario: Verify various fields of response on INvalid input 
Given Rest API for "Latest" Foreign Exchange rates
When The API is called for "invalid input" using get method
Then User should get error message for result status

@tc_04 @positive @smoke
Scenario: Verify exchange rates availability for specific date
Given Rest API for "Specific date" Foreign Exchange rates
When The API is called for "specific date" using get method
Then User should get success message for result status 

@tc_05 @positive
Scenario: Verify exchange rates details for specific date
Given Rest API for "Specific date" Foreign Exchange rates
When The API is called for "specific date" using get method
Then User should get proper details for specific date exchange rates

@tc_06 @positive
Scenario: Verify exchange rates for future date
Given Rest API for "Specific date" Foreign Exchange rates
When The API is called for "future date" using get method
Then User should get proper details for current date exchange rates




