package Day_2_Automation;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import  static io.restassured.RestAssured.*;

import org.testng.Assert;
public class GetRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 //Specified the base URL= https://reqres.in/api/unknown/2
		RestAssured.baseURI="https://reqres.in";

		//FOR Automation API We Use BDD approach in that we use gherkin key annotation 
Response getResponse=given().log().all().when().get("api/unknown/2").then().log().all().assertThat().statusCode(200).extract().response();
 
//validate the reponse code 
int statusCode=getResponse.getStatusCode();
System.out.println("status code :"+ statusCode);
Assert.assertEquals(statusCode,200);


//Response time validation 
System.out.println("Response-Time: "+getResponse.getTime());
Assert.assertTrue(getResponse.getTime()<4200);	
	}

}
