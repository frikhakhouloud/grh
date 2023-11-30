package com.gti.grh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gti.grh.dao.PosteRepository;
import com.gti.grh.entities.Poste;
@RestController
@RequestMapping(value="/Poste")

public class PosteController {
	@Autowired
	private PosteRepository posteRepository;
	
	@PostMapping("/add")
	public Poste ajouterPoste(@RequestBody Poste p)
	{
		return posteRepository.save(p);
	}
	@GetMapping("/GetAll")
	public List<Poste> getAllPoste()
	{
		return posteRepository.findAll();
	}
	
	

}
