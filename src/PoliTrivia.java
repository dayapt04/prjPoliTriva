import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import BusinessLogic.Entities.PAJugadorAnfitrion;
import DataAccess.PreguntaDAO;
import DataAccess.PreguntaDTO;
import DataAccess.RespuestaDAO;
import DataAccess.RespuestaDTO;

public class PoliTrivia {
    private Scanner sc = new Scanner(System.in);

    public void mainPolitrivia() throws Exception {

        PreguntaDAO pDAO = new PreguntaDAO();
        RespuestaDAO rDAO = new RespuestaDAO();
        RespuestaDTO rDTO = new RespuestaDTO();
        PreguntaDTO pDto = new PreguntaDTO();

        Integer numeroRespuestaCorrecta = 0;
        String usuarioRespuesta = "";
        Integer totalPreguntas = 0;

        int opcionUsuario;
        int opcionCategoria1;
        int opcionCategoria2;

        PAJugadorAnfitrion jugadorAnfitrion = new PAJugadorAnfitrion(usuarioRespuesta);
        PAJugadorAnfitrion[] Jugador = jugadorAnfitrion.paEscogerParametrosJuego();
        do {
            System.out.println("Seleccione la Tematica deseada");
            System.out.println(
                    "1. Cultura General Politecnica \n2. Politecnico Basico \n3. Revisar Puntajes de la Partida");

            opcionUsuario = sc.nextInt();
            sc.nextLine();

            switch (opcionUsuario) {
                // Cultura General Politecnica
                case 1:
                    int condicion = 0;
                    do {
                        System.out.println("Seleccione la categoria que le gustaria jugar");
                        System.out.println(
                                "1. Cultura General Estudiantil \n2. Cultura General Institucional \n3. Regresar");
                        // 1. Cultura General Estudiantil
                        // 2. Cultura General Institucional
                        opcionCategoria1 = sc.nextInt();
                        sc.nextLine();
                        switch (opcionCategoria1) {
                            case 1:

                                List<PreguntaDTO> preguntasEstudiantes = pDAO.readById(3);

                                for (int i = 0; i < preguntasEstudiantes.size(); i++) {
                                    pDto = preguntasEstudiantes.get(i);

                                    System.out.println(pDto.toString() + "\n");

                                    List<RespuestaDTO> respuestas = rDAO.readById(pDto.getIdPregunta());

                                    for (int j = 0; j < respuestas.size(); j++) {
                                        rDTO = respuestas.get(j);
                                        System.out.println(rDTO.getIdRespuesta() + ": " + rDTO.getRespuestaUsuario());
                                        if (rDTO.getAprobada().equals(1)) {
                                            numeroRespuestaCorrecta = rDTO.getIdRespuesta();
                                        }
                                    }

                                    int[] puntajesAntes = new int[Jugador.length];
                                    for (int ju = 0; ju < Jugador.length; ju++) {
                                        puntajesAntes[ju] = Jugador[ju].getPuntaje();
                                    }

                                    for (int ju = 0; ju < Jugador.length; ju++) {

                                        System.out.println("Ingrese su respuesta " + Jugador[ju].getTJnombre());
                                        usuarioRespuesta = sc.nextLine();
                                        if (usuarioRespuesta.equals(numeroRespuestaCorrecta.toString())) {

                                            Jugador[ju].aumentarPuntaje(1);
                                        }

                                    }
                                    // System.out.println("Respuesta correcta");
                                    for (int ju = 0; ju < Jugador.length; ju++) {
                                        int puntajeDespues = Jugador[ju].getPuntaje();
                                        boolean respuestaCorrecta = puntajeDespues > puntajesAntes[ju];
                                        System.out.println("Jugador " + Jugador[ju].getTJnombre() + ": "
                                                + (respuestaCorrecta ? "Respuesta correcta" : "Respuesta incorrecta"));
                                    }
                                    totalPreguntas++;
                                }
                                for (int h = 0; h < Jugador.length; h++) {
                                    System.out.println("* " + Jugador[h].getTJnombre() + " obtuvo "
                                            + Jugador[h].getPuntaje() + "/" + totalPreguntas);
                                }

                                // System.out
                                // .println("Jugador correctamente en esta rona " + puntajeUsuario + "/"
                                // + totalPreguntas);
                                break;
                            case 2:

                                List<PreguntaDTO> preguntasValores = pDAO.readById(4);

                                for (int i = 0; i < preguntasValores.size(); i++) {
                                    pDto = preguntasValores.get(i);

                                    System.out.println(pDto.toString() + "\n");

                                    List<RespuestaDTO> respuestas = rDAO.readById(pDto.getIdPregunta());

                                    for (int j = 0; j < respuestas.size(); j++) {
                                        rDTO = respuestas.get(j);
                                        System.out.println(rDTO.getIdRespuesta() + ": " + rDTO.getRespuestaUsuario());
                                        if (rDTO.getAprobada().equals(1)) {
                                            numeroRespuestaCorrecta = rDTO.getIdRespuesta();
                                        }
                                    }

                                    int[] puntajesAntes = new int[Jugador.length];
                                    for (int ju = 0; ju < Jugador.length; ju++) {
                                        puntajesAntes[ju] = Jugador[ju].getPuntaje();
                                    }

                                    for (int ju = 0; ju < Jugador.length; ju++) {

                                        System.out.println("Ingrese su respuesta " + Jugador[ju].getTJnombre());
                                        usuarioRespuesta = sc.nextLine();
                                        if (usuarioRespuesta.equals(numeroRespuestaCorrecta.toString())) {

                                            Jugador[ju].aumentarPuntaje(1);
                                        }
                                    }
                                    // System.out.println("Respuesta correcta");
                                    for (int ju = 0; ju < Jugador.length; ju++) {
                                        int puntajeDespues = Jugador[ju].getPuntaje();
                                        boolean respuestaCorrecta = puntajeDespues > puntajesAntes[ju];
                                        System.out.println("Jugador " + Jugador[ju].getTJnombre() + ": "
                                                + (respuestaCorrecta ? "Respuesta correcta" : "Respuesta incorrecta"));
                                    }
                                    totalPreguntas++;
                                }
                                for (int h = 0; h < Jugador.length; h++) {
                                    System.out.println("* " + Jugador[h].getTJnombre() + " obtuvo "
                                            + Jugador[h].getPuntaje() + "/" + totalPreguntas);
                                }
                                break;
                            case 3:
                                condicion = 1;
                                break;

                            default:
                                System.out.println("Opcion no valida");
                                break;
                        }
                    } while (condicion != 1);

                    break;

                // Politecnico Basica
                case 2:
                    int condicion1 = 0;
                    do {
                        System.out.println("Seleccione la categoria que le gustaria jugar");
                        System.out.println("1. Algebra Lineal\n" +
                                "2. Calculo en una variable\n" +
                                "3. Mecanica Newtoniana\n" +
                                "4. COE\n" +
                                "5. Analisis Socioeconomico\n" + "6. Regresar");
                        // 1. Algebra Lineal
                        // 2. Calculo en una variable
                        // 3. Mecanica Newtoniana
                        // 4. COE
                        // 5. Analisis Socioeconomico
                        opcionCategoria2 = sc.nextInt();
                        sc.nextLine();

                        switch (opcionCategoria2) {
                            case 1:
                                List<PreguntaDTO> preguntasAlgebra = pDAO.readById(5);

                                for (int i = 0; i < preguntasAlgebra.size(); i++) {
                                    pDto = preguntasAlgebra.get(i);

                                    System.out.println(pDto.toString() + "\n");

                                    List<RespuestaDTO> respuestas = rDAO.readById(pDto.getIdPregunta());

                                    for (int j = 0; j < respuestas.size(); j++) {
                                        rDTO = respuestas.get(j);
                                        System.out.println(rDTO.getIdRespuesta() + ": " + rDTO.getRespuestaUsuario());
                                        if (rDTO.getAprobada().equals(1)) {
                                            numeroRespuestaCorrecta = rDTO.getIdRespuesta();
                                        }
                                    }

                                    int[] puntajesAntes = new int[Jugador.length];
                                    for (int ju = 0; ju < Jugador.length; ju++) {
                                        puntajesAntes[ju] = Jugador[ju].getPuntaje();
                                    }

                                    for (int ju = 0; ju < Jugador.length; ju++) {

                                        System.out.println("Ingrese su respuesta " + Jugador[ju].getTJnombre());
                                        usuarioRespuesta = sc.nextLine();
                                        if (usuarioRespuesta.equals(numeroRespuestaCorrecta.toString())) {

                                            Jugador[ju].aumentarPuntaje(1);
                                        }

                                    }
                                    // System.out.println("Respuesta correcta");
                                    for (int ju = 0; ju < Jugador.length; ju++) {
                                        int puntajeDespues = Jugador[ju].getPuntaje();
                                        boolean respuestaCorrecta = puntajeDespues > puntajesAntes[ju];
                                        System.out.println("Jugador " + Jugador[ju].getTJnombre() + ": "
                                                + (respuestaCorrecta ? "Respuesta correcta" : "Respuesta incorrecta"));
                                    }
                                    totalPreguntas++;
                                }
                                for (int h = 0; h < Jugador.length; h++) {
                                    System.out.println("* " + Jugador[h].getTJnombre() + " obtuvo "
                                            + Jugador[h].getPuntaje() + "/" + totalPreguntas);
                                }
                                break;
                            case 2:

                                List<PreguntaDTO> preguntasCalculo = pDAO.readById(6);

                                for (int i = 0; i < preguntasCalculo.size(); i++) {
                                    pDto = preguntasCalculo.get(i);

                                    System.out.println(pDto.toString() + "\n");

                                    List<RespuestaDTO> respuestas = rDAO.readById(pDto.getIdPregunta());

                                    for (int j = 0; j < respuestas.size(); j++) {
                                        rDTO = respuestas.get(j);
                                        System.out.println(rDTO.getIdRespuesta() + ": " + rDTO.getRespuestaUsuario());
                                        if (rDTO.getAprobada().equals(1)) {
                                            numeroRespuestaCorrecta = rDTO.getIdRespuesta();
                                        }
                                    }

                                    int[] puntajesAntes = new int[Jugador.length];
                                    for (int ju = 0; ju < Jugador.length; ju++) {
                                        puntajesAntes[ju] = Jugador[ju].getPuntaje();
                                    }

                                    for (int ju = 0; ju < Jugador.length; ju++) {

                                        System.out.println("Ingrese su respuesta " + Jugador[ju].getTJnombre());
                                        usuarioRespuesta = sc.nextLine();
                                        if (usuarioRespuesta.equals(numeroRespuestaCorrecta.toString())) {

                                            Jugador[ju].aumentarPuntaje(1);
                                        }
                                        totalPreguntas++;
                                    }
                                    // System.out.println("Respuesta correcta");
                                    for (int ju = 0; ju < Jugador.length; ju++) {
                                        int puntajeDespues = Jugador[ju].getPuntaje();
                                        boolean respuestaCorrecta = puntajeDespues > puntajesAntes[ju];
                                        System.out.println("Jugador " + Jugador[ju].getTJnombre() + ": "
                                                + (respuestaCorrecta ? "Respuesta correcta" : "Respuesta incorrecta"));
                                    }
                                    totalPreguntas++;
                                }
                                for (int h = 0; h < Jugador.length; h++) {
                                    System.out.println("* " + Jugador[h].getTJnombre() + " obtuvo "
                                            + Jugador[h].getPuntaje() + "/" + totalPreguntas);
                                }
                                break;
                            case 3:
                                List<PreguntaDTO> preguntasMecanica = pDAO.readById(7);

                                for (int i = 0; i < preguntasMecanica.size(); i++) {
                                    pDto = preguntasMecanica.get(i);

                                    System.out.println(pDto.toString() + "\n");

                                    List<RespuestaDTO> respuestas = rDAO.readById(pDto.getIdPregunta());

                                    for (int j = 0; j < respuestas.size(); j++) {
                                        rDTO = respuestas.get(j);
                                        System.out.println(rDTO.getIdRespuesta() + ": " + rDTO.getRespuestaUsuario());
                                        if (rDTO.getAprobada().equals(1)) {
                                            numeroRespuestaCorrecta = rDTO.getIdRespuesta();
                                        }
                                    }

                                    int[] puntajesAntes = new int[Jugador.length];
                                    for (int ju = 0; ju < Jugador.length; ju++) {
                                        puntajesAntes[ju] = Jugador[ju].getPuntaje();
                                    }

                                    for (int ju = 0; ju < Jugador.length; ju++) {

                                        System.out.println("Ingrese su respuesta " + Jugador[ju].getTJnombre());
                                        usuarioRespuesta = sc.nextLine();
                                        if (usuarioRespuesta.equals(numeroRespuestaCorrecta.toString())) {

                                            Jugador[ju].aumentarPuntaje(1);
                                        }
                                        totalPreguntas++;
                                    }
                                    // System.out.println("Respuesta correcta");
                                    for (int ju = 0; ju < Jugador.length; ju++) {
                                        int puntajeDespues = Jugador[ju].getPuntaje();
                                        boolean respuestaCorrecta = puntajeDespues > puntajesAntes[ju];
                                        System.out.println("Jugador " + Jugador[ju].getTJnombre() + ": "
                                                + (respuestaCorrecta ? "Respuesta correcta" : "Respuesta incorrecta"));
                                    }
                                    totalPreguntas++;
                                }
                                for (int h = 0; h < Jugador.length; h++) {
                                    System.out.println("* " + Jugador[h].getTJnombre() + " obtuvo "
                                            + Jugador[h].getPuntaje() + "/" + totalPreguntas);
                                }
                                break;
                            case 4:
                                List<PreguntaDTO> preguntasCOE = pDAO.readById(8);

                                for (int i = 0; i < preguntasCOE.size(); i++) {
                                    pDto = preguntasCOE.get(i);

                                    System.out.println(pDto.toString() + "\n");

                                    List<RespuestaDTO> respuestas = rDAO.readById(pDto.getIdPregunta());

                                    for (int j = 0; j < respuestas.size(); j++) {
                                        rDTO = respuestas.get(j);
                                        System.out.println(rDTO.getIdRespuesta() + ": " + rDTO.getRespuestaUsuario());
                                        if (rDTO.getAprobada().equals(1)) {
                                            numeroRespuestaCorrecta = rDTO.getIdRespuesta();
                                        }
                                    }

                                    int[] puntajesAntes = new int[Jugador.length];
                                    for (int ju = 0; ju < Jugador.length; ju++) {
                                        puntajesAntes[ju] = Jugador[ju].getPuntaje();
                                    }

                                    for (int ju = 0; ju < Jugador.length; ju++) {

                                        System.out.println("Ingrese su respuesta " + Jugador[ju].getTJnombre());
                                        usuarioRespuesta = sc.nextLine();
                                        if (usuarioRespuesta.equals(numeroRespuestaCorrecta.toString())) {

                                            Jugador[ju].aumentarPuntaje(1);
                                        }
                                        totalPreguntas++;
                                    }
                                    // System.out.println("Respuesta correcta");
                                    for (int ju = 0; ju < Jugador.length; ju++) {
                                        int puntajeDespues = Jugador[ju].getPuntaje();
                                        boolean respuestaCorrecta = puntajeDespues > puntajesAntes[ju];
                                        System.out.println("Jugador " + Jugador[ju].getTJnombre() + ": "
                                                + (respuestaCorrecta ? "Respuesta correcta" : "Respuesta incorrecta"));
                                    }
                                    totalPreguntas++;
                                }
                                for (int h = 0; h < Jugador.length; h++) {
                                    System.out.println("* " + Jugador[h].getTJnombre() + " obtuvo "
                                            + Jugador[h].getPuntaje() + "/" + totalPreguntas);
                                }
                                break;
                            case 5:
                                List<PreguntaDTO> preguntasPolitica = pDAO.readById(9);

                                for (int i = 0; i < preguntasPolitica.size(); i++) {
                                    pDto = preguntasPolitica.get(i);

                                    System.out.println(pDto.toString() + "\n");

                                    List<RespuestaDTO> respuestas = rDAO.readById(pDto.getIdPregunta());

                                    for (int j = 0; j < respuestas.size(); j++) {
                                        rDTO = respuestas.get(j);
                                        System.out.println(rDTO.getIdRespuesta() + ": " + rDTO.getRespuestaUsuario());
                                        if (rDTO.getAprobada().equals(1)) {
                                            numeroRespuestaCorrecta = rDTO.getIdRespuesta();
                                        }
                                    }

                                    int[] puntajesAntes = new int[Jugador.length];
                                    for (int ju = 0; ju < Jugador.length; ju++) {
                                        puntajesAntes[ju] = Jugador[ju].getPuntaje();
                                    }

                                    for (int ju = 0; ju < Jugador.length; ju++) {

                                        System.out.println("Ingrese su respuesta " + Jugador[ju].getTJnombre());
                                        usuarioRespuesta = sc.nextLine();
                                        if (usuarioRespuesta.equals(numeroRespuestaCorrecta.toString())) {

                                            Jugador[ju].aumentarPuntaje(1);
                                        }

                                    }
                                    // System.out.println("Respuesta correcta");
                                    for (int ju = 0; ju < Jugador.length; ju++) {
                                        int puntajeDespues = Jugador[ju].getPuntaje();
                                        boolean respuestaCorrecta = puntajeDespues > puntajesAntes[ju];
                                        System.out.println("Jugador " + Jugador[ju].getTJnombre() + ": "
                                                + (respuestaCorrecta ? "Respuesta correcta" : "Respuesta incorrecta"));
                                    }
                                    totalPreguntas++;
                                }
                                for (int h = 0; h < Jugador.length; h++) {
                                    System.out.println("* " + Jugador[h].getTJnombre() + " obtuvo "
                                            + Jugador[h].getPuntaje() + "/" + totalPreguntas);
                                }
                                break;
                            case 6:
                                condicion1 = 1;
                                break;
                            default:
                                // System.out.println("Opcion no valida");
                                break;
                        }
                    } while (condicion1 != 1);
                    break;
                case 3: {
                    paGuardarArchivoPenitencias(jugadorAnfitrion, Jugador);
                    break;
                }

                default:
                    System.out.println("Opcion no valida");
                    break;

            }
        } while (opcionUsuario != 3);
    }

