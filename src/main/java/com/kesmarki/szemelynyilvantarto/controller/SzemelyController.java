package com.kesmarki.szemelynyilvantarto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kesmarki.szemelynyilvantarto.model.Szemely;
import com.kesmarki.szemelynyilvantarto.repository.SzemelyRepository;

import jakarta.validation.Valid;

@Controller
public class SzemelyController {

	@Autowired
	private SzemelyRepository szemelyRepository;

	@GetMapping("/szemelyek")
	public String listAll(Model model) {
		List<Szemely> listSzemelyek = szemelyRepository.findAll();
		model.addAttribute("listSzemelyek", listSzemelyek);
		return "szemelyek";
	}

	@GetMapping("/szemely")
	public String newSzemely(Szemely szemely) {
		return "szemely_form";
	}

	@PostMapping("/szemely")
	public String newSzemely(@Valid Szemely szemely, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "szemely_form";
		} else {
			szemelyRepository.save(szemely);
			List<Szemely> listSzemelyek = szemelyRepository.findAll();
			model.addAttribute("listSzemelyek", listSzemelyek);
			return "redirect:/szemelyek";
		}
	}
}
