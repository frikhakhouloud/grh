package com.gti.grh.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gti.grh.dao.CollaborateurRepository;
import com.gti.grh.entities.Collaborateur;
import com.gti.grh.service.CollaborateurService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/Collaborateurs")
public class CollaborateurController {

	@Autowired
	protected CollaborateurRepository collaborateurRepository;

	@Autowired
	CollaborateurService collaborateurService;

	@PostMapping("/add")
	@ResponseBody
	public Collaborateur ajouterCollaborateur(@RequestBody Collaborateur c) {
		return collaborateurService.saveCollaborateur(c);
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
	@ResponseBody
	public List<Collaborateur> getAllCollaborateur() {
		return collaborateurService.getAllCollaborateur();
	}

	@GetMapping("GetId/{id}")
	public Collaborateur getIdCollaborateur(@PathVariable("id") Long id) {
		return collaborateurService.getCollaborateur(id);
	}

	@PutMapping("/Update")
	public Collaborateur modifierCollaborateur(@RequestBody Collaborateur c) {
		return collaborateurService.updateCollaborateur(c);
	}

	@DeleteMapping("Delete/{id}")
	@ResponseBody
	public void deleteCollaborateur(@PathVariable("id") Long id) {
		collaborateurService.deleteCollaborateurById(id);
	}

	@GetMapping("GetName/{nom}")
	@ResponseBody
	public Collaborateur getNameCollaborateur(@PathVariable("nom") String nom) {
		return collaborateurService.getNameCollaborateur(nom);
	}


}
