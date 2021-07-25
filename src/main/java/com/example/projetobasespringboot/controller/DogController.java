package com.example.projetobasespringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetobasespringboot.model.Dog;
import com.example.projetobasespringboot.service.DogService;

@RestController
@RequestMapping(value = "dog")
public class DogController {
	
	@Autowired
	DogService dogService;
	
	@GetMapping
	public ResponseEntity<List<Dog>> getAllDogs(){
		List<Dog> listOfDogs = dogService.getAll();
		return ResponseEntity.ok().body(listOfDogs);
	}
}
