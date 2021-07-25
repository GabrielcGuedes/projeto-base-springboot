package com.example.projetobasespringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetobasespringboot.model.Dog;
import com.example.projetobasespringboot.repository.DogRepository;

@Service
public class DogService {
	
	@Autowired
	DogRepository dogRepository;
	
	public List<Dog> getAll(){
		return dogRepository.findAll();
	}
}
