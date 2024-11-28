package HttpMethods_RestAssured;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class StudenAPi_ParsingPostRequest {

	
//	http://localhost:3000/students
	
	
	@Test
	void parsingjsonObject()
	{
		Response res=given()
		
		    .contentType("application/json")
		
		.when()
		
		   .get("http://localhost:3000/students");
		
		   boolean status = false;
		   JSONArray jarr=new JSONArray(res.asString());
		   for(int i=0;i<jarr.length();i++)
		   {
			  String values= jarr.getJSONObject(i).get("name").toString();
			  if(values.equals("Nilan"))
			  {
				  status=true;
				  break;
			  }
			  System.out.println(values);
			 }
		   Assert.assertEquals(status, true);
		   
		  
		
	}
	
	
	
	
	
}
