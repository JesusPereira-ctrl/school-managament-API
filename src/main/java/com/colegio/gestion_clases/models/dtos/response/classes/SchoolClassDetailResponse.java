package com.colegio.gestion_clases.models.dtos.response.classes;

import java.util.List;

import com.colegio.gestion_clases.models.dtos.response.note.NoteDetailResponse;
import com.colegio.gestion_clases.models.dtos.response.subject.SubjectDetailResponse;
import com.colegio.gestion_clases.models.dtos.response.teacher.TeacherDetailResponse;
import com.colegio.gestion_clases.models.entities.SchoolClass;
import com.colegio.gestion_clases.utils.DateFormatterUtil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolClassDetailResponse {

    private Long id;
    private String course;
    private String hall;
    private String schedule;
    private Integer yearSchool;
    private Boolean active;
    private TeacherDetailResponse teacher;
    private SubjectDetailResponse subject;
    private List<NoteDetailResponse> notes;
    private String createdAt;
    private String updatedAt;

    public SchoolClassDetailResponse(SchoolClass schoolClass) {
        this.id = schoolClass.getId();
        this.course = schoolClass.getCourse();
        this.hall = schoolClass.getHall();
        this.yearSchool = schoolClass.getYearSchool();
        this.active = schoolClass.isActive();
        this.teacher = new TeacherDetailResponse(schoolClass.getTeacher());
        this.subject = new SubjectDetailResponse(schoolClass.getSubject());

        this.notes = schoolClass.getNotes()
                                .stream()
                                .map(NoteDetailResponse::new)
                                .toList();

        this.createdAt = DateFormatterUtil.format(schoolClass.getAudit().getCreatedAt());
        this.updatedAt = DateFormatterUtil.format(schoolClass.getAudit().getUpdatedAt());
    }
}
