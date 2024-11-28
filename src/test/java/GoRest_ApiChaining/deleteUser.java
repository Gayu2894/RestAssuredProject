package GoRest_ApiChaining;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class deleteUser {

	

	@Test
	void deleteUser_test(ITestContext context)
	{
		int id= (Integer)context.getSuite().getAttribute("user_Id");
		
		given()
		
		  .contentType("application/json")
		  .pathParam("myPath1", "public/v2/users")
		  .pathParam("myPath2", id)
		 
		
		.when()
		
		 .delete("https://gorest.co.in/{myPath}/{myPath2}")
		 
		
		.then()
		   .statusCode(204)
		   .log().all()
		;
	}
}
