package StepApi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hamcrest.Matchers;

import BaseApi.BaseAPI;
import Endpoints.PersonalEndpoint;
import Model.PersonalInfo;
import Reader.JsonReader;
import Reader.PropertyReader;
import UtilityLayer.JsonSchemaReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class ProductApiPostReq extends BaseAPI {

	@Given("user set Baseuri")
	public void user_set_baseuri() throws IOException {

		String baseuri = PropertyReader.getProperty("BaseURI");

		RestAssured.baseURI = baseuri;

	}

	@Given("get Request Sepcification")
	public void get_request_sepcification() {

		BaseAPI.Intialization();

	}

	@Given("create and attach Req body")
	public void create_and_attach_req_body() throws IOException {

		PersonalInfo personal = JsonReader.Desrilization("PeronsalPayload", PersonalInfo.class, "CreateEntity");

		String reqbody = JsonReader.serialization(personal);

		httpreq.body(reqbody);

	}

	@When("select http post request from RequestSpeccification Object")
	public void select_http_post_request_from_request_speccification_object() {

		resp = httpreq.post(PersonalEndpoint.Per_post);

	}

	@Then("capture PersonalInfo id")
	public void capture_personal_info_id() {

		pid = resp.jsonPath().getString("id");

	}

	@Then("then get ValidatableResponse Object")
	public void then_get_validatable_response_object() {

		vrs = resp.then();

	}

	@Then("validate status code as {int} and Status Line as {string}")
	public void validate_status_code_as_and_status_line_as(Integer code, String line) {

		vrs.statusCode(Matchers.equalTo(code)).statusLine(Matchers.containsString(line));

	}

	@Then("Validate Response Time should be below {int} ms")
	public void validate_response_time_should_be_below_ms(Integer time) {

		vrs.time(Matchers.lessThan((long) time));

	}

	@Then("validate {string} and {string} Response Header")
	public void validate_and_response_header(String key, String value) {

		vrs.header(key, Matchers.is(value));

	}

	@Then("validate {string} and Current date and time response Header")
	public void validate_and_current_date_and_time_response_header(String key) {

		String date = new SimpleDateFormat("MMM yyyy").format(new Date());

		vrs.header(key, Matchers.containsString(date));

	}

	@Then("validate Json Schema")
	public void validate_json_schema() throws FileNotFoundException {

		JsonSchemaReader.jsonSchemaReader("PersonalSchema");

	}

	@Given("add path param and attach")
	public void add_path_param_and_attach() {
		httpreq.pathParam("id", pid);

	}

	@When("select http get request from RequestSpeccification Object")
	public void select_http_get_request_from_request_speccification_object() {
		resp = httpreq.get(PersonalEndpoint.Per_Get);

	}

	@Then("print repsonse logs")
	public void print_repsonse_logs() {

		vrs.log().all();

	}

	@Given("create and attach put Req body")
	public void create_and_attach_put_req_body() throws IOException {

		PersonalInfo personal=JsonReader.Desrilization("PeronsalPayload",PersonalInfo.class,"UpdateEntity");
		
		String reqbody=JsonReader.serialization(personal);
		
		httpreq.body(reqbody);
	}

	@When("select http put request from RequestSpeccification Object")
	public void select_http_put_request_from_request_speccification_object() {

		resp=httpreq.put(PersonalEndpoint.Per_Put);
	}
}
