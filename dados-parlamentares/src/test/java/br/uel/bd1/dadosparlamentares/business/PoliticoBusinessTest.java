package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.PoliticoDAO;
import br.uel.bd1.dadosparlamentares.factory.BusinessFactory;
import br.uel.bd1.dadosparlamentares.factory.DAOFactory;
import br.uel.bd1.dadosparlamentares.factory.PgConnectionFactory;
import br.uel.bd1.dadosparlamentares.factory.PgDAOFactory;
import br.uel.bd1.dadosparlamentares.model.Politico;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.sql.SQLException;

public class PoliticoBusinessTest {
    @Test
    public void insertFromCsv() throws SQLException, IOException, ClassNotFoundException {
        PoliticoDAO politicoDao = DAOFactory.getInstance().getPoliticoDAO();

        PoliticoBusiness business = BusinessFactory.getPoliticoBusiness();
        business.insertFromCsv("/home/matheuspvr/Politico.csv");
        politicoDao.closeConnection();
    }
}