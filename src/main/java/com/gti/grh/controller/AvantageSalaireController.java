package com.gti.grh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gti.grh.dao.AvantageSalaireRepository;
import com.gti.grh.entities.AvantageSalaire;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/AvantageSalaire")

public class AvantageSalaireController {
	@Autowired
	private AvantageSalaireRepository avantageSalaireRepository;

	@PostMapping("/add")
	public AvantageSalaire ajouterAvantge(@RequestBody AvantageSalaire a) {
		return avantageSalaireRepository.save(a);
	}

	@GetMapping("/GetAll")
	public List<AvantageSalaire> getAllAvantage() {
		return avantageSalaireRepository.findAll();
	}

}
