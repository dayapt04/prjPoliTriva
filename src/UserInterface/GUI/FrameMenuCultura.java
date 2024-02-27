/*
|----------------------------------------|
| ©2024 EPN-FIS, All rights reserved     |       
| KarolSalazar03@git.hub                 |
|________________________________________|
-Autor: Karolina Salazar
-Fecha: 25/02/2024
*/
package UserInterface.GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMenuCultura extends JFrame {

    final private Font mainFont = new Font("Arial", Font.BOLD, 18);

    public void MainFrame(int numJugadores) {

        // Mensaje Principal
        JLabel mensaje = new JLabel("Seleccione una opción:");
        mensaje.setFont(mainFont);
        mensaje.setHorizontalAlignment(JLabel.CENTER);
        mensaje.setForeground(Color.WHITE);

        // Botón para Cultura General Politécnica
        JButton btnCulturaGeneral = new JButton("CULTURA GENERAL POLITÉCNICA");
        btnCulturaGeneral.setFont(mainFont);
        btnCulturaGeneral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual
                mostrarPreguntas(true); // Muestra el menú de preguntas para Cultura General
            }
        });

        // Botón para Politécnico Básico
        JButton btnPolitecnicoBasico = new JButton("POLITÉCNICO BÁSICO");
        btnPolitecnicoBasico.setFont(mainFont);
        btnPolitecnicoBasico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual
                FrameMenuPolitecnicoBasico frameMenuPolitecnicoBasico = new FrameMenuPolitecnicoBasico();
                frameMenuPolitecnicoBasico.mostrarPreguntas(true); // Muestra el menú de preguntas para Politécnico Básico
            }
        });

        // Botón para Atrás
        JButton btnAtras = new JButton("ATRÁS");
        btnAtras.setFont(mainFont);
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra esta ventana
                FrameMenuPrincipal frameMenuPrincipal = new FrameMenuPrincipal();
                frameMenuPrincipal.MainFrame(); // Vuelve al menú de Principal
            }
        });

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(3, 1, 10, 10));
        panelBotones.setBackground(new Color(8, 48, 107));
        panelBotones.add(btnCulturaGeneral);
        panelBotones.add(btnPolitecnicoBasico);
        panelBotones.add(btnAtras);

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(new Color(8, 48, 107));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panelPrincipal.add(mensaje, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Se añade el panel principal a la ventana
        add(panelPrincipal);

        // Datos de la ventana
        setTitle("Menú de Juegos");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void mostrarPreguntas(boolean esCulturaGeneral) {
        FrameMenuCultura frameMenuCultura = new FrameMenuCultura();
        frameMenuCultura.setTitle("Menú de Preguntas"); // Establece el título de la ventana
        frameMenuCultura.setSize(600, 400); // Establece el tamaño de la ventana
        frameMenuCultura.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Define la operación de cierre
        frameMenuCultura.setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Botones de las preguntas
        JButton[] botonesPreguntas;
        if (esCulturaGeneral) {
            botonesPreguntas = new JButton[3]; // Aumentamos el tamaño del arreglo para incluir el botón adicional
            botonesPreguntas[0] = new JButton("CULTURA GENERAL ESTUDIANTIL");
            botonesPreguntas[1] = new JButton("CULTURA GENERAL INSTITUCIONAL");
            botonesPreguntas[2] = new JButton("Atras"); // Agregamos el botón de "Regresar Atrás"
        } else {
            botonesPreguntas = new JButton[6]; // Aumentamos el tamaño del arreglo para incluir el botón adicional
            botonesPreguntas[0] = new JButton("ÁLGEBRA LINEAL");
            botonesPreguntas[1] = new JButton("CÁLCULO EN UNA VARIABLE");
            botonesPreguntas[2] = new JButton("MECÁNICA NEWTONIANA");
            botonesPreguntas[3] = new JButton("COMUNICACIÓN ORAL Y ESCRITA");
            botonesPreguntas[4] = new JButton("ANÁLISIS SOCIOECONÓMICO Y POLÍTICO DEL ECUADOR");
            botonesPreguntas[5] = new JButton("Atras"); // Agregamos el botón de "Regresar Atrás"
        }

        // Panel de botones de preguntas
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(botonesPreguntas.length, 1, 10, 10));
        panelBotones.setBackground(new Color(8, 48, 107));
        for (JButton boton : botonesPreguntas) {
            panelBotones.add(boton);
        }

        // Asignar evento al botón de "Regresar Atrás"
        botonesPreguntas[botonesPreguntas.length - 1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual
                FrameMenuCultura frameMenuCultura = new FrameMenuCultura();
                frameMenuCultura.MainFrame(0); // Vuelve al menú de juegos
            }
        });

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(new Color(8, 48, 107));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Se añade el panel principal a la ventana
        frameMenuCultura.add(panelPrincipal);

        // Hace visible la ventana
        frameMenuCultura.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FrameMenuCultura frame = new FrameMenuCultura();
            frame.MainFrame(0);
        });
    }
}
