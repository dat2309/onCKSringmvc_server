package com.se.onck3.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.onck3.entity.Person;
import com.se.onck3.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonRestController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/persons")
	public List<Person> getPersons(){
		List<Person> list = personService.getPersons();
		return list;
	}
	
	@GetMapping("/persons/{personId}")
	public Person getPerson(@PathVariable("personId") int personId){
		Person p = personService.getPerson(personId);
		if(p == null) {
			throw new RuntimeException("Person not found :"+ personId);
		}
		return p;
	}
	
	@PostMapping("/persons")
	public Person addPerson(@RequestBody Person person){
		//person.setId(0);
		personService.savePerson(person);
		
		return person;
		
	}
	
	@PutMapping("/persons")
	public Person updatePerson(@RequestBody Person person){
		
		personService.savePerson(person);
		return person;
		
	}
	
	@DeleteMapping("/persons/{personId}")
	public String deletePerson(@PathVariable("personId") int personId){
		Person p = personService.getPerson(personId);
		if(p == null) {
			throw new RuntimeException("Person not found :"+ personId);
		}
		personService.deletePerson(personId);
		return "Delete person id: "+personId;
		
	}

}
