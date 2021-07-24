package com.example.projetobasespringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetobasespringboot.model.Person;
import com.example.projetobasespringboot.service.PersonService;

@RestController
@RequestMapping(value = "person")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping
	public ResponseEntity<List<Person>> findAll(){
		List<Person> listOfPerson = personService.getAll();
		return ResponseEntity.ok().body(listOfPerson);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Person> findPersonById(@PathVariable long id){
		Person person = personService.findPersonId(id);
		return ResponseEntity.ok().body(person);
	}
	
	@GetMapping(value = "/{name}")
	public ResponseEntity<List<Person>> findPersonByName(@PathVariable String name){
		List<Person> listOfPerson = personService.findPersonName(name);
		return ResponseEntity.ok(listOfPerson);
	}
	
	@PostMapping
	public ResponseEntity<Person> save(@RequestBody Person person) {
		Person personSaved = personService.save(person);
		return ResponseEntity.ok().body(personSaved);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Person> update(@RequestBody Person person, @PathVariable int id) {
		Person personChanged = personService.update(id, person);
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
