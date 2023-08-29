package com.RestAssured;
import org.testng.Assert;

import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.*;



public class com_Site {
	
	@BeforeMethod
	public void setUp() {
		
		System.out.println("Thread Id :"+Thread.currentThread().getId());
		RestAssured.baseURI="https://fakerestapi.azurewebsites.net";
	
	}
	

	@Test(priority=1)
	public void GET_tc001() {
		
		Response response=given()
		
		.when()
		
		      .get("/api/v1/Activities")

		.then()
		.assertThat()
		.statusCode(200)
		.log().all()
		.extract().response();
		
	String responseBody=response.body().asString();
	System.out.println(responseBody);
	
	Object responseHeaders=response.getHeaders();
	System.out.println(responseHeaders);
	
	Object o=response.jsonPath().getJsonObject("id");
	System.out.println("check :"+o);
		
		
	}
	
	@Test(priority=2)
	public void Post() {
		
		HashMap data=new HashMap();
		data.put("id", "0");
		data.put("title", "string");
		data.put("dueDate", "2023-08-27T04:39:41.677Z");
		data.put("completed", true);
		
		
		Response response=given()
				
				.contentType("application/json")
				.body(data)
		
		.when()
		
		       .post("/api/v1/Activities")
		       
		.then()
		.assertThat()
		.statusCode(200)
		.extract().response();
		
	String responseBody=response.body().asString();
	System.out.println(responseBody);
	
	Object responseHeaders=response.getHeaders();
	System.out.println(responseHeaders);
	
	Assert.assertEquals(response.jsonPath().getString("completed"), "true");
		
	}
	
	
	@Test(priority=3)
	public void Get_002() {
		
		
		Response response=given()
		
		.when()
		
		      .get("/api/v1/Activities/3")
		      
		      
		 .then()
		 .assertThat().statusCode(200)
		 .extract().response();
	
	}
	
	
	@Test(priority=4)
	public void Delete() {
		
		
		given()
		
		.when()
		
		       .delete("/api/v1/Activities/3")
		       
		       
	     .then()
	     .assertThat()
	     .statusCode(200)
    	.extract().response();
		
	}

}
