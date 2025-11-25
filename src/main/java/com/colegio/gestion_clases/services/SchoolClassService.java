package com.colegio.gestion_clases.services;

import java.util.List;

import com.colegio.gestion_clases.models.dtos.request.SchoolClassRequest;
import com.colegio.gestion_clases.models.dtos.response.classes.SchoolClassDetailResponse;
import com.colegio.gestion_clases.models.dtos.response.classes.SchoolClassSummaryResponse;

public interface SchoolClassService {

    List<SchoolClassSummaryResponse> getAll();

    SchoolClassDetailResponse getById(Long id);

    SchoolClassDetailResponse create(SchoolClassRequest schoolClassRequest);

    SchoolClassDetailResponse update(Long id, SchoolClassRequest schoolClassRequest);

    void deleteById(Long id);
}
