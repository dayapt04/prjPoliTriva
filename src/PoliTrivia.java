import java.util.ArrayList;
import java.util.List;
import BusinessLogic.Entities.LZJugador;
public class PoliTrivia {
    public void iniciarJuego() {
        // Suponiendo que tienes una lista de jugadores
        List<LZJugador> jugadores = obtenerJugadores();

        // Iniciar el temporizador para cada jugador
        for (LZJugador jugador : jugadores) {
            Thread temporizador = new Thread(new Temporizador(jugador));
            temporizador.start();
        }
    }

    // Método para obtener la lista de jugadores
    private List<LZJugador> obtenerJugadores() {
        // Supongamos que aquí obtienes una lista de jugadores
        // Puedes implementar este método según tu estructura de datos para los jugadores
        return new ArrayList<>(); // Solo un ejemplo; debes retornar tu lista de jugadores
    }

    private class Temporizador implements Runnable {
        private LZJugador jugador;

        public Temporizador(LZJugador jugador) {
            this.jugador = jugador;
        }

        @Override
        public void run() {
            // Definir el tiempo límite para cada turno (en segundos)
            int tiempoLimite = 60; // Por ejemplo, 60 segundos

            // Contador para el temporizador
            int contador = tiempoLimite;

            // Simular el temporizador para el turno del jugador
            while (contador > 0) {
                System.out.println("Turno del jugador " + jugador.getNombre() + ": Tiempo restante - " + contador + " segundos");
                try {
                    Thread.sleep(1000); // Esperar 1 segundo (1000 milisegundos)
                    contador--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // El tiempo se ha agotado para el turno del jugador
            System.out.println("¡Tiempo agotado para el turno del jugador " + jugador.getNombre() + "!");
        }
    }
}
