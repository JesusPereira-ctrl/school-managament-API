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

import com.colegio.gestion_clases.models.dtos.request.SubjectRequest;
import com.colegio.gestion_clases.models.dtos.response.subject.SubjectDetailResponse;
import com.colegio.gestion_clases.models.dtos.response.subject.SubjectSummaryResponse;
import com.colegio.gestion_clases.services.SubjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("")
    public ResponseEntity<List<SubjectSummaryResponse>> getAll() {
        return ResponseEntity.ok(subjectService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDetailResponse> getById(
        @PathVariable(required = true) Long id
    ) {
        return ResponseEntity.ok(subjectService.getById(id));
    }

    @PostMapping("")
    public ResponseEntity<SubjectDetailResponse> create(
        @RequestBody(required = true) @Valid SubjectRequest subjectRequest
    ) {
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(subjectService.create(subjectRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectDetailResponse> update(
        @PathVariable(required = true) Long id,
        @RequestBody(required = true) SubjectRequest subjectRequest
    ) {
        return ResponseEntity.ok(subjectService.update(id, subjectRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
        @PathVariable(required = true) Long id
    ) {
        subjectService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
