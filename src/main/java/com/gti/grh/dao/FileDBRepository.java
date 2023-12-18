package com.gti.grh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gti.grh.entities.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}