package com.example.projetobasespringboot.utils;



import com.example.projetobasespringboot.dto.DogRequestDto;
import com.example.projetobasespringboot.dto.DogResponseDto;
import com.example.projetobasespringboot.dto.PersonRequestDto;
import com.example.projetobasespringboot.dto.PersonResponseDto;
import com.example.projetobasespringboot.model.Dog;
import com.example.projetobasespringboot.model.Person;

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
		dog.setAge(dogDto.getAge());
		dog.setName(dogDto.getName());

		dog.setPerson(fromDto(dogDto.getPersonRequestDto()));
		return dog;
	}
	
	public static DogResponseDto toDto(Dog dog) {
		DogResponseDto dogDto = new DogResponseDto();
		
		dogDto.setAge(dog.getAge());
		dogDto.setName(dog.getName());

		dogDto.setPersonResponseDto(toDto(dog.getPerson()));
		
		return dogDto;
	}
}


