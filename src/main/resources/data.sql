-- teachers

INSERT INTO teachers (name, lastname, rut, email, phone)
VALUES ('María Fernanda', 'Pérez Soto', '12345678-5', 'mfernanda@example.com', '+56912345678');

INSERT INTO teachers (name, lastname, rut, email, phone)
VALUES ('José Antonio', 'García Muñoz', '9876543-K', 'jose.garcia@example.com', '+56923456789');

INSERT INTO teachers (name, lastname, rut, email, phone)
VALUES ('Camila Isabel', 'Rojas Figueroa', '14567239-2', 'camila.rojas@example.com', '+56934567890');

INSERT INTO teachers (name, lastname, rut, email, phone)
VALUES ('Felipe Ignacio', 'Morales Paredes', '17654321-9', 'felipe.morales@example.com', '+56945678901');

INSERT INTO teachers (name, lastname, rut, email, phone)
VALUES ('Daniela Andrea', 'Carrasco Silva', '11222333-4', 'daniela.carrasco@example.com', '+56956789012');

INSERT INTO teachers (name, lastname, rut, email, phone)
VALUES ('Sebastián Elías', 'Hernández Díaz', '19456325-1', 'sebastian.hdz@example.com', '+56967890123');

INSERT INTO teachers (name, lastname, rut, email, phone)
VALUES ('Valentina Sofía', 'Fuentes Rivera', '10123456-7', 'valentina.fuentes@example.com', '+56978901234');

INSERT INTO teachers (name, lastname, rut, email, phone)
VALUES ('Rodrigo Esteban', 'Lagos Cifuentes', '15678943-0', 'rodrigo.lagos@example.com', '+56989012345');

INSERT INTO teachers (name, lastname, rut, email, phone)
VALUES ('Francisca Belén', 'Araya Torres', '18234567-8', 'francisca.araya@example.com', '+56990123456');

INSERT INTO teachers (name, lastname, rut, email, phone)
VALUES ('Cristóbal Martín', 'Vega Morales', '16875432-6', 'cristobal.vega@example.com', '+56901234567');

-- Students

INSERT INTO students (name, lastname, rut)
VALUES ('María', 'González', '12.345.678-5');

INSERT INTO students (name, lastname, rut)
VALUES ('Juan', 'Pérez', '15.678.234-K');

INSERT INTO students (name, lastname, rut)
VALUES ('Camila', 'Rojas', '9.876.543-2');

INSERT INTO students (name, lastname, rut)
VALUES ('Francisca', 'Muñoz', '7.654.321-8');

INSERT INTO students (name, lastname, rut)
VALUES ('Matías', 'Soto', '21.345.987-K');

INSERT INTO students (name, lastname, rut)
VALUES ('Diego', 'Ramírez', '18.234.567-3');

INSERT INTO students (name, lastname, rut)
VALUES ('Valentina', 'Castillo', '13.579.246-1');

INSERT INTO students (name, lastname, rut)
VALUES ('Sebastián', 'Molina', '22.468.135-K');

INSERT INTO students (name, lastname, rut)
VALUES ('Ignacia', 'Herrera', '10.456.789-7');

INSERT INTO students (name, lastname, rut)
VALUES ('Tomás', 'Vargas', '8.123.456-K');

-- Subjects

INSERT INTO subjects (name, code, mandatory)
VALUES ('Matematicas', 'MAT-001', true);

INSERT INTO subjects (name, code, mandatory)
VALUES ('Lenguaje', 'LEN-001', true);

INSERT INTO subjects (name, code, mandatory)
VALUES ('Ciencias Naturales', 'CNT-001', true);

INSERT INTO subjects (name, code, mandatory)
VALUES ('Fisica', 'FIS-001', true);

INSERT INTO subjects (name, code, mandatory)
VALUES ('Biologia', 'BIO-001', false);

INSERT INTO subjects (name, code, mandatory)
VALUES ('Ingles', 'ING-001', false);

INSERT INTO subjects (name, code, mandatory)
VALUES ('Gastronomia', 'GTM-001', false);

INSERT INTO subjects (name, code, mandatory)
VALUES ('Educacion Fisica', 'EDF-001', false);

INSERT INTO subjects (name, code, mandatory)
VALUES ('Quimica', 'QMC-001', false);

INSERT INTO subjects (name, code, mandatory)
VALUES ('Logica Computacional', 'LCO-001', false);

-- classes

INSERT INTO classes (course, hall, schedule, teacher_id, subject_id)
VALUES('Programacion orientada a objetos', 'B2', '10AM - 2PM', 1, 10);

-- notes

INSERT INTO notes (value, type, date, observation, student_id, school_class_id)
VALUES (5.3, 'Prueba definiva', '2006-11-7', 'Alumno hace trampa en clases', 1, 1);