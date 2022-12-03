package Day_2_Automation;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;

public class PostRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method st

		// https://reqres.in/api/users
		RestAssured.baseURI = "https://reqres.in";

		Response createResponse = given().log().all().header("Content-Type", "application/json")
				.body("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"leader\"\r\n" + "}").when()
				.post("api/users").then().log().all().assertThat().statusCode(201).extract().response();
//validate the response code and header
		int statusCode = createResponse.getStatusCode();
		System.out.println("StatusCode :" + statusCode);
		Assert.assertEquals(statusCode, 201);

//header --->Content-Type
		String header1 = createResponse.getHeader("Content-Type");
		System.out.println("Content-Type header Name: " + header1);
		Assert.assertEquals(header1, "application/json; charset=utf-8");

// header --->
		System.out.println("X-Powered-By :" + createResponse.getHeader("X-Powered-By"));
		Assert.assertEquals(createResponse.getHeader("X-Powered-By"), "Express");
	}

}
