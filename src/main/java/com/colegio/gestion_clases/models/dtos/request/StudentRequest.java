package com.colegio.gestion_clases.models.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {

    @NotBlank(message = "The student's name cannot be blank.")
    private String name;

    @NotBlank(message = "The student's lastname cannot be blank.")
    private String lastname;

    @NotBlank(message = "The student's rut cannot be blank.")
    @Pattern(
        regexp = "^(\\d{1,3}(?:\\.\\d{3})*|\\d+)-[\\dkK]$",
        message = "The RUT must have the valid Chilean format: numbers with or without periods, followed by a hyphen and a check digit (0-9 or K). Valid examples: 12.345.678-5, 12345678-K."
    )
    private String rut;
}
