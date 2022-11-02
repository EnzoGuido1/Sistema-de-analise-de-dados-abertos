package br.uel.bd1.dadosparlamentares.control;

import br.uel.bd1.dadosparlamentares.factory.DAOFactory;
import br.uel.bd1.dadosparlamentares.model.Partido;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import br.uel.bd1.dadosparlamentares.dao.PartidoDAO;

@Named
@ViewScoped
public class PartidoController extends GenericController<Partido> {
    //call the selectAll method from PartidoDAO to fill on setQueryBuf
    public List<Partido> getPartidos() throws SQLException, IOException, ClassNotFoundException {
        PartidoDAO dao = DAOFactory.getInstance().getPartidoDAO();
        setQueryBuf(dao.selectAll());
        return queryBuf;
    }
}