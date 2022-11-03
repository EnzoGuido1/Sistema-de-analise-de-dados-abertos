package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.factory.BusinessFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class LegislaturaSenadoBusinessTest {
    @Test
    public void insertFromCsv() throws SQLException, IOException, ClassNotFoundException {
        LegislaturaSenadoBusiness legislaturaSenadoBusiness = BusinessFactory.getLegislaturaSenadoBusiness();
        legislaturaSenadoBusiness.insertFromCsv("C:\\Users\\PCMonstro\\Desktop\\LegislaturaSenado.csv");
    }
}
