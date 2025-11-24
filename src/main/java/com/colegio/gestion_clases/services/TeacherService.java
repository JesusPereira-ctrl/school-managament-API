package com.colegio.gestion_clases.services;

import java.util.List;

import com.colegio.gestion_clases.models.dtos.request.TeacherRequest;
import com.colegio.gestion_clases.models.dtos.response.TeacherResponse;

public interface TeacherService {

    List<TeacherResponse> getAll();

    TeacherResponse getById(Long id);

    TeacherResponse create(TeacherRequest teacherRequest);

    TeacherResponse update(Long id, TeacherRequest teacherRequest);

    void deleteById(Long id);

    TeacherResponse updateActive(Long id, boolean active);
}
