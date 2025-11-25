package com.colegio.gestion_clases.models.dtos.response.note;

import java.time.LocalDate;

import com.colegio.gestion_clases.models.entities.Note;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteSummaryResponse {

    private Long id;
    private Double value;
    private String type;
    private LocalDate date;
    private String course;

    public NoteSummaryResponse(Note note) {
        this.id = note.getId();
        this.value = note.getValue();
        this.type = note.getType();
        this.date = note.getDate();
        this.course = note.getSchoolClass().getCourse();
    }
}
