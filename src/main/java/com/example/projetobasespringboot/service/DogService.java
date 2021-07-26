package com.example.projetobasespringboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetobasespringboot.dto.DogRequestDto;
import com.example.projetobasespringboot.dto.DogResponseDto;
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
	
	public List<DogResponseDto> getAll(){
		List<Dog> dogSearched = dogRepository.findAll();
		List<DogResponseDto> dogDto = new ArrayList<>();
		
		for(Dog dog: dogSearched) {
			dogDto.add(ConversionDto.toDto(dog));
		}
				
		return dogDto;
	}
	
	public DogResponseDto saveDog(DogRequestDto dogDto) {
		Dog dog = ConversionDto.fromDto(dogDto);
//		dog.setPerson(personRepository.findById(dog.getPerson().getId()).get()); 
		dogRepository.save(dog);
		return ConversionDto.toDto(dog);
	}
}