    public void paGuardarArchivoPenitencias(PAJugadorAnfitrion anfitrion, PAJugadorAnfitrion[] jugadores) {
        // JugadorAnfitrion jugadorAnfitrion = new JugadorAnfitrion(null);
        // String[] nombres = jugadorAnfitrion.get();
        // ArrayList<String> penitencias = anfitrion.listaPenitencias(null)
        String fileCSV = "database\\penitencias.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileCSV))) {
            // FileWriter fileWriter = new FileWriter(fileCSV, true);
            // BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < anfitrion.getPANumJugadores(); i++) {
                // int random =generarNumeroAleatorio(0, 20);

                int random[] = new int[20];
                String penitencia = "";
                for (int j = 0; j <= 19; j++) {
                    random[j] = generarNumeroAleatorio();

                    penitencia = (i == anfitrion.paIndiceMayorPuntaje(jugadores)) ? ""
                            : anfitrion.paListaPenitencias().get(random[j]);
                }

                writer.write((i + 1) + "," + anfitrion.paObtenerNombresJugadores(jugadores).get(i) + ","
                        + anfitrion.paObtenerPuntajesJugadores(jugadores).get(i)
                        + "," + penitencia);
                writer.newLine();
            }
            // writer.close();
        } catch (IOException e) {
            System.err.println("Error al manipular el archivo " + fileCSV + ": " + e.getMessage());
        }
    }

    public static int generarNumeroAleatorio() {
        int maximo = 19;
        int minimo = 0;
        Random rand = new Random();

        int numeroAleatorio = rand.nextInt(maximo - minimo + 1) + minimo;
        return numeroAleatorio;
    }
}
