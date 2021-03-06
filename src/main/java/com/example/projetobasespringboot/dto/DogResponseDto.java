package com.example.projetobasespringboot.dto;

import java.util.List;

import com.example.projetobasespringboot.model.Dog;
import com.example.projetobasespringboot.model.Person;
import com.example.projetobasespringboot.model.Toy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DogResponseDto {
	private Long id;
	private String name;
	private Integer age;
	private PersonResponseDto personResponseDto;
	
}
