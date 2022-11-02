package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.factory.DAOFactory;
import br.uel.bd1.dadosparlamentares.model.Partido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PartidoDAOTest {
    @Test
    public void selectAll() throws SQLException, IOException, ClassNotFoundException {
        PartidoDAO dao = DAOFactory.getInstance().getPartidoDAO();
        List<Partido> partidos = dao.selectAll();
        Assertions.assertNotNull(partidos);
    }
}
