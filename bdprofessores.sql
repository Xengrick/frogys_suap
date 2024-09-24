CREATE DATABASE IF NOT EXISTS examen;
USE examen;

-- Tabla Profesor
CREATE TABLE Profesor (
    idProfesor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    RFC VARCHAR(13) NOT NULL,
    CONSTRAINT rfc_length CHECK (CHAR_LENGTH(RFC) = 13),
    CONSTRAINT rfc_unique UNIQUE (RFC) /*RFC no se repitirá */
);

-- Tabla UnidadAprendizaje
CREATE TABLE UnidadAprendizaje (
    idUnidadAprendizaje INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    horasClase INT NOT NULL,
    horasTaller INT NOT NULL,
    horasLaboratorio INT NOT NULL
);

-- Tabla Asignacion
CREATE TABLE Asignacion (
    idAsignacion INT AUTO_INCREMENT PRIMARY KEY,
    idProfesor INT NOT NULL,
    idUnidadAprendizaje INT NOT NULL,
    FOREIGN KEY (idProfesor) REFERENCES Profesor(idProfesor) ON DELETE CASCADE,
    FOREIGN KEY (idUnidadAprendizaje) REFERENCES UnidadAprendizaje(idUnidadAprendizaje) ON DELETE CASCADE
);

-- Tabla Usuario  
CREATE TABLE Usuario (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    rol VARCHAR(20) NOT NULL CHECK (rol IN ('ADMIN', 'PROFESOR'))
);

ALTER TABLE Usuario
CHANGE COLUMN username nombreUsuario VARCHAR(50) NOT NULL,
CHANGE COLUMN password clave VARCHAR(100) NOT NULL;

