import java.util.List;
import java.util.Scanner;

import BusinessLogic.Entities.Jugador;
import BusinessLogic.Entities.JugadorAnfitrion;
import DataAccess.PreguntaDAO;
import DataAccess.RespuestaDAO;
import DataAccess.RespuestaDTO;
import DataAccess.PreguntaDTO;

public class App {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        PreguntaDAO pDAO = new PreguntaDAO();
        RespuestaDAO rDAO = new RespuestaDAO();
        RespuestaDTO rDTO = new RespuestaDTO();
        PreguntaDTO pDto = new PreguntaDTO();
        // System.out.println(pDAO.readAll().toString());

        Integer numeroRespuestaCorrecta = 0;
        String usuarioRespuesta = "";
        Integer puntajeUsuario = 0;
        Integer totalPreguntas = 0;

        int opcionUsuario;
        int opcionCategoria1;
        int opcionCategoria2;

        // JugadorAnfitrion Anfitrion = new JugadorAnfitrion();
        JugadorAnfitrion[] Jugador;

        System.out.println("1. Individual \n2. Multijugador");
        int tipoDeJuego = sc.nextInt();
        if (tipoDeJuego != 1) {
            System.out.println("Ingrese  el número de jugadores: ");
            int cantidadJugadores = sc.nextInt();
            sc.nextLine();
            Jugador = new JugadorAnfitrion[cantidadJugadores];

            for (int i = 0; i < cantidadJugadores; i++) {
                System.out.println("Ingrese el nombre del Jugador " + i);
                String NombreJugador = sc.nextLine();
                Jugador[i] = new JugadorAnfitrion(NombreJugador);
            }
        } else {
            Jugador = new JugadorAnfitrion[1];
        }

        do {
            System.out.println("Seleccione la Tematica deseada");
            System.out.println("1. Cultura General Politecnica \n2. Politecnico Basico");

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
                                        // totalPreguntas++;
                                    }
                                    // System.out.println("Respuesta correcta");
                                    for (int ju = 0; ju < Jugador.length; ju++) {
                                        int puntajeDespues = Jugador[ju].getPuntaje();
                                        boolean respuestaCorrecta = puntajeDespues > puntajesAntes[ju];
                                        System.out.println("Jugador " + Jugador[ju].getTJnombre() + ": " + (respuestaCorrecta ? "Respuestas correcta" : "Respuestas incorrecta"));
                                    }
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

                                    System.out.println("Ingrese su respuesta");
                                    usuarioRespuesta = sc.nextLine();
                                    if (usuarioRespuesta.equals(numeroRespuestaCorrecta.toString())) {
                                        System.out.println("Respuesta correcta");
                                        puntajeUsuario++;
                                    } else {
                                        System.out.println("Respuesta incorrecta");
                                    }
                                    totalPreguntas++;
                                }
                                System.out
                                        .println("Usted ha contestado correctamente " + puntajeUsuario + "/"
                                                + totalPreguntas);
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

                                    System.out.println("Ingrese su respuesta");
                                    usuarioRespuesta = sc.nextLine();
                                    if (usuarioRespuesta.equals(numeroRespuestaCorrecta.toString())) {
                                        System.out.println("Respuesta correcta");
                                        puntajeUsuario++;
                                    } else {
                                        System.out.println("Respuesta incorrecta");
                                    }
                                    totalPreguntas++;
                                }
                                System.out.println(
                                        "Usted ha contestado correctamente " + puntajeUsuario + "/" + totalPreguntas);
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

                                    System.out.println("Ingrese su respuesta");
                                    usuarioRespuesta = sc.nextLine();
                                    if (usuarioRespuesta.equals(numeroRespuestaCorrecta.toString())) {
                                        System.out.println("Respuesta correcta");
                                        puntajeUsuario++;
                                    } else {
                                        System.out.println("Respuesta incorrecta");
                                    }
                                    totalPreguntas++;
                                }
                                System.out.println(
                                        "Usted ha contestado correctamente " + puntajeUsuario + "/" + totalPreguntas);
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

                                    System.out.println("Ingrese su respuesta");
                                    usuarioRespuesta = sc.nextLine();
                                    if (usuarioRespuesta.equals(numeroRespuestaCorrecta.toString())) {
                                        System.out.println("Respuesta correcta");
                                        puntajeUsuario++;
                                    } else {
                                        System.out.println("Respuesta incorrecta");
                                    }
                                    totalPreguntas++;
                                }
                                System.out.println(
                                        "Usted ha contestado correctamente " + puntajeUsuario + "/" + totalPreguntas);
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

                                    System.out.println("Ingrese su respuesta");
                                    usuarioRespuesta = sc.nextLine();
                                    if (usuarioRespuesta.equals(numeroRespuestaCorrecta.toString())) {
                                        System.out.println("Respuesta correcta");
                                        puntajeUsuario++;
                                    } else {
                                        System.out.println("Respuesta incorrecta");
                                    }
                                    totalPreguntas++;
                                }
                                System.out.println(
                                        "Usted ha contestado correctamente " + puntajeUsuario + "/" + totalPreguntas);
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

                                    System.out.println("Ingrese su respuesta");
                                    usuarioRespuesta = sc.nextLine();
                                    if (usuarioRespuesta.equals(numeroRespuestaCorrecta.toString())) {
                                        System.out.println("Respuesta correcta");
                                        puntajeUsuario++;
                                    } else {
                                        System.out.println("Respuesta incorrecta");
                                    }
                                    totalPreguntas++;
                                }
                                System.out.println(
                                        "Usted ha contestado correctamente " + puntajeUsuario + "/" + totalPreguntas);
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

                default:
                    System.out.println("Opcion no valida");
                    break;

            }
        } while (opcionUsuario != 3);
        // Aqui se pone la categoria seleccionada
        // List<PreguntaDTO> preguntas = pDAO.readById(3);

        // for (int i = 0; i < preguntas.size(); i++) {
        // pDto = preguntas.get(i);

        // System.out.println(pDto.toString() + "\n");

        // List<RespuestaDTO> respuestas = rDAO.readById(pDto.getIdPregunta());

        // for (int j = 0; j < respuestas.size(); j++) {
        // rDTO = respuestas.get(j);
        // System.out.println(rDTO.getIdRespuesta() + ": " +
        // rDTO.getRespuestaUsuario());
        // if (rDTO.getAprobada().equals(1)) {
        // numeroRespuestaCorrecta = rDTO.getIdRespuesta();
        // }
        // }

        // System.out.println("Ingrese su respuesta");
        // usuarioRespuesta = sc.nextLine();
        // if (usuarioRespuesta.equals(numeroRespuestaCorrecta.toString())) {
        // System.out.println("Respuesta correcta");
        // puntajeUsuario++;
        // } else {
        // System.out.println("Respuesta incorrecta");
        // }
        // totalPreguntas++;
        // }
        // System.out.println("Usted ha contestado correctamente " + puntajeUsuario +
        // "/" + totalPreguntas);
    }
}
