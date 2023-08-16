package basic.rest.getcall;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

public class VerifyResponseTest {

	@Test
	public void verifyResponseBody() {
		RestAssured.baseURI="https://api.trello.com";
		given().
		param("key", "4a7fe23c76a6bda2dc5eae9ea5377abd").
		param("token", "ATTA5e6da541abdaef6d352b2599e11a8c3a9ad9419b028ca3448342feea436277d90F99759B").
		log().all().
	when().
		get("/1/boards/fBdc2ebT").
	then().
		assertThat().statusCode(200).and().
		contentType(ContentType.JSON).and().
		body("name", equalTo("My First Board")).and().
		body("desc", equalTo("This is a Practice Board for Testing REST API.")).log().all();
	}
	
	@Test
	public void verifyResponseHeader() {
		RestAssured.baseURI="https://api.trello.com";
		given().
		param("key", "ccd3215b0059c20cb38867f33346e8f1").
		param("token", "922731ccc7fc77df3ce1a208830177e367f8c0769a1441e01a796370a45392c9").
	when().
		get("/1/boards/XJaDDM5o").
	then().
		assertThat().statusCode(200).and().
		contentType(ContentType.JSON).and().
		header("Referrer-Policy", "strict-origin-when-cross-origin").and().
		header("X-Trello-Environment", "Production");
	}
}
