package com.colegio.gestion_clases.models.dtos.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolClassRequest {

    @NotBlank
    private String course;

    @NotBlank
    private String hall;

    @NotBlank
    private String schedule;

    @NotNull
    @Min(1)
    private Long teacherId;

    @NotNull
    @Min(1)
    private Long subjectId;
}
