package com.gti.grh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gti.grh.dao.ResponsableRepository;
import com.gti.grh.entities.Responsable;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/Responsable")
public class ResponsaleController {
	@Autowired
	private ResponsableRepository responsableRepository;

	@PostMapping("/add")
	public Responsable ajouterResponsable(@RequestBody Responsable r) {
		return responsableRepository.save(r);
	}

	@GetMapping("/GetAll")
	public List<Responsable> getAllResponsable() {
		return responsableRepository.findAll();
	}
}
