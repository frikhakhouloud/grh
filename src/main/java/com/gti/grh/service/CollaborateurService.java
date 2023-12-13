package com.gti.grh.service;

import java.util.List;

import com.gti.grh.dto.GetDto;

import com.gti.grh.entities.Collaborateur;

public interface CollaborateurService {

	Collaborateur saveCollaborateur(Collaborateur c);

	Collaborateur updateCollaborateur(Collaborateur c);

	void deleteCollaborateur(Collaborateur c);

	Collaborateur getCollaborateur(Long id);

	List<Collaborateur> getAllCollaborateur();

	void deleteCollaborateurById(Long id);

	Collaborateur getNameCollaborateur(String nom);

	void AffecterCollabContrat(Long idcollab, Long idtypecontrat);

	List<GetDto> getAllCollaborateurDto();
	
	Integer getPiramideAge();

	Float getSalairesMoyenne();

	Float getMasseSalariale();

}
