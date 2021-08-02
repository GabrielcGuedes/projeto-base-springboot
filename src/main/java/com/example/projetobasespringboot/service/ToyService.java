package com.example.projetobasespringboot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetobasespringboot.dto.ToyRequestDto;
import com.example.projetobasespringboot.dto.ToyResponseDto;
import com.example.projetobasespringboot.model.Dog;
import com.example.projetobasespringboot.model.Toy;
import com.example.projetobasespringboot.repository.DogRepository;
import com.example.projetobasespringboot.repository.ToyRepository;
import com.example.projetobasespringboot.utils.ConversionDto;

@Service
public class ToyService {
	@Autowired
	ToyRepository toyRepository;
	
	@Autowired
	DogRepository dogRepository;
	
	public ToyResponseDto saveToy(ToyRequestDto toyRequest) {
		Toy toy = ConversionDto.fromDto(toyRequest);
		
		Toy toyToSave= new Toy();
		toyToSave.setName(toy.getName());
		toyToSave.setDogs(new ArrayList<Dog>());
		for(Dog dog : toy.getDogs()) {
			toyToSave.getDogs().add(dogRepository.getById(dog.getId()));
		}
		
		toyRepository.save(toyToSave);
		ToyResponseDto toyResponse = ConversionDto.toDto(toyToSave);
		return toyResponse;
	}
}
