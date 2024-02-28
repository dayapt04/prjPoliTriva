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

public class FrameMenuPolitecnicoBasico extends JFrame {

    final private Font mainFont = new Font("Arial", Font.BOLD, 18);

    public void mostrarPreguntas(boolean esPolitecnicoBasico) {

        
        // Mensaje Principal
        JLabel mensaje = new JLabel("Seleccione una opción:");
        mensaje.setFont(mainFont);
        mensaje.setHorizontalAlignment(JLabel.CENTER);
        mensaje.setForeground(Color.WHITE);

        // Botones de las preguntas
        JButton[] botonesPreguntas;
        if (esPolitecnicoBasico) {
            botonesPreguntas = new JButton[5];
            botonesPreguntas[0] = new JButton("ÁLGEBRA LINEAL");
            botonesPreguntas[1] = new JButton("CÁLCULO EN UNA VARIABLE");
            botonesPreguntas[2] = new JButton("MECÁNICA NEWTONIANA");
            botonesPreguntas[3] = new JButton("COMUNICACIÓN ORAL Y ESCRITA");
            botonesPreguntas[4] = new JButton("ANÁLISIS SOCIOECONÓMICO Y POLÍTICO DEL ECUADOR");
        } else {
            botonesPreguntas = new JButton[2];
            botonesPreguntas[0] = new JButton("CULTURA GENERAL ESTUDIANTIL");
            botonesPreguntas[1] = new JButton("CULTURA GENERAL INSTITUCIONAL");
        }

        for (JButton boton : botonesPreguntas) {
            boton.setFont(mainFont);
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(FrameMenuPolitecnicoBasico.this,
                            "Aquí iría la lógica para la pregunta correspondiente",
                            "Pregunta seleccionada", JOptionPane.INFORMATION_MESSAGE);
                    // Agrega aquí la lógica para cada pregunta
                }
            });
        }

        // Botón de Volver Atrás
        JButton btnVolver = new JButton("Atras");
        btnVolver.setFont(mainFont);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual
                FrameMenuCultura frameMenuCultura = new FrameMenuCultura();
                frameMenuCultura.MainFrame(0); // Vuelve al menú principal (puedes ajustar el argumento según tus necesidades)
            }
        });

        // Panel de botones de preguntas
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(botonesPreguntas.length, 1, 10, 10));
        panelBotones.setBackground(new  Color(8, 48, 107));
        for (JButton boton : botonesPreguntas) {
            panelBotones.add(boton);
        }

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(new  Color(8, 48, 107));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panelPrincipal.add(mensaje, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);
        panelPrincipal.add(btnVolver, BorderLayout.SOUTH); // Agregar el botón de volver atrás

        // Se añade el panel principal a la ventana
        add(panelPrincipal);

        // Datos de la ventana
        setTitle("Menú de Preguntas");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FrameMenuPolitecnicoBasico frame = new FrameMenuPolitecnicoBasico();
            // Suponiendo que el usuario eligió Politécnico Básico
            frame.mostrarPreguntas(true);
            // Si elige Cultura General Politécnica, usa: frame.mostrarPreguntas(false);
        });
    }
}
