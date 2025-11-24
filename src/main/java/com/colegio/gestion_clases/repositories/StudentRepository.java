package com.colegio.gestion_clases.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.colegio.gestion_clases.models.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
