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
public class CreatePost {
	@Test
	public void createNewPost() {
		JSONObject request1= new JSONObject();
		request1.put("user_id", 1430);
		request1.put("title", " This is my post title");
		request1.put("body", "You can add body contents here");
		System.out.println(request1);
		
		given().
		       headers("Authorization","Bearer " + "56f59c5d5a083bcd228334828f01d97ff70d20cb306f8a1ebfc06f868b971ab9").
		       contentType("application/json").body(request1.toString()).
		when().
		       post("https://gorest.co.in/public-api/posts").
		       then().statusCode(200).
		       log().all(); 
	}
}
