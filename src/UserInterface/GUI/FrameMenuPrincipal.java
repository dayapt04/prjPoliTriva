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

import UserInterface.IAStyle;

public class FrameMenuPrincipal extends JFrame {

    final private Font mainFont = new Font("Arial", Font.BOLD, 18);
    final private int WINDOW_WIDTH = 800;
    final private int WINDOW_HEIGHT = 700;

    public FrameMenuPrincipal() {
        MainFrame();
    }

    public void MainFrame() {
        // Crear un panel con fondo de imagen para la ventana principal
        JPanel panelPrincipal = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibujar la imagen de fondo
                Image image = new ImageIcon(IAStyle.URL_LOGO).getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        JLabel mensaje = new JLabel("INGRESE NÚMERO DE JUGADORES");
        mensaje.setFont(mainFont);
        mensaje.setHorizontalAlignment(JLabel.CENTER);
        mensaje.setForeground(Color.WHITE);

        // Campo de texto para ingresar el número de jugadores
        JTextField txtNumJugadores = new JTextField();
        txtNumJugadores.setFont(mainFont);
        txtNumJugadores.setForeground(Color.BLACK);

        JButton btnIngresarNumJugadores = new JButton("Ingresar");
        btnIngresarNumJugadores.setFont(mainFont);
        btnIngresarNumJugadores.setPreferredSize(new Dimension(150, 30)); // Modificar tamaño del botón
        btnIngresarNumJugadores.setForeground(Color.BLACK);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panelBotones.setOpaque(false); // Hacer que el panel sea transparente
        txtNumJugadores.setPreferredSize(new Dimension(200, 40));
        gbc.gridx = 0;
        gbc.gridy = 0;
        //Coordenas para el boton nose 
        gbc.insets = new Insets(130, 10, -80, 10);
        panelBotones.add(txtNumJugadores, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1; // Restaurar el valor predeterminado
        panelBotones.add(btnIngresarNumJugadores, gbc);

        // Se añaden los componentes al panel principal
        panelPrincipal.add(mensaje, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Se añade el panel principal a la ventana
        add(panelPrincipal);

        // Asignar evento al botón para abrir la ventana de ingresar nombres de jugadores
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
                        JOptionPane.showMessageDialog(FrameMenuPrincipal.this,
                                "Por favor ingrese un número de jugadores válido (entre 1 y 5).",
                                "Número de jugadores inválido", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(FrameMenuPrincipal.this,
                            "Por favor ingrese un número válido para el número de jugadores.",
                            "Número de jugadores inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Datos de la ventana
        setTitle("Menu Ingresar Jugadores");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void abrirFormularioNombres(int numJugadores) {
        // Crear un panel con fondo de imagen para la ventana de nombres
        JPanel panelPrincipalNombres = new JPanel(new GridLayout(numJugadores + 1, 2, 1, 10)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibujar la imagen de fondo
                Image image = new ImageIcon(IAStyle.URL_LOGO).getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        JLabel[] labels = new JLabel[numJugadores];
        JTextField[] textFields = new JTextField[numJugadores];

        for (int i = 0; i < numJugadores; i++) {
            labels[i] = new JLabel("Jugador " + (i + 1) + ":");
            labels[i].setFont(mainFont);
            labels[i].setForeground(Color.WHITE);
            textFields[i] = new JTextField();
            textFields[i].setFont(mainFont);
            textFields[i].setForeground(Color.BLACK);
            panelPrincipalNombres.add(labels[i]);
            panelPrincipalNombres.add(textFields[i]);

        }

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setFont(mainFont);
        btnConfirmar.setPreferredSize(new Dimension(150, 30)); // Modificar tamaño del botón
        btnConfirmar.setForeground(Color.BLACK);
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean nombresValidos = true; // Variable para verificar si se ingresaron nombres válidos
                StringBuilder nombres = new StringBuilder();
                for (int i = 0; i < numJugadores; i++) {
                    String nombreJugador = textFields[i].getText().trim(); // Obtener el nombre del jugador y eliminar espacios en blanco
                    if (nombreJugador.isEmpty()) { // Si el nombre está vacío
                        nombresValidos = false; // Los nombres no son válidos
                        break; // Salir del bucle
                    }
                    nombres.append(nombreJugador);
                    if (i < numJugadores - 1) {
                        nombres.append(", ");
                    }
                }
                if (!nombresValidos) {
                    JOptionPane.showMessageDialog(FrameMenuPrincipal.this,
                            "Por favor ingrese nombres para todos los jugadores.",
                            "Nombres de Jugadores Vacíos", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(FrameMenuPrincipal.this,
                            "Los nombres de los jugadores son: " + nombres.toString(),
                            "Nombres de Jugadores", JOptionPane.INFORMATION_MESSAGE);
                    // Después de ingresar los nombres, muestra el menú de juegos
                    FrameMenuCultura frameMenuCultura = new FrameMenuCultura();
                    frameMenuCultura.MainFrame(numJugadores);
                    dispose(); // Cerrar la ventana actual después de abrir el siguiente menú
                }
            }
        });

        panelPrincipalNombres.add(btnConfirmar);

        // Crear la ventana de nombres y agregar el panel principal
        JFrame frameNombres = new JFrame("Ingresar Nombres de Jugadores");
        frameNombres.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameNombres.add(panelPrincipalNombres);
        frameNombres.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frameNombres.setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        frameNombres.setLocationRelativeTo(null);
        frameNombres.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FrameMenuPrincipal::new);
    }
}
