package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import Payload.UserDetails;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import EndPoints.Endpoints;

public class UserTests {
	
	UserDetails payload;
	Faker faker;
	
	
	@BeforeClass
	public void setup() {
		
		faker = new Faker();
		payload =  new UserDetails();
		
		payload.setId(faker.idNumber().hashCode());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setUsername(faker.name().username());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPassword(faker.internet().password(8, 12));
		payload.setPhone(faker.phoneNumber().cellPhone());
			
	}
	
	@Test(priority = 1)
	public void createUserTest() {
		
		
		Response response = Endpoints.createUser(payload);
		
		response.then().statusCode(200);
	
		response.then().log().body();
		
	}
	
	@Test(priority = 2)
	public void getUserDetailsTest() {
		
		Response response = Endpoints.getUserDetails(payload.getUsername());
		
		response.then().statusCode(200);
		
		response.then().log().body();
		
	}
	
	@Test(priority = 3)
	public void updateUserDetailsTest() {
		
		payload.setId(faker.idNumber().hashCode());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		
		Response response = Endpoints.updateUserDetails(payload.getUsername(), payload);
		
		response.then().statusCode(200);
		
		response.then().log().body();
		
	}
	
	
	@Test(priority = 4)
	public void deleteUserDetailsTest() {
		
		Response response = Endpoints.deleteUser(payload.getUsername());
		
		response.then().statusCode(200);
		
		response.then().log().body();
		
	}
	
	
	
	
	
	

}
