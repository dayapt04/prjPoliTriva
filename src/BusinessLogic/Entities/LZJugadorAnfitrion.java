package BusinessLogic.Entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LZJugadorAnfitrion extends LZJugador{
    private int numJugadores;
    private String penitencias;

    private static Map<Integer, Boolean> respuestas = new HashMap<>();

    public int getNumJugadores() {
        return numJugadores;
    }
    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }
    public String getPenitencias() {
        return penitencias;
    }
    public void setPenitencias(String penitencias) {
        this.penitencias = penitencias;
    }

    public void escogerParametrosJuego(){

    }

    public static List<String> listaPenitencias(int numJugadores, List<String> penitencias) {
        List<String> listaDePenitencias = new ArrayList<>();

        Collections.shuffle(penitencias);

        for (int i = 1; i < numJugadores; i++) {
            listaDePenitencias.add(penitencias.get(i % penitencias.size()));
        }

        return listaDePenitencias;
    }

    public static boolean obtenerRespuestas(int idJugador, int idPregunta) {
        // Obtener la respuesta del jugador para la pregunta específica del mapa
        Boolean respuesta = respuestas.getOrDefault(idPregunta, false);

        // Devolver la respuesta del jugador para la pregunta específica
        return respuesta != null && respuesta;
    }
}