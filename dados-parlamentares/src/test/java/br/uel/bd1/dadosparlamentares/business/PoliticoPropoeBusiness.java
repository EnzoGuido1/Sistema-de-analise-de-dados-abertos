package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.factory.BusinessFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class PoliticoPropoeBusiness {
    @Test
    public void insertFromCsv() throws SQLException, IOException, ClassNotFoundException {
        PoliticoPropoeBusiness politicoPropoeBusiness = BusinessFactory.getPoliticoPropoeBusiness();
//        politicoPropoeBusiness.insertFromCsv("/home/matheuspvr/PoliticoPropoe.csv");
    }
}
