package com.example.projetobasespringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetobasespringboot.dto.ToyRequestDto;
import com.example.projetobasespringboot.dto.ToyResponseDto;
import com.example.projetobasespringboot.service.ToyService;

@RestController
@RequestMapping(value = "toy")
public class ToyController {

	@Autowired
	ToyService toyService;
	
	@PostMapping
	public ResponseEntity<ToyResponseDto> saveToy(@RequestBody ToyRequestDto toyRequestDto){
		ToyResponseDto toyResponseDto = toyService.saveToy(toyRequestDto);
		return ResponseEntity.ok().body(toyResponseDto);
	}
}
