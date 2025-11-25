package com.colegio.gestion_clases.models.dtos.response;

import java.util.List;

import com.colegio.gestion_clases.models.entities.Student;
import com.colegio.gestion_clases.utils.DateFormatterUtil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {

    private Long id;
    private String name;
    private String lastname;
    private String rut;
    private boolean active;

    private String createdAt;
    private String updatedAt;

    private List<NoteResponse> notes;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.lastname = student.getLastname();
        this.rut = student.getRut();
        this.active = student.isActive();
        this.createdAt = DateFormatterUtil.format(student.getAudit().getCreatedAt());
        this.updatedAt = DateFormatterUtil.format(student.getAudit().getUpdatedAt());

        this.notes = student.getNotes()
                            .stream()
                            .map(NoteResponse::new)
                            .toList();
    }
}
