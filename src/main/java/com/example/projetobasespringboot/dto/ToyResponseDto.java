package com.example.projetobasespringboot.dto;

import java.util.List;

import com.example.projetobasespringboot.model.Dog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToyResponseDto {
	private Long id;
	private String name;
	
	private List<DogResponseDto> dogs;
}
