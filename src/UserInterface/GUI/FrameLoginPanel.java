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
import java.awt.event.*;

public class FrameLoginPanel extends JPanel {

    private JButton btnIngresar, btnSalir;

    public FrameLoginPanel() {
        initializeComponents();
    }

    private void initializeComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Botón para Ingresar
        btnIngresar = new JButton("Ingresar");
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMenu frameMenu = new FrameMenu();
                frameMenu.setVisible(true); // Mostrar la instancia de FrameMenu
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnIngresar, gbc);
        

        // Botón para Salir
        btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí iría el código para salir de la aplicación
                System.exit(0);
            }
        });
        gbc.gridy = 1;
        add(btnSalir, gbc);
    }
}
