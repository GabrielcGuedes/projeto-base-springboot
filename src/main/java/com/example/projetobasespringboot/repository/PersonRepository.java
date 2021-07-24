package com.example.projetobasespringboot.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.projetobasespringboot.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	
	public List<Person>findByNameContainsIgnoreCase(String personName);
	
	@Modifying
	@Query(value = "Update Person p Set p.name = ?1")
	public void changeNamePerson(String name);
}
