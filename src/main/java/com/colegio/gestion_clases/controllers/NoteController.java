package com.colegio.gestion_clases.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.gestion_clases.models.dtos.request.NoteRequest;
import com.colegio.gestion_clases.models.dtos.response.note.NoteDetailResponse;
import com.colegio.gestion_clases.models.dtos.response.note.NoteSummaryResponse;
import com.colegio.gestion_clases.services.NoteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("")
    public ResponseEntity<List<NoteSummaryResponse>> getAll() {
        return ResponseEntity.ok(noteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDetailResponse> getById(
        @PathVariable(required = true) Long id
    ) {
        return ResponseEntity.ok(noteService.getById(id));
    }

    @PostMapping("")
    public ResponseEntity<NoteDetailResponse> create(
        @RequestBody(required = true) @Valid NoteRequest noteRequest
    ) {
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(noteService.create(noteRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteDetailResponse> update(
        @PathVariable(required = true) Long id,
        @RequestBody(required = true) @Valid NoteRequest noteRequest
    ) {
        return ResponseEntity.ok(noteService.update(id, noteRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
        @PathVariable(required = true) Long id
    ) {
        noteService.deleteById(id);
        return ResponseEntity.status(HttpStatus.GONE.value()).build();
    }
}
