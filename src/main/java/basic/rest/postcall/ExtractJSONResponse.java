package basic.rest.postcall;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

public class ExtractJSONResponse {

	@Test
	public void extractResponse() {
		
		RestAssured.baseURI="https://api.github.com";
		String bearerToken = "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";
		String repoName="CreatedByRestAssured";
		String repoDescription="This repository is created through Rest Assured";
		String repoPrivate="true";
		System.out.println(repoName+": "+repoDescription+": "+repoPrivate);
		String requestBody="{\n"
		   		+ "    \"name\": \""+repoName+"\",\n"
		   		+ "    \"private\": "+repoPrivate+",\n"
		   		+ "    \"description\": \""+repoDescription+"\"\n"
		   		+ "}";
		System.out.println(requestBody);
		
		Response response=given().
			header("Content-Type", "application/json").
			header("Authorization", "Bearer " + bearerToken).
			body(requestBody).
		when().
			post("/user/repos").
		then().
			assertThat().statusCode(201).and().
			contentType(ContentType.JSON).and().
			body("name", equalTo(repoName)).and().
			body("description", equalTo(repoDescription)).and().
			body("private", equalTo(true)).
		extract().response();
		
		String stringResponse = response.asString();
		JsonPath responseBody = new JsonPath(stringResponse);
		
		System.out.println("Node Id : " + responseBody.get("node_id"));
		System.out.println("Name : " + responseBody.get("name"));
		System.out.println("Full Name : " + responseBody.get("full_name"));
	}
}
