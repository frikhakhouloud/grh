package com.gti.grh;

import org.springframework.boot.CommandLineRunner;
import java.util.Date;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
import com.gti.grh.entities.Departement;
import com.gti.grh.entities.NiveauEtude;
import com.gti.grh.entities.Poste;
import com.gti.grh.entities.Responsable;


@SpringBootApplication
public class GrhApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GrhApplication.class, args);
	}
	
	
	@Bean
    public CommandLineRunner loadData(ContratTypeRepository contratTypeRepository, AvantageSalaireRepository avantageSalaireRepository, DepartementRepository departementRepository, NiveauEtudeRepository niveauEtudeRepository, PosteRepository posteRepository, ResponsableRepository responsableRepository, CollaborateurRepository collaborateurRepository) {
        return args -> {
            ContratType contrat1 = new ContratType(null, "CDD");
            ContratType contrat2 = new ContratType(null, "CDI");
            ContratType contrat3 = new ContratType(null, "sivp");
            contratTypeRepository.save(contrat1);
            contratTypeRepository.save(contrat2);
            contratTypeRepository.save(contrat3);

            
            AvantageSalaire avantage1 = new AvantageSalaire(null,"ticket resto",(float) 500.5);
            AvantageSalaire avantage2 = new AvantageSalaire(null,"prime",(float) 500.5);     
            avantageSalaireRepository.save(avantage1);
            avantageSalaireRepository.save(avantage2);
            
            Departement departement1 = new Departement(null, "Informatique");
            Departement departement2 = new Departement(null, "RH");
            departementRepository.save(departement1);
            departementRepository.save(departement2);
            
            NiveauEtude niveau1 = new NiveauEtude(null, "Licence");
            NiveauEtude niveau2 = new NiveauEtude(null, "Master");
            NiveauEtude niveau3 = new NiveauEtude(null, "Ingenieur");
            niveauEtudeRepository.save(niveau1);
            niveauEtudeRepository.save(niveau2);
            niveauEtudeRepository.save(niveau3);
            
            
            Poste poste1 = new Poste(null, "developpeur");
            Poste poste2 = new Poste(null, "HelpDesk");
            Poste poste3 = new Poste(null, "QA");
            Poste poste4 = new Poste(null, "RH");

            posteRepository.save(poste1);
            posteRepository.save(poste2);
            posteRepository.save(poste3);
            posteRepository.save(poste4);


            
            Responsable responsable1 = new Responsable(null, "chef projet Punic Trade");
            Responsable responsable2 = new Responsable(null, "chef projet Bourse");
            responsableRepository.save(responsable1);
            responsableRepository.save(responsable2);


//Collaborateur collaborateur1 = new Collaborateur(null,77777,"khouloud",4587541,256985,20145623,"2010-01-22","khuloud@gmail.com","sfax","informatique","angular",3,1,8,11,15,6,4, contrat1, niveau1, poste1, responsable1, departement1, avantage2);
//            Collaborateur collaborateur2 = new Collaborateur(null,12546,"Hazar",2563154,11111,53621500,"2008-12-03","hazar@gmail.com","nabeul","buisness","angular",1,2,9,12,16,7,5, contrat1, niveau2, poste2, responsable2, departement2, avantage1);
//            Collaborateur collaborateur3 = new Collaborateur(null,444521,"khalil",1258745,2222,22120451,"2005-06-10","khalil@gmail.com","sousse","test et qualité","springboot",1,3,8,13,15,7,5, contrat3, niveau1, poste3, responsable1, departement2, avantage1);
//            Collaborateur collaborateur4 = new Collaborateur(null,332015,"maissa",2140006,78542,99856321,"2000-10-10","maissa@gmail.com","bizerte","developpement","springboot",1,1,8,11,16,7,5, contrat1, niveau1, poste1, responsable2, departement2, avantage1);
//            Collaborateur collaborateur5 = new Collaborateur(null,562000,"omar",22500365,555231,44512,"2015-11-05","omar@gmail.com","ben arous","test et qualité","selenium",1,2,9,12,15,7,5, contrat2, niveau2, poste2, responsable1, departement2, avantage1);
//            Collaborateur collaborateur6 = new Collaborateur(null,452361,"Amal",23001500,775210,12003,"2012-10-01","amal@gmail.com","mahdia","informatique","angular",1,3,10,11,15,6,4, contrat3, niveau3, poste1, responsable1, departement1, avantage2);
//            Collaborateur collaborateur7 = new Collaborateur(null,523642,"Rahma",58562312,5699857,36550,"2014-09-01","rahma@gmail.com","beja","ressource humaine","jira",1,3,10,14,15,6,4, contrat3, niveau3, poste4, responsable1, departement1, avantage2);
//
//collaborateurRepository.save(collaborateur1);
//            collaborateurRepository.save(collaborateur2);
//            collaborateurRepository.save(collaborateur3);
//            collaborateurRepository.save(collaborateur4);
//            collaborateurRepository.save(collaborateur5);
//            collaborateurRepository.save(collaborateur6);
//            collaborateurRepository.save(collaborateur7);



        };
    }
	
}
