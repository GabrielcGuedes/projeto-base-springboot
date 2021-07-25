package com.example.projetobasespringboot.utils;



import com.example.projetobasespringboot.dto.DogResponseDto;
import com.example.projetobasespringboot.dto.PersonRequestDto;
import com.example.projetobasespringboot.dto.PersonResponseDto;
import com.example.projetobasespringboot.model.Dog;
import com.example.projetobasespringboot.model.Person;

public class ConversionDto {

	public static PersonResponseDto toDto(Person person) {
		PersonResponseDto responseDto = new PersonResponseDto();
		
		responseDto.setAge(person.getAge());
		responseDto.setName(person.getName());
		
		return responseDto;

	}
	
	public static Person fromDto(PersonRequestDto personDto) {
		Person request = new Person();
		
		request.setAge(personDto.getAge());
		request.setName(personDto.getName());
		
		return request;
	}
}


