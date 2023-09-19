package EndPoints;

import Payload.OrderDetails;
import Payload.UserDetails;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class Endpoints {
	
	
	// User Endpoints methods 

	
	
	public static Response createUser(UserDetails payload) {
		
		
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.UserPostRequestURL);
		
		return response;
		
	}
	
	
	public static Response getUserDetails(String userName) {
		
		
		Response response = 
		given()
		.pathParam("username", userName)
		.when()
		.get(Routes.UserGetRequestURL);
		
		return response;
		
	}
	
	public static Response updateUserDetails(String userName , UserDetails payload) {
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
				.when()
				.put(Routes.UserPutRequestURL);
				
				return response;
		
	}
	
	public static Response deleteUser(String userName) {
		
		
		Response response = given()
				.pathParam("username", userName)
		.when()
		.delete(Routes.UserDeleteRequestURL);
		
		return response;
		
	}
	
	
	
	// Store Endpoints methods 
	
	
	public static Response placePetOrder(OrderDetails payload) {
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(Routes.PlaceOrderPostRequestUrl);
				
				return response;
		
	}
	
	
   public static Response getPurchaseOrderDetails(int orderid) {
		
		
		Response response = 
		given()
		.pathParam("orderid", orderid)
		.when()
		.get(Routes.GetOrderDetailsRequestUrl);
		
		return response;
		
	}
   
   
   public static Response deleteOrderData(int orderid) {
		
		
		Response response = given()
				.contentType(ContentType.JSON)
				.pathParam("orderid", orderid)
		.when()
		.delete(Routes.DeleteOrderRequestUrl);
		
		return response;
		
	}
   
   
   
   public static Response getPetInventoryDetails() {
		
		
		Response response = given()
				.contentType(ContentType.JSON)
		.when()
		.get(Routes.GetPetInventoryRequestUrl);
		
		return response;
		
	}
	
	
	
	
	
	
	

}
