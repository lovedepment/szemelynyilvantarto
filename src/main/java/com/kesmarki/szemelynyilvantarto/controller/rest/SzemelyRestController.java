package com.kesmarki.szemelynyilvantarto.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kesmarki.szemelynyilvantarto.exception.ResourceNotFoundException;
import com.kesmarki.szemelynyilvantarto.model.Szemely;
import com.kesmarki.szemelynyilvantarto.repository.SzemelyRepository;

import jakarta.validation.Valid;

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
				.orElseThrow(() -> new ResourceNotFoundException("Szemely not found for this id: " + szemelyId));
		return ResponseEntity.ok().body(szemely);
	}

	@PostMapping("/szemelyek")
	public Szemely createSzemely(@Valid @RequestBody Szemely szemely) {
		return szemelyRepository.save(szemely);
	}
	
	@DeleteMapping("/szemelyek/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long szemelyId)
			throws ResourceNotFoundException {
		Szemely szemely = szemelyRepository.findById(szemelyId)
				.orElseThrow(() -> new ResourceNotFoundException("Szemely not found for this id :" + szemelyId));
		szemelyRepository.delete(szemely);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@PutMapping("/szemelyek/{id}")
	public ResponseEntity<Szemely> updateszemelyek(@PathVariable("id") long id, @RequestBody Szemely szemely) {
		Optional<Szemely> szemelyData = szemelyRepository.findById(id);

		if (szemelyData.isPresent()) {
			Szemely _szemely = szemelyData.get();
			_szemely.setFirstName(szemely.getFirstName());
			_szemely.setLastName(szemely.getLastName());
			_szemely.setPermanentAddress(szemely.getPermanentAddress());
			_szemely.setResidentialAddress(szemely.getResidentialAddress());
			return new ResponseEntity<>(szemelyRepository.save(_szemely), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
