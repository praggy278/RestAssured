package basic.rest.getcall;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetMethodAutomation {

	public static String baseUri = "https://api.trello.com";
	public static void main(String args[]) {
		RestAssured.baseURI=baseUri;
		given().
		param("key", "4a7fe23c76a6bda2dc5eae9ea5377abd").
		param("token", "ATTA5e6da541abdaef6d352b2599e11a8c3a9ad9419b028ca3448342feea436277d90F99759B").
	when().
		get("/1/boards/fBdc2ebT").
	then().
		assertThat().statusCode(200).and().
		contentType(ContentType.JSON).and().
		body("name", equalTo("My First Board")).and().
		body("desc", equalTo("This is a Practice Board for Testing REST API."));
	
	System.out.println("This is the First Get Automation Call.");
	System.out.println("Get Call executed successfully");
	}
}
