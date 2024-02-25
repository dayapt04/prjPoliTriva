package BusinessLogic.Entities;

import java.util.ArrayList;
import java.util.List;

public class PoliTrivia {
    private int puntajes;
    private int tiempo;

    public int getPuntajes() {
        return puntajes;
    }

    public void setPuntajes(int puntajes) {
        this.puntajes = puntajes;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
 }

    public void AVshowMenuPrincipal() {} 

    public void AVshowMenuSalida() {}

    public void AVshowMenuCategorias() {}

    public void AVshowMenuSubtema() {} 

    public List<Pregunta> AVobtenerPreguntas(String categoria, String subtema) {
        List<Pregunta> preguntas = new ArrayList<>();
        return preguntas;
    }

    public void AVtemporizador(int tiempo) {
    }

    public ArrayList<String> AVobtenerInfoJugador(String nombre, int puntaje, String penitencia) {
        ArrayList<String> Datos = new ArrayList<>();
        return Datos;
    }

    public void AvgenerarCodigoQr(ArrayList Datos, String idQr) {}

}