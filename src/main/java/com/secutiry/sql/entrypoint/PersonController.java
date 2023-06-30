package com.secutiry.sql.entrypoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.secutiry.sql.core.PersonService;
import com.secutiry.sql.dataprovider.entities.Person;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonService service;
	
	@DeleteMapping
	public String deleteByName(@RequestParam(name = "firstName") String firstName) {
		service.deleteByName(firstName);
		return "OK";
	}
	
	@PostMapping
	public String save(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
		service.createNewPerson(firstName, lastName);
		return "OK";
	}
	
	@GetMapping
	public List<Person> getPersons(){
		return service.getAllPersons();
	}
}
