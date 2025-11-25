package com.colegio.gestion_clases.models.dtos.response;

import java.time.LocalDate;

import com.colegio.gestion_clases.models.entities.Note;
import com.colegio.gestion_clases.utils.DateFormatterUtil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteResponse {

    private Long id;
    private Double value;
    private String type;
    private LocalDate date;
    private String observation;
    private Long studentId;
    private Long schoolClassId;
    private String createdAt;
    private String updatedAt;

    public NoteResponse(Note note) {
        this.id = note.getId();
        this.value = note.getValue();
        this.type = note.getType();
        this.date = note.getDate();
        this.observation = note.getObservation();
        this.studentId = note.getStudent().getId();
        this.schoolClassId = note.getSchoolClass().getId();
        this.createdAt = DateFormatterUtil.format(note.getAudit().getCreatedAt());
        this.updatedAt = DateFormatterUtil.format(note.getAudit().getUpdatedAt());
    }
}
