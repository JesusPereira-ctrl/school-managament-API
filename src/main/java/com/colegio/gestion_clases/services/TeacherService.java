package com.colegio.gestion_clases.services;

import java.util.List;

import com.colegio.gestion_clases.models.dtos.request.TeacherRequest;
import com.colegio.gestion_clases.models.dtos.response.teacher.TeacherDetailResponse;

public interface TeacherService {

    List<TeacherDetailResponse> getAll();

    TeacherDetailResponse getById(Long id);

    TeacherDetailResponse create(TeacherRequest teacherRequest);

    TeacherDetailResponse update(Long id, TeacherRequest teacherRequest);

    void deleteById(Long id);

    TeacherDetailResponse updateActive(Long id, boolean active);
}
