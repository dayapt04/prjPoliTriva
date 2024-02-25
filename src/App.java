import DataAccess.PreguntaDAO;

public class App {
    public static void main(String[] args) throws Exception {

        PreguntaDAO pDAO = new PreguntaDAO();
        System.out.println(pDAO.readAll().toString());
    }
}
