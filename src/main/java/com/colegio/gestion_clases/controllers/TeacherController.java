package com.colegio.gestion_clases.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.gestion_clases.models.dtos.request.TeacherRequest;
import com.colegio.gestion_clases.models.dtos.response.TeacherResponse;
import com.colegio.gestion_clases.services.TeacherService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("")
    public ResponseEntity<List<TeacherResponse>> getAll() {
        return ResponseEntity.ok(teacherService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponse> getById(
        @PathVariable(required = true) Long id
    ) {
        return ResponseEntity
                .ok(teacherService.getById(id));
    }

    @PostMapping("")
    public ResponseEntity<TeacherResponse> create(
        @RequestBody(required = true) @Valid TeacherRequest teacherRequest
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .body(teacherService.create(teacherRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherResponse> update(
        @PathVariable(required = true) Long id,
        @RequestBody @Valid TeacherRequest teacherRequest
    ) {
        return ResponseEntity
                .ok(teacherService.update(id, teacherRequest));
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<TeacherResponse> activate(
        @PathVariable(required = true) Long id
    ) {
        TeacherResponse teacher = teacherService.updateActive(id, true);
        return ResponseEntity.ok(teacher);
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<TeacherResponse> deactivate(
        @PathVariable(required = true) Long id
    ) {
        TeacherResponse teacher = teacherService.updateActive(id, false);
        return ResponseEntity.ok(teacher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
        @PathVariable(required = true) Long id
    ) {
        teacherService.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
