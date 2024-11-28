package HttpMethods_RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

public class XMLSchemaValidation {

	
	@Test
	void XMLSchemaValidate()
	{
		
		 given()
		 
		 .when()
		   
		      .get("http://restapi.adequateshop.com/api/Traveler")
		 
		 
		 .then()
		 
		      .statusCode(200)
		      .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("store.xsd")); // file not working
		 
	}
	
	

}
