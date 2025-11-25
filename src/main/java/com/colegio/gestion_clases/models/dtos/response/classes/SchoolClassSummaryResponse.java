package com.colegio.gestion_clases.models.dtos.response.classes;

import com.colegio.gestion_clases.models.entities.SchoolClass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolClassSummaryResponse {

    private Long id;
    private String course;
    private String hall;
    private String teacher;
    private String subject;
    private String schedule;
    private Boolean mandatory;

    public SchoolClassSummaryResponse(SchoolClass schoolClass) {
        this.id = schoolClass.getId();
        this.course = schoolClass.getCourse();
        this.hall = schoolClass.getHall();
        this.teacher = schoolClass.getTeacher().getName();
        this.subject = schoolClass.getSubject().getName();
        this.schedule = schoolClass.getSchedule();
        this.mandatory = schoolClass.getSubject().isMandatory();
    }
}
