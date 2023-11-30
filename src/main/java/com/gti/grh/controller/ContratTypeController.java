package com.gti.grh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gti.grh.dao.ContratTypeRepository;
import com.gti.grh.entities.ContratType;

@RestController
@RequestMapping(value="/ContratType")
public class ContratTypeController {
@Autowired
protected ContratTypeRepository contratTypeRepository;

@PostMapping("/add")
public ContratType ajouterContratType(@RequestBody ContratType c)
{
	return contratTypeRepository.save(c);
}

@GetMapping("/GetAll")
public List<ContratType> getAllContrat()
{
	return contratTypeRepository.findAll();
}

}
