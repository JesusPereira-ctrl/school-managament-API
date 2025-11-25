package com.colegio.gestion_clases.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.colegio.gestion_clases.exceptions.ResourceNotFoundException;
import com.colegio.gestion_clases.models.dtos.request.SubjectRequest;
import com.colegio.gestion_clases.models.dtos.response.subject.SubjectDetailResponse;
import com.colegio.gestion_clases.models.dtos.response.subject.SubjectSummaryResponse;
import com.colegio.gestion_clases.models.entities.Subject;
import com.colegio.gestion_clases.repositories.SubjectRepository;
import com.colegio.gestion_clases.services.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<SubjectSummaryResponse> getAll() {
        return subjectRepository.findAll()
                                .stream()
                                .map(SubjectSummaryResponse::new)
                                .toList();
    }

    @Override
    public SubjectDetailResponse getById(Long id) {
        Subject subjectDB = getDataOfDB(id);

        return new SubjectDetailResponse(subjectDB);
    }

    @Override
    public SubjectDetailResponse create(SubjectRequest subjectRequest) {
        Subject subjectNew = new Subject();

        subjectNew.setName(subjectRequest.getName());
        subjectNew.setCode(subjectRequest.getCode());

        // La descripcion es opcional, si viene la colocamos
        if (!subjectRequest.getDescription().isBlank()) {
            subjectNew.setDescription(subjectRequest.getDescription()); 
        }

        subjectNew.setMandatory(subjectRequest.getMandatory());

        return new SubjectDetailResponse(subjectNew);
    }

    @Override
    public SubjectDetailResponse update(Long id, SubjectRequest subjectRequest) {
        Subject subjectDB = getDataOfDB(id);

        subjectDB.setName(subjectRequest.getName());
        subjectDB.setCode(subjectRequest.getCode());

        // La descripcion es opcional, si viene la colocamos
        if (!subjectRequest.getDescription().isBlank()) {
            subjectDB.setDescription(subjectRequest.getDescription()); 
        }

        subjectDB.setMandatory(subjectRequest.getMandatory());

        subjectRepository.save(subjectDB);

        return new SubjectDetailResponse(subjectDB);
    }

    @Override
    public void deleteById(Long id) {
        Subject subjectDB = getDataOfDB(id);
        
        subjectRepository.delete(subjectDB);
    }

    private Subject getDataOfDB(Long id) {
        return subjectRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));
    }
}
