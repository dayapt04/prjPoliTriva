/*
|----------------------------------------|
| ©2024 EPN-FIS, All rights reserved     |       
| Iexvas@git.hub                         |
|----------------------------------------|
-Autor: Alexis Vasco
-Fecha: 29/02/2024
*/
package UserInterface.GUI;

import DataAccess.*;
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

    public static void VAmainFrame() {
        SplashScreenForm.show();
        JFrame frame = new JFrame("PoliTrivia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel);

        VSplaceComponents(panel);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    private static void VAcreateAndShowGUI() {
        JFrame frame = new JFrame("PoliTrivia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(173, 216, 230));

        VSplaceComponents(panel);

        frame.getContentPane().add(panel);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void VSplaceComponents(JPanel panel) {
        JLabel welcomeLabel = new JLabel("¡BIENVENIDO A LA POLITRIVIA!", SwingConstants.CENTER);
        panel.add(welcomeLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JLabel selectLabel = new JLabel("           Seleccione la Temática deseada", SwingConstants.LEFT);
        centerPanel.add(selectLabel);

        String[] options = { "Cultura General Politécnica", "Politécnico Básico" };
        JComboBox<String> comboBox1 = new JComboBox<>(options);
        centerPanel.add(comboBox1);

        JLabel categoryLabel = new JLabel("   Seleccione la categoría que le gustaría jugar", SwingConstants.CENTER);
        centerPanel.add(categoryLabel);

        JComboBox<String> comboBox2 = new JComboBox<>();
        centerPanel.add(comboBox2);
        JLabel numPlayersLabel = new JLabel("  \t                  Número de jugadores", SwingConstants.CENTER);
        centerPanel.add(numPlayersLabel);

        Integer[] numPlayers = { 1, 2, 3, 4, 5 };
        JComboBox<Integer> comboBoxPlayers = new JComboBox<>(numPlayers);
        centerPanel.add(comboBoxPlayers);
        JButton button = new JButton("                          Iniciar Juego                         ");
        centerPanel.add(button);

        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        selectLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        categoryLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        numPlayersLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setFont(new Font("Arial", Font.BOLD, 16));
        comboBox1.setFont(new Font("Arial", Font.PLAIN, 16));
        comboBox2.setFont(new Font("Arial", Font.PLAIN, 16));
        comboBoxPlayers.setFont(new Font("Arial", Font.PLAIN, 16));

        welcomeLabel.setForeground(new Color(34, 139, 34));
        selectLabel.setForeground(Color.BLACK);
        categoryLabel.setForeground(Color.BLACK);
        numPlayersLabel.setForeground(Color.BLACK);

        button.setBackground(new Color(34, 139, 34));
        button.setForeground(Color.WHITE);

        HashMap<String, Integer> optionValues = new HashMap<>();
        optionValues.put("Cultura General Politécnica", 1);
        optionValues.put("Politécnico Básico", 2);

        HashMap<Integer, String[]> option2Values = new HashMap<>();
        option2Values.put(1, new String[] { "Cultura General Estudiantil", "Cultura General Institucional" });
        option2Values.put(2, new String[] { "Álgebra Lineal", "Cálculo en una variable", "Mecánica Newtoniana", "COE",
                "Analisis Socioeconómico" });

        HashMap<String, Integer> option2IDs = new HashMap<>();
        option2IDs.put("Cultura General Estudiantil", 3);
        option2IDs.put("Cultura General Institucional", 4);
        option2IDs.put("Álgebra Lineal", 5);
        option2IDs.put("Cálculo en una variable", 6);
        option2IDs.put("Mecánica Newtoniana", 7);
        option2IDs.put("COE", 8);
        option2IDs.put("Analisis Socioeconómico", 9);

        JLabel preguntaLabel = new JLabel();
        centerPanel.add(preguntaLabel);
        preguntaLabel.setText("                                              Aquí va la pregunta");

        JTextArea areaRespuestas = new JTextArea();
        centerPanel.add(areaRespuestas);
        areaRespuestas.setEditable(false);

        JLabel etiquetaRespuesta = new JLabel("Digitar su respuesta:");
        JLabel etiquetaJugador = new JLabel("JUGADOR:");

        JTextField campoRespuesta = new JTextField(10);
        JTextField campoJugador = new JTextField(10);
        JTextArea areaResultado = new JTextArea();
        JButton botonEvaluar = new JButton("    EVALUAR     ");
        botonEvaluar.setBackground(button.getBackground());
        botonEvaluar.setForeground(button.getForeground());
        botonEvaluar.setFont(new Font("Arial", Font.BOLD, 16));

        // Crear el botón y el ActionListener
        JButton boton = new JButton("Guardar respuesta");
        boton.setBackground(button.getBackground());
        boton.setForeground(button.getForeground());
        boton.setFont(new Font("Arial", Font.BOLD, 16));
      
        JButton qrButton = new JButton("Mostrar Puntajes");
        centerPanel.add(qrButton, BorderLayout.NORTH);

        // Agregar ActionListener al botón QR
        qrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear y mostrar el JFrame que contiene el código QR
                FrameMenuRevisarPuntajes frameQR = new FrameMenuRevisarPuntajes();
                frameQR.setVisible(true);
                frameQR.setLocationRelativeTo(null);
            }
        });

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (campoRespuesta.getText().isEmpty() || campoJugador.getText().isEmpty()) {
                    return;
                }

                int respuesta;
                String jugador;
                try {
                    respuesta = Integer.parseInt(campoRespuesta.getText());
                    jugador = campoJugador.getText();
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    return;
                }
                int numeroPregunta = preguntaActual;// Aquí deberías obtener el número de la pregunta
                int codigoRespuestaCorrecta = numeroRespuestaCorrecta;// Aquí deberías obtener el código de la respuesta
                                                                      // correcta

                // Crea una nueva RespuestaJugador y la añade a la lista
                RespuestaJugador respuestaJugador = new RespuestaJugador(respuesta, numeroPregunta, jugador,
                        codigoRespuestaCorrecta);
                respuestalista.add(respuestaJugador);
            }
        });

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

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox1.getSelectedItem().equals("REVISAR RESULTADOS")) {
                    FrameMenuRevisarPuntajes frameQR = new FrameMenuRevisarPuntajes();
                    frameQR.setVisible(true);
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

                    preguntaActualIndex++;
                } else {
                    preguntaLabel.setText("No hay preguntas disponibles");
                }
                centerPanel.add(etiquetaRespuesta);
                centerPanel.add(campoRespuesta);
                centerPanel.add(etiquetaJugador);
                centerPanel.add(campoJugador);
                centerPanel.add(boton);
                centerPanel.add(areaResultado);
                centerPanel.add(botonEvaluar);

            }
        });

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

}
