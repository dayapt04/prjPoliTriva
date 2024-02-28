/*
|----------------------------------------|
| ©2024 EPN-FIS, All rights reserved     |       
| Iexvas@git.hub                         |
|----------------------------------------|
-Autor: Alexis Vasco
-Fecha: 27/02/2024
*/

package UserInterface.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMenuIngresar extends JFrame {

    final private Font mainFont = new Font("Arial", Font.BOLD, 18);

    public void MainFrame() {

        FramePanelMenu panelMenu = new FramePanelMenu();
        JLabel mensaje;

        // Mensaje Principal
        mensaje = new JLabel("INGRESE NÚMERO DE JUGADORES");
        mensaje.setFont(mainFont);
        mensaje.setHorizontalAlignment(JLabel.CENTER);

        // Campo de texto para ingresar el número de jugadores
        JTextField txtNumJugadores = new JTextField();
        txtNumJugadores.setFont(mainFont);
        txtNumJugadores.setPreferredSize(new Dimension(150, 50));

        // Boton para ingresar el número de jugadores
        JButton btnIngresarNumJugadores = new JButton("Ingresar");
        btnIngresarNumJugadores.setFont(mainFont);
        btnIngresarNumJugadores.setPreferredSize(new Dimension(150, 50));
        btnIngresarNumJugadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numJugadoresStr = txtNumJugadores.getText();
                int numJugadores;
                try {
                    numJugadores = Integer.parseInt(numJugadoresStr);
                    if (numJugadores > 0 && numJugadores <= 5) {
                        // Abre el formulario para ingresar los nombres de los jugadores
                        abrirFormularioNombres(numJugadores);
                    } else {
                        JOptionPane.showMessageDialog(FrameMenuIngresar.this,
                                "Por favor ingrese un número de jugadores válido (entre 1 y 5).",
                                "Número de jugadores inválido", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(FrameMenuIngresar.this,
                            "Por favor ingrese un número válido para el número de jugadores.",
                            "Número de jugadores inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBotones.setBackground(new Color(28, 163, 234));
        panelBotones.add(txtNumJugadores);
        panelBotones.add(btnIngresarNumJugadores);

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(new Color(28, 163, 234));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(150, 10, 10, 10));
        panelPrincipal.add(mensaje, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Se añade el panel principal a la ventana
        add(panelPrincipal);

        // Datos de la ventana
        setTitle("Menu Ingresar Jugadores");
        setSize(800, 700);
        setMinimumSize(new Dimension(250, 300));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void abrirFormularioNombres(int numJugadores) {
        // Crea el formulario para ingresar los nombres de los jugadores
        JFrame frameNombres = new JFrame("Ingresar Nombres de Jugadores");
        frameNombres.setLayout(new GridLayout(numJugadores + 1, 2, 10, 10)); // 1 fila extra para el botón de confirmar
        frameNombres.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel[] labels = new JLabel[numJugadores];
        JTextField[] textFields = new JTextField[numJugadores];

        for (int i = 0; i < numJugadores; i++) {
            labels[i] = new JLabel("Jugador " + (i + 1) + ":");
            labels[i].setFont(mainFont);
            textFields[i] = new JTextField();
            textFields[i].setFont(mainFont);
            frameNombres.add(labels[i]);
            frameNombres.add(textFields[i]);
        }

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setFont(mainFont);
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder nombres = new StringBuilder();
                for (int i = 0; i < numJugadores; i++) {
                    nombres.append(textFields[i].getText());
                    if (i < numJugadores - 1) {
                        nombres.append(", ");
                    }
                }
                JOptionPane.showMessageDialog(FrameMenuIngresar.this,
                        "Los nombres de los jugadores son: " + nombres.toString(),
                        "Nombres de Jugadores", JOptionPane.INFORMATION_MESSAGE);
                frameNombres.dispose();

                // Después de ingresar los nombres, muestra el menú de juegos
                FrameMenuCultura frameMenuCultura = new FrameMenuCultura();
                frameMenuCultura.MainFrame(numJugadores);
            }
        });

        frameNombres.add(btnConfirmar);
        frameNombres.pack();
        frameNombres.setLocationRelativeTo(null);
        frameNombres.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FrameMenuIngresar frame = new FrameMenuIngresar();
            frame.MainFrame();
        });
    }
}
