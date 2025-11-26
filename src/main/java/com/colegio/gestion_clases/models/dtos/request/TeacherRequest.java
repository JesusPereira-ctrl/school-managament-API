package com.colegio.gestion_clases.models.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherRequest {

    @NotBlank(message = "The teacher's name cannot be blank.")
    private String name;

    @NotBlank(message = "The teacher's lastname cannot be blank.")
    private String lastname;

    @NotBlank(message = "The teacher's rut cannot be blank.")
    @Pattern(
        regexp = "^(\\d{1,3}(?:\\.\\d{3})*|\\d+)-[\\dkK]$",
        message = "The RUT must have the valid Chilean format: numbers with or without periods, followed by a hyphen and a check digit (0-9 or K). Valid examples: 12.345.678-5, 12345678-K."
    )
    @Schema(example = "12.345.678-9")
    private String rut;

    @NotBlank(message = "The teacher's email cannot be blank.")
    @Email(message = "The email must have a valid format. Example: name@example.com.")
    @Schema(example = "example@email.com")
    private String email;
    
    @NotBlank(message = "The teacher's phone cannot be blank.")
    @Pattern(
        regexp = "^(?:\\+?56)?\\s*9\\d{8}$",
        message = "The cell phone number must be in Chilean format: begin with +56 9 or 9, followed by 8 digits. Valid examples: +56912345678, 56912345678, 912345678."
    )
    @Schema(example = "+56912345678")
    private String phone;    
}
