package com.colegio.gestion_clases.services;

import java.util.List;

import com.colegio.gestion_clases.models.dtos.request.SubjectRequest;
import com.colegio.gestion_clases.models.dtos.response.subject.SubjectDetailResponse;
import com.colegio.gestion_clases.models.dtos.response.subject.SubjectSummaryResponse;

public interface SubjectService {

    List<SubjectSummaryResponse> getAll();

    SubjectDetailResponse getById(Long id);

    SubjectDetailResponse create(SubjectRequest subjectRequest);

    SubjectDetailResponse update(Long id, SubjectRequest subjectRequest);

    void deleteById(Long id);
}
