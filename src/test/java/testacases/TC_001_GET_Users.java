package testacases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

public class TC_001_GET_Users {

	
	@Test(priority=1)
	public  void GET_All_Users() {
		
		given()
		
		
		.when()
		   .get("https://fakerestapi.azurewebsites.net/api/v1/Users")
		   
		   .then()
		   .statusCode(200);
		
	}
	@Test(priority=2)
public  void POST_An_User() {
		
	
	HashMap data=new HashMap();
	
	data.put("id", "1085353");
	data.put("username", "Rajendra Chozhan");
	data.put("Password", "XYZ");
	
	Response res =
		given()
		
		.contentType("application/json")
		.body(data)
		.when()
		   .post("https://fakerestapi.azurewebsites.net/api/v1/Users")
		   .then()
		   .statusCode(200)
		.log().body()
		.extract().response();
		
		String jasonresponse=res.asString();
		Assert.assertEquals(jasonresponse.contains("Record Added Successfully"),false);
		
		
		
	}
	
		@Test(priority=3)	
		public void DELETE_books() {
			
			
			given()
			
			.contentType("application/json")
			   .when()
			   .delete("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/2")
			   .then()
			   .statusCode(200)	
			   .log().body()
			   .extract().response();
			
			
		}
			 
			
			
		
	
	
	

}
