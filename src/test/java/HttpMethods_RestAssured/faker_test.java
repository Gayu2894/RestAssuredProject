package HttpMethods_RestAssured;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class faker_test {

	
	@Test
	void generate_RandomData()
	{
		
		Faker faker=new Faker();
		
		HashMap<String, Object> hm =new HashMap<String, Object>();
		hm.put("Name: ",faker.name().firstName());
		hm.put("LastName: ",faker.name().lastName());
		hm.put("userName :",faker.name().username());
		hm.put("Email :",faker.internet().emailAddress());
		hm.put("password :",faker.internet().password());
		hm.put("Job :",faker.job());
		System.out.println(hm);
		
		
		//faker.
		
	}
	
	
	
}
