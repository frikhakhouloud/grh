package com.gti.grh.controller;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.gti.grh.dto.GetDto;
import com.gti.grh.entities.Collaborateur;
import com.gti.grh.service.CollaborateurService;

import net.sf.jasperreports.engine.JRException;


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



	@GetMapping("/GetAll")
	@ResponseBody
	public List<Collaborateur> getAllCollaborateur() {
		return collaborateurService.getAllCollaborateur();
	}

	@GetMapping("GetId/{id}")
	public Collaborateur getIdCollaborateur(@PathVariable("id") Long id) {
		return collaborateurService.getCollaborateur(id);
	}

	@PutMapping("/Update/{id}")
	public Collaborateur modifierCollaborateur(@RequestBody Collaborateur c,@PathVariable Long id) {
		return collaborateurService.updateCollaborateur(c, id);
	}

	
//	@PutMapping("/update/{id}")
//	public CollaborateurDto updateCollaborateur(@RequestBody AjoutCollaborateurDto ajoutCollaborateurDto,@PathVariable Integer id) {
//		return collaborateurService.updateCollaborateur(ajoutCollaborateurDto, id);
//	}
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

	@GetMapping("/GetAllDto")
	public List<GetDto> getAllCollaborateurDto() {
		return collaborateurService.getAllCollaborateurDto();
	}
	@GetMapping("/piramideAge")
	public Integer getPiramideAge() {
		return collaborateurService.getPiramideAge();
	}
	@GetMapping("/salairesMoyenne")
	public Float getSalairesMoyenne() {
		return collaborateurService.getSalairesMoyenne();
	}
	
	@GetMapping("/masseSalariale")
	public Float getMasseSalariale() {
		return collaborateurService.getMasseSalariale();
	}
	@GetMapping("/generateReport/{id}")
	public ResponseEntity<Void> downloadJasper(@PathVariable Long id)
	throws FileNotFoundException, SQLException, JRException {
		collaborateurService.downloadJasper(id);
	return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
