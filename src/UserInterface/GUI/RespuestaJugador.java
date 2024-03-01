package UserInterface.GUI;

public class RespuestaJugador {  
    private int respuesta;  
    private int numeroPregunta;  
    private String jugador;  
    private int codigoRespuestaCorrecta;  
  
    // Constructor  
    public RespuestaJugador(int respuesta, int numeroPregunta, String jugador, int codigoRespuestaCorrecta) {  
        this.respuesta = respuesta;  
        this.numeroPregunta = numeroPregunta;  
        this.jugador = jugador;  
        this.codigoRespuestaCorrecta = codigoRespuestaCorrecta;  
    }  
  
    // Getters  
    public int getRespuesta() { return respuesta; }  
    public int getNumeroPregunta() { return numeroPregunta; }  
    public String getJugador() { return jugador; }  
    public int getCodigoRespuestaCorrecta() { return codigoRespuestaCorrecta; }  
}  

