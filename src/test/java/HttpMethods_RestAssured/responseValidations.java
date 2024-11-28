package HttpMethods_RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class responseValidations {

	
	
	@Test
	void responseValidations()
	{
		//Approach 1:
		given()
		
		   // .contentType("content.JSON")
		
		.when()
		
		   .get("http://localhost:3000/store")
		.then()
		  .statusCode(200)
		  .header("Content-Type", "application/json")
		  .body("book[3].title", equalTo("The Lords of the Rings"))
		  .body("book[2].price", equalTo(75.5F))
		  .body("book[1].price", equalTo(100))
		  .log().all()
		; 
		
		//Approach 2:
		
		/*Response res=given()
		
		   		
		.when()
		   
		    .get("http://localhost:3000/store");
		
		
		     Assert.assertEquals(res.getStatusCode(), 200);
		     //System.out.println(res.getStatusCode());
		     Assert.assertEquals(res.header("Content-Type"), "application/json");
		     //System.out.println(res.header("Content-Type"));
		     
		     String v=res.jsonPath().get("book[1].title").toString();
		     System.out.println(v);
		     Assert.assertEquals(v, "Sword of Honour");
		  */   
		
		//Approach 3: Storing whole JSON 
		
		Response res=given()
		
		   		
		.when()
		   
		    .get("http://localhost:3000/store");
		
		    JSONObject jo=new JSONObject(res.asString());
		    boolean status=false;
		
		     for(int i=0;i<jo.getJSONArray("book").length();i++)
		     {
		    	String book_title= jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		    	System.out.println(jo.getJSONArray("book").get(i));
		    	if(book_title.equals("Moby Dick"))
		    	{
		    	    status = true;
		    		break;
		    	}
		    	
		     }
		   Assert.assertEquals(status, true);
		
	}
	
	
	 @Test(priority=2)
	 void testbyTotalPrice()
	 {

			Response res=given()
			
			   		
			.when()
			   
			    .get("http://localhost:3000/store");
			
			JSONObject jo = new JSONObject(res.asString());
		
		    double TotalPrice = 0;
		    
		    for(int i=0;i<jo.getJSONArray("book").length();i++)
			{
				String d =jo.getJSONArray("book").getJSONObject(i).get("price").toString();
				TotalPrice = TotalPrice+Double.parseDouble(d) ;
			}
		    System.out.println(TotalPrice);
		    Assert.assertEquals(TotalPrice, 526.0);
		    
		 
	 }

}
