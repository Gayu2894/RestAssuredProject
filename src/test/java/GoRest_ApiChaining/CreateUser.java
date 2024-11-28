package GoRest_ApiChaining;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser {

	
	@Test
	void createUser_test(ITestContext context)
	{
		
		Faker faker=new Faker();
		
		JSONObject jobj=new JSONObject();
	
		jobj.put("name", faker.name().firstName());
		jobj.put("gender", "female");
		jobj.put("email", faker.internet().emailAddress());
		jobj.put("status", "inactive");
		
		int id= given()
		
		  .contentType("application/json")
		  .pathParam("myPath", "public/v2/users")
		  .body(jobj.toString())
		
		.when()
		
		 .post("https://gorest.co.in/{myPath}")
		 .jsonPath().getInt("id");
		
		 context.setAttribute("user_Id", id);
		
		/*.then()
		   .statusCode(200)
		   .log().all()
		;*/
	}
	 
}
