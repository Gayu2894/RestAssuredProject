package HttpMethods_RestAssured;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class POJOPostRequest {

	private String name;
	
	@JsonIgnore
	private String password;
	
	private String location;
	private String id;
	private String phone;
	private String[] courses;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String[] getcourses() {
		return courses;
	}
	public void setcourses(String[] courses) {
		this.courses = courses;
	}
	
}
