package UserInterface.GUI;

import javax.swing.*;
import java.awt.*;
import BusinessLogic.Entities.LZLectorQR; // Importar la clase LZLectorQR

public class FrameMenuRevisarPuntajes extends JFrame {

    public FrameMenuRevisarPuntajes() {
        setTitle("Mostrar Resultados de la Partida");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        // Crear un panel para colocar los componentes
        JPanel panel = new JPanel(new BorderLayout());
        add(panel);

        // Obtener la imagen del código QR
        ImageIcon qrCodeIcon = new ImageIcon("qr_code.png"); // Reemplaza "qr_code.png" con la ruta de tu imagen QR

        // Crear un JLabel para mostrar el código QR
        JLabel qrCodeLabel = new JLabel(qrCodeIcon);
        qrCodeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        qrCodeLabel.setVerticalAlignment(SwingConstants.CENTER);

        // Agregar el JLabel al centro del panel
        panel.add(qrCodeLabel, BorderLayout.CENTER);

        // Si deseas agregar un mensaje, puedes usar un JLabel debajo del código QR
        JLabel messageLabel = new JLabel("Escanea el código QR para ver los resultados", SwingConstants.CENTER);
        panel.add(messageLabel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        // Crear y mostrar el frame de los resultados
        SwingUtilities.invokeLater(() -> {
            FrameMenuRevisarPuntajes frame = new FrameMenuRevisarPuntajes();
            frame.setVisible(true);
        });
    }
}
