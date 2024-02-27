import java.util.Scanner;

import BusinessLogic.Entities.LZCodigoQR;
import BusinessLogic.Entities.LZLectorQR;
// import DataAccess.PreguntaDAO;

public class App {
    // private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        // PreguntaDAO pDAO = new PreguntaDAO();
        // // System.out.println(pDAO.readAll().toString());
        // for (int i = 1; i <= 25; i++) {
        // System.out.println(pDAO.readBy(i).toString());
        // sc.nextLine();
        // }

        String data = "https://epnecuador-my.sharepoint.com/:u:/g/personal/liam_zuniga_epn_edu_ec/EW-BygwtvO1Gjs9z07YvKTsB48faMDLI3GAxkYjIfnCI-g?e=qSeTWj"; // Cambia
                                                                                                                                                            // esto
                                                                                                                                                            // por
                                                                                                                                                            // el
                                                                                                                                                            // enlace
                                                                                                                                                            // que
                                                                                                                                                            // desees
                                                                                                                                                            // codificar
        String filePath = "qr_code.png";
        LZCodigoQR.generateQR(data, filePath);
        LZLectorQR.mostrarImagenQR(filePath);
    }
}
