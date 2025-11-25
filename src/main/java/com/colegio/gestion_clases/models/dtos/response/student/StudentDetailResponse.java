package com.colegio.gestion_clases.models.dtos.response.student;

import java.util.List;

import com.colegio.gestion_clases.models.dtos.response.note.NoteDetailResponse;
import com.colegio.gestion_clases.models.entities.Student;
import com.colegio.gestion_clases.utils.DateFormatterUtil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDetailResponse {

    private Long id;
    private String name;
    private String lastname;
    private String rut;
    private Boolean active;

    private String createdAt;
    private String updatedAt;

    private List<NoteDetailResponse> notes;

    public StudentDetailResponse(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.lastname = student.getLastname();
        this.rut = student.getRut();
        this.active = student.isActive();
        this.createdAt = DateFormatterUtil.format(student.getAudit().getCreatedAt());
        this.updatedAt = DateFormatterUtil.format(student.getAudit().getUpdatedAt());

        this.notes = student.getNotes()
                            .stream()
                            .map(NoteDetailResponse::new)
                            .toList();
    }
}
