package BusinessLogic.Entities;

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
// import java.util.InputMismatchException;
import java.util.Scanner;

public class PAJugadorAnfitrion extends TJJugador {
    private Scanner sc = new Scanner(System.in);
    private int paNumJugadores;

    public PAJugadorAnfitrion(String nombre) {
        super(nombre);
    }

    public int getPANumJugadores() {
        return paNumJugadores;
    }

    public void setPANumJugadores(int paNumJugadores) {

        if (paNumJugadores <= 1 || paNumJugadores > 5) {
            System.out.println("ERROR. El número de jugadores en MODO MULTIJUGADOR tiene que ser entre 2 y 5");
        } else
            this.paNumJugadores = paNumJugadores;
    }

    // public PAJugadorAnfitrion[] paEscogerParametrosJuego() {
    // PAJugadorAnfitrion[] Jugador;
    // int cantidadJugadores;
    // int bucle = 0;
    // do {
    // try {
    // System.out.println("\nMODO DE JUEGO: \n");
    // System.out.println("1. INDIVIDUAL \n2. MULTIJUGADOR");
    // int opcionModo = sc.nextInt();
    // switch (opcionModo) {
    // case 1: {
    // Jugador = new PAJugadorAnfitrion[1];
    // Jugador[0] = new PAJugadorAnfitrion("Solitario");
    // bucle = 1;
    // break;
    // }
    // case 2: {
    // do {
    // System.out.print("Ingrese el número de jugadores: ");
    // cantidadJugadores = sc.nextInt();
    // setPANumJugadores(cantidadJugadores);
    // sc.nextLine();
    // Jugador = new PAJugadorAnfitrion[cantidadJugadores];
    // // if (cantidadJugadores != 0) {
    // // continue;
    // // }
    // } while (getPANumJugadores() == 0);
    // for (int i = 0; i < cantidadJugadores; i++) {
    // System.out.print("Ingrese el nombre del Jugador " + (i + 1) + ": ");
    // String NombreJugador = sc.nextLine();
    // Jugador[i] = new PAJugadorAnfitrion(NombreJugador);
    // }
    // bucle = 1;
    // break;
    // }
    // default:
    // System.out.println("Ingrese un número válido.");
    // bucle = 0;
    // break;
    // }
    // } catch (InputMismatchException e) {
    // System.out.println("Error: Debes ingresar un número entero.");
    // bucle = 0;
    // sc.nextLine();
    // }
    // Jugador = new PAJugadorAnfitrion[0];
    // } while (bucle != 1);
    // return Jugador;
    // }
    public PAJugadorAnfitrion[] paEscogerParametrosJuego() {
        PAJugadorAnfitrion[] Jugador = new PAJugadorAnfitrion[0];
        // PAJugadorAnfitrion[] Jugador;
        String cantidadJugadores1 = " ";
        int cantidadJugadores = 0;

        System.out.println("\n\tMODO JUEGO \n1. Individual \n2. Multijugador");
        int bucle = 0;
        do {

            int tipoDeJuego = sc.nextInt();
            sc.nextLine();
            if (tipoDeJuego == 2) {
                do {
                    System.out.print("Ingrese  el número de jugadores: ");
                    cantidadJugadores1 = sc.nextLine();
                    if (cantidadJugadores1.equals("2") || cantidadJugadores1.equals("3")
                            || cantidadJugadores1.equals("4") || cantidadJugadores1.equals("5")) {
                        cantidadJugadores = Integer.parseInt(cantidadJugadores1);
                    }

                    setPANumJugadores(cantidadJugadores);
                    // sc.nextLine();
                    Jugador = new PAJugadorAnfitrion[cantidadJugadores];

                } while (getPANumJugadores() == 0);

                for (int i = 0; i < cantidadJugadores; i++) {
                    System.out.print("Ingrese el nombre del Jugador " + (i + 1) + ": ");
                    String NombreJugador = sc.nextLine();
                    Jugador[i] = new PAJugadorAnfitrion(NombreJugador);
                }
                bucle = 1;
                // return Jugador;
            } else if (tipoDeJuego == 1) {
                Jugador = new PAJugadorAnfitrion[1];
                Jugador[0] = new PAJugadorAnfitrion("Solitario");
                bucle = 1;
                // return Jugador;
            }
            // }else{
            // System.out.print("Ingrese un numero valido: ");
            // }

        } while (bucle != 1);
        return Jugador;
    }

