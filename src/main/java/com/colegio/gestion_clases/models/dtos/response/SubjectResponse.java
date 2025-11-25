package com.colegio.gestion_clases.models.dtos.response;

import java.util.List;

import com.colegio.gestion_clases.models.entities.Subject;
import com.colegio.gestion_clases.utils.DateFormatterUtil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectResponse {

    private Long id;
    private String name;
    private String code;
    private Boolean mandatory;
    private List<SchoolClassResponse> schoolClasses;
    private String createdAt;
    private String updatedAt;

    public SubjectResponse(Subject subject) {
        this.id = subject.getId();
        this.name = subject.getName();
        this.code = subject.getCode();
        this.mandatory = subject.isMandatory();
        
        this.schoolClasses = subject.getSchoolClasses()
                                    .stream()
                                    .map(SchoolClassResponse::new)
                                    .toList();

        this.createdAt = DateFormatterUtil.format(subject.getAudit().getCreatedAt());
        this.updatedAt = DateFormatterUtil.format(subject.getAudit().getUpdatedAt());
    }
}
