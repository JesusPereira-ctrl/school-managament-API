package com.colegio.gestion_clases.services;

import java.util.List;

import com.colegio.gestion_clases.models.dtos.request.StudentRequest;
import com.colegio.gestion_clases.models.dtos.response.StudentResponse;

public interface StudentService {

    List<StudentResponse> getAll();

    StudentResponse getById(Long id);

    StudentResponse create(StudentRequest studentRequest);

    StudentResponse update(Long id, StudentRequest studentRequest);

    void deleteById(Long id);

    StudentResponse updateActive(Long id, boolean active);
}