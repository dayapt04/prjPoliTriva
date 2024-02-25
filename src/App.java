import java.util.Scanner;

import DataAccess.PreguntaDAO;

public class App {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        PreguntaDAO pDAO = new PreguntaDAO();
        // System.out.println(pDAO.readAll().toString());
        for (int i = 1; i <= 25; i++) {
            System.out.println(pDAO.readBy(i).toString());
            sc.nextLine();
        }
    }
}
