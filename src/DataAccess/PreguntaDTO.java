package DataAccess;

public class PreguntaDTO {
    private Integer IdPregunta;
    private Integer IdCategoriaPregunta;
    private String Pregunta;
    private String Respuesta;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;

    public PreguntaDTO() {
    }

    public PreguntaDTO(int IdPregunta, int IdCategoriaPregunta, String Pregunta, String Respuesta, String Estado,
            String FechaCrea, String FechaModifica) {
        this.IdPregunta = IdPregunta;
        this.IdCategoriaPregunta = IdCategoriaPregunta;
        this.Pregunta = Pregunta;
        this.Respuesta = Respuesta;
        this.Estado = Estado;
        this.FechaCrea = FechaCrea;
        this.FechaModifica = FechaModifica;
    }

    public Integer getIdPregunta() {
        return IdPregunta;
    }

    public Integer getIdCategoriaPregunta() {
        return IdCategoriaPregunta;
    }

    public String getPregunta() {
        return Pregunta;
    }

    public String getRespuesta() {
        return Respuesta;
    }

    public String getEstado() {
        return Estado;
    }

    public String getFechaCrea() {
        return FechaCrea;
    }

    public String getFechaModifica() {
        return FechaModifica;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "\n IdPregunta:   " + getIdPregunta()
                + "\n IdCategoria:  " + getIdCategoriaPregunta()
                + "\n Pregunta:     " + getPregunta()
                + "\n Respuesta:    " + getRespuesta()
                + "\n Estado:       " + getEstado()
                + "\n FechaCrea:    " + getFechaCrea()
                + "\n FechaModifica:" + getFechaModifica();
    }
}
