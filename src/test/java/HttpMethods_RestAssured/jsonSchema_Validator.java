package HttpMethods_RestAssured;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class jsonSchema_Validator {

	
	
	@Test
	void jsonSchemaValidation()
	{
		
		 given()
		 
		 .when()
		   
		      .get("http://localhost:3000/store")
		 
		 
		 .then()
		 
		      .statusCode(200)
		      .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JsonStoreSchema.json"));
		 
	}
	
	
	
	
	
}
