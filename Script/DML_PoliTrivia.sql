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
    (2,'Análisis Socieconómico y Político del Ecuador');

INSERT INTO
    Pregunta (IdCategoriaEstructura, Enunciado)
VALUES
    -- CULTURA GENERAL POLITÉCNICA
    (3,'¿Cuáles son los nombres de 3 poliperros?'),
    (3, 'Si un poliperro te ladra, tú…'),
    (3, '¿Cuál  es la mejor facultad de la universidad?'),
    (3, '¿Por qué a los estudiantes de mecánica se les conoce como guayperos ?'),
    (3, 'Segunda es . . .');
INSERT INTO
    Respuesta (IdPregunta, RespuestaUsuario, Aprobada)
VALUES
    (1, 'Max, Asiri, Suco.', 1), --Incorrecta
    (1, 'Bruna, Franzua, Scott.', 0), --Correcta
    (1, 'Flaquito, Pocha, Gordo.', 0),

    (2, 'Pasas todas las materias del semestre.', 0), --Incorrecta
    (2, 'Encuentras el amor de tu vida.', 0), --Correcta
    (2, 'Te vas a supletorios.', 1),

    (3, 'Sistemas.', 1), --Incorrecta
    (3, 'Tú sabes la opción correcta.', 0), --Correcta
    (3, '¿Por qué quieres otra respuesta?', 0),

    (4, 'Porque les gustan las franelas.', 0), --Incorrecta
    (4, 'Se le relaciona a los mecánicos con el uso de franelas.', 1), --Correcta
    (4, 'No tengo idea.', 0),

    (5, 'Todo.', 1), --Incorrecta
    (5, 'de prueba, tercera es todo.', 0), --Correcta
    (5, 'para reforzar los conocimientos.', 0);

INSERT INTO
    Pregunta (IdCategoriaEstructura, Enunciado)
VALUES
    -- CULTURA GENERAL POLITÉCNICA
    (4,'¿Cuál es el nombre del campus principal de la EPN?'),
    (4, '¿En qué año se fundó la EPN?'),
    (4, '¿Quién fue el primer rector de la EPN?'),
    (4, '¿Cuáles son los valores de la EPN?'),
    (4, '¿Cuál es la misión de la EPN?');
INSERT INTO
    Respuesta (IdPregunta, RespuestaUsuario, Aprobada)
VALUES
    (6, 'Gustavo Galindo Velasco.', 0), --Incorrecta
    (6, 'José Rubén Orellana Ricaurte.', 1), --Correcta
    (6, 'Oxford.', 0),

    (7, '2023', 0), --Incorrecta
    (7, '1869', 1), --Correcta
    (7, '1563', 0),

    (8, 'Juan Jose Flores.', 0), --Incorrecta
    (8, 'Atahualpa.', 0), --Correcta
    (8, 'Juan Bautista.', 1),

    (9, 'Excelencia, innovación, ética.', 0), --Incorrecta
    (9, 'Responsabilidad social y equidad.', 0), --Correcta
    (9, 'Todos los anteriores.', 1),

    (10, 'Formar profesionales íntegros, con pensamiento crítico y capacidad de liderazgo, para el desarrollo científico, tecnológico y social del Ecuador.', 0), --Incorrecta
    (10, 'Formar individuos librepensadores, innovadores, creativos, emprendedores en el marco de las Artes Liberales y bajo sus principios fundacionales.', 0), --Correcta
    (10, 'Formar académicos, profesionales e investigadores de excelencia, creativos, humanistas, con capacidad de liderazgo, pensamiento crítico y alta conciencia ciudadana.', 1);




-- POLITÉCNICO BÁSICO - ÁLGEBRA LINEAL
INSERT INTO
    Pregunta (IdCategoriaEstructura, Enunciado)
VALUES
    (5, '¿Qué es un vector en álgebra lineal?'),
    (5,'¿Cómo se calcula el producto escalar de dos vectores?'),
    (5,'¿Cómo se determina la matriz inversa de una matriz cuadrada?'),
    (5,'¿Cómo se resuelven sistemas de ecuaciones lineales usando matrices?'),
    (5,'¿Qué es un espacio vectorial y cuáles son sus propiedades?');

INSERT INTO
    Respuesta (IdPregunta, RespuestaUsuario, Aprobada)
