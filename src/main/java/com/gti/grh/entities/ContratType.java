package com.gti.grh.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ContratType {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String type;

	
	
	@OneToMany(mappedBy = "contratType")
	private Collection<Collaborateur> collaborateurs;
	
	@OneToMany(mappedBy = "contratType")
	private Collection<PieceJointe> pieceJointes;
	
}
