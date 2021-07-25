package com.example.projetobasespringboot.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.example.projetobasespringboot.model.Dog;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonRequestDto {
	

	private String name;
	
	private Integer age;
	
	
}
