package com.gti.grh.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AvantageSalaire implements Serializable {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String avantage;
	private float salaire;

//	@OneToMany(mappedBy = "avantageSalaire")
//	private Collection<Collaborateur> collaborateurs;
}
