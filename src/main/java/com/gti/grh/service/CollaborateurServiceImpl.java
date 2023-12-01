package com.gti.grh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gti.grh.dao.CollaborateurRepository;
import com.gti.grh.dao.ContratTypeRepository;
import com.gti.grh.entities.Collaborateur;
import com.gti.grh.entities.ContratType;


@Service
public class CollaborateurServiceImpl implements CollaborateurService  {

	@Autowired
	CollaborateurRepository collaborateurRepository;
	
	@Autowired
	ContratTypeRepository contratTypeRepository;
	
	@Override
	public Collaborateur saveCollaborateur(Collaborateur c) {
		
		return collaborateurRepository.save(c);
	}

	@Override
	public Collaborateur updateCollaborateur(Collaborateur c) {
		return collaborateurRepository.save(c);
	}

	@Override
	public void deleteCollaborateur(Collaborateur c) {
		collaborateurRepository.delete(c);
		
	}
	

	@Override
	public Collaborateur getCollaborateur(Long id) {
		return collaborateurRepository.findById(id).get();
	}

	@Override
	public List<Collaborateur> getAllCollaborateur() {
		return collaborateurRepository.findAll();
	}

	@Override
	public void deleteCollaborateurById(Long id) {
  		collaborateurRepository.deleteById(id);
	}

	@Override
	public Collaborateur getNameCollaborateur(String nom) {
		return collaborateurRepository.findByName(nom);
	}

	@Override
	public void AffecterCollabContrat(Long idcollab, Long idtypecontrat) {
		ContratType contrattype = contratTypeRepository.findById(idtypecontrat).get();
		Collaborateur collaborateur = collaborateurRepository.findById(idcollab).get();
		
		collaborateur.setContratType(contrattype);
		collaborateurRepository.save(collaborateur);
		
	}


}
