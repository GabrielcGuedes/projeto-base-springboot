package com.example.projetobasespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetobasespringboot.model.Dog;

public interface DogRepository extends JpaRepository<Dog, Long>{

}
