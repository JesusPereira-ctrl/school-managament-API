package com.colegio.gestion_clases.services;

import java.util.List;

import com.colegio.gestion_clases.models.dtos.request.StudentRequest;
import com.colegio.gestion_clases.models.dtos.response.student.StudentDetailResponse;
import com.colegio.gestion_clases.models.dtos.response.student.StudentSummaryResponse;

public interface StudentService {

    List<StudentSummaryResponse> getAll();

    StudentDetailResponse getById(Long id);

    StudentDetailResponse create(StudentRequest studentRequest);

    StudentDetailResponse update(Long id, StudentRequest studentRequest);

    void deleteById(Long id);

    StudentDetailResponse updateActive(Long id, boolean active);
}