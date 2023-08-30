package ApiTesting;

import org.junit.Assert;
import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.response.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class site1 {
	
	@Test
	public void getBooking() {
		
		System.out.println("Retrive data booking_id 1");
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		
		  Response response=given()
		  
		  .when()
		  
		        .get("/booking/1")
		      
		  .then()
		  .extract().response();
		  
		  String responseBody=response.getBody().asString();
		  System.out.println(responseBody);
		  
		  String firstName=response.jsonPath().getString("firstname");
          System.out.println(firstName);
		
          Object headers=response.getHeaders();
          System.out.println(headers);
          
          Object cookies=response.getCookies();
          System.out.println(cookies);
		  
		 
          
	}
	
	@Test
	public void createToken() {
		
		System.out.println("create token using post request");
		
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		HashMap data=new HashMap();
		data.put("username", "admin");
		data.put("password", "password123");
		
		       Response response= given()
		    		   
		             .contentType("application/json")
		             .body(data)
                 		        
		        .when()
		        
		             .post("/auth")
		             
		        .then()
		        .extract().response();
		
		String responseBody=response.body().asString();
		System.out.println(responseBody);
		
		System.out.println(response.statusCode());
	}
	
	
	
	@Test
	public void getBookingIds() {
		
		System.out.println("All Ids");
		
		Response response=given()
		
		.when()
		
		       .get("https://restful-booker.herokuapp.com/booking")
		       
		       
		.then()
		.statusCode(200)
		.assertThat()
		.extract().response();
		
		String responseBody=response.body().asString();
		System.out.println(responseBody);
		
		String content_type=response.getContentType();
		System.out.println(content_type);
		
	}
	


}
