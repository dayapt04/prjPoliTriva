package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import Framework.PException;

public class PreguntaDAO extends SQLiteDataHelper implements IDAO<PreguntaDTO> {

    @Override
    public PreguntaDTO readBy(Integer id) throws Exception {
        PreguntaDTO oP = new PreguntaDTO();
        String query = " SELECT IdPregunta               "
                + " ,IdCategoriaEstructura      "
                + " ,Enunciado                       "
                + " ,Respuesta                      "
                + " ,Estado                         "
                + " ,FechaCrea                      "
                + " ,FechaModifica                  "
                + " FROM    PREGUNTA                "
                + " WHERE   Estado ='A' AND IdPregunta =   " + id.toString();
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                oP = new PreguntaDTO(rs.getInt(1) // IdPregunta
                        , rs.getInt(2) // IdCategoriaEstructura
                        , rs.getString(3) // Enunciado
                        , rs.getString(4) // Respuesta
                        , rs.getString(5) // Estado
                        , rs.getString(6) // FechaCrea
                        , rs.getString(7)); // FechaModifica
            }
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oP;
    }

    @Override
    public List<PreguntaDTO> readAll() throws Exception {
        List<PreguntaDTO> lst = new ArrayList<>();
        String query = " SELECT IdPregunta               "
                + " ,IdCategoriaEstructura      "
                + " ,Enunciado                       "
                + " ,Respuesta                      "
                + " ,Estado                         "
                + " ,FechaCrea                      "
                + " ,FechaModifica                  "
                + " FROM    PREGUNTA                "
                + " WHERE   Estado ='A' ";
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                PreguntaDTO preguntaDTO = new PreguntaDTO(rs.getInt(1) // IdPregunta
                        , rs.getInt(2) // IdCategoriaEstructura
                        , rs.getString(3) // Enunciado
                        , rs.getString(4) // Respuesta
                        , rs.getString(5) // Estado
                        , rs.getString(6) // FechaCrea
                        , rs.getString(7));// FechaModifica
                lst.add(preguntaDTO);
            }
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(PreguntaDTO entity) throws Exception {
        String query = " INSERT INTO PREGUNTA (Enunciado, Respuesta) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getEnunciado());
            pstmt.setString(2, entity.getRespuesta());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(PreguntaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE PREGUNTA SET IdCategoriaEstructura = ?, Pregunta = ?, Respuesta = ?, FechaModifica = ? WHERE IdPregunta = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdCateogoriaEstructura());
            pstmt.setString(2, entity.getEnunciado());
            pstmt.setString(3, entity.getRespuesta());
            pstmt.setString(4, dtf.format(now).toString());
            pstmt.setInt(5, entity.getIdPregunta());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE PREGUNTA SET Estado = ? WHERE IdPregunta = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

}
