// import java.util.List;
// import java.util.Scanner;

// import BusinessLogic.Entities.Jugador;
// import BusinessLogic.Entities.JugadorAnfitrion;
// import DataAccess.PreguntaDAO;
// import DataAccess.RespuestaDAO;
// import DataAccess.RespuestaDTO;
// import DataAccess.PreguntaDTO;

import java.sql.SQLException;

import UserInterface.GUI.FramePanelMenu;

public class App {
    // private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        // PoliTrivia poliTrivia = new PoliTrivia();
        // poliTrivia.mainPolitrivia();
        FramePanelMenu panelMenu = new FramePanelMenu();
         javax.swing.SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 try {
                     new FramePanelMenu().FrameInicio();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             }
         });
    }

        // String data =
        // "https://epnecuador-my.sharepoint.com/:u:/g/personal/liam_zuniga_epn_edu_ec/EW-BygwtvO1Gjs9z07YvKTsB48faMDLI3GAxkYjIfnCI-g?e=qSeTWj";
        // // Cambia
        // // esto
        // // por
        // // el
        // // enlace
        // // que
        // // desees
        // // codificar
        // String filePath = "qr_code.png";
        // LZCodigoQR.generateQR(data, filePath);
        // LZLectorQR.mostrarImagenQR(filePath);
    }

