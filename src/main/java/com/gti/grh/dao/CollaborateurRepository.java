package com.gti.grh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gti.grh.entities.Collaborateur;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Long>{
	@Query("Select c from Collaborateur c where c.nom like %:nom%")
	Collaborateur findByName(String nom);
}
