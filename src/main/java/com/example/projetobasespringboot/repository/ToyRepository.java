package com.example.projetobasespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetobasespringboot.model.Toy;

public interface ToyRepository extends JpaRepository<Toy, Long>{

}
