package EndPoints;

public class Routes {
	
	public static String UserBaseURL = "https://petstore.swagger.io/v2/user";
	
	public static String UserPostRequestURL = UserBaseURL;
	
	public static String UserGetRequestURL = UserBaseURL + "/{username}";

	public static String UserPutRequestURL = UserBaseURL + "/{username}";

	public static String UserDeleteRequestURL = UserBaseURL + "/{username}";
	
	public static String StoreBaseURL = "https://petstore.swagger.io/v2/store";
	
	public static String PlaceOrderPostRequestUrl = StoreBaseURL + "/order";

	public static String GetOrderDetailsRequestUrl = PlaceOrderPostRequestUrl + "/{orderid}";

	public static String DeleteOrderRequestUrl = PlaceOrderPostRequestUrl + "/{orderid}";

	public static String GetPetInventoryRequestUrl = StoreBaseURL + "/inventory";
	
}
