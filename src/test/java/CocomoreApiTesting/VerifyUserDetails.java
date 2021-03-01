package CocomoreApiTesting;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class VerifyUserDetails {
	@Test
	public void verifyUserData() {
		given().
		when().
		      get("https://gorest.co.in/public-api/users/1430").
		then().
		      statusCode(200).
		      assertThat().body("data.name",equalTo("Akshay")).
		      assertThat().body("data.email",equalTo("agney@gmail.com")).
		      assertThat().body("data.gender",equalTo("Male")).
		      assertThat().body("data.status",equalTo("Active")).
		      log().all();
	}




}
