package HttpMethods_RestAssured;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class getCookies {
	
	
	@Test(priority=1)
	void getCookies()
	{
		 Response res= given()
		
		
		.when()
		
		   .get("https://www.google.com");
		 
		  Map<String,String> cookies_values= res.getCookies();
		  for( String k: cookies_values.keySet())
		  {
			  String v= res.getCookie(k);
			  
			  //String v= getCookie(k);
			  System.out.println(k+"    " +v);
		  }
		
		/*.then()
		   .log().all()
		;*/
	}

}
