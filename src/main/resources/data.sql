-- TEACHERS
INSERT INTO teachers (name, lastname, rut, email, phone) VALUES ('María Fernanda', 'Pérez Soto', '12345678-5', 'mfernanda@example.com', '+56912345678');
INSERT INTO teachers (name, lastname, rut, email, phone) VALUES ('José Antonio', 'García Muñoz', '9876543-K', 'jose.garcia@example.com', '+56923456789');
INSERT INTO teachers (name, lastname, rut, email, phone) VALUES ('Camila Isabel', 'Rojas Figueroa', '14567239-2', 'camila.rojas@example.com', '+56934567890');
INSERT INTO teachers (name, lastname, rut, email, phone) VALUES ('Felipe Ignacio', 'Morales Paredes', '17654321-9', 'felipe.morales@example.com', '+56945678901');
INSERT INTO teachers (name, lastname, rut, email, phone) VALUES ('Daniela Andrea', 'Carrasco Silva', '11222333-4', 'daniela.carrasco@example.com', '+56956789012');
INSERT INTO teachers (name, lastname, rut, email, phone) VALUES ('Sebastián Elías', 'Hernández Díaz', '19456325-1', 'sebastian.hdz@example.com', '+56967890123');
INSERT INTO teachers (name, lastname, rut, email, phone) VALUES ('Valentina Sofía', 'Fuentes Rivera', '10123456-7', 'valentina.fuentes@example.com', '+56978901234');
INSERT INTO teachers (name, lastname, rut, email, phone) VALUES ('Rodrigo Esteban', 'Lagos Cifuentes', '15678943-0', 'rodrigo.lagos@example.com', '+56989012345');
INSERT INTO teachers (name, lastname, rut, email, phone) VALUES ('Francisca Belén', 'Araya Torres', '18234567-8', 'francisca.araya@example.com', '+56990123456');
INSERT INTO teachers (name, lastname, rut, email, phone) VALUES ('Cristóbal Martín', 'Vega Morales', '16875432-6', 'cristobal.vega@example.com', '+56901234567');

-- STUDENTS
INSERT INTO students (name, lastname, rut) VALUES ('María', 'González', '12.345.678-5');
INSERT INTO students (name, lastname, rut) VALUES ('Juan', 'Pérez', '15.678.234-K');
INSERT INTO students (name, lastname, rut) VALUES ('Camila', 'Rojas', '9.876.543-2');
INSERT INTO students (name, lastname, rut) VALUES ('Francisca', 'Muñoz', '7.654.321-8');
INSERT INTO students (name, lastname, rut) VALUES ('Matías', 'Soto', '21.345.987-K');
INSERT INTO students (name, lastname, rut) VALUES ('Diego', 'Ramírez', '18.234.567-3');
INSERT INTO students (name, lastname, rut) VALUES ('Valentina', 'Castillo', '13.579.246-1');
INSERT INTO students (name, lastname, rut) VALUES ('Sebastián', 'Molina', '22.468.135-K');
INSERT INTO students (name, lastname, rut) VALUES ('Ignacia', 'Herrera', '10.456.789-7');
INSERT INTO students (name, lastname, rut) VALUES ('Tomás', 'Vargas', '8.123.456-K');

-- SUBJECTS
INSERT INTO subjects (name, code, mandatory) VALUES ('Matemáticas', 'MAT-001', true);
INSERT INTO subjects (name, code, mandatory) VALUES ('Lenguaje', 'LEN-001', true);
INSERT INTO subjects (name, code, mandatory) VALUES ('Ciencias Naturales', 'CNT-001', true);
INSERT INTO subjects (name, code, mandatory) VALUES ('Física', 'FIS-001', true);
INSERT INTO subjects (name, code, mandatory) VALUES ('Biología', 'BIO-001', false);
INSERT INTO subjects (name, code, mandatory) VALUES ('Inglés', 'ING-001', false);
INSERT INTO subjects (name, code, mandatory) VALUES ('Gastronomía', 'GTM-001', false);
INSERT INTO subjects (name, code, mandatory) VALUES ('Educación Física', 'EDF-001', false);
INSERT INTO subjects (name, code, mandatory) VALUES ('Química', 'QMC-001', false);
INSERT INTO subjects (name, code, mandatory) VALUES ('Lógica Computacional', 'LCO-001', false);

-- CLASSES
INSERT INTO classes (course, hall, schedule, teacher_id, subject_id) VALUES ('1A', 'A1', '08:00 - 09:30', 1, 1);
INSERT INTO classes (course, hall, schedule, teacher_id, subject_id) VALUES ('1B', 'A2', '10:00 - 11:30', 2, 2);
INSERT INTO classes (course, hall, schedule, teacher_id, subject_id) VALUES ('2A', 'B1', '12:00 - 13:30', 3, 3);
INSERT INTO classes (course, hall, schedule, teacher_id, subject_id) VALUES ('2B', 'B2', '14:00 - 15:30', 4, 4);
INSERT INTO classes (course, hall, schedule, teacher_id, subject_id) VALUES ('3A', 'C1', '08:00 - 09:30', 5, 5);
INSERT INTO classes (course, hall, schedule, teacher_id, subject_id) VALUES ('3B', 'C2', '10:00 - 11:30', 6, 6);
INSERT INTO classes (course, hall, schedule, teacher_id, subject_id) VALUES ('4A', 'D1', '12:00 - 13:30', 7, 7);
INSERT INTO classes (course, hall, schedule, teacher_id, subject_id) VALUES ('4B', 'D2', '14:00 - 15:30', 8, 8);
INSERT INTO classes (course, hall, schedule, teacher_id, subject_id) VALUES ('5A', 'E1', '08:00 - 09:30', 9, 9);
INSERT INTO classes (course, hall, schedule, teacher_id, subject_id) VALUES ('5B', 'E2', '10:00 - 11:30', 10, 10);

-- NOTES
INSERT INTO notes (value, type, date, observation, student_id, school_class_id)
VALUES (5.5, 'Prueba', '2024-03-12', 'Buen desempeño', 1, 1);

INSERT INTO notes (value, type, date, observation, student_id, school_class_id)
VALUES (4.3, 'Control', '2024-04-21', 'Debe mejorar', 2, 2);

INSERT INTO notes (value, type, date, observation, student_id, school_class_id)
VALUES (6.1, 'Prueba', '2024-05-30', 'Excelente trabajo', 3, 3);

INSERT INTO notes (value, type, date, observation, student_id, school_class_id)
VALUES (3.9, 'Evaluación', '2024-06-18', 'Falta estudio', 4, 4);

INSERT INTO notes (value, type, date, observation, student_id, school_class_id)
VALUES (6.7, 'Prueba Parcial', '2024-07-22', 'Muy buen resultado', 5, 5);

INSERT INTO notes (value, type, date, observation, student_id, school_class_id)
VALUES (5.0, 'Tarea', '2024-08-11', 'Completo', 6, 6);

INSERT INTO notes (value, type, date, observation, student_id, school_class_id)
VALUES (4.8, 'Control', '2024-09-03', 'Regular', 7, 7);

INSERT INTO notes (value, type, date, observation, student_id, school_class_id)
VALUES (6.4, 'Exposición', '2024-10-14', 'Muy buena', 8, 8);

INSERT INTO notes (value, type, date, observation, student_id, school_class_id)
VALUES (5.2, 'Prueba', '2024-11-06', 'Promedio', 9, 9);

INSERT INTO notes (value, type, date, observation, student_id, school_class_id)
VALUES (3.5, 'Examen', '2024-12-01', 'Debe reforzar', 10, 10);


