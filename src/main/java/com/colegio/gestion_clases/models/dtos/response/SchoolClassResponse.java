package com.colegio.gestion_clases.models.dtos.response;

import java.util.List;

import com.colegio.gestion_clases.models.entities.Note;
import com.colegio.gestion_clases.models.entities.SchoolClass;
import com.colegio.gestion_clases.utils.DateFormatterUtil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolClassResponse {

    private Long id;
    private String course;
    private String hall;
    private String schedule;
    private Integer yearSchool;
    private Boolean active;
    private TeacherResponse teacher;
    private SubjectResponse subject;
    private List<Note> notes;
    private String createdAt;
    private String updatedAt;

    public SchoolClassResponse(SchoolClass schoolClass) {
        this.id = schoolClass.getId();
        this.course = schoolClass.getCourse();
        this.hall = schoolClass.getHall();
        this.yearSchool = schoolClass.getYearSchool();
        this.active = schoolClass.isActive();
        this.teacher = new TeacherResponse(schoolClass.getTeacher());
        this.subject = new SubjectResponse(schoolClass.getSubject());
        this.notes = schoolClass.getNotes();
        this.createdAt = DateFormatterUtil.format(schoolClass.getAudit().getCreatedAt());
        this.updatedAt = DateFormatterUtil.format(schoolClass.getAudit().getUpdatedAt());
    }
}
