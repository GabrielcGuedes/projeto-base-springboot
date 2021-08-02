package com.example.projetobasespringboot.utils;



import java.util.ArrayList;
import java.util.List;

import com.example.projetobasespringboot.dto.DogRequestDto;
import com.example.projetobasespringboot.dto.DogResponseDto;
import com.example.projetobasespringboot.dto.PersonRequestDto;
import com.example.projetobasespringboot.dto.PersonResponseDto;
import com.example.projetobasespringboot.dto.ToyRequestDto;
import com.example.projetobasespringboot.dto.ToyResponseDto;
import com.example.projetobasespringboot.model.Dog;
import com.example.projetobasespringboot.model.Person;
import com.example.projetobasespringboot.model.Toy;
import java.util.List;

public class ConversionDto {

	public static PersonResponseDto toDto(Person person) {
		PersonResponseDto responseDto = new PersonResponseDto();
		responseDto.setId(person.getId());
		responseDto.setAge(person.getAge());
		responseDto.setName(person.getName());
		
		return responseDto;

	}
	
	public static Person fromDto(PersonRequestDto personDto) {
		Person request = new Person();
		request.setId(personDto.getId());
		request.setAge(personDto.getAge());
		request.setName(personDto.getName());
		
		return request;
	}
	
	public static Dog fromDto(DogRequestDto dogDto) {
		Dog dog = new Dog();
		
		dog.setId(dogDto.getId());
		dog.setAge(dogDto.getAge());
		dog.setName(dogDto.getName());

		dog.setPerson(fromDto(dogDto.getPersonRequestDto()));
		return dog;
	}
	
	public static DogResponseDto toDto(Dog dog) {
		DogResponseDto dogDto = new DogResponseDto();
		
		dogDto.setId(dog.getId());
		dogDto.setAge(dog.getAge());
		dogDto.setName(dog.getName());

		dogDto.setPersonResponseDto(toDto(dog.getPerson()));
		
		return dogDto;
	}
	
	public static Toy fromDto (ToyRequestDto toyDto) {
		Toy toy = new Toy();
		
		toy.setName(toyDto.getName());
		toy.setDogs(new ArrayList());
		for(DogRequestDto dog: toyDto.getDogs()) {
			toy.getDogs().add(fromDto(dog));
		}
		
		return toy;
	}
	
	public static ToyResponseDto toDto(Toy toy) {
		
		ToyResponseDto toyDto = new ToyResponseDto();
		
		toyDto.setName(toy.getName());
		toy.setDogs(new ArrayList());
		for(Dog dog : toy.getDogs()) {
			toyDto.getDogs().add(toDto(dog));
		}
		
		return toyDto;
	}
}


