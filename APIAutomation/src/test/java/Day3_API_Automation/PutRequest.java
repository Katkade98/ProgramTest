package Day3_API_Automation;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

import API_Utility.JsonUtility;
import API_Utility.PayLoadUtility;

public class PutRequest extends JsonUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//https://reqres.in/api/users/2
		
	//Specifed the base URI=
		
	 RestAssured.baseURI="https://reqres.in";
	 String userName="shub";
	 String userJob="SDET";
Response updateUserResponse= given().log().all().header("Content-Type","application/json").body(PayLoadUtility.updateUserPayload(userName, userJob)).when().put("api/users/2").then().log().all().assertThat().statusCode(200)
	 .extract().response();
String userNameRes=getJsonValue(updateUserResponse,"name");
String userJobRes=getJsonValue(updateUserResponse, "job");
Assert.assertEquals(userNameRes,userName);
Assert.assertEquals(userJobRes,userJob);
	
	}


}
