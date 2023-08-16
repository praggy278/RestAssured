package jsonResponseValidation;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

public class GetFirst2RepoNames {

	@Test
	public void createRepo() {

		RestAssured.baseURI="https://api.github.com";
		String bearerToken = "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";
		Response response=
				given().
					header("Content-Type", "application/json").
					header("Authorization", "Bearer " + bearerToken).
				when().
					get("/user/repos").
				then().
					assertThat().statusCode(200).and().
					contentType(ContentType.JSON).and().
					extract().response();
		String stringResponse = response.asString();
		JsonPath responseBody = new JsonPath(stringResponse);
		
		System.out.println("Repo Names: " + responseBody.get("name"));
		System.out.println("Repo Name 1: " + responseBody.get("[0].name"));
		System.out.println("Repo Name 2: " + responseBody.get("[1].name"));
	}
}
