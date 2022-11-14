package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.factory.BusinessFactory;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.sql.SQLException;

public class PoliticoPropoeBusinessTest {
    @Test
    public void insertFromCsv() throws SQLException, IOException, ClassNotFoundException {
        PoliticoPropoeBusiness business = BusinessFactory.getPoliticoPropoeBusiness();
        business.insertFromCsv("/home/matheuspvr/Pol_propoe.csv");
    }
}