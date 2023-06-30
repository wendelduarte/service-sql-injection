package com.secutiry.sql.dataprovider.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.secutiry.sql.dataprovider.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	
	@Query(value = "SELECT * FROM person WHERE FIRST_NAME = ?1", nativeQuery = true)
	Optional<Person> findByFirstName(String name);

}
