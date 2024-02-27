package BusinessLogic;

import java.util.List;

import DataAccess.RespuestaDAO;
import DataAccess.RespuestaDTO;

public class RespuestaBL {
    private RespuestaDAO rDAO = new RespuestaDAO();

    public RespuestaBL() {
    }

    public List<RespuestaDTO> getAll() throws Exception {
        return rDAO.readAll();
    }

    public RespuestaDTO getById(int id) throws Exception {
        return rDAO.readBy(id);
    }
}
