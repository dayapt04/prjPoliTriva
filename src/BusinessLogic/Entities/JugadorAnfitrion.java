package BusinessLogic.Entities;

import java.util.ArrayList;

public class JugadorAnfitrion extends Jugador{

    
    private int numJugadores;

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    private String Penitencias;

    public String getPenitencias() {
        return Penitencias;
    }

    public void setPenitencias(String penitencias) {
        Penitencias = penitencias;
    }

    public void escogerParametrosJuego() {

    }

    public ArrayList<String> listaPenitencias(int numJugadores, String Penitencias) {
        ArrayList<String> listaPenitemcias = new ArrayList<>();

        return listaPenitemcias;
    }

    public Boolean obtenerRespuestas(int idPregunta){
        


        return true;
    }
}