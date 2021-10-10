package com.gestion.blanchiment.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.blanchiment.entities.Agence;
import com.gestion.blanchiment.entities.Uploadfile;


@Repository
public interface UploadFileRepository extends JpaRepository<Uploadfile, Integer> {

}
