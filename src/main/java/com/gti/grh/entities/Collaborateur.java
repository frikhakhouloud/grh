package com.gti.grh.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Collaborateur implements Serializable  {

	public Collaborateur(Object id2, int cin2, String nom2, int numCompte2, int numSecSocial2, int telephone2,
			String string, String email2, String adresse2, String natureEtude2, String certification2,
			int anneeExperience2, int idTypeContrat2, int idNiveauEtude2, int idPoste2, int idResponsable2,
			int idDepartement2, int idAvantageSalaire2, ContratType contrat1, NiveauEtude niveau3, Poste poste1,
			Responsable responsable1, Departement departement1, AvantageSalaire avantage2) {
		// TODO Auto-generated constructor stub
	}

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private Integer cin;
	private String nom;
	private Integer numCompte;
	private Integer numSecSocial;
	private Integer telephone;
	private Date dateNaissance;
	private String email;
	private String adresse;
	private String natureEtude;
	private String certification;
	private Integer anneeExperience;
	
	
	private long idTypeContrat; 
	
	private long idNiveauEtude;
	
	private long idPoste;
	
	private long idResponsable;

	private long idDepartement;
	
	private long idAvantageSalaire;


	
	@Transient
	private ContratType contratType;
	
	@Transient
	private NiveauEtude niveauEtude;
	
	@Transient
	private Poste poste;
	
	@Transient
	private Responsable responsable;
	
	@Transient
	private Departement departement;
	
	@Transient
	private AvantageSalaire avantageSalaire;

	
	
//	@RestResource(exported = false)
//	@ManyToOne
//	private ContratType contratType;
//
//	@ManyToOne
//	private NiveauEtude niveauEtude;
//
//	@ManyToOne
//	private Poste poste;
//
//	@ManyToOne
//	private Responsable responsable;
//
//	@ManyToOne
//	private Departement departement;
//
//	@ManyToOne
//	private AvantageSalaire avantageSalaire;


}
