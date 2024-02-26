package BusinessLogic.Entities;

public abstract class Jugador {
    public static int length;
    private String TJnombre;

    public String getTJnombre() {
        return TJnombre;
    }

    public void setTJnombre(String tJnombre) {
        TJnombre = tJnombre;
    }

    private int puntaje;

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void aumentarPuntaje(int Punto){
        this.puntaje += Punto;
    }

    public Jugador(String nombre) {
        this.TJnombre = nombre;
        this.puntaje = 0;
    }
}
