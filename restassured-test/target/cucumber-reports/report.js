$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/resources/ExchangeRates.feature");
formatter.feature({
  "name": "Demo for rest assured framework using cucumber and maven selenium project",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "I have generated valid token for exchange rates API",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I have a valid api key",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Verify the functionality of get method on given api",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I have valid request specification for exchange rates api",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.Steps.i_have_valid_request_specification_for_exchange_rates_api()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I perform get operation using above request",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.Steps.i_perform_get_operation_using_above_request()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I should get proper response for given input",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.Steps.i_should_get_proper_response_for_given_input()"
});
formatter.result({
  "status": "skipped"
});
});