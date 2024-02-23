package Framework;

public class PException extends Exception {

    public PException(String e, String clase, String metodo) {
        // grabar el log
        System.out.println("[ERROR EN IABot para el LOG] " + clase + "." + metodo + " : " + e);
    }

    @Override
    public String getMessage() {
        return "no se sapo..";
    }
}
