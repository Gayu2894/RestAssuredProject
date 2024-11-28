package HttpMethods_RestAssured;


import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class getHeaders {
	
	
	
	//@Test(priority=1)
	void testHeaders()
	{
		 given()
		
		
		.when()
		  
		   .get("https://www.google.com")
		
		
		.then()
		   .statusCode(200)
		   .header("Content-Type", "text/html; charset=ISO-8859-1")
		   .header("Content-Encoding", "gzip")
		   .header("Server", "gws")
		   //.log().headers();
		   ;
	}
	
	@Test(priority=2)
	void getHeaders()
	{
		Response res= given()
		
		    .when()
		       .get("https://www.google.com");
		
		         String header= res.getHeader("Content-Type");
		         System.out.println(header); 
		         
		         
		      Headers h=   res.getHeaders();
		      for(Header g: h)
		      {
		    	  System.out.println(g.getName() + " "+ g.getValue()); 
		    	
		      }
		     
		
		
		/*.then()
		   .statusCode(200)
		   .header("Content-Type", "text/html; charset=ISO-8859-1")
		   .header("Content-Encoding", "gzip")
		   .header("Server", "gws")
		   //.log().headers();*/
		   ;
	}
	
	
	
	

}
