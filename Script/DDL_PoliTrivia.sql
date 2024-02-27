-- database: ../database/POLITRIVIA.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| pat_mic@hotmail.com           pat_mic  |
|----------------------------------------|
Autor : Karolina Salazar
Fecha : 24.feb.2k24
Script: Creacion de la tabla preguntas + datos
*/
-- Tabla de categorías de preguntas
DROP TABLE IF EXISTS CategoriaEstructura;

CREATE TABLE
    CategoriaEstructura (
        IdCategoriaEstructura INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
        IdCategoriaEstructuraPadre INTEGER REFERENCES CategoriaEstructura (IdCategoriaEstructura),
        Nombre VARCHAR(50) NOT NULL,
        Descripcion VARCHAR(255) DEFAULT NULL,
        Estado VARCHAR(1) NOT NULL DEFAULT ('A'),
        FechaCrea DATETIME DEFAULT (datetime('now', 'localtime')),
        FechaModifica DATETIME
    );

DROP TABLE IF EXISTS Pregunta;

CREATE TABLE
    Pregunta (
        IdPregunta INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
        IdCategoriaEstructura INTEGER NOT NULL REFERENCES CategoriaEstructura (IdCategoriaEstructura),
        Enunciado TEXT NOT NULL,
        Estado VARCHAR(1) NOT NULL DEFAULT ('A'),
        FechaCrea DATETIME DEFAULT (datetime('now', 'localtime')),
        FechaModifica DATETIME
    );

-- Tabla de etiquetas de preguntas
DROP TABLE IF EXISTS Respuesta;

CREATE TABLE
    Respuesta (
        IdRespuesta INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
        IdPregunta INTEGER NOT NULL REFERENCES Pregunta (IdPregunta),
        RespuestaUsuario TEXT NOT NULL,
        Aprobada BOOLEAN DEFAULT 0,
        FechaCrea DATETIME DEFAULT (datetime('now', 'localtime')),
        FechaModifica DATETIME
    );

SELECT
    *
FROM
    CategoriaEstructura
WHERE
    Estado = "A";

SELECT
    *
FROM
    Pregunta
WHERE
    Estado = "A";

SELECT
    *
FROM
    Respuesta
WHERE
    IdPregunta = 3;

SELECT
    p.IdPregunta PreguntaId,
    p.Enunciado Pregunta,
    cp.Nombre Categoria
FROM
    Pregunta p
    JOIN CategoriaEstructura cp ON p.IdPregunta = cp.IdCategoriaEstructura
WHERE
    p.Estado = "A"
    AND cp.Estado = "A";
