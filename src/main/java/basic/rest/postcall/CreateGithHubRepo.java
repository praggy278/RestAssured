package basic.rest.postcall;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

public class CreateGithHubRepo {

	@Test
	public void createRepo() {
		String repoName="CreatedByRestAssured4";
		String repoDescription="This repository is created through Rest Assured";
		String repoPrivate="true";
		System.out.println(repoName+": "+repoDescription+": "+repoPrivate);
		System.out.println("{\n"
				+ "  \"name\": "+repoName+"\n"
				+ "  \"description\": "+repoDescription+"\n"
				+ "  \"private\": "+repoPrivate+"\n"
				+ "}");
		RestAssured.baseURI="https://api.github.com";
		String bearerToken = "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";
		given().
		header("Content-Type", "application/json").
		header("Authorization", "Bearer " + bearerToken).
		body("{\n"
		   		+ "    \"name\": \""+repoName+"\",\n"
		   		+ "    \"private\": "+repoPrivate+",\n"
		   		+ "    \"description\": \""+repoDescription+"\"\n"
		   		+ "}").
	when().
		post("/user/repos").
	then().
		assertThat().statusCode(201).and().
		contentType(ContentType.JSON).and().
		body("name", equalTo(repoName)).and().
		body("description", equalTo(repoDescription)).and().
		body("private", equalTo(true));
	}
}
