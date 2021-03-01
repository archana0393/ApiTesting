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
public class AddPostComment {
	JSONObject request1= new JSONObject();
	@Test
	public void verifyPostDetails(){
		given().
		when().
		       get("https://gorest.co.in/public-api/posts/1277").
		then().
		       statusCode(200). log().all().
		       assertThat().body("data.user_id",equalTo(1430));

	}
	@Test
	public void addComments() {
		request1.put("post_id", 1277);
		request1.put("name", "Agney");
		request1.put("email", "agney@gmail.com");
		request1.put("body", "Comment added successfully");
		System.out.println(request1);
		
		given().
		       headers("Authorization","Bearer " + "56f59c5d5a083bcd228334828f01d97ff70d20cb306f8a1ebfc06f868b971ab9").
		       contentType("application/json").body(request1.toString()).
		when().
		       post("https://gorest.co.in/public-api/comments").
		then().
		       assertThat().body("data.email",equalTo("agney@gmail.com")).
		       statusCode(200).
		       log().all(); 
	}
}
