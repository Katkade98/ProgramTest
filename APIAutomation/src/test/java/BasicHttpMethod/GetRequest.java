package BasicHttpMethod;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class GetRequest {

	public static void main(String[] args) {
		//END Point=https://reqres.in/api/users?page=2
		RestAssured.baseURI="https://reqres.in";
	given().log().all().when().get("api/users?page=2").then().log().all().assertThat().statusCode(200);
	}

}
