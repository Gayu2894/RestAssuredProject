package GoRest_ApiChaining;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class getUser {


	@Test
	void getUser_test(ITestContext context)
	{
		//int id =0;
		int id= (Integer)context.getSuite().getAttribute("user_Id");
		
		given()
		
		  .contentType("application/json")
		  .pathParam("myPath1", "public/v2/users")
		  .pathParam("myPath2", id)
		 
		
		.when()
		
		 .get("https://gorest.co.in/{myPath}/{myPath2}")
		 
		
		.then()
		   .statusCode(200)
		   .log().all()
		;
	}
}