VALUES
    (11, 'Un vector es una entidad matemática que tiene magnitud y dirección.', 1), --Incorrecta
    (11, 'Un vector es una entidad química que tiene propiedades varias.', 0), --Correcta
    (11, 'Un vector es una representación gráfica de la rapidez con la que un objeto se desplaza.', 0),

    (12, 'El producto escalar es una operación matemática que divide dos vectores para obtener un tercer vector.', 0), --Correcta
    (12, 'El producto escalar de dos vectores se calcula multiplicando sus componentes y sumando los productos.', 1), --Incorrecta
    (12, 'El producto escalar es una técnica que se utiliza para multiplicar las componentes de dos vectores y otro que apunta en una dirección diferente.', 0),

    (13, 'La matriz inversa de una matriz cuadrada se puede calcular usando el método de Gauss-Jordan o la fórmula de Cramer.', 1), --Incorrecta
    (13, 'La matriz inversa de una matriz cuadrada se obtiene dividiendo cada elemento de la matriz original por la determinante de la matriz.', 0), --Correcta
    (13, 'Para obtener la matriz inversa, se intercambian las filas y las columnas de la matriz original y luego se multiplican todos los elementos por el inverso de la determinante.', 0),

    (14, 'Para resolver un sistema de ecuaciones lineales con matrices, simplemente se suman las matrices de coeficientes y las matrices de términos constantes.', 0), --Incorrecta
    (14, 'La solución de un sistema de ecuaciones lineales se obtiene multiplicando el vector de incógnitas por la inversa de la matriz de coeficientes.', 0), --Correcta
    (14, 'Los sistemas de ecuaciones lineales se pueden resolver usando el método de eliminación o la regla de Cramer.', 1),

    (15, 'Un espacio vectorial es un conjunto de vectores con dos operaciones: suma y multiplicación por un escalar. Las propiedades de un espacio vectorial incluyen la asociativa, la conmutativa y la distributiva.', 1), --Incorrecta
    (15, 'Un espacio vectorial es un conjunto de vectores que pueden sumarse entre sí y multiplicarse por un escalar, siempre y cuando la multiplicación por un escalar sea mayor que cero.', 0), --Correcta
    (15, 'Un espacio vectorial es un conjunto de vectores en el que la suma de dos vectores y la multiplicación por un escalar son operaciones conmutativas.', 0);


    -- POLITÉCNICO BÁSICO - CÁLCULO EN UNA VARIABLE
INSERT INTO
    Pregunta (IdCategoriaEstructura, Enunciado)
VALUES
    (6,'¿Qué es el límite de una función?'),
    (6,'¿Cómo se calcula la derivada de una función?'),
    (6,'¿Cómo se aplica la derivada a la optimización de funciones?'),
    (6,'¿Cómo se calcula la integral de una función?'),
    (6,'¿Cómo se aplica la integral al cálculo de áreas y volúmenes?');

INSERT INTO
    Respuesta (IdPregunta, RespuestaUsuario, Aprobada)
VALUES
    (16, 'El límite de una función es el valor al que se aproxima la función cuando la variable independiente se acerca a un punto determinado.', 1), --Incorrecta
    (16, 'El límite de una función es el valor que la función se acerca a medida que la variable independiente se aleja indefinidamente, pero nunca alcanza.', 0), --Correcta
    (16, 'El límite de una función es el valor que la función toma en un punto específico, independientemente de cómo se acerque la variable independiente a ese punto.', 0),

    (17, 'La derivada de una función es la medida de cómo cambia la función con respecto a su variable independiente.', 1), --Incorrecta
    (17, 'La derivada de una función se encuentra tomando la diferencia entre el valor de la función en un punto y el valor en el punto vecino.', 0), --Correcta
    (17, 'La derivada de una función se obtiene multiplicando el exponente de cada término en la expresión de la función por el coeficiente correspondiente y restando 1 al exponente.', 0),

    (18, 'La optimización de una función se realiza encontrando los puntos en los que la derivada es máxima o mínima, y luego tomando esos valores como los máximos o mínimos de la función original.', 0), --Incorrecta
    (18, 'Para optimizar una función, simplemente encuentre el valor crítico de la función, que es donde la derivada es igual a cero, y luego evalúe la función en ese punto para encontrar el máximo o mínimo.', 0), --Correcta
    (18, 'La derivada se puede utilizar para encontrar los puntos máximos y mínimos de una función.', 1),

    (19, 'La integral de una función se obtiene sumando los valores de la función en varios puntos y dividiendo por el número de puntos seleccionados.', 0), --Incorrecta
    (19, 'La integral de una función es la suma de los valores infinitesimales de la función en un intervalo determinado.', 1), --Correcta
    (19, 'Para calcular la integral de una función, se multiplican los valores de la función por sus respectivas variables independientes y luego se suman todos los términos.', 0),

    (20, 'El cálculo del área bajo una curva se realiza dividiendo la función en segmentos pequeños, calculando el área de cada segmento y sumándolas todas. Esto se logra aplicando la integral a la función original.', 0), --Incorrecta
    (20, 'La integral se puede utilizar para calcular el área bajo una curva, el volumen de un sólido y otras medidas geométricas.', 1), --Correcta
    (20, 'Para hallar el volumen de un sólido de revolución, se toma la función que define el perfil del sólido, se eleva al cuadrado y se integra con respecto a la variable independiente.', 0);
    -- POLITÉCNICO BÁSICO - Mecanica
