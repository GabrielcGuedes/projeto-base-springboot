package com.example.projetobasespringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetobasespringboot.repository.ToyRepository;

@Service
public class ToyService {
	@Autowired
	ToyRepository toyRepository;
}
