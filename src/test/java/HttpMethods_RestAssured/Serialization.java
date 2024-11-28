package HttpMethods_RestAssured;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serialization {

	
	   //1) pojo ---> json  (Serialization)
	   //2) json -Through network--> pojo(De-serialization)
	
	   @Test(priority=1)
	   void serializationTest() throws JsonProcessingException
	   {
		   POJOPostRequest po= new POJOPostRequest();
		   po.setId("20");
		   po.setName("Saga");
		   po.setPhone("22233333");
		   
		   ObjectMapper obj=new ObjectMapper();
		   String values=obj.writerWithDefaultPrettyPrinter().writeValueAsString(po);
		   System.out.println(values);
		   
	   }
	   
	   @Test(priority=2)
	   void deserializationTest() throws JsonProcessingException
	   {
		  
		   
		   String svalue=  "{\n"
		   		+ "  \"username\" : \"Saga\",\n"
		   		+ "  \"location\" : null,\n"
		   		+ "  \"id\" : \"20\",\n"
		   		+ "  \"phone\" : \"22233333\",\n"
		   		+ "  \"courses\" : null\n"
		   		+ "}";
		   final ObjectMapper obj=new ObjectMapper();

		   POJOPostRequest pr= obj.readValue(svalue, POJOPostRequest.class);
		   System.out.println("ID: "+pr.getId()); 
		   System.out.println("Name: "+pr.getName()); 
		   System.out.println("Phone: "+pr.getPhone()); 
		   System.out.println("Location: "+pr.getLocation()); 
		   System.out.println("Courses: "+pr.getcourses()); 
		   
	   }

}
