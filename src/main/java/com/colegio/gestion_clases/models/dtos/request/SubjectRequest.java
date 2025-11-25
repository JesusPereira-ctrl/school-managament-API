package com.colegio.gestion_clases.models.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String code;

    @Size(max = 255)
    private String description;

    @NotNull
    private Boolean mandatory;
}
