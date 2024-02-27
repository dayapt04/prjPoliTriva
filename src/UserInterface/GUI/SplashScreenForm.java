/*
|----------------------------------------|
| ©2024 EPN-FIS, All rights reserved     |       
| Iexvas@git.hub                         |
|----------------------------------------|
-Autor: Alexis Vasco
-Fecha: 27/02/2024
*/
package UserInterface.GUI;
import java.awt.BorderLayout;
import java.awt.Color; // Importa la clase Color
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import UserInterface.IAStyle;

public abstract class SplashScreenForm {
    private static JFrame       frmSplash;
    private static JProgressBar prbLoaging;
    private static ImageIcon    icoImagen ;
    private static JLabel       lblSplash ;

    public static void show() {
        icoImagen  = new ImageIcon(IAStyle.URL_SPLASH);
        lblSplash  = new JLabel(icoImagen);
        
        prbLoaging = new JProgressBar(0, 100);
        prbLoaging.setStringPainted(true);
        prbLoaging.setForeground(Color.BLACK); // Establece el color del texto del porcentaje
        
        frmSplash = new JFrame("Splash Screen");
        frmSplash.setUndecorated(true);
        frmSplash.getContentPane().add(lblSplash, BorderLayout.CENTER);
        frmSplash.add(prbLoaging, BorderLayout.SOUTH);
        frmSplash.setSize(icoImagen.getIconWidth(), icoImagen.getIconHeight());
        frmSplash.setLocationRelativeTo(null); 
        frmSplash.setVisible(true);
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(50); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prbLoaging.setValue(i);
        }
        frmSplash.setVisible(false);
    }
}
