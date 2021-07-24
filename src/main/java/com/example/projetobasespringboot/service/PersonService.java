package com.example.projetobasespringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetobasespringboot.model.Person;
import com.example.projetobasespringboot.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	public List<Person> getAll() {
		return personRepository.findAll();
	}
	
	public Person findPersonId(long id) {
		return personRepository.findById(id).get();
	}
	
	public List<Person> findPersonName(String personName) {
		return personRepository.findByNameContainsIgnoreCase(personName);
	}
	
	public Person save(Person person) {	
		return personRepository.save(person);
	}
	
	public Person update(long id, Person person) {
		Optional<Person> personSearched = personRepository.findById(id);
		
		if (personSearched.isPresent()) {
			person.setId(id);
			personRepository.save(person);
		}
		
		return person;		
	}
	
	public Person updateName(long id, Person person) {
		personRepository.changeNamePerson(person.getName());;

		return person;		
	}
	
	public void delete(long id) {
		this.personRepository.deleteById(id);
	}
}
