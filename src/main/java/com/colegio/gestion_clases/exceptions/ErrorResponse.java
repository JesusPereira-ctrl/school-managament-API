package com.colegio.gestion_clases.exceptions;

public record ErrorResponse(
    int status,
    String error,
    Object message,
    String timestamp
) {}
