INSERT INTO examen.profesor (nombre, apellido, RFC) VALUES
('Carlos', 'Hernández', 'HEGC850923XYZ'),
('María', 'García', 'GACM920614ABC'),
('Pedro', 'López', 'LOPE891213DEF'),
('Laura', 'Martínez', 'MALJ800801GHI'),
('Juan', 'Pérez', 'PEJJ750504JKL');


INSERT INTO examen.unidadaprendizaje (nombre, horasClase, horasTaller, horasLaboratorio) VALUES
('Cálculo Integral', 2, 3, 0),
('Contabilidad', 3, 2, 0),
('Desarollo Humano', 1, 3, 0),
('Taller Linux', 0, 4, 0),
('Introducción a la Programación', 2, 1, 2);


INSERT INTO examen.asignacion (idProfesor, idUnidadAprendizaje) VALUES
(1,1),
(1,2),
(1,3),
(1,4),
(1,5);


