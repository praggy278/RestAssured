package basic.rest.postcall;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

public class PostCallAutomation {

	@Test
	public void createBoard() {
		String boardName="Automation Sprint "+(int)(Math.random()*100);
		System.out.println(boardName);
		RestAssured.baseURI="https://api.trello.com";
		given().
		queryParam("key", "4a7fe23c76a6bda2dc5eae9ea5377abd").
		queryParam("token", "ATTA5e6da541abdaef6d352b2599e11a8c3a9ad9419b028ca3448342feea436277d90F99759B").
		queryParam("name", boardName).
		header("Content-Type", "application/json").
	when().
		post("/1/boards").
	then().
		assertThat().statusCode(200).and().
		contentType(ContentType.JSON).and().
		body("name", equalTo(boardName));
	}
}