    public ArrayList<String> paListaPenitencias() {
        ArrayList<String> lista_penitencia = new ArrayList<>();
        lista_penitencia.add("Haz una imitación graciosa de tu profesor favorito.");
        lista_penitencia.add("Baila tu canción favorita en medio de la habitación durante un minuto sin música.");
        lista_penitencia.add("Haz una llamada telefónica a un amigo y cántale una canción.");
        lista_penitencia.add("Haz una serenata a una almohada como si fuera tu amor platónico.");
        lista_penitencia.add("Haz una interpretación dramática de tu emoji favorito.");
        lista_penitencia.add(
                "Toma una foto tuya haciendo una cara graciosa y publícala en tus redes sociales con un mensaje embarazoso.");
        lista_penitencia.add("Realiza una interpretación de una escena de tu película favorita.");
        lista_penitencia.add("Di un chiste malo y asegúrate de que todos se rían.");
        lista_penitencia.add("Actúa como un animal asignado por el grupo durante los próximos 3 minutos.");
        lista_penitencia.add("Haz una breve declaración de amor a un objeto inanimado.");
        lista_penitencia.add("Realiza una danza improvisada al ritmo de la canción que elijan los demás.");
        lista_penitencia.add("Escribe un poema improvisado sobre un tema elegido por el grupo.");
        lista_penitencia.add(
                "Haz una selfie ridícula y ponla como foto de perfil en todas tus redes sociales durante una hora.");
        lista_penitencia.add("Di en voz alta tu secreto más vergonzoso.");
        lista_penitencia.add("Háblale a una planta como si fuera tu confidente y cuéntale tus problemas.");
        lista_penitencia.add("Realiza una sesión de fotos con poses exageradas y expresiones faciales locas.");
        lista_penitencia.add("Haz una imitación de un personaje famoso y deja que los demás adivinen quién es.");
        lista_penitencia
                .add("Contagia un rumor ridículo sobre ti mismo/a y asegúrate de que se extienda entre tus amigos.");
        lista_penitencia.add(
                "Haz una llamada telefónica a un miembro de tu familia y dile que te has convertido en una estrella de rock.");
        lista_penitencia.add("Canta \"Los Pollitos Dicen\" enfrente del grupo.");

        return lista_penitencia;
    }

    // public ArrayList<String> paObtenerNombresJugadores(PAJugadorAnfitrion[]
    // jugadores) {
    // ArrayList<String> nombresJugadores = new ArrayList<>();
    // for (PAJugadorAnfitrion jugador : jugadores) {
    // nombresJugadores.add(jugador.getTJnombre());
    // }
    // return nombresJugadores;
    // }

    // public ArrayList<Integer> paObtenerPuntajesJugadores(PAJugadorAnfitrion[]
    // jugadores) {
    // ArrayList<Integer> puntajesJugadores = new ArrayList<>();
    // for (PAJugadorAnfitrion jugador : jugadores) {
    // puntajesJugadores.add(jugador.getPuntaje());
    // }
    // return puntajesJugadores;
    // }

    // public int paIndiceMayorPuntaje(PAJugadorAnfitrion[] jugadores) {
    // int indiceMayorPuntaje = 0;
    // int mayorPuntaje = jugadores[0].getPuntaje();

    // for (int i = 1; i < jugadores.length; i++) {
    // int puntajeActual = jugadores[i].getPuntaje();
    // if (puntajeActual > mayorPuntaje) {
    // mayorPuntaje = puntajeActual;
    // indiceMayorPuntaje = i;
    // }
    // }
    // return indiceMayorPuntaje;
    // }

    public ArrayList<String> paObtenerNombresJugadoresConPuntajes(PAJugadorAnfitrion[] jugadores) {
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
