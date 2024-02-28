package UserInterface.GUI;

import DataAccess.*;
// import UserInterface.CustomerControl.PatButton;

import javax.swing.*;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PoliTriviaUI {

    static PreguntaDAO pDAO = new PreguntaDAO();
    static RespuestaDAO rDAO = new RespuestaDAO();
    static RespuestaDTO rDTO = new RespuestaDTO();
    static PreguntaDTO pDto = new PreguntaDTO();
    static List<PreguntaDTO> preguntasEstudiantes;
    static List<RespuestaDTO> respuestas;
    static int numeroRespuestaCorrecta;
    static int preguntaActual;
    static List<RespuestaJugador> respuestalista = new ArrayList<>();
    static private int preguntaActualIndex = 0;
    static private int categoriaActual = 0;

    public static void mainFrame() {
        SplashScreenForm.show();
        JFrame frame = new JFrame("PoliTrivia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creando panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel);

        placeComponents(panel);
        // Mostrando la ventana
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Hacer la ventana visible
        // frame.pack();
        frame.setVisible(true);
        // Creando el botón para cerrar la ventana
        // JButton btnCerrar = new JButton("Cerrar");
        // centerPanel.add(btnCerrar);

        // // Lógica para manejar el botón de cerrar
        // btnCerrar.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {
        // frame.dispose(); // Cierra la ventana
        // }
        // });

        // Otra opción es sobreescribir el método defaultCloseOperation del JFrame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    private static void placeComponents(JPanel panel) {
        // Creando etiqueta
        JLabel welcomeLabel = new JLabel("Bienvenido a la PoliTrivia", SwingConstants.CENTER);
        panel.add(welcomeLabel, BorderLayout.NORTH);

        // Creando panel central con BoxLayout
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        panel.add(centerPanel, BorderLayout.CENTER);

        // Creando etiqueta de seleccion
        JLabel selectLabel = new JLabel("Seleccione la Tematica deseada", SwingConstants.CENTER);
        centerPanel.add(selectLabel);

        // Creando JComboBox
        String[] options = { "Cultura General Politecnica", "Politecnico Basico", "Revisar Puntajes de la Partida" };
        JComboBox<String> comboBox1 = new JComboBox<>(options);
        centerPanel.add(comboBox1);

        // Creando etiqueta de seleccion de categoría
        JLabel categoryLabel = new JLabel("Seleccione la categoria que le gustaria jugar", SwingConstants.CENTER);
        centerPanel.add(categoryLabel);

        // Creando segundo JComboBox
        JComboBox<String> comboBox2 = new JComboBox<>();
        centerPanel.add(comboBox2);
        // Creando etiqueta de número de jugadores
        JLabel numPlayersLabel = new JLabel("Numero de jugadores", SwingConstants.CENTER);
        centerPanel.add(numPlayersLabel);

        // Creando JComboBox para el número de jugadores
        Integer[] numPlayers = { 1, 2, 3, 4, 5 };
        JComboBox<Integer> comboBoxPlayers = new JComboBox<>(numPlayers);
        centerPanel.add(comboBoxPlayers);
        // Creando el botón
        JButton button = new JButton("Iniciar Juego");
        centerPanel.add(button);

        // Asociando valores a las opciones
        HashMap<String, Integer> optionValues = new HashMap<>();
        optionValues.put("Cultura General Politecnica", 1);
        optionValues.put("Politecnico Basico", 2);
        optionValues.put("Revisar Puntajes de la Partida", 3);

        // Creando mapas para las opciones del segundo JComboBox
        HashMap<Integer, String[]> option2Values = new HashMap<>();
        option2Values.put(1,
                new String[] { "Cultura General Estudiantil", "Cultura General Institucional" });
        option2Values.put(2, new String[] { "Algebra Lineal", "Calculo en una variable", "Mecanica Newtoniana", "COE",
                "Analisis Socioeconomico" });

        HashMap<String, Integer> option2IDs = new HashMap<>();
        option2IDs.put("Cultura General Estudiantil", 3);
        option2IDs.put("Cultura General Institucional", 4);
        option2IDs.put("Algebra Lineal", 5);
        option2IDs.put("Calculo en una variable", 6);
        option2IDs.put("Mecanica Newtoniana", 7);
        option2IDs.put("COE", 8);
        option2IDs.put("Analisis Socioeconomico", 9);

        JLabel preguntaLabel = new JLabel();
        centerPanel.add(preguntaLabel);
        preguntaLabel.setText("Aquí va la pregunta");

        JTextArea areaRespuestas = new JTextArea();
        centerPanel.add(areaRespuestas);
        areaRespuestas.setEditable(false); // Deshabilita la edición

        // Crear las etiquetas
        JLabel etiquetaRespuesta = new JLabel("Digitar su respuesta:");
        JLabel etiquetaJugador = new JLabel("Jugador:");

        // Crear los campos de entrada
        JTextField campoRespuesta = new JTextField(10);
        JTextField campoJugador = new JTextField(10);
        JTextArea areaResultado = new JTextArea();
        JButton botonEvaluar = new JButton("Evaluar");

        // Crear el botón y el ActionListener
        JButton boton = new JButton("Guardar respuesta");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Guarda la respuesta y el nombre del jugador en variables
                int respuesta = Integer.parseInt(campoRespuesta.getText());
                int jugador = Integer.parseInt(campoJugador.getText());
                int numeroPregunta = preguntaActual;// Aquí deberías obtener el número de la pregunta
                int codigoRespuestaCorrecta = numeroRespuestaCorrecta;// Aquí deberías obtener el código de la respuesta
                                                                      // correcta

                // Crea una nueva RespuestaJugador y la añade a la lista
                RespuestaJugador respuestaJugador = new RespuestaJugador(respuesta, numeroPregunta, jugador,
                        codigoRespuestaCorrecta);
                respuestalista.add(respuestaJugador);
            }
        });

        // Agregando ActionListener al primer JComboBox
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedValue = optionValues.get(comboBox1.getSelectedItem().toString());
                comboBox2.removeAllItems();
                if (option2Values.containsKey(selectedValue)) {
                    for (String option : option2Values.get(selectedValue)) {
                        comboBox2.addItem(option);
                    }
                }
            }
        });

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox2.getSelectedItem();
                if (option2IDs.containsKey(selectedOption)) {
                    categoriaActual = option2IDs.get(selectedOption);
                    preguntaActualIndex = 0;
                }

            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verificando si la categoría es 1
                // if (optionValues.get(comboBox1.getSelectedItem().toString()) == 1) {
                // Tu código aquí
                try {
                    preguntasEstudiantes = pDAO.readById(categoriaActual);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                if (!preguntasEstudiantes.isEmpty() && preguntaActualIndex < preguntasEstudiantes.size()) {
                    // Obtiene la pregunta actual y establece el texto del JLabel
                    PreguntaDTO pregunta = preguntasEstudiantes.get(preguntaActualIndex);
                    preguntaLabel.setText(pregunta.getEnunciado());
                    preguntaActual = pregunta.getIdPregunta();
                    try {
                        respuestas = rDAO.readById(pregunta.getIdPregunta());
                    } catch (Exception ex1) {
                        ex1.printStackTrace();
                    }

                    String textoRespuestas = "";
                    RespuestaDTO rDTO;
                    numeroRespuestaCorrecta = -1;
                    for (int j = 0; j < respuestas.size(); j++) {
                        rDTO = respuestas.get(j);
                        textoRespuestas += rDTO.getIdRespuesta() + ": " + rDTO.getRespuestaUsuario() + "\n";
                        if (rDTO.getAprobada().equals(1)) {
                            numeroRespuestaCorrecta = rDTO.getIdRespuesta();
                        }
                    }
                    areaRespuestas.setText(textoRespuestas);

                    // Incrementa el índice de la pregunta actual
                    preguntaActualIndex++;
                } else {
                    // Si no hay preguntas, muestra un mensaje de error
                    preguntaLabel.setText("No hay preguntas disponibles");
                }
                // Añadir los componentes al panel
                centerPanel.add(etiquetaRespuesta);
                centerPanel.add(campoRespuesta);
                centerPanel.add(etiquetaJugador);
                centerPanel.add(campoJugador);
                centerPanel.add(boton);
                centerPanel.add(areaResultado);
                centerPanel.add(botonEvaluar);

            }
        });

        // Solo permitir dígitos en el campo de respuesta
        campoRespuesta.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignora cualquier carácter que no sea un dígito
                }
            }
        });
        botonEvaluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpiar el área de resultado antes de agregar nuevos resultados
                areaResultado.setText("");

                for (RespuestaJugador respuestaJugador : respuestalista) {
                    // Verifica si la respuesta es correcta
                    if (respuestaJugador.getRespuesta() == respuestaJugador.getCodigoRespuestaCorrecta()) {
                        // Añade el resultado al área de resultado
                        areaResultado.append("Pregunta: " + respuestaJugador.getNumeroPregunta()
                                + ", Jugador: " + respuestaJugador.getJugador()
                                + ", Resultado: Correcto\n");
                    } else {
                        // Añade el resultado al área de resultado
                        areaResultado.append("Pregunta: " + respuestaJugador.getNumeroPregunta()
                                + ", Jugador: " + respuestaJugador.getJugador()
                                + ", Resultado: Incorrecto\n");
                    }
                }
            }
        });

    }

    // // Agregar botones para navegar entre las preguntas
    // PatButton btnAnt = new PatButton(" << ");
    // PatButton btnSig = new PatButton(" >> ");
    // centerPanel.add(btnSig);
    // centerPanel.add(btnAnt);
    // // Lógica para manejar el botón de siguiente pregunta
    // btnSig.addActionListener(new ActionListener() {

    // public void actionPerformed(ActionEvent e) {
    // if (currentQuestionIndex < questions.length - 1) {
    // currentQuestionIndex++;
    // centerPanel.removeAll();
    // centerPanel.add(new JLabel(questions[currentQuestionIndex]));
    // centerPanel.add(btnAnt);
    // centerPanel.add(btnSig);
    // centerPanel.revalidate();
    // centerPanel.repaint();
    // }
    // }
    // });

    // Lógica para manejar el botón de pregunta anterior
    // btnAnt.addActionListener(new ActionListener() {
    // public void actionPerformed(ActionEvent e) {
    // if (currentQuestionIndex > 0) {
    // currentQuestionIndex--;
    // centerPanel.removeAll();
    // centerPanel.add(new JLabel(questions[currentQuestionIndex]));
    // centerPanel.add(btnAnt);
    // centerPanel.add(btnSig);
    // centerPanel.revalidate();
    // centerPanel.repaint();
    // }
    // }
    // });
    // Lógica para manejar el botón de siguiente pregunta

    // Agregar botones para navegar entre las preguntas
    // JButton btnAnt = new JButton("Anterior");
    // JButton btnSig = new JButton("Siguiente");
    // centerPanel.add(btnAnt);
    // centerPanel.add(btnSig);

    // // Lógica para manejar el botón de siguiente pregunta
    // btnSig.addActionListener(new ActionListener() {

    // public void actionPerformed(ActionEvent e) {
    // if (preguntaActualIndex < preguntasEstudiantes.size() - 1) {
    // preguntaActualIndex++;
    // mostrarPreguntaActual();
    // }
    // }
    // });

    // // Lógica para manejar el botón de pregunta anterior
    // btnAnt.addActionListener(new ActionListener() {
    // public void actionPerformed(ActionEvent e) {
    // if (preguntaActualIndex > 0) {
    // preguntaActualIndex--;
    // mostrarPreguntaActual();
    // }
    // }
    // });

    // // Método para mostrar la pregunta actual
    // private void mostrarPreguntaActual() {
    // JPanel panel = new JPanel();
    // panel.setLayout(new BorderLayout());
    // Container frame;
    // frame.add(panel);
    // JPanel centerPanel = new JPanel();
    // String textoRespuestas = "";
    // JTextArea areaRespuestas = new JTextArea();
    // centerPanel.add(areaRespuestas);
    // areaRespuestas.setEditable(false); // Deshabilita la edición

    // for (RespuestaDTO respuesta : respuestas) {
    // textoRespuestas += respuesta.getIdRespuesta() + ": " +
    // respuesta.getRespuestaUsuario() + "\n";
    // }
    // areaRespuestas.setText(textoRespuestas);

    // JLabel preguntaLabel = new JLabel();
    // centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
    // panel.add(centerPanel, BorderLayout.CENTER);
    // if (!preguntasEstudiantes.isEmpty() && preguntaActualIndex <
    // preguntasEstudiantes.size()) {
    // PreguntaDTO pregunta = preguntasEstudiantes.get(preguntaActualIndex);
    // centerPanel.add(preguntaLabel);
    // preguntaLabel.setText(pregunta.getEnunciado());
    // preguntaActual = pregunta.getIdPregunta();

    // try {
    // respuestas = rDAO.readById(pregunta.getIdPregunta());
    // } catch (Exception ex1) {
    // ex1.printStackTrace();
    // }

    // RespuestaDTO rDTO;
    // numeroRespuestaCorrecta = -1;
    // for (int j = 0; j < respuestas.size(); j++) {
    // rDTO = respuestas.get(j);
    // textoRespuestas += rDTO.getIdRespuesta() + ": " + rDTO.getRespuestaUsuario()
    // + "\n";
    // if (rDTO.getAprobada().equals(1)) {
    // numeroRespuestaCorrecta = rDTO.getIdRespuesta();
    // }
    // }
    // areaRespuestas.setText(textoRespuestas);
    // } else {
    // // Si no hay preguntas, muestra un mensaje de error
    // preguntaLabel.setText("No hay preguntas disponibles");
    // }
    // }

}
