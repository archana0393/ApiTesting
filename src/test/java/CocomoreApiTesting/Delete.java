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
public class Delete {
	@Test
	public void deleteUser() {
		given().
		        headers("Authorization","Bearer " + "56f59c5d5a083bcd228334828f01d97ff70d20cb306f8a1ebfc06f868b971ab9").
		        contentType("application/json").
		when().
		        delete("https://gorest.co.in/public-api/users/1430").
		then().
		       statusCode(200).log().all(); 
	}
	@Test
	public void verifydeleteduser() {
		given().
		        headers("Authorization","Bearer " + "56f59c5d5a083bcd228334828f01d97ff70d20cb306f8a1ebfc06f868b971ab9").
		        contentType("application/json").
		when().
		        put("https://gorest.co.in/public-api/users/1430").
		then().
		        body("data.message",equalTo("Resource not found")).
		        statusCode(200).log().all(); 
	}}
