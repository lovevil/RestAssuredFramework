package Tests;

import java.time.Instant;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import EndPoints.Endpoints;
import Payload.OrderDetails;
import io.restassured.response.Response;

public class StoreTests {
	
	OrderDetails payload;
	Faker faker;
	int num;
	
	@BeforeClass
	public void setup() {
		
		faker = new Faker();
		payload =  new OrderDetails();
		Instant now = Instant.now();
		num = faker.number().numberBetween(1, 100);
		
		payload.setId(num);
		payload.setPetId(faker.number().randomDigit());
		payload.setQuantity(faker.number().randomDigitNotZero());
		payload.setShipDate(now.toString());
		payload.setStatus("placed");
		payload.setComplete(faker.bool().bool());
			
	}
	
	@Test(priority = 1)
	public void placeOrderTest() {
		
		System.out.println("store tests started");

		
		
		Response response = Endpoints.placePetOrder(payload);
		
//		System.out.println(payload.getId() + " " + payload.getPetId() + " " + payload.getQuantity() + " " +payload.getShipDate() + " " + payload.getStatus() + " " + payload.getComplete());
		
		response.then().statusCode(200);
	
		response.then().log().body();
		
	}
	
	@Test(priority = 2)
	public void getOrderDetailsTest() {
		
		Response response = Endpoints.getPurchaseOrderDetails(faker.number().numberBetween(1, 10));
		
		response.then().statusCode(200);
		
		response.then().log().body();
		
	}
	

	@Test(priority = 3)
	public void deleteOrderDetailsTest() {
		
			
		Response response = Endpoints.deleteOrderData(num);
		
		response.then().statusCode(200);
		
		response.then().log().body();
		
	}
	
	
	@Test(priority = 4)
	public void getPetInventoryDetailsTest() {
		
		Response response = Endpoints.getPetInventoryDetails();
		
		response.then().statusCode(200);
		
		response.then().log().body();
		
		System.out.println("store tests ended");

		
	}
	
	
	
	
	

}
