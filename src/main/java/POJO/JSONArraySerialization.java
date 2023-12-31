package POJO;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONArraySerialization {

public String completeJson;
	
	@Test
	public void createJSONArrayFromPOJO() throws JsonProcessingException {
		
		SamplePOJO anshul = new SamplePOJO();
		anshul.setFirstName("Anshul");
		anshul.setLastName("Chauhan");
		anshul.setAge(29);
		anshul.setGender("Male");
		anshul.setSalary(123456);
		anshul.setMarried(false);
		
		
		SamplePOJO mark = new SamplePOJO();
		mark.setFirstName("Mark");
		mark.setLastName("Wood");
		mark.setAge(30);
		mark.setGender("Male");
		mark.setSalary(200000.3);
		mark.setMarried(true);
		
		SamplePOJO kitty = new SamplePOJO();
		kitty.setFirstName("Kitty");
		kitty.setLastName("Martin");
		kitty.setAge(26);
		kitty.setGender("Female");
		kitty.setSalary(300000.3);
		kitty.setMarried(false);
		
		List<SamplePOJO> allemployees = new ArrayList<SamplePOJO>();
		allemployees.add(anshul);
		allemployees.add(mark);
		allemployees.add(kitty);
		
		ObjectMapper objectMapper = new ObjectMapper();
		completeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(allemployees);
		System.out.println(completeJson);
		
	}
	
	@Test
	public void getPOJOsfromStringJSONArray() throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		List<SamplePOJO> allemployees = objectMapper.readValue(completeJson, new TypeReference<List<SamplePOJO>>() { });
		
		for (SamplePOJO empployee : allemployees) {
			System.out.println("========================================================");
			System.out.println("First Name of employee : " + empployee.getFirstName());
			System.out.println("Last Name of employee : " + empployee.getLastName());
			System.out.println("Age of employee : " + empployee.getAge());
			System.out.println("Gender of employee : " + empployee.getGender());
			System.out.println("Salary of employee : " + empployee.getSalary());
			System.out.println("Marital status of employee : " + empployee.getMarried());
			System.out.println("========================================================");
		
		}
		
	}
}
