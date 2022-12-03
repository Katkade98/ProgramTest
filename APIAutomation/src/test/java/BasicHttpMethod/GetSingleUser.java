package BasicHttpMethod;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class GetSingleUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//https://reqres.in/api/users/2
		RestAssured.baseURI="https://reqres.in";
	given().log().all().when().get("api/users/2").then().log().all().assertThat().statusCode(200);
	}

}
