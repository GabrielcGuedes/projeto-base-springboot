package com.example.projetobasespringboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetobasespringboot.dto.PersonRequestDto;
import com.example.projetobasespringboot.dto.PersonResponseDto;
import com.example.projetobasespringboot.model.Person;
import com.example.projetobasespringboot.service.PersonService;

@RestController
@RequestMapping(value = "person")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping
	public ResponseEntity<List<PersonResponseDto>> findAll(){
		List<PersonResponseDto> listOfPerson = personService.getAll();
		return ResponseEntity.ok().body(listOfPerson);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PersonResponseDto> findPersonById(@PathVariable long id){
		PersonResponseDto person = personService.findPersonId(id);
		return ResponseEntity.ok().body(person);
	}
	
	@GetMapping(value = "/{name}")
	public ResponseEntity<List<PersonResponseDto>> findPersonByName(@PathVariable String name){
		List<PersonResponseDto> listOfPerson = personService.findPersonName(name);
		return ResponseEntity.ok(listOfPerson);
	}
	
	@PostMapping
	public ResponseEntity<PersonResponseDto> save(@RequestBody PersonRequestDto personDto) {
		PersonResponseDto personSaved = personService.save(personDto);
		return ResponseEntity.ok().body(personSaved);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PersonResponseDto> update(@RequestBody PersonRequestDto personDto, @PathVariable int id) {
		PersonResponseDto personChanged = personService.update(id, personDto);
		return ResponseEntity.ok().body(personChanged);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable long id) {
		personService.delete(id);
	}
	
//	@GetMapping(value = "/pagination")
//	public ResponseEntity<Page<?>> paginacao(@RequestParam(value = "pagina", defaultValue = "5") int pagina,
//			@RequestParam(value = "linhas", defaultValue = "5") int linhas,
//			@RequestParam(value = "busca", defaultValue = "") String busca) {
//		Page<CategoriaDto> page = this.categoriaService.pagination(pagina, linhas, busca);
//		return ResponseEntity.ok().body(page);
//	}
}
