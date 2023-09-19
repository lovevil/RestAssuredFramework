package EndPoints;

import Payload.UserDetails;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Endpoints {
	
	
	public static Response createUser(UserDetails payload) {
		
		
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.PostRequestURL);
		
		return response;
		
	}
	
	
	public static Response getUserDetails(String userName) {
		
		
		Response response = 
		given()
		.pathParam("username", userName)
		.when()
		.get(Routes.GetRequestURL);
		
		return response;
		
	}
	
	public static Response updateUserDetails(String userName , UserDetails payload) {
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
				.when()
				.put(Routes.PutRequestURL);
				
				return response;
		
	}
	
	public static Response deleteUser(String userName) {
		
		
		Response response = given()
				.pathParam("username", userName)
		.when()
		.delete(Routes.DeleteRequestURL);
		
		return response;
		
	}
	
	
	
	
	
	
	

}
