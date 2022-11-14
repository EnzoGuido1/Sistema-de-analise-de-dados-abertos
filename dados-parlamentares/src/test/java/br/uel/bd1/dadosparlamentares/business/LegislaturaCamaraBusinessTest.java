package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.factory.BusinessFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class LegislaturaCamaraBusinessTest {
    @Test
    public void insertFromCsv() throws SQLException, IOException, ClassNotFoundException {
        LegislaturaCamaraBusiness legislaturaCamaraBusiness = BusinessFactory.getLegislaturaCamaraBusiness();
        legislaturaCamaraBusiness.insertFromCsv("/home/matheuspvr/Legislatura_ca.csv");
    }
}
