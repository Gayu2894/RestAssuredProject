package HttpMethods_RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class DifferentWaysOfPostRequest {

	// @Test(priority=1)
	 void testPostHashMap()
	 {
		 
		 
		 HashMap<Object,Object> hm=new HashMap<Object,Object>();
		 hm.put("id", "5");
		 hm.put("name", "Siva");
		 hm.put("location", "Chennai");
		 hm.put("phone", "1233221145");
		 String coursesArr[]= {"C","C++"};
		 hm.put("courses", coursesArr);
		 
		 
		 given()
		 
		   .contentType("application/json")
		   .body(hm)
		  
		 .when()
		 
		    .post("http://localhost:3000/students")
		 
		 
		 .then()
		 
		     .statusCode(201)
		     .body("id", equalTo("5"))
		     .body("name", equalTo("Siva"))
		     .body("location", equalTo("Chennai"))
		     .body("phone", equalTo("1233221145"))
		     .body("courses[0]", equalTo("C"))
		     .body("courses[1]", equalTo("C++"))
		     .header("content-type", "application/json")
		     .log().all();
	 }
	 
	// @Test(priority=1)
	 void testPostJsonLibrary()
	 {
		 
		 
		JSONObject obj=new JSONObject();
		 obj.put("id", "5");
		 obj.put("name", "Siva");
		 obj.put("location", "Chennai");
		 obj.put("phone", "1233221145");
		 String coursesArr[]= {"C","C++"};
		 obj.put("courses", coursesArr);
		 
		 
		 given()
		 
		   .contentType("application/json")
		   .body(obj.toString())
		  
		 .when()
		 
		    .post("http://localhost:3000/students")
		 
		 
		 .then()
		 
		     .statusCode(201)
		     .body("id", equalTo("5"))
		     .body("name", equalTo("Siva"))
		     .body("location", equalTo("Chennai"))
		     .body("phone", equalTo("1233221145"))
		     .body("courses[0]", equalTo("C"))
		     .body("courses[1]", equalTo("C++"))
		     .header("content-type", "application/json")
		     .log().all();
	 }
	 
	 
	 //@Test(priority=1)
	 void testPostUsingPOJO()
	 {
		 POJOPostRequest POJOobj=new POJOPostRequest();
		 POJOobj.setId("5");
		 POJOobj.setName("Siva");
		 POJOobj.setLocation("Chennai");
		 POJOobj.setPhone("1233221145");
		 String coursesArr[]= {"C","C++"};
		 POJOobj.setcourses(coursesArr);
		 
	     given()
		 
		   .contentType("application/json")
		   .body(POJOobj)
		  
		 .when()
		 
		    .post("http://localhost:3000/students")
		 
		 .then()
		 
		     .statusCode(201)
		     .body("id", equalTo("5"))
		     .body("name", equalTo("Siva"))
		     .body("location", equalTo("Chennai"))
		     .body("phone", equalTo("1233221145"))
		     .body("courses[0]", equalTo("C"))
		     .body("courses[1]", equalTo("C++"))
		     .header("content-type", "application/json")
		     .log().all();
	 }
	 
	     @Test(priority=1)
		 void testPostExternalFile() throws FileNotFoundException
		 {
	    	 
	       
	    	 //File file=new File("/Users/saravana/eclipse-workspace/RestAssuredProject/body.json");
	    	 // File file=new File(System.getProperty("user.dir")+"/body.json");
	    	 File file=new File(".//body.json");
	    	 FileReader fr= new FileReader(file);
	    	 
			 JSONTokener jt=new JSONTokener(fr);
			 JSONObject obj=new JSONObject(jt);
			 
			 given()
			 
			   .contentType("application/json")
			   .body(obj.toString()) //converting JSONObject to String - only for JSON Object
			  
			 .when()
			 
			    .post("http://localhost:3000/students")
			 
			 
			 .then()
			 
			     .statusCode(201)
			     .body("id", equalTo("5"))
			     .body("name", equalTo("Sivani"))
			     .body("location", equalTo("Coimbatore"))
			     .body("phone", equalTo("0000001111"))
			     .body("courses[0]", equalTo("Medical Coding"))
			     .body("courses[1]", equalTo("C++"))
			     .header("content-type", "application/json")
			     .log().all();
		 }
		 
	 
	 
	@Test(priority=2)
	 
	 void testDelete()
	 {
		 
		 when()
		 
		  .delete("http://localhost:3000/students/5")
		  
		 .then()
		 
		   .statusCode(200)
		   .log().all();
		  
	 }
	
}
