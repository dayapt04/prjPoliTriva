package BusinessLogic.Entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * PAJugadorInvitado
 */
public class PAJugadorInvitado {

    public ArrayList<String> paObtenerRespuestas(PAJugadorAnfitrion[] jugadores) {
        ArrayList<String> nombresJugadoresConPuntajes = new ArrayList<>();
        for (PAJugadorAnfitrion jugador : jugadores) {
            nombresJugadoresConPuntajes.add(jugador.getTJnombre() + "," + jugador.getPuntaje());
        }
        Collections.sort(nombresJugadoresConPuntajes, new Comparator<String>() {
            @Override
            public int compare(String jugador1, String jugador2) {
                int puntaje1 = Integer.parseInt(jugador1.split(",")[1]);
                int puntaje2 = Integer.parseInt(jugador2.split(",")[1]);
                return Integer.compare(puntaje2, puntaje1);
            }
        });
        return nombresJugadoresConPuntajes;
    }
}