package com.colegio.gestion_clases.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.colegio.gestion_clases.models.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
