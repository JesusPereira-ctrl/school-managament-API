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

import com.colegio.gestion_clases.models.dtos.request.SchoolClassRequest;
import com.colegio.gestion_clases.models.dtos.response.classes.SchoolClassDetailResponse;
import com.colegio.gestion_clases.models.dtos.response.classes.SchoolClassSummaryResponse;
import com.colegio.gestion_clases.services.SchoolClassService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/classes")
public class SchoolClassController {

    private SchoolClassService schoolClassService;

    public SchoolClassController(SchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }

    @GetMapping("")
    public ResponseEntity<List<SchoolClassSummaryResponse>> getAll() {
        return ResponseEntity.ok(schoolClassService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolClassDetailResponse> getById(
        @PathVariable(required = true) Long id
    ) {
        return ResponseEntity.ok(schoolClassService.getById(id));
    }

    @PostMapping("")
    public ResponseEntity<SchoolClassDetailResponse> create(
        @RequestBody(required = true) @Valid SchoolClassRequest schoolClassRequest
    ) {
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(schoolClassService.create(schoolClassRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SchoolClassDetailResponse> update(
        @PathVariable(required = true) Long id,
        @RequestBody(required = true) @Valid SchoolClassRequest schoolClassRequest
    ) {
        return ResponseEntity.ok(schoolClassService.update(id, schoolClassRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
        @PathVariable(required = true) Long id
    ) {
        schoolClassService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
