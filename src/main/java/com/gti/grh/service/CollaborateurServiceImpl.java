package com.gti.grh.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gti.grh.dao.AvantageSalaireRepository;
import com.gti.grh.dao.CollaborateurRepository;
import com.gti.grh.dao.ContratTypeRepository;
import com.gti.grh.dao.DepartementRepository;
import com.gti.grh.dao.NiveauEtudeRepository;
import com.gti.grh.dao.PosteRepository;
import com.gti.grh.dao.ResponsableRepository;
import com.gti.grh.dto.GetDto;
import com.gti.grh.entities.AvantageSalaire;
import com.gti.grh.entities.Collaborateur;
import com.gti.grh.entities.ContratType;
import com.gti.grh.entities.Poste;


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

//	AvantageSalaire avantageSalaire=	avantageSalaireRepository.save(c.getAvantageSalaire());
//	
//	
//	c.setIdAvantageSalaire(avantageSalaire.getId());
		
		
		
		
		
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

	@Override
	public List<GetDto> getAllCollaborateurDto() {
		List<GetDto>getDtos= new ArrayList<>();
		
				
		List<Collaborateur> collaborateurs = collaborateurRepository.findAll();
		collaborateurs.stream().forEach(c->{
			ContratType contrattype = contratTypeRepository.findById(c.getIdTypeContrat()).get();
			Poste poste = posteRepository.findById(c.getIdPoste()).orElse(null);

			GetDto dto = new GetDto();
			
			dto.setId(c.getId());
			dto.setNom(c.getNom());
			dto.setType(contrattype.getType());
			dto.setPoste(poste.getPoste());
			dto.setAnneeExperience(c.getAnneeExperience());
			getDtos.add(dto);
			
			
		});
		return getDtos;
	}
	private int calculateAge(Date dateOfBirth) {
		LocalDate birthDate = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate currentDate = LocalDate.now();
		return Period.between(birthDate, currentDate).getYears();
		
	}
	@Override
	public Integer getPiramideAge() {
		List<Collaborateur> collaborateurs = collaborateurRepository.findAll();
		int n = collaborateurs.size();
		int sumOfAges = collaborateurs.stream().mapToInt(collab -> calculateAge(collab.getDateNaissance())).sum();

		return sumOfAges / n;
	}

	@Override
	public Float getSalairesMoyenne() {
		List<Collaborateur> collaborateurs = collaborateurRepository.findAll();
		int n = collaborateurs.size();
		AtomicReference<Float> sumOfSalaire = new AtomicReference<>(0.0f);

		collaborateurs.forEach(c -> {
			AvantageSalaire  salaire = avantageSalaireRepository.findById(c.getIdAvantageSalaire()).get();
			if (salaire != null) {
				sumOfSalaire.updateAndGet(currentSum -> currentSum + salaire.getSalaire());
			}
		});

		return n > 0 ? sumOfSalaire.get() / n : 0.0f; // Calculate average if there are collaborators, else return 0
	}


	 @Override
	    public Float getMasseSalariale() {
			List<AvantageSalaire> listeAvantagesSalaires = avantageSalaireRepository.findAll(); 
	        float sommeSalaires = 0;
	        for (AvantageSalaire avantageSalaire : listeAvantagesSalaires) {
	        	sommeSalaires += avantageSalaire.getSalaire();
	        }
	        return sommeSalaires;
	    }
	 
	 
}
