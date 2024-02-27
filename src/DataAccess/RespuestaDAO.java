package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Framework.PException;

public class RespuestaDAO extends SQLiteDataHelper implements IDAO<RespuestaDTO> {
    @Override
    public RespuestaDTO readBy(Integer id) throws Exception {
        RespuestaDTO oP = new RespuestaDTO();
        String query = " SELECT IdRespuesta               "
                + " ,IdPregunta     "
                + " ,RespuestaUsuario                       "
                + " ,Aprobada                         "
                + " FROM    Respuesta                "
                + " WHERE   IdPregunta =   " + id.toString();
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : selec t * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                oP = new RespuestaDTO(rs.getInt(1) // IdPregunta
                        , rs.getInt(2) // IdCategoriaEstructura
                        , rs.getString(3) // Enunciado
                        , rs.getInt(4)); // FechaModifica
            }
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oP;
    }

    @Override
    public List<RespuestaDTO> readAll() throws Exception {
        List<RespuestaDTO> lst = new ArrayList<>();
        String query = " SELECT IdRespuesta               "
                + " ,IdPregunta     "
                + " ,RespuestaUsuario                       "
                + " ,Aprobada                         "
                + " FROM    Respuesta                ";
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                RespuestaDTO respuestaDTO = new RespuestaDTO(rs.getInt(1) // IdPregunta
                        , rs.getInt(2) // IdCategoriaEstructura
                        , rs.getString(3) // Enunciado

                        , rs.getInt(4));// FechaModifica
                lst.add(respuestaDTO);
            }
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public List<RespuestaDTO> readById(Integer id) throws Exception {
        List<RespuestaDTO> lst = new ArrayList<>();
        String query = " SELECT IdRespuesta               "
                + " ,IdPregunta     "
                + " ,RespuestaUsuario                       "
                + " ,Aprobada                         "
                + " FROM    Respuesta                "
                + " WHERE   IdPregunta =   " + id.toString();
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                RespuestaDTO respuestaDTO = new RespuestaDTO(rs.getInt(1) // IdPregunta
                        , rs.getInt(2) // IdCategoriaEstructura
                        , rs.getString(3) // Enunciado

                        , rs.getInt(4));// FechaModifica
                lst.add(respuestaDTO);
            }
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(RespuestaDTO entity) throws Exception {
        String query = " INSERT INTO Respuesta (IdPregunta, RespuestaUsuario, Aprobada) VALUES (?,?,?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdPregunta());
            pstmt.setString(2, entity.getRespuestaUsuario());
            pstmt.setInt(3, entity.getAprobada());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(RespuestaDTO entity) throws Exception {
        String query = " UPDATE Respuesta SET RespuestaUsuario = ?, Aprobada = ? WHERE IdRespuesta = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.getRespuestaUsuario());
            pstmt.setInt(2, entity.getAprobada());
            pstmt.setInt(3, entity.getIdRespuesta());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "DELETE Respuesta WHERE IdRespuesta = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "delete()");
        }
    }
}
