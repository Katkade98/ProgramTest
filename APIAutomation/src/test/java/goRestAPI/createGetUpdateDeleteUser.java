package goRestAPI;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import API_Utility.PayLoadUtility;
public class createGetUpdateDeleteUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//https://gorest.co.in/public/v2/users// end point
		
		RestAssured.baseURI="https://gorest.co.in";
	given().log().all().header("Content-Type","application/json").header("Authorization","Bearer d497d1df556239d748701f28e048b3c22feac3dc73de9bb49b223e48fa4185ff")
	.body(PayLoadUtility.createUserGoRestPayLoad("Amit", "male", "Amit123@gmail.com", "Active")).when().post("public/v2/users").then().log().all() ;
	}

}
