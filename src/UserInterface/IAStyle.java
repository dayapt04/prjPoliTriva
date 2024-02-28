/*
|----------------------------------------|
| ©2024 EPN-FIS, All rights reserved     |       
| KarolSalazar03@git.hub             |
|________________________________________|
-Autor: Karolina Salazar
-Fecha: 25/02/2024
*/
package UserInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
public abstract class IAStyle {
    public static final Color COLOR_FONT = new Color(200, 100, 50); //(218, 8, 40)
    public static final Color COLOR_FONT_LIGHT = new Color(100, 100, 100);
    public static final Color COLOR_CURSOR = Color.black;
    public static final Color COLOR_BORDER = Color.lightGray;

    // Tipos de letra

    public static final Font  FONT         = new Font("JetBrains Mono", Font.PLAIN, 14);
    public static final Font  FONTMAIN         = new Font("Arial", Font.BOLD, 40);
    public static final Font  FONTSUBMAIN        = new Font("Arial", Font.PLAIN, 20);
    public static final Font  FONT_BOLD    = new Font("JetBrains Mono", Font.BOLD | Font.PLAIN, 14);
    public static final Font  FONT_SMALL   = new Font("Arial", Font.BOLD, 18);

    public static final int ALIGNMENT_LEFT  = SwingConstants.LEFT;
    public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT;
    public static final int ALIGNMENT_CENTER= SwingConstants.CENTER;

    public static final Cursor CURSOR_HAND    = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);


    public static final URL URL_LOGO  = IAStyle.class.getResource("/UserInterface/Resource/Img/Pantallas.jpg");
    public static final URL URL_SPLASH= IAStyle.class.getResource("/UserInterface/Resource/Img/Splash.jpg");
    public static final URL URL_INICIO= IAStyle.class.getResource("/UserInterface/Resource/Img/Main.jpg");



    public static final CompoundBorder createBorderRect(){
        return BorderFactory.createCompoundBorder(  new LineBorder(Color.lightGray),
                                                    new EmptyBorder(5, 5, 5, 5));
    }

    public static final void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg, "😏 IABot", JOptionPane.INFORMATION_MESSAGE);
    }
    public static final void showMsgError(String msg){
        JOptionPane.showMessageDialog(null, msg, "💀 IABot", JOptionPane.OK_OPTION);
    }

    public static final boolean showConfirmYesNo(String msg){
        return (JOptionPane.showConfirmDialog(null, msg, "😞 IABot", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
}
