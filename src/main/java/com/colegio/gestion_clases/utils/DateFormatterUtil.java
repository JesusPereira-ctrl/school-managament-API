package com.colegio.gestion_clases.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatterUtil {

    private static final DateTimeFormatter FORMATTER = 
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public static String format(LocalDateTime date) {
        return date != null ? date.format(FORMATTER) : null;
    }
}
