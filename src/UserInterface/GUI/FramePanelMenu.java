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

import UserInterface.IAStyle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FramePanelMenu extends JFrame {
    final private Font mainFont = new Font("Arial", Font.BOLD, 18);

    public void FrameInicio() throws SQLException {
        // Configuración de la ventana
        setTitle("Menu Principal");
        setSize(800, 700);
        setMinimumSize(new Dimension(250, 300));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear panel principal
        JPanel panelPrincipal = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon(IAStyle.URL_INICIO);
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panelPrincipal.setLayout(null); // Establecer layout a null para superponer componentes
        add(panelPrincipal);

        // Mensaje Principal
        JLabel mensaje = new JLabel("BIENVENIDO AL JUEGO POLITRIVIA");
        mensaje.setFont(mainFont);
        mensaje.setHorizontalAlignment(JLabel.CENTER);
        mensaje.setForeground(Color.WHITE);
        panelPrincipal.add(mensaje);
        mensaje.setBounds(150, 0, 500, 200); // Ajusta el valor Y a 0 o cualquier valor negativo que desees

        // Crear botón "Ingresar"
        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(mainFont);
        btnIngresar.setBounds(610, 560, 150, 50);
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Agrega aquí la lógica para ingresar al sistema
                FrameMenu frameMenu = new FrameMenu();
                frameMenu.MainFrame();
            }
        });
        panelPrincipal.add(btnIngresar);

        // Crear botón "Salir"
        JButton btnSalir = new JButton("Salir");
        btnSalir.setFont(mainFont);
        btnSalir.setBounds(20, 560, 150, 50);
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Sale del programa
            }
        });
        panelPrincipal.add(btnSalir);

        // Hacer visible la ventana
        setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FramePanelMenu frame = new FramePanelMenu();
            try {
                frame.FrameInicio();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
