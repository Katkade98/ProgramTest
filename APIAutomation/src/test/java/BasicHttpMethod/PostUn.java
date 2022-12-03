package BasicHttpMethod;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
public class PostUn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//      END Point==https://reqres.in/api/register
		
		RestAssured.baseURI="https://reqres.in";
	Response createResponse=given().log().all().header("Content-Type","application/json").body("{\r\n"
				+ "    \"email\": \"sydney@fife\"\r\n"
				+ "}").when().post("api/register").then().log().all().assertThat().statusCode(400).extract().response();
	//how to validate the status code and header
int responseStatusCode=createResponse.getStatusCode(); //return the status code of response
System.out.println("Response statusCode:"+responseStatusCode);
Assert.assertEquals(responseStatusCode,400);

 
 String header1=createResponse.getHeader("Content-Type");
 System.out.println("Content-Type header value :"+header1);
 Assert.assertEquals(header1,"application/json; charset=utf-8");
 String  server=createResponse.getHeader("Server");
 System.out.println("Server header value :"+server);
 Assert.assertEquals(server, "cloudflare");
	
	//How to validate the Response-time
 System.out.println("Response Time :"+createResponse.getTime() );
 Assert.assertTrue(createResponse.getTime()<=2500);

 
 //How to print the response body 
 String responseBody=createResponse.asPrettyString();
 System.out.println("Response body is /n: "+responseBody);
// How to validate reponse body
//To validate the Json reponse first we have to parse  it using JsonPath class 
 JsonPath jp=new JsonPath(createResponse.asString());
 String errorMessage=jp.get("error");
 System.out.println("Error Message :"+errorMessage);
	}

}
