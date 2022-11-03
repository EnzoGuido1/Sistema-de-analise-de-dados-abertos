package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.factory.BusinessFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class LegislaturaBusinessTest {
    @Test
    public void insertFromCsv() throws SQLException, IOException, ClassNotFoundException {
        LegislaturaBusiness business = BusinessFactory.getLegislaturaBusiness();
//        business.insertFromCsv("/home/matheuspvr/Downloads/Dados Processados/Legislatura.csv");
        business.insertFromCsv("/home/matheuspvr/Legislatura.csv");
    }
}
