package com.colegio.gestion_clases.models.dtos.response.teacher;

import com.colegio.gestion_clases.models.entities.Teacher;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherSummaryResponse {

    private Long id;
    private String name;
    private String lastname;
    private Boolean active;

    public TeacherSummaryResponse(Teacher teacher) {
        this.id = teacher.getId();
        this.name = teacher.getName();
        this.lastname = teacher.getLastname();
        this.active = teacher.isActive();
    }
}
