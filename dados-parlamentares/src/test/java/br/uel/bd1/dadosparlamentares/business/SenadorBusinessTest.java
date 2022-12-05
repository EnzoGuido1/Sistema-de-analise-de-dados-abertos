package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.factory.BusinessFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SenadorBusinessTest {
    @Test
    public void insertFromCsv() throws SQLException, IOException, ClassNotFoundException {
        SenadorBusiness senadorBusiness = BusinessFactory.getSenadorBusiness();
        senadorBusiness.insertFromCsv("/home/matheuspvr/Senador.csv");
    }
}