package DataAccess;

public class PreguntaDTO {
    private Integer IdPregunta;
    private Integer IdCategoriaEstructura;
    private String Enunciado;
    private String Respuesta;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;

    public PreguntaDTO() {
    }

    public PreguntaDTO(int IdPregunta, int IdCategoriaEstructura, String Enunciado, String Respuesta, String Estado,
            String FechaCrea, String FechaModifica) {
        this.IdPregunta = IdPregunta;
        this.IdCategoriaEstructura = IdCategoriaEstructura;
        this.Enunciado = Enunciado;
        this.Respuesta = Respuesta;
        this.Estado = Estado;
        this.FechaCrea = FechaCrea;
        this.FechaModifica = FechaModifica;
    }

    public Integer getIdPregunta() {
        return IdPregunta;
    }

    public Integer getIdCateogoriaEstructura() {
        return IdCategoriaEstructura;
    }

    public String getEnunciado() {
        return Enunciado;
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
                // + "\n IdPregunta: " + getIdPregunta()
                // + "\n IdCategoria: " + getIdCateogoriaEstructura()
                // + "\n Enunciado: " + getEnunciado()
                // + "\n Respuesta: " + getRespuesta()
                // + "\n Estado: " + getEstado()
                // + "\n FechaCrea: " + getFechaCrea()
                // + "\n FechaModifica:" + getFechaModifica();

                + "\n PREGUNTA:     " + getIdPregunta()
                + "\n               " + getEnunciado()
                + "\n RESPUESTA:    " + getRespuesta();

    }
}
