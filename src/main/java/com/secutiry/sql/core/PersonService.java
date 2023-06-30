package com.secutiry.sql.core;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secutiry.sql.dataprovider.entities.Person;
import com.secutiry.sql.dataprovider.repository.NativePersonRepository;
import com.secutiry.sql.dataprovider.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private NativePersonRepository nativeRepository;
	
	public void deleteByName(String name) {
		try {
			 nativeRepository.deleteByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createNewPerson(String firstName, String lastName) {
		var person = new Person(firstName, lastName);
		repository.save(person);
	}
	
	public List<Person> getAllPersons(){
		return repository.findAll();
	}
}