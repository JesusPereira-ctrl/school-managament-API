package com.colegio.gestion_clases.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.gestion_clases.models.dtos.request.StudentRequest;
import com.colegio.gestion_clases.models.dtos.response.StudentResponse;
import com.colegio.gestion_clases.services.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("")
    public ResponseEntity<List<StudentResponse>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @RequestMapping("/{id}")
    public ResponseEntity<StudentResponse> getById(
        @PathVariable(required = true) Long id
    ) {
        return ResponseEntity
                .ok(studentService.getById(id));
    }

    @PostMapping("")
    public ResponseEntity<StudentResponse> create(
        @RequestBody(required = true) @Valid StudentRequest studentRequest
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .body(studentService.create(studentRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> update(
        @PathVariable(required = true) Long id,
        @RequestBody(required = true) StudentRequest studentRequest
    ) {
        return ResponseEntity
                .ok(studentService.update(id, studentRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
        @PathVariable(required = true) Long id
    ) {
        studentService.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
