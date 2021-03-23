package stepDefinitions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Steps {

	private static final String API_key = "a97b38d7045597c9e8acd73c";
	private static final String USERNAME = "kanheresoham@gmail.com";
	private static final String PASSWORD = "Tushar2765";
	private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

//	private static String token;
	private static Response response;
	private static String jsonString;
	private static BufferedReader reader;
	private static Properties properties;
	private static String properties_file = "C:\\Assignment\\RestAPIFramework\\restassured-test\\configuration\\data.properties";
	SimpleDateFormat dateTimeInGMT = new SimpleDateFormat("dd MMM yyyy");
//	dateTimeInGMT.setTimeZone(TimeZone.getTimeZone("UTC"));
//	System.out.println(dateTimeInGMT.format(new Date()));
//https://app.exchangerate-api.com/dashboard
//	https://v6.exchangerate-api.com/v6/YOUR-API-KEY/history/USD/YEAR/MONTH/DAY
	// https://v6.exchangerate-api.com/v6/a97b38d7045597c9e8acd73c/latest/USD
	Steps() throws Exception
	{
	try {
		reader = new BufferedReader(new FileReader(properties_file));
		properties = new Properties();
		properties.load(reader);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	@Given("I have a valid token")
	public void i_have_a_valid_api_key() {
		 RestAssured.baseURI = BASE_URL+API_key;
	}

	@Given("I have valid request specification for exchange rates api")
	public void i_have_valid_request_specification_for_exchange_rates_api() {
		RequestSpecification request = RestAssured.given();
	}

	@When("I perform get operation using above request")
	public void i_perform_get_operation_using_above_request() {
		RequestSpecification request = RestAssured.given();
		response = request.get("/latest/USD");
	}

	@Then("I should get proper response for given input")
	public void i_should_get_proper_response_for_given_input() {
		jsonString = response.asString();
		Assert.assertEquals("success", JsonPath.from(jsonString).get("result"), "request for latest exchange rates is NOT successful");
	}
	
	///////////////////////////////////////////////////////

	@Then("User should get success message for result status")
	public void user_should_get_success_message_for_result_status() {
		jsonString = response.asString();
		Assert.assertEquals("success", JsonPath.from(jsonString).get("result"), "request for latest exchange rates is NOT successful");
	}

	@Given("Rest API for {string} Foreign Exchange rates")
	public void rest_API_for_Foreign_Exchange_rates(String string) {
		RequestSpecification request = RestAssured.given();
		response = request.get(properties.getProperty(string));
	}

	@When("The API is called for {string} using get method")
	public void the_API_is_called_for_using_get_method(String string) {
		RequestSpecification request = RestAssured.given();
		response = request.get(properties.getProperty(string));
	}

	@Then("User should get proper details for latest exchange rates")
	public void user_should_get_proper_details_for_latest_exchange_rates() {
		jsonString = response.asString();
		Assert.assertTrue(((Properties) JsonPath.from(jsonString).get("time_last_update_utc")).contains(dateTimeInGMT.format(new Date())));
		Assert.assertNotNull("success", JsonPath.from(jsonString).get("INR"));
	}

	@Then("User should get error message for result status")
	public void user_should_get_error_message_for_result_status() {
		jsonString = response.asString();
		Assert.assertTrue(((String) JsonPath.from(jsonString).get("result")).contains("error")); 
	}

	@Then("User should get proper details for specific date exchange rates")
	public void user_should_get_proper_details_for_specific_date_exchange_rates() {
		jsonString = response.asString();
		Assert.assertTrue(((Properties) JsonPath.from(jsonString).get("time_last_update_utc")).contains(dateTimeInGMT.format(new Date())));
		Assert.assertNotNull("success", JsonPath.from(jsonString).get("INR"));  
	}

	@Then("User should get proper details for current date exchange rates")
	public void user_should_get_proper_details_for_current_date_exchange_rates() {
		jsonString = response.asString();
		Assert.assertTrue(((Properties) JsonPath.from(jsonString).get("time_last_update_utc")).contains(dateTimeInGMT.format(new Date())));
		Assert.assertNotNull("success", JsonPath.from(jsonString).get("INR"));
	}
}
