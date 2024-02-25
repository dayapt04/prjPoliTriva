-- database: ../database/POLITRIVIA.sqlite
INSERT INTO
    CategoriaEstructura (IdCategoriaEstructuraPadre, Nombre)
VALUES
    (NULL, 'CULTURA GENERAL POLITÉCNICA'),
    (NULL, 'POLITÉCNICO BÁSICO'),
    (1, 'Cultura General Estudiantil'),
    (1, 'Cultura General Institucional'),
    (2, 'Álgebra Lineal'),
    (2, 'Cálculo en una Variable'),
    (2, 'Mecánica Newtoniana'),
    (2, 'Comunicación Oral y Escrita'),
    (
        2,
        'Análisis Socieconómico y Político del Ecuador'
    );

INSERT INTO
    Pregunta (IdCategoriaEstructura, Enunciado, Respuesta)
VALUES
    -- CULTURA GENERAL POLITÉCNICA
    (
        4,
        '¿Cuál es el nombre del campus principal de la EPN?',
        'a)Campus Gustavo Galindo Velasco\nb)“José Rubén Orellana Ricaurte'
    ),
    (4, '¿En qué año se fundó la EPN?', '1958'),
    (
        4,
        '¿Quién fue el primer rector de la EPN?',
        'Sixto Durán Ballén'
    ),
    (
        4,
        '¿Cuáles son los valores de la EPN?',
        'Excelencia, innovación, ética, responsabilidad social y equidad.'
    ),
    (
        4,
        '¿Cuál es la misión de la EPN?',
        'Formar profesionales íntegros, con pensamiento crítico y capacidad de liderazgo, para el desarrollo científico, tecnológico y social del Ecuador.'
    ),
    -- POLITÉCNICO BÁSICO - ÁLGEBRA LINEAL
    (
        5,
        '¿Qué es un vector en álgebra lineal?',
        'Un vector es una entidad matemática que tiene magnitud y dirección.'
    ),
    (
        5,
        '¿Cómo se calcula el producto escalar de dos vectores?',
        'El producto escalar de dos vectores se calcula multiplicando sus componentes y sumando los productos.'
    ),
    (
        5,
        '¿Cómo se determina la matriz inversa de una matriz cuadrada?',
        'La matriz inversa de una matriz cuadrada se puede calcular usando el método de Gauss-Jordan o la fórmula de Cramer.'
    ),
    (
        5,
        '¿Cómo se resuelven sistemas de ecuaciones lineales usando matrices?',
        'Los sistemas de ecuaciones lineales se pueden resolver usando el método de eliminación o la regla de Cramer.'
    ),
    (
        5,
        '¿Qué es un espacio vectorial y cuáles son sus propiedades?',
        'Un espacio vectorial es un conjunto de vectores con dos operaciones: suma y multiplicación por un escalar. Las propiedades de un espacio vectorial incluyen la asociativa, la conmutativa y la distributiva.'
    ),
    -- POLITÉCNICO BÁSICO - CÁLCULO EN UNA VARIABLE
    (
        6,
        '¿Qué es el límite de una función?',
        'El límite de una función es el valor al que se aproxima la función cuando la variable independiente se acerca a un punto determinado.'
    ),
    (
        6,
        '¿Cómo se calcula la derivada de una función?',
        'La derivada de una función es la medida de cómo cambia la función con respecto a su variable independiente.'
    ),
    (
        6,
        '¿Cómo se aplica la derivada a la optimización de funciones?',
        'La derivada se puede utilizar para encontrar los puntos máximos y mínimos de una función.'
    ),
    (
        6,
        '¿Cómo se calcula la integral de una función?',
        'La integral de una función es la suma de los valores infinitesimales de la función en un intervalo determinado.'
    ),
    (
        6,
        '¿Cómo se aplica la integral al cálculo de áreas y volúmenes?',
        'La integral se puede utilizar para calcular el área bajo una curva, el volumen de un sólido y otras medidas geométricas.'
    ),
    -- POLITÉCNICO BÁSICO - Mecanica
    (
        7,
        '¿Qué son las leyes de Newton del movimiento?',
        'Las leyes de Newton del movimiento son tres leyes que describen el movimiento de los objetos.'
    ),
    (
        7,
        '¿Cómo se aplica la segunda ley de Newton para resolver problemas de dinámica?',
        'La segunda ley de Newton se puede aplicar para resolver problemas de dinámica, como encontrar la fuerza que actúa sobre un objeto o la aceleración de un objeto.'
    ),
    (
        7,
        '¿Qué es el trabajo y la energía cinética?',
        'El trabajo es la fuerza aplicada a un objeto para moverlo una distancia determinada. La energía cinética es la energía que posee un objeto debido a su movimiento.'
    ),
    (
        7,
        '¿Qué es el momento de una fuerza y el momento angular?',
        'El momento de una fuerza es la tendencia de la fuerza a hacer girar un objeto. El momento angular es la cantidad de movimiento rotacional de un objeto.'
    ),
    (
        7,
        '¿Cómo se aplica la conservación del momento angular a la resolución de problemas?',
        'La conservación del momento angular se puede aplicar para resolver problemas de dinámica, como encontrar la velocidad angular de un objeto o el torque que actúa sobre un objeto.'
    ),
    -- POLITÉCNICO COE
    (
        8,
        '¿Cuáles son las características de un texto escrito formal?',
        'Un texto escrito formal debe tener una estructura clara, un lenguaje preciso y una ortografía y gramática correctas.'
    ),
    (
        8,
        '¿Cómo se estructura un texto escrito formal?',
        'Un texto escrito formal debe tener una introducción, un desarrollo y una conclusión.'
    ),
    (
        8,
        '¿Qué son las normas APA y cómo se utilizan?',
        'Las normas APA son un conjunto de reglas para la presentación de trabajos escritos. Las normas APA se utilizan para citar fuentes de información en un trabajo escrito.'
    ),
    (
        8,
        '¿Qué es la argumentación y cómo se utiliza en la comunicación oral y escrita?',
        'La argumentación es la presentación de razones para defender una idea o punto de vista. La argumentación se utiliza para convencer o persuadir a un interlocutor.'
    ),
    (
        8,
        '¿Cómo se realiza una exposición oral efectiva?',
        'Para realizar una exposición oral efectiva, se debe tener en cuenta el público objetivo, el contenido de la exposición, la organización del discurso y la comunicación no verbal.'
    );

INSERT INTO
    Respuesta (IdPregunta, RespuestaUsuario, Aprobada)
VALUES
    (1, 'a', 0), --Incorrecta
    (1, 'b', 1); --Correcta
