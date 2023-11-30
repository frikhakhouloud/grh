package com.gti.grh.dto;

import java.util.Date;

import lombok.Data;
@Data
public class CollaborateurDto {
	private Integer id;
	private Integer cin;
	private String nom;
	private Integer numCompte;
	private Integer numSecSocial;
	private Integer telephone;
	private Date dateNaissance;
//	private String email;
//	private String adresse;
//
//	private Integer id_qualification;
//	private Integer id_contrat;
//	private Integer id_grade;
//	private Integer id_piece;
//	private Integer id_autre_information;
}
