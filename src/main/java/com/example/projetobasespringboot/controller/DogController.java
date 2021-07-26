package com.example.projetobasespringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetobasespringboot.dto.DogRequestDto;
import com.example.projetobasespringboot.dto.DogResponseDto;
import com.example.projetobasespringboot.model.Dog;
import com.example.projetobasespringboot.service.DogService;

@RestController
@RequestMapping(value = "dog")
public class DogController {
	
	@Autowired
	DogService dogService;
	
	@GetMapping
	public ResponseEntity<List<DogResponseDto>> getAllDogs(){
		List<DogResponseDto> listOfDogs = dogService.getAll();
		return ResponseEntity.ok().body(listOfDogs);
	}
	
	@PostMapping
	public ResponseEntity<DogResponseDto> saveDog(@RequestBody DogRequestDto dogDto){
		DogResponseDto dog = dogService.saveDog(dogDto);
		return ResponseEntity.ok().body(dog);
	}
}
