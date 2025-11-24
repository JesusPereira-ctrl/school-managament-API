package com.colegio.gestion_clases.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.colegio.gestion_clases.models.entities.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