INSERT INTO
    Pregunta (IdCategoriaEstructura, Enunciado)
VALUES
    (7,'¿Qué son las leyes de Newton del movimiento?'),
    (7,'¿Cómo se aplica la segunda ley de Newton para resolver problemas de dinámica?'),
    (7,'¿Qué es el trabajo y la energía cinética?'),
    (7,'¿Qué es el momento de una fuerza y el momento angular?'),
    (7,'¿Cómo se aplica la conservación del momento angular a la resolución de problemas?');

INSERT INTO
    Respuesta (IdPregunta, RespuestaUsuario, Aprobada)
VALUES
    (21, 'Las leyes de Newton son reglas que indican que todo movimiento en el universo está controlado por fuerzas invisibles que solo afectan a los objetos si quieren.', 0), --Incorrecta
    (21, 'Las leyes de Newton del movimiento son tres leyes que describen el movimiento de los objetos.', 1), --Correcta
    (21, 'Según las leyes de Newton, la velocidad de un objeto siempre cambiará en la dirección opuesta a la fuerza aplicada, independientemente de su masa o entorno.', 0),

    (22, 'La segunda ley de Newton se puede aplicar para resolver problemas de dinámica, como encontrar la fuerza que actúa sobre un objeto o la aceleración de un objeto.', 1), --Incorrecta
    (22, 'Para aplicar la segunda ley de Newton en problemas de dinámica, simplemente multiplicamos la masa del objeto por la aceleración que queremos que tenga y obtenemos la fuerza necesaria para lograr eso.', 0), --Correcta
    (22, 'En problemas de dinámica, la segunda ley de Newton se usa calculando la aceleración del objeto y dividiéndola por su masa para encontrar la fuerza requerida.', 0),

    (23, 'El trabajo es la fuerza aplicada a través de una distancia, y la energía cinética es la energía almacenada en un objeto cuando está en reposo.', 0), --Incorrecta
    (23, 'El trabajo es la cantidad de esfuerzo mental que una persona realiza al mover un objeto, y la energía cinética es la sensación de cansancio que experimenta después', 0), --Correcta
    (23, 'El trabajo es la fuerza aplicada a un objeto para moverlo una distancia determinada. La energía cinética es la energía que posee un objeto debido a su movimiento.', 1),
    
    (24, 'El momento de una fuerza es la tendencia de la fuerza a hacer girar un objeto. El momento angular es la cantidad de movimiento rotacional de un objeto.', 1), --Incorrecta
    (24, 'El momento de una fuerza es la rapidez con la que un objeto rota, y el momento angular es la fuerza que genera ese movimiento circular.', 0), --Correcta
    (24, 'El momento de una fuerza se refiere a la cantidad de energía asociada con la aplicación de una fuerza, y el momento angular es la medida de cuánto se desvía un objeto de su posición original.', 0),

    (25, 'Para aplicar la conservación del momento angular, simplemente multiplicamos la masa de un objeto por su velocidad angular inicial y final.', 0), --Incorrecta
    (25, 'La conservación del momento angular se aplica calculando la cantidad total de movimiento angular en un sistema y asegurándose de que permanezca igual antes y después de cualquier interacción.', 0), --Correcta
    (25, 'La conservación del momento angular se puede aplicar para resolver problemas de dinámica, como encontrar la velocidad angular de un objeto o el torque que actúa sobre un objeto.', 1);
    
    -- POLITÉCNICO COE
INSERT INTO
    Pregunta (IdCategoriaEstructura, Enunciado)
VALUES
    (8,'¿Cuáles son las características de un texto escrito formal?'),
    (8,'¿Cómo se estructura un texto escrito formal?'),
    (8,'¿Qué son las normas APA y cómo se utilizan?'),
    (8,'¿Qué es la argumentación y cómo se utiliza en la comunicación oral y escrita?'),
    (8,'¿Cómo se realiza una exposición oral efectiva?');

INSERT INTO
    Respuesta (IdPregunta, RespuestaUsuario, Aprobada)
