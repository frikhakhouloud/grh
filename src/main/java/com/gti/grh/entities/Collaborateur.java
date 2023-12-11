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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private Integer cin;
	private String nom;
	private Integer numCompte;
	private Integer numSecSocial;
	private Integer telephone;
	private String dateNaissance;
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
