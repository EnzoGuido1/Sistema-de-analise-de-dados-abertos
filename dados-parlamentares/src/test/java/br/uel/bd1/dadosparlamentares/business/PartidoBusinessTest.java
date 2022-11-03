package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.factory.BusinessFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class PartidoBusinessTest {
    @Test
    public void insertFromCsv() throws SQLException, IOException, ClassNotFoundException {
        PartidoBusiness partidoBusiness = BusinessFactory.getPartidoBusiness();
        partidoBusiness.insertFromCsv("C:\\Users\\PCMonstro\\Desktop\\Partidos.csv");
    }
}
