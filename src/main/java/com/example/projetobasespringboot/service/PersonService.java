package com.example.projetobasespringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetobasespringboot.dto.PersonRequestDto;
import com.example.projetobasespringboot.dto.PersonResponseDto;
import com.example.projetobasespringboot.model.Person;
import com.example.projetobasespringboot.repository.PersonRepository;
import com.example.projetobasespringboot.utils.ConversionDto;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	public List<PersonResponseDto> getAll() {
		List<Person> allPersonSearched = personRepository.findAll();
		List<PersonResponseDto> personDto = new ArrayList<>();
		
		for(Person personSearched : allPersonSearched) {
			personDto.add(ConversionDto.toDto(personSearched));
		}
		
		return personDto;
	}
	
	public PersonResponseDto findPersonId(long id) {
		Person person = personRepository.findById(id).get();
		PersonResponseDto personResponseDto = ConversionDto.toDto(person);
		return personResponseDto;
	}
	
	public List<PersonResponseDto> findPersonName(String personName) {
		List<Person> listPerson = personRepository.findByNameContainsIgnoreCase(personName);
		List<PersonResponseDto> personDto = new ArrayList<>();
		
		for(Person personSearched : listPerson) {
			personDto.add(ConversionDto.toDto(personSearched));
		}
		
		return personDto;
	}
	
	public PersonResponseDto save(PersonRequestDto personDto) {
		Person person = ConversionDto.fromDto(personDto);
		personRepository.save(person);
		PersonResponseDto personResponseDto = ConversionDto.toDto(person);
		return personResponseDto;
	}
	
	public PersonResponseDto update(long id, PersonRequestDto personDto) {
		Optional<Person> personSearched = personRepository.findById(id);
		
		Person person = ConversionDto.fromDto(personDto);
		
		if (personSearched.isPresent()) {
			person.setId(id);
			personRepository.save(person);
		}
		
		PersonResponseDto personResponseDto = ConversionDto.toDto(person);
		return personResponseDto;
		
	}
	
	public Person updateName(long id, Person person) {
		personRepository.changeNamePerson(person.getName());;

		return person;		
	}
	
	public void delete(long id) {
		this.personRepository.deleteById(id);
	}
}
