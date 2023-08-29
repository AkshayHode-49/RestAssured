package com.RestAssured;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class com_Site1 {
	
	
	
	@Test(groups="GET")
	public void GET_tc001() {
		
		Response response=given()
		
		
		.when()
		    
		        .get("https://dummy.restapiexample.com/api/v1/employees")
		        
		        
		 .then()
		 .statusCode(200)
		 .assertThat()
		 .statusCode(200)
		 .extract().response();
		
		String responseBody=response.body().asString();
		System.out.println(responseBody);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getContentType(), "application/json");
		Assert.assertEquals(response.jsonPath().getString("status"), "success");
		
		String check=response.jsonPath().getString("status");
		System.out.println("status :"+check);
		
		
		
	}
	
	@Test(groups="GET") 
	public void GET_tc002() {
		
		Response response=given()
		
		
		
		.when()
		
		      .get("https://dummy.restapiexample.com/api/v1/employee/1")
		      
		      
		 .then()
		 .statusCode(200)
		 .assertThat()
		 .contentType("application/json")
		 .extract().response();
		
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("data.employee_name"), "Tiger Nixon");
		
	
	}
	
	@Test(groups="POST")
	public void POST_tc003() {
		
		HashMap data=new HashMap();
		data.put("name", "test");
		data.put("salary", "123");
		data.put("age", "23");
		
		Response response=given()
		      .contentType("application/json")
		      .body(data)
		
		.when()
		
		      .post("https://dummy.restapiexample.com/api/v1/create")
		      
		 .then()
		 .assertThat()
		 .extract().response();
		
		String responseBody=response.body().asString();
		System.out.println(responseBody);
		
		int status_code=response.getStatusCode();
		System.out.println("Status code :"+status_code);
		
		Assert.assertEquals(response.jsonPath().getString("data.name"), "test");
		Assert.assertEquals(response.getStatusCode(), 200);
	
		
		Assert.assertEquals(response.jsonPath().getString("data.salary"), "123");
		
//		SoftAssert sa=new SoftAssert();
//		sa.assertAll();
		
	}
	
	
	@Test(groups="PUT")
	public void PUT_tc004() {
		
		HashMap data=new HashMap();
		data.put("name", "test");
		data.put("salary", "123");
		data.put("age", "23");
		
		Response response=given()
		
		     .contentType("application/json")
		     .body(data)
		
		.when()
		     .put("https://dummy.restapiexample.com/api/v1/update/21")
		     
		 .then()
		 .assertThat()
		 .extract().response();
		
		String responseBody=response.body().asString();
		System.out.println(responseBody);
		
	}
	

	
	

}
