package stepDefinitions;

import java.util.List;
import java.util.Map;

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

	private static String token;
	private static Response response;
	private static String jsonString;
//https://app.exchangerate-api.com/dashboard
	// https://v6.exchangerate-api.com/v6/a97b38d7045597c9e8acd73c/latest/USD

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
		response = request.get("/BookStore/v1/Books");
	}

	@Then("I should get proper response for given input")
	public void i_should_get_proper_response_for_given_input() {
		Assert.assertEquals(201, response.getStatusCode());
	}

}
