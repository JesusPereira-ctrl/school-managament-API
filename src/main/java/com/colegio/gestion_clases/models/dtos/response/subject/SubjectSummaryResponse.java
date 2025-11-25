package com.colegio.gestion_clases.models.dtos.response.subject;

import java.util.List;

import com.colegio.gestion_clases.models.dtos.response.classes.SchoolClassSummaryResponse;
import com.colegio.gestion_clases.models.entities.Subject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectSummaryResponse {

    private Long id;
    private String name;
    private String code;
    private List<SchoolClassSummaryResponse> schoolClasses;

    public SubjectSummaryResponse(Subject subject) {
        this.id = subject.getId();
        this.name = subject.getName();
        this.code = subject.getCode();

        this.schoolClasses = subject.getSchoolClasses()
                                    .stream()
                                    .map(SchoolClassSummaryResponse::new)
                                    .toList();
    }
}
