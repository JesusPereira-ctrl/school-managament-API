package com.colegio.gestion_clases.models.dtos.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteRequest {

    @NotNull
    private Double value;

    @NotBlank
    private String type;

    @NotNull
    private LocalDate date;

    @Size(min = 10, max = 255)
    private String observation;

    @NotNull
    @Min(1)
    private Long studentId;

    @NotNull
    @Min(1)
    private Long schoolClassId;
}
