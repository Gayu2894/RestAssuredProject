package GoRest_ApiChaining;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class updateUser {

	    @Test
		void updateUser_test(ITestContext context)
		{
			
			int id= (Integer)context.getSuite().getAttribute("user_Id");
			Faker faker=new Faker();
			
			JSONObject jobj=new JSONObject();
		
			jobj.put("name", faker.name().firstName());
			jobj.put("gender", "male");
			jobj.put("email", faker.internet().emailAddress());
			jobj.put("status", "active");
			
			given()
			
			  .contentType("application/json")
			  .pathParam("myPath1", "public/v2/users")
			  .pathParam("myPath2", id)
			  .body(jobj.toString())
			
			.when()
			
			 .put("https://gorest.co.in/{myPath}/{myPath2}")
			 
			.then()
			   .statusCode(200)
			   .log().all();
			
}
}