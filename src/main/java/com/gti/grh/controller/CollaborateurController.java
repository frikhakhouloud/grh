package com.gti.grh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gti.grh.dao.CollaborateurRepository;
import com.gti.grh.entities.Collaborateur;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(value="/Collaborateurs")
public class CollaborateurController {
	@Autowired
	protected CollaborateurRepository collaborateurRepository;
	
	@PostMapping("/add")
	public Collaborateur ajouterCollaborateur(@RequestBody Collaborateur c)
	{
		return collaborateurRepository.save(c);
	}
	
	
	/*
	 * @PostMapping("/addDto") public CollaborateurDto ajouterCollaborateur
	 * (@RequestBody CollaborateurDto c) { Collaborateur co = new Collaborateur();
	 * //co.setAdresse(c.getAdresse()); co.setCin(c.getCin());
	 * co.setDateNaissance(c.getDateNaissance()); //co.setEmail(c.getEmail());
	 * co.setNom(c.getNom()); co.setNumCompte(c.getNumCompte());
	 * co.setNumSecSocial(c.getNumSecSocial()); co.setTelephone(c.getTelephone());
	 * co.setId(c.getId()); co = collaborateurRepository.save(co); return c;
	 * 
	 * }
	 */
	
	@GetMapping("/GetAll")
	public List<Collaborateur> getAllCollaborateur()
	{
		return collaborateurRepository.findAll();
	}
	
	
	@GetMapping("GetId/{id}") 
    public Optional<Collaborateur> getIdCollaborateur(@PathVariable("id") Long id)
    {
        return collaborateurRepository.findById(id);
    }
	
	
	@PutMapping("/Update")
    public Collaborateur modifierCollaborateur(@RequestBody Collaborateur c)
    {
        return collaborateurRepository.save(c);
    }
	
	
	@DeleteMapping("Delete/{id}")
	 public void deleteCollaborateur(@PathVariable("id") Long id)
	 {
		collaborateurRepository.deleteById(id);
	 }
	
	
	 @GetMapping("GetName/{nom}")
	  public Collaborateur getNameCollaborateur(@PathVariable("nom") String nom)
	  { 
		  return collaborateurRepository.findByName(nom);
	  } 
}
