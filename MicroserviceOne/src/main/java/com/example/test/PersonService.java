package com.example.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	RestTemplate restTemplate = new RestTemplate();// Useful for communicating between Microservices.
	
	public void addPerson(PersonEntity pe) {
		personRepository.save(pe);
	}
	
	public PersonResponse getPerson(int personId)
	{
		final String uri = "http://localhost:8082/webapitwo/hobby/{personId}";
		
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("personId", personId);	
		
		//Fetch Hobby from MicroserviceTwo
		String result = restTemplate.getForObject(uri, String.class, params); // Get data from the other Microservice.
		
		//Fetch personId, age, name directly from our DB.
		PersonEntity pe = personRepository.findById(personId).get();
		
		
		//Map the results to PersonResponse
		PersonResponse pr = new PersonResponse();
		pr.setPersonId(pe.getPersonId());
		pr.setName(pe.getName());
		pr.setAge(pe.getAge());
		pr.setHobby(result);
		
		return pr;
		
	}

}
