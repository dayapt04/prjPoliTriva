package DataAccess;

public class RespuestaDTO {

    private Integer IdRespuesta;

    public Integer getIdRespuesta() {
        return IdRespuesta;
    }

    private Integer IdPregunta;

    public Integer getIdPregunta() {
        return IdPregunta;
    }

    private String RespuestaUsuario;

    public String getRespuestaUsuario() {
        return RespuestaUsuario;
    }

    private Integer Aprobada;

    public Integer getAprobada() {
        return Aprobada;
    }

    public RespuestaDTO(){
        
    }

    public RespuestaDTO(int IdRespuesta, int IdPregunta, String RespuestaUsuario, int Aprobada){
        this.IdRespuesta = IdRespuesta;
        this.IdPregunta = IdPregunta;
        this.RespuestaUsuario= RespuestaUsuario;
        this.Aprobada = Aprobada;
    }

    @Override
    public String toString() {
        return getClass().getName()


                + "\n Respuesta:     " + getIdRespuesta()
                + ": " + getRespuestaUsuario();


    }
}
