package Framework;

public class PException extends Exception {

    public PException(String e, String clase, String metodo) {
        System.out.println("[ERROR EN POLITRIVIA] " + clase + "." + metodo + " : " + e);
    }

    @Override
    public String getMessage() {
        return "¡ERROR! : POLITRIVIA";
    }
}
