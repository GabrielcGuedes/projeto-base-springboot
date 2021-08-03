package com.example.projetobasespringboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import com.example.projetobasespringboot.dto.DogRequestDto;
import com.example.projetobasespringboot.dto.DogResponseDto;
import com.example.projetobasespringboot.handle.RestExceptionHandler;
import com.example.projetobasespringboot.model.Dog;
import com.example.projetobasespringboot.repository.DogRepository;
import com.example.projetobasespringboot.repository.PersonRepository;
import com.example.projetobasespringboot.utils.ConversionDto;

@Service
public class DogService {
	
	@Autowired
	DogRepository dogRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	public Object getAll(){
		try {
		List<Dog> dogSearched = dogRepository.findAll();
		List<DogResponseDto> dogDto = new ArrayList<>();
		
		for(Dog dog: dogSearched) {
			dogDto.add(ConversionDto.toDto(dog));
		}
				
		return dogDto;
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public DogResponseDto saveDog(DogRequestDto dogDto) {
		Dog dog = ConversionDto.fromDto(dogDto);
		dog.setPerson(personRepository.findById(dog.getPerson().getId()).get()); 
		dogRepository.save(dog);
		return ConversionDto.toDto(dog);
	}
}
