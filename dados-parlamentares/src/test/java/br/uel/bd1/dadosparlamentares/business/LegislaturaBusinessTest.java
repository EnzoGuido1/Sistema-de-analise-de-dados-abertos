package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.factory.BusinessFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class LegislaturaBusinessTest {
    @Test
    public void insertFromCsv() throws SQLException, IOException, ClassNotFoundException {
        LegislaturaBusiness legislaturaBusiness = BusinessFactory.getLegislaturaBusiness();
        legislaturaBusiness.insertFromCsv("C:\\Users\\PCMonstro\\Desktop\\Legislatura.csv");
    }
}
