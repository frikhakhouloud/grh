package com.gti.grh.service;

import java.util.List;


import com.gti.grh.entities.Collaborateur;

public interface CollaborateurService {
	
	Collaborateur saveCollaborateur(Collaborateur c);
	Collaborateur updateCollaborateur(Collaborateur c);
	void deleteCollaborateur(Collaborateur c);
	Collaborateur getCollaborateur(Long id);
	List<Collaborateur> getAllCollaborateur();
	void deleteCollaborateurById(Long id);
	Collaborateur getNameCollaborateur(String nom);
	public void AffecterCollabContrat(Long idcollab, Long idtypecontrat);
	
}


//@GetMapping("GetName/{nom}")
//public Collaborateur getNameCollaborateur(@PathVariable("nom") String nom)
//{ 
//	  return collaborateurRepository.findByName(nom);
//} 
//}