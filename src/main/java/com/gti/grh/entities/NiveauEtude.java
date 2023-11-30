package com.gti.grh.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor@Data@Entity
public class NiveauEtude {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String niveauEtude;

}
