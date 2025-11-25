package com.colegio.gestion_clases.models.dtos.response.student;

import java.util.List;

import com.colegio.gestion_clases.models.dtos.response.note.NoteSummaryResponse;
import com.colegio.gestion_clases.models.entities.Student;
import com.colegio.gestion_clases.utils.DateFormatterUtil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentSummaryResponse {

    private Long id;
    private String name;
    private String lastname;
    private Boolean active;
    private String rut;
    private String createdAt;
    private List<NoteSummaryResponse> notes;

    public StudentSummaryResponse(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.lastname = student.getLastname();
        this.active = student.isActive();
        this.rut = student.getRut();
        this.createdAt = DateFormatterUtil.format(student.getAudit().getCreatedAt());

        this.notes = student.getNotes()
                            .stream()
                            .map(NoteSummaryResponse::new)
                            .toList();
    }
}
