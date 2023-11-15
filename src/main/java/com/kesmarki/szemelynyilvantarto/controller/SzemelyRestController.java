package com.kesmarki.szemelynyilvantarto.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kesmarki.szemelynyilvantarto.exception.ResourceNotFoundException;
import com.kesmarki.szemelynyilvantarto.model.Szemely;
import com.kesmarki.szemelynyilvantarto.repository.SzemelyRepository;

@RestController
@RequestMapping("/api")
public class SzemelyRestController {
	
	@Autowired
	private SzemelyRepository szemelyRepository;
	
	@GetMapping("/szemelyek")
	public List<Szemely> getAllSzemelys() {
		return szemelyRepository.findAll();
	}
	
	@GetMapping("/szemelyek/{id}")
	public ResponseEntity<Szemely> getSzemelyById(@PathVariable(value = "id") Long szemelyId)
			throws ResourceNotFoundException {
		Szemely szemely = szemelyRepository.findById(szemelyId)
				.orElseThrow(() -> new ResourceNotFoundException("Szemely not found for this id :: " + szemelyId));
		return ResponseEntity.ok().body(szemely);
	}

	@PostMapping("/szemelyek")
	public Szemely createSzemely(@Valid @RequestBody Szemely szemely) {
		return szemelyRepository.save(szemely);
	}

}
