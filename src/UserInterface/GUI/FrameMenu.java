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
import java.awt.event.*;
import java.sql.SQLException;
import UserInterface.IAStyle;

public class FrameMenu extends JFrame {

    final private Font mainFont = new Font("Arial", Font.BOLD, 18);

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FrameMenu().MainFrame();
            }
        });
    }

    public void MainFrame() {
        FramePanelMenu panelMenu = new FramePanelMenu();
        JLabel mensaje; // Mensaje Principal

        mensaje = new JLabel("EMPEZAR JUEGO");
        mensaje.setFont(mainFont);
        mensaje.setHorizontalAlignment(JLabel.CENTER);
        mensaje.setForeground(Color.WHITE);

        // Crear un panel con fondo de imagen
        JPanel panelPrincipal = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibujar la imagen de fondo
                Image image = new ImageIcon(IAStyle.URL_LOGO).getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        //Boton para Volver
        JButton btnVolver = new JButton("Atras");
        btnVolver.setFont(mainFont);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    panelMenu.FrameInicio();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        //Boton para Ingresar
        JButton btnIngresar = new JButton("<html><center>Ingresa Numero<br>De Jugadores</center></html>");
        btnIngresar.setFont(mainFont);
        // Ajustar la anchura y la altura del botón para que se pueda leer completamente el texto
        btnIngresar.setPreferredSize(new Dimension(200, 50));

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMenuPrincipal frameMenuIngresar = new FrameMenuPrincipal();
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            new FrameMenuPrincipal().MainFrame();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                });
            }
        });

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setOpaque(false); // Hacer que el panel sea transparente
        panelBotones.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(100, 4, -90, 10);

        // Se añaden los componentes al panel principal
        panelPrincipal.add(mensaje, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Se añade el panel principal a la ventana
        add(panelPrincipal);

        // Ajusta el primer valor según sea necesario
        Dimension btnSize = new Dimension(200, 50);
        btnVolver.setPreferredSize(btnSize);
        btnIngresar.setPreferredSize(btnSize);

        panelBotones.add(btnIngresar, gbc);
        gbc.gridy = 1;
        panelBotones.add(btnVolver, gbc);

        // Panel de mensaje
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(mensaje, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Se añade el panel
        add(panelPrincipal);

        // Datos de Ventana
        setTitle("Menu Principal");
        setSize(800, 700);
        setMinimumSize(new Dimension(20, 100));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
