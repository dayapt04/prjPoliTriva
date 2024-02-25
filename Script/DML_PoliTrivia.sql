-- database: ../database/POLITRIVIA.sqlite
-- Insertar datos de prueba
INSERT INTO
    CategoriaPregunta (Nombre, Descripcion)
VALUES
    (
        'Ciencia',
        'Preguntas relacionadas con temas científicos'
    ),
    (
        'Matemáticas',
        'Preguntas relacionadas con conceptos matemáticos'
    ),
    (
        'Historia',
        'Preguntas sobre eventos y personajes históricos'
    ),
    (
        'Literatura',
        'Preguntas sobre obras literarias y autores'
    ),
    (
        'Arte y Cultura',
        'Preguntas sobre diferentes expresiones artísticas y culturales'
    );

INSERT INTO
    Pregunta (
        IdCategoriaPregunta,
        Pregunta,
        Respuesta
        -- NivelDificultad
    )
VALUES
    (1, '¿Cuál es la capital de Francia?', 'París'),
    (2, '¿Cuál es la fórmula química del agua?', 'H2O'),
    (
        3,
        '¿Quién fue el primer presidente de Ecuador?',
        'Juan José Flores'
    ),
    (
        4,
        '¿Cuál es la obra más famosa de Miguel de Cervantes?',
        'Don Quijote de la Mancha'
    ),
    (
        5,
        '¿Qué es el cubismo?',
        'Un movimiento artístico de vanguardia que surgió a principios del siglo XX'
    );

INSERT INTO
    EtiquetaPregunta (Nombre, Descripcion)
VALUES
    (
        'Geografía',
        'Preguntas relacionadas con lugares y países'
    ),
    (
        'Química',
        'Preguntas relacionadas con conceptos y reacciones químicas'
    ),
    (
        'Política',
        'Preguntas sobre sistemas políticos y líderes mundiales'
    ),
    (
        'Literatura española',
        'Preguntas sobre obras y autores de la literatura española'
    ),
    (
        'Arte Moderno',
        'Preguntas sobre movimientos artísticos del siglo XX'
    );

INSERT INTO
    PreguntaEtiqueta (IdPregunta, IdEtiquetaPregunta)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);

-- Consultas de ejemplo
-- Seleccionar todas las categorías de preguntas
SELECT
    *
FROM
    CategoriaPregunta;

-- Seleccionar todas las preguntas de la categoría "Ciencia"
SELECT
    *
FROM
    Pregunta
WHERE
    IdCategoriaPregunta = 1;

-- Seleccionar la pregunta con ID 3
SELECT
    *
FROM
    Pregunta
WHERE
    IdPregunta = 3;

-- Seleccionar todas las etiquetas de la pregunta con ID 4
SELECT
    e.Nombre
FROM
    EtiquetaPregunta e
    INNER JOIN PreguntaEtiqueta pe ON e.IdEtiquetaPregunta = pe.IdEtiquetaPregunta
WHERE
    pe.IdPregunta = 2;

-- Buscar preguntas que contengan la palabra "Ecuador" en la pregunta o en alguna de sus etiquetas
SELECT
    p.Pregunta,
    e.Nombre AS Etiqueta
FROM
    Pregunta p
    INNER JOIN PreguntaEtiqueta pe ON p.IdPregunta = pe.IdPregunta
    INNER JOIN EtiquetaPregunta e ON pe.IdEtiquetaPregunta = e.IdEtiquetaPregunta
WHERE
    (p.Pregunta LIKE '%Ecuador%')
    OR (e.Nombre LIKE '%Ecuador%');

-- Obtener las preguntas con sus categorías y etiquetas
SELECT
    p.Pregunta,
    c.Nombre AS Categoria,
    GROUP_CONCAT(e.Nombre) AS Etiquetas
FROM
    Pregunta p
    INNER JOIN CategoriaPregunta c ON p.IdCategoriaPregunta = c.IdCategoriaPregunta
    INNER JOIN PreguntaEtiqueta pe ON p.IdPregunta = pe.IdPregunta
    INNER JOIN EtiquetaPregunta e ON pe.IdEtiquetaPregunta = e.IdEtiquetaPregunta
GROUP BY
    p.IdPregunta;
