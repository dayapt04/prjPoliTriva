-- database: ../database/POLITRIVIA.sqlite
-- DROP TABLE IF EXISTS Politrivia;
-- CREATE TABLE Politrivia (
--      IdPreguntaEstructura         INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
--     ,IdPreguntaEstructuraPadre    INTEGER     REFERENCES  LocalidaEstructura (IdLocalidaEstructura)
--     ,Categoria                    VARCHAR(10) NOT NULL 
--     ,Estado                       VARCHAR(1)  NOT NULL DEFAULT('A')
--     ,FechaCrea                    DATETIME    DEFAULT(datetime('now','localtime'))
--     ,FechaModifica                DATETIME
-- ); 
-- database: PREGUNTAS_RESPUESTAS.sqlite
-- Base de datos: ../database/PREGUNTAS_RESPUESTAS.sqlite
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
DROP TABLE IF EXISTS CategoriaPregunta;

CREATE TABLE
    CategoriaPregunta (
        IdCategoriaPregunta INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
        Nombre VARCHAR(50) NOT NULL,
        Descripcion VARCHAR(255) DEFAULT NULL,
        Estado VARCHAR(1) NOT NULL DEFAULT ('A'),
        FechaCrea DATETIME DEFAULT (datetime('now', 'localtime')),
        FechaModifica DATETIME
    );

-- Tabla de preguntas
DROP TABLE IF EXISTS Pregunta;

CREATE TABLE
    Pregunta (
        IdPregunta INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
        IdCategoriaPregunta INTEGER NOT NULL REFERENCES CategoriaPregunta (IdCategoriaPregunta),
        Pregunta TEXT NOT NULL,
        Respuesta TEXT NOT NULL,
        --   NivelDificultad INTEGER NOT NULL DEFAULT(1),
        Estado VARCHAR(1) NOT NULL DEFAULT ('A'),
        FechaCrea DATETIME DEFAULT (datetime('now', 'localtime')),
        FechaModifica DATETIME
    );

-- Tabla de etiquetas de preguntas
DROP TABLE IF EXISTS EtiquetaPregunta;

CREATE TABLE
    EtiquetaPregunta (
        IdEtiquetaPregunta INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
        Nombre VARCHAR(50) NOT NULL,
        Descripcion VARCHAR(255) DEFAULT NULL,
        Estado VARCHAR(1) NOT NULL DEFAULT ('A'),
        FechaCrea DATETIME DEFAULT (datetime('now', 'localtime')),
        FechaModifica DATETIME
    );

-- Tabla de relaciones entre preguntas y etiquetas
DROP TABLE IF EXISTS PreguntaEtiqueta;

CREATE TABLE
    PreguntaEtiqueta (
        IdPregunta INTEGER NOT NULL REFERENCES Pregunta (IdPregunta),
        IdEtiquetaPregunta INTEGER NOT NULL REFERENCES EtiquetaPregunta (IdEtiquetaPregunta),
        Estado VARCHAR(1) NOT NULL DEFAULT ('A'),
        FechaCrea DATETIME DEFAULT (datetime('now', 'localtime')),
        FechaModifica DATETIME
    );