VALUES
    (26, 'Un texto escrito formal debe tener una estructura clara, un lenguaje preciso y una ortografía y gramática correctas.', 1), --Incorrecta
    (26, 'Un texto formal se caracteriza por el uso exagerado de vocabulario complicado y estructuras de oraciones extremadamente complejas para impresionar al lector.', 0), --Correcta
    (26, 'Un texto escrito formal es aquel que se adhiere estrictamente a las reglas gramaticales, sin permitir el uso de metáforas, analogías u otras formas creativas de expresión.', 0),

    (27, 'La estructura de un texto formal se basa en la aleatoriedad de ideas, permitiendo la inclusión de información irrelevante para mantener la formalidad.', 0), --Incorrecta
    (27, 'Un texto escrito formal sigue una estructura caótica, con párrafos que no están relacionados entre sí y sin una introducción o conclusión clara.', 0), --Correcta
    (27, 'Un texto escrito formal debe tener una introducción, un desarrollo y una conclusión.', 1),

    (28, 'Las normas APA son un conjunto de reglas para la presentación de trabajos escritos. Las normas APA se utilizan para citar fuentes de información en un trabajo escrito.', 1), --Incorrecta
    (28, 'Las normas APA son un conjunto de reglas que prohíben el uso de citas y referencias en trabajos académicos, promoviendo la originalidad absoluta en el contenido.', 0), --Correcta
    (28, 'Utilizar las normas APA significa incluir información personal irrelevante sobre el autor en lugar de referencias bibliográficas.', 0),

    (29, 'La argumentación es el arte de confundir al oyente o lector mediante el uso de información contradictoria y emocional, sin importar la coherencia del mensaje.', 0), --Incorrecta
    (29, 'La argumentación es la presentación de razones para defender una idea o punto de vista. La argumentación se utiliza para convencer o persuadir a un interlocutor.', 1), --Correcta
    (29, 'En la comunicación, la argumentación consiste en presentar opiniones personales sin respaldo lógico, confiando en la persuasión emocional en lugar de evidencia o razonamiento.', 0),

    (30, 'Una exposición oral efectiva se logra hablando continuamente sin tener en cuenta el tiempo asignado, ya que cuanto más largo sea el discurso, más impactante será.', 0), --Incorrecta
    (30, 'Para una exposición oral efectiva, es crucial incluir tantos datos y detalles como sea posible, incluso si no están directamente relacionados con el tema principal, para demostrar conocimiento exhaustivo.', 0), --Correcta
    (30, 'Para realizar una exposición oral efectiva, se debe tener en cuenta el público objetivo, el contenido de la exposición, la organización del discurso y la comunicación no verbal.', 1);

INSERT INTO
    Pregunta (IdCategoriaEstructura, Enunciado)
VALUES
    (9,'¿Cuál de los siguientes factores ha tenido un impacto significativo en el análisis político y socioeconómico del Ecuador en las últimas décadas?'),
    (9,'En términos de desigualdad económica, ¿cuál de las siguientes afirmaciones describe mejor la situación en el Ecuador?'),
    (9,'¿Cuál es un desafío importante que enfrenta el Ecuador en términos de desarrollo sostenible?'),
    (9,'¿Cuál es un aspecto clave en el análisis político del Ecuador en relación con su sistema de gobierno?'),
    (9,'En relación con la política exterior del Ecuador, ¿cuál de las siguientes opciones describe mejor su enfoque reciente?');
INSERT INTO
    Respuesta (IdPregunta, RespuestaUsuario, Aprobada)
VALUES
    (31, 'La bonanza petrolera.', 1), --Incorrecta
    (31, 'La influencia extranjera.', 0), --Correcta
    (31, 'La estabilidad geológica.', 0),

    (32, 'Ha experimentado una disminución constante en la desigualdad.', 0), --Incorrecta
    (32, 'La desigualdad ha aumentado, especialmente en las zonas urbanas.', 1), --Correcta
    (32, 'La desigualdad es prácticamente inexistente.', 0),

    (33, 'La falta de recursos naturales.', 0), --Incorrecta
    (33, 'La gestión adecuada de los recursos hídricos.', 1), --Correcta
    (33, 'La inexistencia de reservas naturales.', 0),

    (34, 'Un sistema monárquico.', 0), --Incorrecta
    (34, 'Un sistema presidencialista.', 1), --Correcta
    (34, 'Un sistema feudal.', 0),

    (35, 'Una orientación hacia el aislamiento internacional.', 0), --Incorrecta
    (35, 'Una política de apertura hacia la cooperación regional y global.', 1), --Correcta
    (35, 'Una política de confrontación constante con países vecinos.', 0);

