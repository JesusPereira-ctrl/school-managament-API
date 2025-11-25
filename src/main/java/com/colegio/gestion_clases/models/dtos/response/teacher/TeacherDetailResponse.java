package com.colegio.gestion_clases.models.dtos.response.teacher;

import com.colegio.gestion_clases.models.entities.Teacher;
import com.colegio.gestion_clases.utils.DateFormatterUtil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDetailResponse {

    private Long id;
    private String name;
    private String lastname;
    private String rut;
    private String email;
    private String phone;
    private Boolean active;

    private String createdAt;
    private String updatedAt;

    public TeacherDetailResponse(Teacher teacher) {
        this.id = teacher.getId();
        this.name = teacher.getName();
        this.lastname = teacher.getLastname();
        this.rut = teacher.getRut();
        this.email = teacher.getEmail();
        this.phone = teacher.getPhone();
        this.active = teacher.isActive();
        this.createdAt = DateFormatterUtil.format(teacher.getAudit().getCreatedAt());
        this.updatedAt = DateFormatterUtil.format(teacher.getAudit().getUpdatedAt());
    }
}
