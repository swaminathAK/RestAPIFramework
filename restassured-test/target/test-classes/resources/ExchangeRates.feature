Feature: Demo for rest assured framework using cucumber and maven selenium project

Background: I have generated valid token for exchange rates API
Given I have a valid api key

Scenario: Verify the functionality of get method on given api
Given I have valid request specification for exchange rates api
When I perform get operation using above request
Then I should get proper response for given input
