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
public class CreateUser {
	@Test
	public void createNewUser() {
		JSONObject request= new JSONObject();

		request.put("name", "Akshay");
		request.put("email", "agney@gmail.com");
		request.put("gender", "Male");
		request.put("status", "Active");
		System.out.println(request);
		
		given().
		        headers("Authorization","Bearer " + "56f59c5d5a083bcd228334828f01d97ff70d20cb306f8a1ebfc06f868b971ab9").
		        contentType("application/json").body(request.toString()).
		when().
		        post("https://gorest.co.in/public-api/users").
		then().
		        statusCode(200).log().all(); 




	}
}
