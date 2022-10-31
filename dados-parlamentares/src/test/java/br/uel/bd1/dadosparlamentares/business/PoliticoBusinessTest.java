package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.PoliticoDAO;
import br.uel.bd1.dadosparlamentares.factory.PgConnectionFactory;
import br.uel.bd1.dadosparlamentares.factory.PgDAOFactory;
import br.uel.bd1.dadosparlamentares.model.Politico;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class PoliticoBusinessTest {
    @Test
    public void insertFromCsv() throws SQLException, IOException, ClassNotFoundException {
        PgConnectionFactory connectFactory = (PgConnectionFactory) PgConnectionFactory.getInstance();
        PgDAOFactory daoFactory = new PgDAOFactory(connectFactory.getConnection());
        PoliticoDAO politicoDao = daoFactory.getPoliticoDAO();

        PoliticoBusiness business = new PoliticoBusiness(politicoDao, Politico.class);
        business.insertFromCsv("/home/matheuspvr/Politico.csv");
        politicoDao.closeConnection();
    }
}
