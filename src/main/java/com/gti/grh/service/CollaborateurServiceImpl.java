package com.gti.grh.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gti.grh.dao.AvantageSalaireRepository;
import com.gti.grh.dao.CollaborateurRepository;
import com.gti.grh.dao.ContratTypeRepository;
import com.gti.grh.dao.DepartementRepository;
import com.gti.grh.dao.NiveauEtudeRepository;
import com.gti.grh.dao.PosteRepository;
import com.gti.grh.dao.ResponsableRepository;
import com.gti.grh.entities.AvantageSalaire;
import com.gti.grh.entities.Collaborateur;
import com.gti.grh.entities.ContratType;

@Service
public class CollaborateurServiceImpl implements CollaborateurService {

	@Autowired
	CollaborateurRepository collaborateurRepository;

	@Autowired
	ContratTypeRepository contratTypeRepository;

	@Autowired
	NiveauEtudeRepository niveauEtudeRepository;
	
	@Autowired
	PosteRepository posteRepository;
	
	@Autowired
	ResponsableRepository responsableRepository;
	
	@Autowired
	DepartementRepository departementRepository;
	
	@Autowired
	AvantageSalaireRepository avantageSalaireRepository;
	
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
		List<Collaborateur> collaborateurs = collaborateurRepository.findAll();
		for (Collaborateur c : collaborateurs) {
			c.setContratType(contratTypeRepository.findById(c.getIdTypeContrat()).get());
			c.setNiveauEtude(niveauEtudeRepository.findById(c.getIdNiveauEtude()).get());
			c.setPoste(posteRepository.findById(c.getIdPoste()).get());
			c.setResponsable(responsableRepository.findById(c.getIdResponsable()).get());
			c.setDepartement(departementRepository.findById(c.getIdDepartement()).get());
			c.setAvantageSalaire(avantageSalaireRepository.findById(c.getIdAvantageSalaire()).get());

		}
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
