package com.colegio.gestion_clases.models.dtos.request;

import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
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
    @DecimalMin(value = "1.0", message = "The minimum grade is 1.0")
    @DecimalMax(value = "7.0", message = "The maximum grade is 7.0")
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
