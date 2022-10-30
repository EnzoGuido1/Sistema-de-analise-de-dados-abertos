package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.factory.PgConnectionFactory;
import br.uel.bd1.dadosparlamentares.factory.PgDAOFactory;
import br.uel.bd1.dadosparlamentares.model.Politico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PoliticoDAOTest {
    @Test
    public void selectAll() throws SQLException, IOException, ClassNotFoundException {
        PgConnectionFactory connectFactory = (PgConnectionFactory) PgConnectionFactory.getInstance();
        PgDAOFactory daoFactory = new PgDAOFactory(connectFactory.getConnection());
        PoliticoDAO politicoDao = daoFactory.getPoliticoDAO();

        List<Politico> result = politicoDao.selectAll();
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.size() > 0);
    }
    @Test
    public void selectByPrimaryKey() throws SQLException, IOException, ClassNotFoundException {
        PgConnectionFactory connectFactory = (PgConnectionFactory) PgConnectionFactory.getInstance();
        PgDAOFactory daoFactory = new PgDAOFactory(connectFactory.getConnection());
        PoliticoDAO politicoDao = daoFactory.getPoliticoDAO();

        Politico result = politicoDao.selectByPrimaryKey(12345678912L);
        Assertions.assertNotNull(result);
    }
    @Test
    public void insert() throws SQLException, IOException, ClassNotFoundException {
        PgConnectionFactory connectFactory = (PgConnectionFactory) PgConnectionFactory.getInstance();
        PgDAOFactory daoFactory = new PgDAOFactory(connectFactory.getConnection());
        PoliticoDAO politicoDao = daoFactory.getPoliticoDAO();
        Politico p = new Politico();
        p.setCpf(22233344456L);
        p.setNome("KORCA");
        p.setSobrenome("queimador de rosca");
        p.setSigla("based");

        politicoDao.insert(p);
    }
    @Test
    public void update() throws SQLException, IOException, ClassNotFoundException {
        PgConnectionFactory connectFactory = (PgConnectionFactory) PgConnectionFactory.getInstance();
        PgDAOFactory daoFactory = new PgDAOFactory(connectFactory.getConnection());
        PoliticoDAO politicoDao = daoFactory.getPoliticoDAO();
        Politico p = new Politico();
        p.setCpf(22233344455L);
        p.setNome("José");
        p.setSobrenome("Tora Grossa");
        p.setSigla("PENIS");

        politicoDao.update(p);
    }
    @Test
    public void delete() throws SQLException, IOException, ClassNotFoundException {
        PgConnectionFactory connectFactory = (PgConnectionFactory) PgConnectionFactory.getInstance();
        PgDAOFactory daoFactory = new PgDAOFactory(connectFactory.getConnection());
        PoliticoDAO politicoDao = daoFactory.getPoliticoDAO();
        Politico p = new Politico();
        p.setCpf(22233344455L);
        p.setNome("José");
        p.setSobrenome("Tora Grossa");
        p.setSigla("CUZIL");

        politicoDao.delete(p);
    }
}
