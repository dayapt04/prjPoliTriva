package BusinessLogic;

import java.util.List;

import DataAccess.PreguntaDAO;
import DataAccess.PreguntaDTO;

public class PreguntaBL {
    private PreguntaDAO pDAO = new PreguntaDAO();

    public PreguntaBL() {
    }

    public List<PreguntaDTO> getAll() throws Exception {
        return pDAO.readAll();
    }

    public PreguntaDTO getById(int id) throws Exception {
        return pDAO.readBy(id);
    }
}
