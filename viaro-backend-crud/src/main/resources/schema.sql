CREATE TABLE IF NOT EXISTS Genero(
  IdGenero VARCHAR(1) PRIMARY KEY,
  Descripcion VARCHAR2(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS Alumno(
    IdAlumno INT AUTO_INCREMENT PRIMARY KEY,
    PrimerNombre VARCHAR(50) NOT NULL,
    SegundoNombre VARCHAR(50),
    TercerNombre VARCHAR(50),
    PrimerApellido VARCHAR(50) NOT NULL,
    SegundoApellido VARCHAR(50),
    IdGobernacion VARCHAR(50) UNIQUE,
    IdGenero VARCHAR(1)  NOT NULL ,
    FechaNacimiento DATE NOT NULL,
    FOREIGN KEY (IdGenero) REFERENCES Genero(IdGenero)
);

CREATE TABLE IF NOT EXISTS Profesor(
    IdProfesor INT AUTO_INCREMENT PRIMARY KEY,
    PrimerNombre VARCHAR(50) NOT NULL,
    SegundoNombre VARCHAR(50),
    TercerNombre VARCHAR(50),
    PrimerApellido VARCHAR(50) NOT NULL,
    SegundoApellido VARCHAR(50),
    IdGenero VARCHAR(1) NOT NULL,
    FechaNacimiento DATE NOT NULL,
    FOREIGN KEY (IdGenero) REFERENCES Genero(IdGenero)
);

CREATE TABLE IF NOT EXISTS Grado(
    IdGrado INT AUTO_INCREMENT PRIMARY KEY,
    NombreGrado VARCHAR(50) NOT NULL,
    IdProfesor INT,
    FOREIGN KEY (IdProfesor) REFERENCES Profesor(IdProfesor)
);

CREATE TABLE IF NOT EXISTS Seccion(
    IdGrado INT,
    IdSeccion VARCHAR(1),
    Active VARCHAR(1) NOT NULL,
    PRIMARY KEY (IdGrado, IdSeccion),
    FOREIGN KEY (IdGrado) REFERENCES Grado(IdGrado)
);

CREATE TABLE IF NOT EXISTS AlumnoGrado(
    AlumnoId INT,
    IdGrado INT,
    IdSeccion INT,
    PRIMARY KEY (AlumnoId, IdGrado, IdSeccion)
);