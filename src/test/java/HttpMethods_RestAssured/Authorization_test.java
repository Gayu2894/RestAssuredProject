package HttpMethods_RestAssured;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Authorization_test {

	 @Test(priority=1)
	 void authorization_Basic()
	 {
		given()
		
		 .auth().basic("postman", "password")
		
		.when()
		
		   .get("https://postman-echo.com/basic-auth")
		
		.then()
		  .statusCode(200)
		  .body("authenticated", equalTo(true))
		  .log().all();
	 }
	 
	 @Test(priority=2)
	 void authorization_Digest()
	 {
		given()
		
		 .auth().digest("postman", "password")
		
		.when()
		
		   .get("https://postman-echo.com/basic-auth")
		
		.then()
		  .statusCode(200)
		  .body("authenticated", equalTo(true))
		  .log().all();
	 }
	 
	 @Test(priority=3)
	 void authorization_Preemptive()
	 {
		given()
		
		 .auth().preemptive().basic("postman", "password")
		
		.when()
		
		   .get("https://postman-echo.com/basic-auth")
		
		.then()
		  .statusCode(200)
		  .body("authenticated", equalTo(true))
		  .log().all();
	 }
	 
	 @Test(priority=4)
	 void authorization_bearerToken()
	 {
		 
		String bearertoken = "fake_token";
		
		given()

		  .header("Authorization", "Bearer "+bearertoken)
		
		.when()
		
		   .get("https://api.github.com/users/repos")
		
		.then()
		  .statusCode(200)
		  .log().all();
	 }
	 
	 //@Test(priority=5)
	 void authorization_OuthAuth1()
	 {
		given()

		  .auth().oauth("consumerKey", "consumer secret", "accessToken", "TokenSecret") 
		
		.when()
		
		   .get("url")
		
		.then()
		  .statusCode(200)
		  .log().all();
	 }
	 
	 //@Test(priority=6)
	 void authorization_OuthAuth2()
	 {
		given()

		  .auth().oauth2("accessToken")
		  
		.when()
		
		   .get("url")
		
		.then()
		  .statusCode(200)
		  .log().all();
	 }
	 
	//@Test(priority=6)
		 void authorization_Apikey()
		 {
			given()
			
			   .queryParam("appid", "token")
			   .queryParam("q", "delhi")
			   .queryParam("metric", "7")
			  
			.when()
			
			   .get("url/")
			
			.then()
			  .statusCode(200)
			  .log().all();
		 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
