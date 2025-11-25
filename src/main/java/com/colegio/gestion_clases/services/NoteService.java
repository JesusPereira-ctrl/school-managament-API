package com.colegio.gestion_clases.services;

import java.util.List;

import com.colegio.gestion_clases.models.dtos.request.NoteRequest;
import com.colegio.gestion_clases.models.dtos.response.note.NoteDetailResponse;
import com.colegio.gestion_clases.models.dtos.response.note.NoteSummaryResponse;

public interface NoteService {

    List<NoteSummaryResponse> getAll();

    NoteDetailResponse getById(Long id);

    NoteDetailResponse create(NoteRequest noteRequest);

    NoteDetailResponse update (Long id, NoteRequest noteRequest);

    void deleteById(Long id);
}
