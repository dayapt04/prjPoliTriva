package BusinessLogic.Entities;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;
public class LZLectorQR {
    public static void mostrarImagenQR(String fileName) {
        ImageIcon icon = new ImageIcon(fileName);
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JFrame frame = new JFrame();
        JLabel label = new JLabel();
        label.setIcon(scaledIcon);
        frame.getContentPane().add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
