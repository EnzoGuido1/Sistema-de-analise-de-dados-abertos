package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.factory.DAOFactory;
import br.uel.bd1.dadosparlamentares.model.Politico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PoliticoDAOTest {
    @Test
    public void selectAll() throws SQLException, IOException, ClassNotFoundException {
        PoliticoDAO politicoDao = DAOFactory.getInstance().getPoliticoDAO();

        List<Politico> result = politicoDao.selectAll();
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.size() > 0);
    }
    @Test
    public void selectByPrimaryKey() throws SQLException, IOException, ClassNotFoundException {
        PoliticoDAO politicoDao = DAOFactory.getInstance().getPoliticoDAO();

        Politico result = politicoDao.selectByPrimaryKey(43025900253L);
        Assertions.assertNotNull(result);
    }
    @Test
    public void insert() throws SQLException, IOException, ClassNotFoundException {
        PoliticoDAO politicoDao = DAOFactory.getInstance().getPoliticoDAO();
        Politico p = new Politico();
        p.setCpf(22233344456L);
        p.setNome("KORCA");
        p.setSobrenome("lalalala");
        p.setSigla("based");

        politicoDao.insert(p);
    }
    @Test
    public void update() throws SQLException, IOException, ClassNotFoundException {
        PoliticoDAO politicoDao = DAOFactory.getInstance().getPoliticoDAO();
        Politico p = new Politico();
        p.setCpf(43025900253L);
        p.setNome("Enzo Guido");
        p.setSobrenome("Americano da Costa");
        p.setSigla("PT");

        politicoDao.update(p);
    }
    @Test
    public void delete() throws SQLException, IOException, ClassNotFoundException {
        PoliticoDAO politicoDao = DAOFactory.getInstance().getPoliticoDAO();
        Politico p = new Politico();
//        p.setCpf(43025900253L);

        politicoDao.delete(43025900253L);
    }
}
