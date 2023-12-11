package com.gti.grh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gti.grh.dao.NiveauEtudeRepository;
import com.gti.grh.entities.NiveauEtude;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/NiveauEtude")
public class NiveauEtudeController {
	@Autowired
	private NiveauEtudeRepository niveauEtudeRepository;

	@PostMapping("/add")
	public NiveauEtude ajouterNiveauEtude(@RequestBody NiveauEtude n) {
		return niveauEtudeRepository.save(n);
	}

	@GetMapping("/GetAll")
	public List<NiveauEtude> getAllNiveau() {
		return niveauEtudeRepository.findAll();
	}

}
