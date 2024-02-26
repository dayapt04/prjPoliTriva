package BusinessLogic.Entities;

import java.util.HashMap;
import java.util.Map;

public class LZJugadorInvitado extends LZJugador{
    private static Map<Integer, Boolean> respuestas = new HashMap<>();
    
    public static boolean obtenerRespuestas(int idJugador, int idPregunta) {
        Boolean respuesta = respuestas.getOrDefault(idPregunta, false);

        return respuesta != null && respuesta;
    }
}