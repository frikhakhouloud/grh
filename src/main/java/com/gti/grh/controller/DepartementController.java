package com.gti.grh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gti.grh.dao.DepartementRepository;
import com.gti.grh.entities.Departement;
@RestController
@RequestMapping(value = "/Departement")
public class DepartementController {
	@Autowired
	private DepartementRepository departementRepository;
	
	@PostMapping("/add")
	public Departement ajouterDepartement(@RequestBody Departement d){	
		return departementRepository.save(d);
	}
	@GetMapping("/GetAll")
	public List<Departement> getAllDepartement()
	{
		return departementRepository.findAll();
	}
}
