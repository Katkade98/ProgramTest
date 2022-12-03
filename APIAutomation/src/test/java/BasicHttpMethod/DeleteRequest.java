package BasicHttpMethod;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class DeleteRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
RestAssured.baseURI ="https://reqres.in";
given().log().all().when().delete("api/users/2").then().log().all().assertThat().statusCode(204);
	}

}
