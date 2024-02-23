package UserInterface.Form;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
    
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginPanel() {
        initializeComponents();
        setupLayout();
        setupActions();
    }

    private void initializeComponents() {
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
    }

    private void setupLayout() {
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Username:"));
        add(usernameField);

        add(new JLabel("Password:"));
        add(passwordField);

        // Panel vacío para ajustar el diseño
        add(new JPanel());

        add(loginButton);
    }

    private void setupActions() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica de autenticación
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                // Aquí puedes realizar la lógica de autenticación, por ejemplo, comparar con credenciales almacenadas.
                // En un escenario real, deberías tener una lógica más segura para manejar contraseñas.

                // Ejemplo básico: mostrar un mensaje
                JOptionPane.showMessageDialog(LoginPanel.this, "Usuario: " + username + "\nContraseña: " + new String(password), "Login Exitoso", JOptionPane.INFORMATION_MESSAGE);

                // Limpia los campos después del login
                usernameField.setText("");
                passwordField.setText("");
            }
        });
    }
}
