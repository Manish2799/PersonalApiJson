package BaseApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {

	protected static ValidatableResponse vrs;

	public static String pid;
	protected static Response resp;
	protected static RequestSpecification httpreq;

	public static void Intialization() {
		httpreq = RestAssured.given().contentType(ContentType.JSON).log().all();
	}
}
