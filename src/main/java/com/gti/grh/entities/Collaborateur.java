package com.gti.grh.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Collaborateur {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
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

}
