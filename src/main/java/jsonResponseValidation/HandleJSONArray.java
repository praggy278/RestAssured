package jsonResponseValidation;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

public class HandleJSONArray{

	@Test
	public void verifyResponseBody() {
		RestAssured.baseURI="https://api.trello.com";
		Response response=
				given().
					param("key", "4a7fe23c76a6bda2dc5eae9ea5377abd").
					param("token", "ATTA5e6da541abdaef6d352b2599e11a8c3a9ad9419b028ca3448342feea436277d90F99759B").
				when().
					get("/1/boards/fBdc2ebT").
				then().
					assertThat().statusCode(200).and().
					contentType(ContentType.JSON).and().
					body("name", equalTo("My First Board")).and().
					body("desc", equalTo("This is a Practice Board for Testing REST API.")).log().all().
					extract().response();
		String stringResponse = response.asString();
		JsonPath responseBody = new JsonPath(stringResponse);
		
		System.out.println("Board Name : " + responseBody.get("name"));//My First Board
		System.out.println("BackGround ID : " + responseBody.get("prefs.background"));//purple
		System.out.println("BackGround URL : " + responseBody.get("prefs.backgroundColor"));//#89609E
		System.out.println("BackGround Image Width : " + responseBody.get("prefs.switcherViews[4]._id"));//63e6431d10faa59a4d05e437
		
		int backGroundSize = responseBody.getInt("prefs.switcherViews.size()");
		for (int i = 0; i < backGroundSize; i++) {
			String viewType = responseBody.get("prefs.switcherViews["+i+"].viewType");
			String id = responseBody.get("prefs.switcherViews["+i+"]._id");
			
			System.out.println("View Type at "+i+" is : "+ viewType +" and ID is : " + id);
		}
	}
}
